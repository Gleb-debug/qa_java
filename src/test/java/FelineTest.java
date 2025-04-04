package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat(),"Кошачьи такое не едят!");
    }

    @Test
    void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily(),"Неверная семья");
    }

    @Test
    void testGetKittensWithoutParameters() {
        assertEquals(1, feline.getKittens());
    }
}
