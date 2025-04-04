import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParamsTest {
    Feline feline = new Feline();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void testGetKittensWithParameters(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount), "Котят больше или меньше, чем мы ожидали");
    }
}
