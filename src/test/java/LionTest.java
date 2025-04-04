package com.example;

import org.junit.jupiter.api.Test;
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
        Lion lion = new Lion("Самец",feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка",feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец",feline);
        lion.feline = feline;
        when(feline.getKittens()).thenReturn(1);

        assertEquals(1, lion.getKittens());
    }

    @Test
    void testGetFood() throws Exception {
        Lion lion = new Lion("Самка",feline);
        lion.feline = feline;
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        assertEquals(expectedFood, lion.getFood());
    }
}
