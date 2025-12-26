public class SimpleRSA {
    private final long n, e, d;

    public SimpleRSA(long p, long q){
        this.n = p * q;
        this.e = 65537;
        this.d = NumberTheoryEngine.modularInverse(e, (p-1)*(q-1));
    }

    public long encrypt(long message){
        return NumberTheoryEngine.modularExponentiation(message, e, n);
    }

    public long decrypt(long ciphertext){
        return NumberTheoryEngine.modularExponentiation(ciphertext, d, n);
    }
}
