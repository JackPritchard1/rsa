import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sieve sieve = new Sieve(9999999);
        Random random = new Random();
        ArrayList<Integer> primes = sieve.findAllPrimes();

        long p = primes.get(random.nextInt(primes.size()));
        long q;
        do {
            q = primes.get(random.nextInt(primes.size()));
        } while (p == q);
        System.out.println("p: " + p + ", q: " + q);

        SimpleRSA rsa = new SimpleRSA(p, q);

        long message = 97652234558L;
        System.out.println("Message: " + message);

        long encrypted = rsa.encrypt(message);
        System.out.println("Ciphertext: " + encrypted);

        long decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

    }
}

