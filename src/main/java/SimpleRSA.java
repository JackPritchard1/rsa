import java.security.SecureRandom;
import java.math.BigInteger;

public class SimpleRSA {
    private final BigInteger n, e, d;

    /** Initialises RSA algorithm
     * n = product of two large primes
     * e = 65537 - must be smaller than n and coprime to n (public key)
     * d = 
     *
     */
    public SimpleRSA(){

        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(1024, random);
        BigInteger q;
        do {
            q = BigInteger.probablePrime(1024, random);
        } while (p.equals(q));
        this.n = p.multiply(q);
        this.e = BigInteger.valueOf(65537);
        this.d = NumberTheoryEngine.modularInverse(e, ((p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)))));
    }

    public BigInteger encrypt(BigInteger message){
        if (message.compareTo(n) < 0) return NumberTheoryEngine.modularExponentiation(message, e, n);
        System.out.println("Message too large.");
        return BigInteger.ZERO;
    }

    public BigInteger decrypt(BigInteger ciphertext){
        return NumberTheoryEngine.modularExponentiation(ciphertext, d, n);
    }

    public static BigInteger textToInt(String message){
        return new BigInteger(message.getBytes());
    }

    public static String intToText(BigInteger message){
        return new String(message.toByteArray());
    }
}
