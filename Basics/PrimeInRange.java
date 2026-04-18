

import java.util.Scanner;




//public class PowerOfNumber {
   // public static void main(String[] args) {
    //   Scanner sc = new Scanner(System.in);

     //   System.out.print("Enter base number: ");
     //   int n = sc.nextInt();

    //    System.out.print("Enter exponent: ");
     //   int exp = sc.nextInt();

    //    int result = 1;

    //    for (int i = 1; i <= exp; i++) {
    //        result = result * n;
    //    }

    //    System.out.println(n + " ^ " + exp + " = " + result);

    //    sc.close();
    //}
//}



/*public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        boolean isPrime = true;

        if (n <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(n + " is a Prime number");
        } else {
            System.out.println(n + " is NOT a Prime number");
        }

        sc.close();
    }
}*/


public class PrimeInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter start of range: ");
        int start = sc.nextInt();

        System.out.print("Enter end of range: ");
        int end = sc.nextInt();

        System.out.println("Prime numbers between " + start + " and " + end + ":");

        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }

        sc.close();
    }

    
    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}