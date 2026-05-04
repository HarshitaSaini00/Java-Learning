import java.util.*;

public class MiniProject {

    static Scanner sc = new Scanner(System.in);
    static double memory = 0; // last result memory

    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("=======================================");
        System.out.println(" Welcome " + name + " to Smart Utility System ");
        System.out.println("=======================================");

        mainMenu();
    }

    // ================= MAIN MENU =================
    static void mainMenu() {
        int attempts = 0;

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Calculator");
            System.out.println("2. Number Analyzer");
            System.out.println("3. Pattern Generator");
            System.out.println("4. Advanced Math Tools");
            System.out.println("5. Exit");

            int choice = getIntInput();

            switch (choice) {
                case 1: calculator(); break;
                case 2: numberAnalyzer(); break;
                case 3: patternGenerator(); break;
                case 4: advancedMath(); break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    attempts++;
                    System.out.println("Invalid choice!");
                    if (attempts >= 3) terminate();
            }
        }
    }

    // ================= MODULE 1: CALCULATOR =================
    static void calculator() {
        while (true) {
            System.out.println("\nCalculator (+ - * / %)");
            System.out.println("Enter operator (* to go back, # to exit):");
            String op = sc.next();

            if (op.equals("*")) return;
            if (op.equals("#")) terminate();

            System.out.print("Enter first number (or M for memory): ");
            double a = getDoubleOrMemory();

            System.out.print("Enter second number: ");
            double b = getDoubleInput();

            double result = 0;

            switch (op) {
                case "+": result = add(a, b); break;
                case "-": result = subtract(a, b); break;
                case "*": result = multiply(a, b); break;
                case "/":
                    if (b == 0) {
                        System.out.println("Cannot divide by zero!");
                        continue;
                    }
                    result = divide(a, b); break;
                case "%": result = mod(a, b); break;
                default:
                    System.out.println("Invalid operator!");
                    continue;
            }

            memory = result;
            System.out.println("Result = " + result);

            if (!continueOption()) return;
        }
    }

    static double add(double a, double b) { return a + b; }
    static double subtract(double a, double b) { return a - b; }
    static double multiply(double a, double b) { return a * b; }
    static double divide(double a, double b) { return a / b; }
    static double mod(double a, double b) { return a % b; }

    // ================= MODULE 2: NUMBER ANALYZER =================
    static void numberAnalyzer() {
        while (true) {
            System.out.print("\nEnter number (* to go back): ");
            String input = sc.next();
            if (input.equals("*")) return;
            if (input.equals("#")) terminate();

            int n = Integer.parseInt(input);

            System.out.println("Even/Odd: " + (isEven(n) ? "Even" : "Odd"));
            System.out.println("Prime: " + (isPrime(n) ? "Yes" : "No"));
            System.out.println("Palindrome: " + (isPalindrome(n) ? "Yes" : "No"));
            System.out.println("Armstrong: " + (isArmstrong(n) ? "Yes" : "No"));
            System.out.println("Digits: " + countDigits(n));

            if (!continueOption()) return;
        }
    }

    static boolean isEven(int n) { return n % 2 == 0; }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    static boolean isPalindrome(int n) {
        int rev = 0, temp = Math.abs(n);
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return rev == Math.abs(n);
    }

    static boolean isArmstrong(int n) {
        int temp = Math.abs(n);
        int digits = countDigits(temp);
        int sum = 0;

        while (temp > 0) {
            int d = temp % 10;
            sum += power(d, digits);
            temp /= 10;
        }
        return sum == Math.abs(n);
    }

    static int countDigits(int n) {
        n = Math.abs(n);
        int count = 0;
        do {
            count++;
            n /= 10;
        } while (n > 0);
        return count;
    }

    // ================= MODULE 3: PATTERN GENERATOR =================
    static void patternGenerator() {
        while (true) {
            System.out.println("\nPattern Generator");
            System.out.println("1. Star Triangle");
            System.out.println("2. Reverse Star");
            System.out.println("3. Number Triangle");
            System.out.println("4. Pyramid");
            System.out.println("* Back | # Exit");

            String choice = sc.next();

            if (choice.equals("*")) return;
            if (choice.equals("#")) terminate();

            System.out.print("Enter size: ");
            int n = getIntInput();

            switch (choice) {
                case "1": starTriangle(n); break;
                case "2": reverseStar(n); break;
                case "3": numberTriangle(n); break;
                case "4": pyramid(n); break;
                default: System.out.println("Invalid");
            }

            if (!continueOption()) return;
        }
    }

    static void starTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    static void reverseStar(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    static void numberTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j + " ");
            System.out.println();
        }
    }

    static void pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
    }

    // ================= MODULE 4: ADVANCED MATH =================
    static void advancedMath() {
        while (true) {
            System.out.println("\nAdvanced Math");
            System.out.println("1. Factorial");
            System.out.println("2. Fibonacci");
            System.out.println("3. Power");
            System.out.println("4. GCD & LCM");
            System.out.println("* Back | # Exit");

            String choice = sc.next();

            if (choice.equals("*")) return;
            if (choice.equals("#")) terminate();

            switch (choice) {
                case "1":
                    int n = getIntInput();
                    System.out.println("Factorial = " + factorial(n));
                    break;
                case "2":
                    int f = getIntInput();
                    fibonacci(f);
                    break;
                case "3":
                    int a = getIntInput();
                    int b = getIntInput();
                    System.out.println("Power = " + power(a, b));
                    break;
                case "4":
                    int x = getIntInput();
                    int y = getIntInput();
                    int g = gcd(x, y);
                    int l = (x * y) / g;
                    System.out.println("GCD = " + g + " LCM = " + l);
                    break;
                default:
                    System.out.println("Invalid");
            }

            if (!continueOption()) return;
        }
    }

    static long factorial(int n) {
        if (n < 0) return -1;
        long f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }

    static void fibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    static int power(int a, int b) {
        int res = 1;
        for (int i = 1; i <= b; i++) res *= a;
        return res;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // ================= UTILITIES =================
    static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Enter number:");
            sc.next();
        }
        return sc.nextInt();
    }

    static double getDoubleInput() {
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input! Enter number:");
            sc.next();
        }
        return sc.nextDouble();
    }

    static double getDoubleOrMemory() {
        String input = sc.next();
        if (input.equalsIgnoreCase("M")) return memory;
        return Double.parseDouble(input);
    }

    static boolean continueOption() {
        System.out.print("Continue? (Y/N): ");
        char ch = sc.next().toUpperCase().charAt(0);
        return ch == 'Y';
    }

    static void terminate() {
        System.out.println("Program terminated due to invalid inputs");
        System.exit(0);
    }
}