
import java.util.*;


public class Basic {
   



    static Scanner sc = new Scanner(System.in);

    // ──────────────────────────────────────────────
    // Q1. Even or Odd
    // ──────────────────────────────────────────────
    static void checkEvenOdd() {
        System.out.print("Q1 - Enter a number: ");
        int n = sc.nextInt();
        if (n % 2 == 0)
            System.out.println(n + " is Even");
        else
            System.out.println(n + " is Odd");
    }

    // ──────────────────────────────────────────────
    // Q2. Positive, Negative, or Zero
    // ──────────────────────────────────────────────
    static void checkSign() {
        System.out.print("Q2 - Enter a number: ");
        int n = sc.nextInt();
        if (n > 0)
            System.out.println(n + " is Positive");
        else if (n < 0)
            System.out.println(n + " is Negative");
        else
            System.out.println("The number is Zero");
    }

    // ──────────────────────────────────────────────
    // Q3. Alphabet, Digit, or Special Character
    // ──────────────────────────────────────────────
    static void checkCharType() {
        System.out.print("Q3 - Enter a character: ");
        char ch = sc.next().charAt(0);
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
            System.out.println("'" + ch + "' is an Alphabet");
        else if (ch >= '0' && ch <= '9')
            System.out.println("'" + ch + "' is a Digit");
        else
            System.out.println("'" + ch + "' is a Special Character");
    }

    // ──────────────────────────────────────────────
    // Q4. Check User ID and Password
    // ──────────────────────────────────────────────
    static void checkLogin() {
        String correctId = "admin";
        String correctPass = "java123";
        System.out.print("Q4 - Enter User ID: ");
        String id = sc.next();
        System.out.print("     Enter Password: ");
        String pass = sc.next();
        if (id.equals(correctId) && pass.equals(correctPass))
            System.out.println("Login Successful! Welcome, " + id);
        else
            System.out.println("Invalid User ID or Password.");
    }

    // ──────────────────────────────────────────────
    // Q5. Leap Year Check
    // ──────────────────────────────────────────────
    static void checkLeapYear() {
        System.out.print("Q5 - Enter a year: ");
        int year = sc.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            System.out.println(year + " is a Leap Year");
        else
            System.out.println(year + " is NOT a Leap Year");
    }

    // ──────────────────────────────────────────────
    // Q6. Greatest of Three Numbers
    // ──────────────────────────────────────────────
    static void greatestOfThree() {
        System.out.print("Q6 - Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        if (a >= b && a >= c)
            System.out.println("Greatest is: " + a);
        else if (b >= a && b >= c)
            System.out.println("Greatest is: " + b);
        else
            System.out.println("Greatest is: " + c);
    }

    // ──────────────────────────────────────────────
    // Q7. Student Grade
    // ──────────────────────────────────────────────
    static void checkGrade() {
        System.out.print("Q7 - Enter percentage: ");
        double perc = sc.nextDouble();
        if (perc < 0 || perc > 100)
            System.out.println("Invalid marks/percentage");
        else if (perc >= 90)
            System.out.println("Grade: A");
        else if (perc >= 80)
            System.out.println("Grade: B");
        else if (perc >= 70)
            System.out.println("Grade: C");
        else if (perc >= 60)
            System.out.println("Grade: D");
        else if (perc >= 50)
            System.out.println("Grade: E");
        else
            System.out.println("Grade: Fail");
    }

    // ──────────────────────────────────────────────
    // Q8. Electricity Bill Calculator
    // Slabs:
    //   0–200   units → Free (₹0)
    //   201–300 units → ₹1.2/unit  (for units beyond 200)
    //   301–400 units → ₹1.5/unit  (for units beyond 300)
    //   401–500 units → ₹2.5/unit  (for units beyond 400)
    //   >500    units → ₹8/unit    (for units beyond 500)
    // ──────────────────────────────────────────────
    static void electricityBill() {
        System.out.print("Q8 - Enter units consumed: ");
        int units = sc.nextInt();
        double bill = 0;

        if (units <= 0) {
            System.out.println("Invalid units entered.");
            return;
        } else if (units <= 200) {
            bill = 0;
        } else if (units <= 300) {
            bill = (units - 200) * 1.2;
        } else if (units <= 400) {
            bill = (100 * 1.2) + (units - 300) * 1.5;
        } else if (units <= 500) {
            bill = (100 * 1.2) + (100 * 1.5) + (units - 400) * 2.5;
        } else {
            bill = (100 * 1.2) + (100 * 1.5) + (100 * 2.5) + (units - 500) * 8;
        }

        System.out.println("Units Consumed : " + units);
        System.out.println("Total Bill     : ₹" + bill);
    }

    // ──────────────────────────────────────────────
    // Q9. Valid Currency Note Check
    // Valid notes: 2000, 500, 200, 100, 50
    // ──────────────────────────────────────────────
    static void checkCurrencyNote() {
        System.out.print("Q9 - Enter currency note value: ");
        int note = sc.nextInt();
        if (note == 2000 || note == 500 || note == 200 || note == 100 || note == 50)
            System.out.println("₹" + note + " is a valid currency note. Deposit accepted.");
        else
            System.out.println("₹" + note + " is NOT a valid currency note. Deposit rejected.");
    }

    // ──────────────────────────────────────────────
    // Q10. ATM Currency Denomination Dispenser
    // Notes available: 2000, 500, 200, 100, 50
    // Amount must be a multiple of 50
    // ──────────────────────────────────────────────
    static void atmDispenser() {
        System.out.print("Q10 - Enter amount to withdraw: ");
        int amount = sc.nextInt();

        if (amount <= 0 || amount % 50 != 0) {
            System.out.println("Invalid amount. Must be positive and a multiple of 50.");
            return;
        }
    

        int[] denominations = {2000, 500, 200, 100, 50};
        int remaining = amount;

        System.out.println("\n--- Currency Denomination ---");
        for (int note : denominations) {
            int count = remaining / note;
            if (count > 0) {
                System.out.println("₹" + note + " x " + count + " = ₹" + (note * count));
                remaining -= count * note;
            }
        }

        if (remaining != 0)
            System.out.println("Cannot fully dispense ₹" + amount + " with available notes.");
        else
            System.out.println("Total Dispensed: ₹" + amount);
    }

    // ──────────────────────────────────────────────
    // MAIN METHOD — calls all functions
    // ──────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("========== Q1: Even or Odd ==========");
        checkEvenOdd();

        System.out.println("\n========== Q2: Positive/Negative/Zero ==========");
        checkSign();

        System.out.println("\n========== Q3: Character Type ==========");
        checkCharType();

        System.out.println("\n========== Q4: Login Check ==========");
        checkLogin();

        System.out.println("\n========== Q5: Leap Year ==========");
        checkLeapYear();

        System.out.println("\n========== Q6: Greatest of Three ==========");
        greatestOfThree();

        System.out.println("\n========== Q7: Student Grade ==========");
        checkGrade();

        System.out.println("\n========== Q8: Electricity Bill ==========");
        electricityBill();

        System.out.println("\n========== Q9: Currency Note Validity ==========");
        checkCurrencyNote();

        System.out.println("\n========== Q10: ATM Dispenser ==========");
        atmDispenser();

        sc.close();
    }
}

