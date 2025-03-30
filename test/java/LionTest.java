package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline feline;

    @Test
    void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "Неизвестный", "123"})
    void testLionConstructorWithInvalidSex(String sex) {
        Exception exception = assertThrows(Exception.class, () -> new Lion(sex));
        assertEquals("Используйте допустимые значения пола животного - самей или самка",
                exception.getMessage());
    }

    @Test
    void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец");
        lion.feline = feline;
        when(feline.getKittens()).thenReturn(1);

        assertEquals(1, lion.getKittens());
        verify(feline, times(1)).getKittens();
    }

    @Test
    void testGetFood() throws Exception {
        Lion lion = new Lion("Самка");
        lion.feline = feline;
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        assertEquals(expectedFood, lion.getFood());
        verify(feline, times(1)).getFood("Хищник");
    }
}
