package com.decerto.demo;

import com.decerto.demo.generator.RestGenerator;
import com.decerto.demo.generator.WebClientFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class RestGeneratorTest {

    private static final int INT_RESPONSE = 33;
    private static final String STRING_RESPONSE = "33";

    @Mock
    WebClientFacade webClientFacade;
    @InjectMocks
    RestGenerator restGenerator;

    @Test
    public void restGeneratorShouldWorks() {
        //given
        Mockito.when(webClientFacade.getResponse(any())).thenReturn(STRING_RESPONSE);
        //when
        Integer result = restGenerator.generate();
        //then
        assertEquals(result, INT_RESPONSE);

    }

    @Test
    public void nullResponseShouldReturnZero() {
        //given
        Mockito.when(webClientFacade.getResponse(any())).thenReturn(null);
        //when
        Integer result = restGenerator.generate();
        //then
        assertEquals(result, 0);
    }

    @Test
    public void trimShouldWorks() {
        //given
        Mockito.when(webClientFacade.getResponse(any())).thenReturn(STRING_RESPONSE + " ");
        //when
        Integer result = restGenerator.generate();
        //then
        assertEquals(result, INT_RESPONSE);
    }

    @Test
    public void notNumberResponseShouldThrowsException() {
        //given
        Mockito.when(webClientFacade.getResponse(any())).thenReturn("abc");
        //then
        assertThrows(NumberFormatException.class, () -> restGenerator.generate());
    }
}
