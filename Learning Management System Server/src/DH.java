import java.util.*;

class DH{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any Prime Number: ");
        int p=sc.nextInt();

        for(int i=2;i<p;i++) {
            if(p%i == 0) {
                System.out.println(p + " is not a prime no.");
                System.exit(0);
            }
        }

        int phi = p-1;
        List<Integer> prime = new ArrayList<>();
        List<Integer> pow = new ArrayList<>();
        for(int i = 2; i<p-1; i++) {
            if(phi%i == 0) {
                int x = phi/i; //phi / prime
                prime.add(x);
            }
        }

        for (Integer integer : prime) {
            
            pow.add(phi / integer);
        }

        List<Integer> primitiveIntegers = new ArrayList<>(); int flag = 0;
        for(int i=2;i<=phi;i++){
            for (Integer integer : pow) {
                if (Math.pow(i, integer) % p == 1) {
                    flag = 1;
                    break;
                } else {
                    flag = 0;
                }
            }
            if(flag==0) {
                primitiveIntegers.add(i);
            }
        }

        System.out.println("All the primitive roots of " + p + " are: ");
        System.out.println(primitiveIntegers);

        System.out.println("Enter primitive root of " + p + " from above list: ");
        int alpha=sc.nextInt();
        System.out.println("Choose private key of Person 1: ");
        int a=sc.nextInt();
        System.out.println("Choose private key of Person 2: ");
        int b=sc.nextInt();

        int A = (int)Math.pow(alpha,a)%p;
        int B = (int)Math.pow(alpha,b)%p;

        System.out.println("Public and Private Key of Person 1 = " + A + ", " + a);
        System.out.println("Public and Private Key of Person 2 = " + B + ", " + b);

        int k1 = (int)Math.pow(B,a)%p;
        int k2 =(int)Math.pow(A,b)%p;
        if(k1==k2) {
            System.out.println("ALice and Bob can communicate with each other!!!");
            System.out.println("They share a secret key = " + k1);
        } else {
            System.out.println("ALice and Bob cannot communicate with each other!!!");
        }
    }
}