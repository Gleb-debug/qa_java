import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LionParamsTest {
    @Mock
    private Feline feline;

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "Неизвестный", "123"})
    void testLionConstructorWithInvalidSex(String sex) {
        Exception exception = assertThrows(Exception.class, () -> new Lion(sex,feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}
