import java.math.BigInteger;

public class NumberTheoryEngine {
    private NumberTheoryEngine(){}

    public static BezoutResult extendedGCD(BigInteger a, BigInteger b){
        BigInteger x = BigInteger.valueOf(0);
        BigInteger x_prev = BigInteger.valueOf(1);
        BigInteger y = BigInteger.valueOf(1);
        BigInteger y_prev = BigInteger.valueOf(0);

        while (!b.equals(BigInteger.ZERO)){
            BigInteger[] dr = a.divideAndRemainder(b);
            BigInteger q = dr[0];
            a = b;
            b = dr[1];

            BigInteger x_temp = x;
            x = x_prev.subtract(q.multiply(x));
            x_prev = x_temp;

            BigInteger y_temp = y;
            y = y_prev.subtract(q.multiply(y));
            y_prev = y_temp;

        }
        return new BezoutResult(a, x_prev, y_prev);
    }

    public static BigInteger modularInverse(BigInteger a, BigInteger n){
        BezoutResult result = extendedGCD(a, n);
        if (!result.gcd().equals(BigInteger.ONE)) throw new ArithmeticException("a and n are not coprime.");
        return ((result.x().add(n)).mod(n));

    }

    public static BigInteger modularExponentiation(BigInteger base, BigInteger exp, BigInteger mod) {
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
        return result;
    }



}
