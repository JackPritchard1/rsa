import java.util.BitSet;
import java.util.ArrayList;

public class Sieve {
    private final int n;
    private final BitSet sieve;
    private final ArrayList<Integer> primes;

    public Sieve(int n){
        this.n = n;
        sieve = new BitSet(n+1);
        primes = new ArrayList<>();
    }

    public ArrayList<Integer> findAllPrimes(){
        generateSieve();
        sievePrimes();
        convertToPrimes();
        return primes;
    }

    public void sievePrimes() {
        for (int i = 2; i*i <= n; i++){
            if (sieve.get(i)){
                for (int j = i*i; j <= n; j+=i){
                    sieve.clear(j);
                }
            }
        }
    }

    private void generateSieve(){
        sieve.set(2, n+1);
    }

    public void convertToPrimes(){
        for (int i = 2; i <= n; i++){
            if (sieve.get(i)) primes.add(i);
        }
    }
}