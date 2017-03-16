import java.util.HashMap;
import java.util.Map;


/**
 * Created by mohammad on 3/16/17.
 */
public class RSASmallnumbers {
    private int n;
    private int e;
    private int d;

    public RSASmallnumbers() {
        n = 0;
        e = 0;
        d = 0;
    }
    public RSASmallnumbers(int n, int e) {
        this.n=n;
        this.e=e;
    }

    private int GCD(int p, int q) {

        if (q == 0) {
            return p;
        }
        return GCD(q, p % q);
    }

    public void ready(int p, int q) {


        n = p * q;
        System.out.print("\nn=" + n);
        int temp = (p - 1) * (q - 1);
        System.out.print("\n(p-1)*(q-1)=" + temp);

        e = 2; // randomPrime();
        System.out.print("\nStart with e=" + e);

        int gcd = GCD(temp, e);
        System.out.print(", GCD(" + temp + "," + e + ")=" + gcd);
        while ((gcd != 1) && (e < temp)) {


            e++;
            System.out.print("\nIncrement e=" + e);
            gcd = GCD(temp, e);

            System.out.print(", GCD(" + temp + "," + e + ")=" + gcd);
        }
        System.out.println("\nMod Inverse " + e + "," + temp);
        d = modInverse(e, temp);
        System.out.println("\nd = " + d+", e = " + e);


        //d = modInverse(e, temp);
    }


    int modInverse(int a, int m) {
        int ret = 0;
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1) {
                ret = x;
                break;

            }
        return ret;
    }


    int numberOfOnes(String S) {
        int i = 0;
        for (char c: S.toCharArray()) {
            if (c == '1') {
                i++;
            }

        }
        return i;
    }

    Map < Integer, Integer > m1 = new HashMap();
    int PowModulus(int base, int power, int mod)
    {
        System.out.print("\n "+base+"^"+power+" mod "+mod +" : ");

        if (power == 1) return base % mod;



        int p = 1;

        String s = Integer.toString(power, 2);

        System.out.print(" | "+power+" = ("+s +")2   |   ");
        if (numberOfOnes(s) == 1)
        {
            int bck =s.length()-s.indexOf('1')-2;
            if (m1.containsKey(bck)) {

                return (int) (Math.pow(m1.get(bck), 2) % mod);
            } else
            {
                int res= PowModulus(base, (int) Math.pow(2,bck),mod);
                m1.put(bck,res);
                return (int) (Math.pow(res, 2) % mod);
            }
        }
        else
        {

            p = 1;
            int res = 1;
            for (int i = 0; i <= s.length() - 1; i++)
            {

                if (s.charAt((s.length() - 1)-i) == '1') {
                    if (m1.containsKey(i)) {

                        res = m1.get(p);
                    } else {

                        res = PowModulus(base, (int) Math.pow(2, i), mod);
                        m1.put(i, res);

                    }
                    System.out.print("  ["+res+"*"+p+" mod "+mod+"=");
                    p = (res * p) % mod;
                    System.out.print(p+" ]  ");
                }
            }
        }
        System.out.print("=>  = "+p+"\n");
        return p;
    }

    public int Encryption(int message) {


        //BigInteger msg=new BigInteger(message);
        /**
         * msg plaintext
         * C=Cipher
         * e and n parts of public key
         * c=msg^e mod n
         */
        m1 = new HashMap();
        return PowModulus(message, e, n);


    }



    public int Decryption(int message) {


        /**
         * c Ciphertext
         * msg Plaintext
         * d and n parts of pivate key
         * msg=c^d mod n
         */
        m1 = new HashMap();
        return PowModulus(message, d, n);


    }

}