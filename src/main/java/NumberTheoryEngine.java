import java.math.BigInteger;

public class NumberTheoryEngine {
    private NumberTheoryEngine(){}

    public static BezoutResult extendedGCD(long a, long b){
        long x = 0, x_prev = 1;
        long y = 1, y_prev = 0;

        while (b != 0){
            long q = a / b;

            long temp_b = b;
            b = a % b;
            a = temp_b;

            long x_temp = x;
            x = x_prev - q * x;
            x_prev = x_temp;

            long y_temp = y;
            y = y_prev - q * y;
            y_prev = y_temp;

        }
        return new BezoutResult(a, x_prev, y_prev);
    }

    public static long modularInverse(long a, long n){
        BezoutResult result = extendedGCD(a, n);
        if (result.gcd() != 1) throw new ArithmeticException("a and n are not coprime.");
        return ((result.x() + n) % n);

    }

    public static long modularExponentiation(long b, long e, long m) {
        BigInteger base = BigInteger.valueOf(b);
        BigInteger exp = BigInteger.valueOf(e);
        BigInteger mod = BigInteger.valueOf(m);
        BigInteger result = BigInteger.ONE; // Equivalent to long result = 1
        base = base.mod(mod); // Initial reduction
        while (exp.signum() > 0) { // while exponent > 0
            // if (exp is odd)
            if (exp.testBit(0)) {
                result = result.multiply(base).mod(mod);
            }
            // Square the base: base = (base * base) % mod
            base = base.multiply(base).mod(mod);
            // exp /= 2 (shift right)
            exp = exp.shiftRight(1);
        }
        return result.longValue();
    }



}
