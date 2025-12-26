public class SimpleRSA {
    private final long n, e, d;

    public SimpleRSA(long p, long q){
        this.n = p * q;
        this.e = 65537;
        this.d = NumberTheoryEngine.modularInverse(e, (p-1)*(q-1));
    }

    public long encrypt(long message){
        if (message < n) return NumberTheoryEngine.modularExponentiation(message, e, n);
        System.out.println("Message too large.");
        return 0;
    }

    public long decrypt(long ciphertext){
        return NumberTheoryEngine.modularExponentiation(ciphertext, d, n);
    }
}
