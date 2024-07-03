package com.yourticket.filters;

import com.yourticket.configurations.AppConfig;
import com.yourticket.services.ITokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author fredd
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if (request.getServletPath().equals("/usersession/login"))
            return true;
        if (request.getServletPath().equals("/user/create"))
            return true;
        if (request.getServletPath().equals("/user/createseller"))
            return true;
        if (request.getServletPath().equals("/event/get"))
            return true;
        if (request.getServletPath().equals("/event/getall"))
            return true;
        if (request.getServletPath().equals("/event/getzones"))
            return true;
        if (request.getServletPath().equals("/event/getrows"))
            return true;
        
        return request.getServletPath().equals("/event/getseats");
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String statusMessage;

        if (request.getHeader(HttpHeaders.AUTHORIZATION) == null) {
            statusMessage = "No se proporcionó un token de sesion válido.";
            handleError(response, statusMessage, HttpStatus.UNAUTHORIZED);
            return;
        }

        try {
            String token = request.getHeader(HttpHeaders.AUTHORIZATION).trim();
            String user = tokenService.extractUsername(token);

            if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(user);
                if (tokenService.isJwtTokenValid(token, userDetails)) {

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities());
                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);

                    filterChain.doFilter(request, response);

                } else {
                    statusMessage = "El token de sesion proporcionado no es valido.";
                    handleError(response, statusMessage, HttpStatus.UNAUTHORIZED);
                }
            } else {
                statusMessage = "El token de sesion proporcionado no es valido.";
                handleError(response, statusMessage, HttpStatus.UNAUTHORIZED);
            }
        } catch (ServletException | IOException | UsernameNotFoundException ex) {
            statusMessage = "No se pudo validar el token. Mensaje: Ocurrio un error no esperado.";
            handleError(response, statusMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return;
    }

    private HttpServletResponse handleError(ServletResponse servletResponse, String message, HttpStatus codeError)
            throws IOException {
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.reset();
        response.setStatus(codeError.value());
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, appConfig.getAllowedOrigins());
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, appConfig.getAllowedMethods());
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, appConfig.getAllowedHeaders());
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(message);

        return response;
    }

}
