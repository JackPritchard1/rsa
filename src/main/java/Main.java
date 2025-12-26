import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sieve sieve = new Sieve(99999999);
        Random random = new Random();
        ArrayList<Integer> primes = sieve.findAllPrimes();
        long p = primes.get(random.nextInt(primes.size()));
        long q = primes.get(random.nextInt(primes.size()));
        System.out.println("p: " + p + ", q: " + q);
        SimpleRSA rsa = new SimpleRSA(p, q);

        long message = 9348589;
        System.out.println("Message: " + message);
        System.out.println("Ciphertext: " + rsa.encrypt(message));
        System.out.println("Decrypted: " + rsa.decrypt(rsa.encrypt(message)));

    }
}

