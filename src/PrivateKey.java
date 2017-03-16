import java.math.BigInteger;

/**
 * Created by mohammad on 3/16/17.
 */
public class PrivateKey {
    BigInteger d;
    BigInteger n;
    PrivateKey()
    {

        d = BigInteger.ZERO;
        n = BigInteger.ZERO;
    }
}
