import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SimpleRSATest {
    @Test
    @DisplayName("Encryption followed by decryption should return value.")
    void testEncryption(){
        SimpleRSA rsa = new SimpleRSA(61, 53);
        long message = 100;
        assertEquals(message, rsa.decrypt(rsa.encrypt(message)));
    }

    @Test
    @DisplayName("If message == 0:")
    void testEncryptionZero(){
        SimpleRSA rsa = new SimpleRSA(31, 67);
        assertEquals(0, rsa.decrypt(rsa.encrypt(0)));
    }

    @Test
    @DisplayName("If message == 1:")
    void testEncryptionOne(){
        SimpleRSA rsa = new SimpleRSA(31, 67);
        assertEquals(1, rsa.decrypt(rsa.encrypt(1)));
    }
}
