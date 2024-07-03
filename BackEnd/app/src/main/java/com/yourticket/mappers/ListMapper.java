package com.yourticket.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fredd
 */
@Component
public class ListMapper {
    
    @Autowired
    private ModelMapper mapperDTO;
    
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass){
        return source.stream().map(element -> mapperDTO.map(element, targetClass)).collect(Collectors.toList());
    }
}
