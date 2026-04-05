package Labs;

import java.util.*;

public class Lab1 {
    



// ══════════════════════════════════════════════
// Q1. Bank Class
// ══════════════════════════════════════════════
class Bank {
    double amount;

    // Parameterized Constructor
    Bank(double amount) {
        this.amount = amount;
    }

    void withdraw(double withdrawalAmount) {
        String message = (withdrawalAmount <= amount)
                ? "Withdrawal Successful"
                : "Insufficient Balance";
        System.out.println(message);
        if (withdrawalAmount <= amount) {
            amount -= withdrawalAmount;
        }
    }

    void deposit(double depositAmount) {
        amount += depositAmount;
        System.out.println("Deposit Successful");
    }

    void displayBalance() {
        System.out.println("Total Balance: " + amount);
    }
}

public class ClassAndOperators {

    // ══════════════════════════════════════════════
    // Q2. Maximum of Two Numbers using Ternary
    // ══════════════════════════════════════════════
    static void maxOfTwo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter num2: ");
        int num2 = sc.nextInt();

        int max = (num1 > num2) ? num1 : num2;
        System.out.println("Maximum is: " + max);
        sc.close();
    }

    // ══════════════════════════════════════════════
    // Q3. Check nth Bit of a Number
    // ══════════════════════════════════════════════
    static void checkNthBit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number (num): ");
        int num = sc.nextInt();
        System.out.print("Enter bit position (n): ");
        int n = sc.nextInt();

        int bitStatus = (num >> n) & 1;
        System.out.println(n + "th bit of " + num + " is: " + bitStatus);

        if (bitStatus == 1)
            System.out.println("The " + n + "th bit is SET (1)");
        else
            System.out.println("The " + n + "th bit is NOT SET (0)");
        sc.close();
    }

    // ══════════════════════════════════════════════
    // MAIN METHOD
    // ══════════════════════════════════════════════
    public static void main(String[] args) {

        // ── Q1 ──
        Bank b = new Bank(10000);  
        b.withdraw(5000);
        b.deposit(5000);
        b.displayBalance();

        // ── Q2 ──
        System.out.println("\n========== Q2: Maximum of Two Numbers ==========");
        maxOfTwo();

        // ── Q3 ──
        System.out.println("\n========== Q3: Nth Bit Check ==========");
        checkNthBit();
    }
}
}

