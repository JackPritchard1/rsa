import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTheoryEngineTest {

    @Test
    @DisplayName("EEA returns correct GCD and x,y for Bézouts Identity: ax + by = gcd(a,b)")
    void testEEA(){
        BigInteger a = new BigInteger("240");
        BigInteger b = new BigInteger("46");
        BigInteger expectedGCD = new BigInteger("2");

        BezoutResult result = NumberTheoryEngine.extendedGCD(a, b);
        assertEquals(expectedGCD, result.gcd());

        BigInteger identity = result.x().multiply(a).add(result.y().multiply(b));
        assertEquals(expectedGCD, identity);
    }

    @Test
    @DisplayName("Modular Inverse returns correct value")
    void testModularInverse(){
        assertEquals(new BigInteger("70"), NumberTheoryEngine.modularInverse(new BigInteger("13"), new BigInteger("101")));
    }

    @Test
    @DisplayName("Modular Inverse should throw exception if no inverse exists.")
    void testModInverseException() {
        assertThrows(ArithmeticException.class, () -> NumberTheoryEngine.modularInverse(BigInteger.valueOf(10), BigInteger.valueOf(50)));
    }

    @Test
    @DisplayName("Fast modular exponentiation returns correct value.")
    void testModularExponentiation(){
        BigInteger base = new BigInteger("7");
        BigInteger exp = new BigInteger("13");
        BigInteger mod = new BigInteger("101");
        BigInteger expected = new BigInteger("75");
        assertEquals(expected, NumberTheoryEngine.modularExponentiation(base, exp, mod));
    }

    @Test
    @DisplayName("Modular exponentiation should return 1 for power 0")
    void testModularExponentiationPowerZero(){
        BigInteger base = new BigInteger("7");
        BigInteger exp = new BigInteger("0");
        BigInteger mod = new BigInteger("101");
        BigInteger expected = new BigInteger("1");
        assertEquals(expected, NumberTheoryEngine.modularExponentiation(base, exp, mod));
    }

    @Test
    @DisplayName("Modular exponentiation should return 0 for base 0")
    void testModularExponentiationBaseZero(){
        BigInteger base = new BigInteger("0");
        BigInteger exp = new BigInteger("15");
        BigInteger mod = new BigInteger("45");
        BigInteger expected = new BigInteger("0");
        assertEquals(expected, NumberTheoryEngine.modularExponentiation(base, exp, mod));
    }

    @Test
    @DisplayName("Modular exponentiation should return 0 for modulo 1")
    void testModularExponentiationModuloOne(){
        BigInteger base = new BigInteger("7");
        BigInteger exp = new BigInteger("13");
        BigInteger mod = new BigInteger("1");
        BigInteger expected = new BigInteger("0");
        assertEquals(expected, NumberTheoryEngine.modularExponentiation(base, exp, mod));
    }



}
