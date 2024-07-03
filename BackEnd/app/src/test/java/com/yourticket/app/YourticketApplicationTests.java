package com.yourticket.app;

import com.yourticket.dtos.response.CustomerResDTO;
import com.yourticket.dtos.response.SellerResDTO;
import com.yourticket.dtos.response.UserResDTO;
import com.yourticket.services.ICustomerService;
import com.yourticket.services.ISellerService;
import com.yourticket.services.IUserService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class YourticketApplicationTests {
        
        @SpyBean
        ICustomerService customerService;
        
        @SpyBean
        ISellerService sellerService;
        
        @SpyBean
        IUserService userService;

	@Test
	void contextLoads() {
	}
        
        @Test
        void whenCustomerInformationIsCorrect(){
            CustomerResDTO customer = customerService.getCustomer(1);
            assertThat(customer).isNotNull();
        }
        
        @Test
        void whenCustomerInformationIsWrong(){
            CustomerResDTO customer = customerService.getCustomer(10);
            assertThat(customer).isNull();
        }
        
        @Test
        void whenSellerInformationIsCorrect(){
            SellerResDTO seller = sellerService.getSeller(1);
            assertThat(seller).isNotNull();
        }
        
        @Test
        void whenSellerInformationIsWrong(){
            SellerResDTO seller = sellerService.getSeller(10);
            assertThat(seller).isNull();
        }
        
        @Test
        void whenUserInformationIsCorrect(){
            UserResDTO user = userService.getUser(1);
            assertThat(user).isNotNull();
        }
        
        @Test
        void whenUserInformationIsWrong(){
            UserResDTO user = userService.getUser(10);
            assertThat(user).isNull();
        }

}
