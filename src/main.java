import java.util.Scanner;

/**
 * Write a program that will take a message m (an integer) and key (e,n) – two integers, and
 * generate the ciphertext c (another integer), using the RSA algorithm. Use the examples in
 * question 1 above to test your program.
 * Created by mohammad on 3/12/17.
 */
public class main {

    public static void main(String[] args) {



        Scanner scan2 = new Scanner(System.in);
        System.out.print("please input a prime number as n:");
        int n = scan2.nextInt();
        System.out.print("please input a prime number as e:");
        int e = scan2.nextInt();
        System.out.print("please input an integer as message:");
        int m = scan2.nextInt();



        RSASmallnumbers rs=new RSASmallnumbers(n,e);

        int ci=rs.Encryption(m);
        System.out.print("\nciphertext:"+ci);

    }
}
