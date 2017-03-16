/**
 * Write a program that will take a message m (an integer) and key (e,n) – two integers, and
 * generate the ciphertext c (another integer), using the RSA algorithm. Use the examples in
 * question 1 above to test your program.
 * Created by mohammad on 3/12/17.
 */
public class main {

    private static String bytesToString(byte[] encrypted) {

        String test = "";

        for (byte b : encrypted) {

            test += Byte.toString(b);

        }

        return test;

    }
    public static void main(String[] args) {


        RSASmallnumbers rs=new RSASmallnumbers();
        int p=7;
        int q=11;
        int m=6;
        System.out.print("\nP="+p);
        System.out.print(", q="+q);
        System.out.print(", M="+m);
        System.out.print("\nRSA key generation:");
rs.ready(p,q);
        System.out.print("\nRSA Encryption:");
int ci=rs.Encryption(m);
        System.out.print("\nRSA Encryption:"+ci);
        System.out.print("\nRSA Decryption:");
        int d = rs.Decryption(ci);
        System.out.print("\nRSA Decryption:"+d+"\n");
//
//        RSA rsa = new RSA();
//        rsa.setRSAKeyLength(512);
//        rsa.ready();
//
//
//        String teststring ;
//
//
//        teststring="6";
//
//
//
//        System.out.println("String in Bytes: " + bytesToString(teststring.getBytes()));
//
//
//
//        byte[] encrypted = rsa.Encryption(teststring.getBytes());
//
//
//        System.out.println("Encrypted String in Bytes: " + bytesToString(encrypted));
//
//        // decrypt
//
//        byte[] decrypted = rsa.Decryption(encrypted);
//
//        System.out.println("Decrypted String in Bytes: " +  bytesToString(decrypted));
//
//        System.out.println("Decrypted String: " + new String(decrypted));
//
//
//
//        Caesar c = new Caesar();
//        c.setKey(3);
//        String Cipher= (String) c.Encryption("SECRET MESSAGE");
//        System.out.print(Cipher+"\n");
//        System.out.print(c.Decryption(Cipher)+"\n");
//
//        String Vkey="NetworkSecurity";
//        Vigenere v=new Vigenere();
//        v.setKey(Vkey);
//        Cipher= (String) v.Encryption("SECRET MESSAGE");
//        System.out.print(Cipher+"\n");
//        System.out.print(v.Decryption(Cipher)+"\n");

    }
}
