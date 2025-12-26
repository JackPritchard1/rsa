import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        SimpleRSA rsa = new SimpleRSA();

        String message = "Hello World!";
        System.out.println("Message: " + message);

        BigInteger encrypted = rsa.encrypt(SimpleRSA.textToInt(message));
        System.out.println("Ciphertext: " + encrypted);

        BigInteger decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted: " + SimpleRSA.intToText(decrypted));

    }
}

