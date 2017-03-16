import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Mohammad Etemad on 3/16/17.
 */
public class RSA {

    private PublicKey publicKey;
    private PrivateKey privateKey;
    private int RSAKeyLength;
    BigInteger generateLargeRandomPrime()
    {
        Random random = new Random();
        return BigInteger.probablePrime(RSAKeyLength, random );
    }

    public RSA() {
        //default Key length 512
        RSAKeyLength=512;
        publicKey=new PublicKey();
        privateKey=new PrivateKey();

    }
    public void ready(){

        /**
         * Step 1
         * Choose two large prime numbers p and q
         * typically 512 digits and higher
         */

        BigInteger p = BigInteger.valueOf(7);//generateLargeRandomPrime();
        BigInteger q = BigInteger.valueOf(11);//generateLargeRandomPrime();

        /**
         * Step 2
         * Find their product n=pq
         */
        BigInteger n = p.multiply(q);

        /**
         * Step 3
         * Choose an integer e that is less than n and is relatively prime to (p-1)(q-1)
         * temp=(p-1)*(q-1)
         */

        BigInteger temp = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        /**
         * First we select a prime number less than n by choosing lenght/2 bits
         */
        BigInteger e = BigInteger.probablePrime(RSAKeyLength/2, new Random());
        /**
         * find e so that it is relatively prime to (p-1)(q-1)
         * we check numbers more than e by adding one by one to find this number
         * gcd(temp,e)=1 means that temp and e are relatively prime
         *
         */
        while ((temp.gcd(e)==BigInteger.ONE)  && (e.compareTo(temp) < 0 )) {

            e.add(BigInteger.ONE);

        }

        /**
         * we show mode inverse with A^-1=Modeinverse(A mod c)
         * Mode inverse by definition is (A* A^-1) is 1 mod C
         * so (A*A^-1) mod c=1
         * thus ed mod (p-1)(q-1)=1
         */
        BigInteger d = e.modInverse(temp);

        //Set public key
        publicKey.e=e;
        publicKey.n=n;

        //Set Private key
        privateKey.d=d;
        privateKey.n=n;

    }





    public byte[] Encryption(byte[] message)
    {


        BigInteger msg=new BigInteger(message);
        /**
         * msg plaintext
         * C=Cipher
         * e and n parts of public key
         * c=msg^e mod n
         */
        byte[] ret=msg.modPow(publicKey.e,publicKey.n).toByteArray();
        return ret;

    }



    public byte[] Decryption(byte[] message)
    {
        BigInteger msg = new BigInteger(message);

        /**
         * c Ciphertext
         * msg Plaintext
         * d and n parts of pivate key
         * msg=c^d mod n
         */
        byte[] ret=msg.modPow(privateKey.d,privateKey.n).toByteArray();

        return ret;

    }

    public int getRSAKeyLength() {
        return RSAKeyLength;
    }

    public void setRSAKeyLength(int RSAKeyLength) {
        this.RSAKeyLength = RSAKeyLength;
    }
}
