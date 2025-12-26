import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberTheoryEngineTest {

    @Test
    @DisplayName("EEA returns correct GCD and x,y")
    void testEEA(){
        var result = NumberTheoryEngine.extendedGCD(240, 46);
        assertEquals(2, result.gcd());
        assertEquals(2, result.x()*240, result.y()*46);
    }

    @Test
    @DisplayName("Modular Inverse returns correct value")
    void testModularInverse(){
        assertEquals(70, NumberTheoryEngine.modularInverse(13, 101));
    }

    @Test
    @DisplayName("Modular Inverse should throw exception if no inverse exists.")
    void testModInverseException() {
        assertThrows(ArithmeticException.class, () -> {
            NumberTheoryEngine.modularInverse(10, 50);
        });
    }

    @Test
    @DisplayName("Fast modular exponentiation returns correct value.")
    void testModularExponentiation(){
        assertEquals(75, NumberTheoryEngine.modularExponentiation(7, 13, 101));
        assertEquals(1, NumberTheoryEngine.modularExponentiation(3, 1000002, 1000003));
    }

    @Test
    @DisplayName("Modular exponentiation should return 1 for power 0")
    void testModularExponentiationPowerZero(){
        assertEquals(1, NumberTheoryEngine.modularExponentiation(7, 0, 101));
    }

    @Test
    @DisplayName("Modular exponentiation should return 0 for base 0")
    void testModularExponentiationBaseZero(){
        assertEquals(0, NumberTheoryEngine.modularExponentiation(0, 15, 45));
    }

    @Test
    @DisplayName("Modular exponentiation should return 0 for modulo 1")
    void testModularExponentiationModuloOne(){
        assertEquals(0, NumberTheoryEngine.modularExponentiation(7, 13, 1));
    }



}
