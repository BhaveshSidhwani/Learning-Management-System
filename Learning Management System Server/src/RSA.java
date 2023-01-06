import java.util.Scanner;

class RSA{
    static int gcd(int m, int n) {
        while (n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
    public static void main(String[] args) {
        int p, q, n, e, d, phi;
        int[] nummes = new int[100];
        int[] encrypted = new int[100];
        int[] decrypted = new int[100];
        int i, j, nofelem;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value of p and q:");
        p = sc.nextInt();
        q = sc.nextInt();
        n = p * q;
        phi = (p - 1) * (q - 1);
        for (i = 2; i < phi; i++)
            if (gcd(i, phi) == 1)
                break;
        e = i;
        for (i = 2; i < phi; i++)
            if ((e * i - 1) % phi == 0)
                break;
        d = i;
        System.out.println("The private key is (d,n)=("+d+","+n+")");
        System.out.println("The public key is (e,n)=("+e+","+n+")");
        System.out.println("\nChoose the Operation you want to perform:");
        System.out.println("1.Encryption \n2.Decryption");
        int ch = sc.nextInt();
        switch(ch){
            case 1:
                System.out.println("Enter the Message to be encrypted:");
                String message = sc.next();
                for (i = 0; i < message.length(); i++) {
                    char c = message.charAt(i);
                    int a = (int) c;
                    nummes[i] = c - 96;
                }
                nofelem = message.length();
                for (i = 0; i < nofelem; i++) {
                    encrypted[i] = 1;
                    for (j = 0; j < e; j++)
                        encrypted[i] = (encrypted[i] * nummes[i]) % n;
                }
                System.out.println("\nEncrypted message:");
                for (i = 0; i < nofelem; i++) {
                    System.out.print(encrypted[i]+",");
                    //System.out.print((char) (encrypted[i] + 96));
                }
                break;
            case 2:
                System.out.println("Enter the Length of the text:");
                nofelem = sc.nextInt();
                System.out.println("Enter the Message to be Decrypted:");
                for(i=0; i<nofelem; i++){
                    encrypted[i] = sc.nextInt();
                }
                for (i = 0; i < nofelem; i++) {
                    decrypted[i] = 1;
                    for (j = 0; j < d; j++)
                        decrypted[i] = (decrypted[i] * encrypted[i]) % n;
                }
                System.out.println("\nDecrypted message");
                for (i = 0; i < nofelem; i++)
                    System.out.print((char) (decrypted[i] + 96));
                break;
            default:
                System.out.println("Invalid Input");
        }
    }
}
