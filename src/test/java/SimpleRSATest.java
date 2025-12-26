import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;


public class SimpleRSATest {
    @Test
    @DisplayName("Encryption followed by decryption should return value.")
    void testEncryption(){
        SimpleRSA rsa = new SimpleRSA();
        BigInteger message = BigInteger.valueOf(100);
        assertEquals(message, rsa.decrypt(rsa.encrypt(message)));
    }

    @Test
    @DisplayName("If message == 0:")
    void testEncryptionZero(){
        SimpleRSA rsa = new SimpleRSA();
        assertEquals(BigInteger.ZERO, rsa.decrypt(rsa.encrypt(BigInteger.ZERO)));
    }

    @Test
    @DisplayName("If message == 1:")
    void testEncryptionOne(){
        SimpleRSA rsa = new SimpleRSA();
        assertEquals(BigInteger.ONE, rsa.decrypt(rsa.encrypt(BigInteger.ONE)));
    }
}
