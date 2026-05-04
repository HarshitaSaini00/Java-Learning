package Labs;
import java.util.*;



public class LoopsLabExercise {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case  1: q1();  break;
                case  2: q2();  break;
                case  3: q3();  break;
                case  4: q4();  break;
                case  5: q5();  break;
                case  6: q6();  break;
                case  7: q7();  break;
                case  8: q8();  break;
                case  9: q9();  break;
                case 10: q10(); break;
                case 11: q11(); break;
                case 12: q12(); break;
                case 13: q13(); break;
                case 14: q14(); break;
                case 15: q15(); break;
                case 16: q16(); break;
                case 17: q17(); break;
                case 18: q18(); break;
                case 19: q19(); break;
                case 20: q20(); break;
                case 21: q21(); break;
                case 22: q22(); break;
                case 23: q23(); break;
                case 24: q24(); break;
                case 25: q25(); break;
                case  0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
        sc.close();
    }

    static void printMenu() {
        String[] labels = {
            "Sum of first n numbers",          "Multiplication table of n",
            "Reverse of a string / number",    "Factorial of n",
            "Fibonacci series",                "GCD of two numbers",
            "Binary of a number",              "Frequency of digits",
            "Rotate a number clockwise",       "Automorphic number check",
            "Trailing zeros in n!",            "Pascal's Triangle",
            "Diamond Pattern",                 "Palindromic Pyramid",
            "Floyd's Triangle",               "Spy Number check",
            "Duck Number check",              "Disarium Number check",
            "Circular Prime check",           "Staggered Pattern",
            "Move zeros to end",              "Find duplicate digits",
            "Mini Bank System",               "Monthly Calendar",
            "All Number Patterns"
        };
        System.out.println("\n========================================");
        System.out.println("        LOOPS LAB EXERCISE              ");
        System.out.println("========================================");
        for (int i = 0; i < labels.length; i++)
            System.out.printf("%2d. %s%n", i + 1, labels[i]);
        System.out.println(" 0. Exit");
        System.out.println("========================================");
        System.out.print("Choice: ");
    }

    // ================================================================
    // Q1 – Sum of first n natural numbers
    // ================================================================
    static void q1() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        System.out.println("Sum of first " + n + " numbers = " + sum);
        // Shortcut: n*(n+1)/2
        System.out.println("[Formula n*(n+1)/2 = " + (n * (n + 1) / 2) + "]");
    }

    // ================================================================
    // Q2 – Multiplication table of n
    // ================================================================
    static void q2() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Multiplication Table of " + n + ":");
        for (int i = 1; i <= 10; i++)
            System.out.printf("  %d x %2d = %3d%n", n, i, n * i);
    }

    // ================================================================
    // Q3 – Reverse of a string or number  (Hello -> olleH)
    // ================================================================
    static void q3() {
        System.out.print("Enter string or number: ");
        String input = sc.next();
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Input    : " + input);
        System.out.println("Reversed : " + reversed);
    }

    // ================================================================
    // Q4 – Factorial of n
    // ================================================================
    static void q4() {
        System.out.print("Enter n (0-20): ");
        int n = sc.nextInt();
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        System.out.println(n + "! = " + fact);
    }

    // ================================================================
    // Q5 – Fibonacci series of n terms  (1 1 2 3 5 8 13 ...)
    // ================================================================
    static void q5() {
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        int a = 1, b = 1;
        System.out.print("Fibonacci: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + (i < n - 1 ? " " : "\n"));
            int temp = a + b;
            a = b;
            b = temp;
        }
    }

    // ================================================================
    // Q6 – GCD of two numbers  (12, 18 -> 6)
    // ================================================================
    static void q6() {
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println("GCD(" + a + ", " + b + ") = " + gcd(a, b));
    }

    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    // ================================================================
    // Q7 – Binary representation  (manual loop, no Integer.toBinaryString)
    // ================================================================
    static void q7() {
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        if (n == 0) { System.out.println("Binary: 0"); return; }
        StringBuilder bin = new StringBuilder();
        int tmp = Math.abs(n);
        while (tmp > 0) { bin.insert(0, tmp % 2); tmp /= 2; }
        System.out.println("Binary of " + n + " = " + bin);
    }

    // ================================================================
    // Q8 – Frequency of each digit  (833982 -> 8:2, 3:2, 9:1, 2:1)
    // ================================================================
    static void q8() {
        System.out.print("Enter a number: ");
        String n = sc.next();
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : n.toCharArray())
            if (Character.isDigit(c)) freq.merge(c, 1, Integer::sum);
        System.out.println("Digit frequencies in " + n + ":");
        freq.forEach((k, v) -> System.out.println("  " + k + " -> " + v));
    }

    // ================================================================
    // Q9 – Rotate number clockwise (last digit goes to front)
    //      12345 -> 51234 -> 45123 -> ...
    // ================================================================
    static void q9() {
        System.out.print("Enter number: ");
        String n = sc.next();
        System.out.print("Number of rotations: ");
        int r = sc.nextInt();
        System.out.println("Original: N = " + n);
        for (int i = 1; i <= r; i++) {
            n = n.charAt(n.length() - 1) + n.substring(0, n.length() - 1);
            System.out.println("After rotation " + i + ": N = " + n);
        }
    }

    // ================================================================
    // Q10 – Automorphic number  (n^2 ends with n: 5^2=25, 25^2=625)
    // ================================================================
    static void q10() {
        System.out.print("Enter number: ");
        long n = sc.nextLong();
        long sq = n * n;
        boolean auto = String.valueOf(sq).endsWith(String.valueOf(n));
        System.out.println(n + "^2 = " + sq);
        System.out.println(n + (auto ? " IS" : " is NOT") + " an Automorphic Number.");
    }

    // ================================================================
    // Q11 – Trailing zeros in n!
    //       Each trailing zero = one factor of 10 = 2x5; count factors of 5
    //       5! = 120 -> 1 trailing zero
    // ================================================================
    static void q11() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int zeros = 0;
        for (long p = 5; p <= n; p *= 5) zeros += n / p;
        System.out.println("Trailing zeros in " + n + "! = " + zeros);
    }

    // ================================================================
    // Q12 – Pascal's Triangle
    //       1
    //       1  1
    //       1  2  1
    //       1  3  3  1
    // ================================================================
    static void q12() {
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Pascal's Triangle:");
        for (int i = 0; i < n; i++) {
            // Leading spaces for centering
            System.out.print(" ".repeat((n - i - 1) * 2));
            long val = 1;
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", val);
                // C(i, j+1) = C(i, j) * (i-j) / (j+1)
                val = val * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    // ================================================================
    // Q13 – Number Diamond Pattern
    //    n=5:          1
    //                1 2 1
    //              1 2 3 2 1
    //            1 2 3 4 3 2 1
    //          1 2 3 4 5 4 3 2 1
    //            1 2 3 4 3 2 1
    //              1 2 3 2 1
    //                1 2 1
    //                  1
    // ================================================================
    static void q13() {
        System.out.print("Enter n (half-height): ");
        int n = sc.nextInt();
        System.out.println("Diamond Pattern:");
        // Upper half (including middle row)
        for (int i = 1; i <= n; i++) {
            System.out.print("  ".repeat(n - i));
            for (int j = 1; j <= i; j++)     System.out.print(j + " ");
            for (int j = i - 1; j >= 1; j--) System.out.print(j + " ");
            System.out.println();
        }
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            System.out.print("  ".repeat(n - i));
            for (int j = 1; j <= i; j++)     System.out.print(j + " ");
            for (int j = i - 1; j >= 1; j--) System.out.print(j + " ");
            System.out.println();
        }
    }

    // ================================================================
    // Q14 – Palindromic Pyramid
    //    n=5:      1
    //             121
    //            12321
    //           1234321
    //          123454321
    // ================================================================
    static void q14() {
        System.out.print("Enter n (rows): ");
        int n = sc.nextInt();
        System.out.println("Palindromic Pyramid:");
        for (int i = 1; i <= n; i++) {
            System.out.print(" ".repeat(n - i));
            for (int j = 1; j <= i; j++)     System.out.print(j);
            for (int j = i - 1; j >= 1; j--) System.out.print(j);
            System.out.println();
        }
    }

    // ================================================================
    // Q15 – Floyd's Triangle
    //    1
    //    2  3
    //    4  5  6
    //    7  8  9  10
    //   11 12 13  14  15
    // ================================================================
    static void q15() {
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Floyd's Triangle:");
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.printf("%-4d", num++);
            System.out.println();
        }
    }

    // ================================================================
    // Q16 – Spy Number  (sum of digits == product of digits)
    //       1124 -> sum = 1+1+2+4 = 8, product = 1*1*2*4 = 8  ✓
    // ================================================================
    static void q16() {
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int sum = 0, prod = 1, tmp = n;
        while (tmp > 0) {
            int d = tmp % 10;
            sum += d;
            prod *= d;
            tmp /= 10;
        }
        System.out.println("Sum of digits     = " + sum);
        System.out.println("Product of digits = " + prod);
        System.out.println(n + (sum == prod ? " IS" : " is NOT") + " a Spy Number.");
    }

    // ================================================================
    // Q17 – Duck Number  (contains 0 but NOT as the leading digit)
    //       1023 -> Duck ✓  |  023 -> NOT a Duck (leading zero)
    // ================================================================
    static void q17() {
        System.out.print("Enter number: ");
        String n = sc.next();
        boolean duck = n.length() > 1 && n.substring(1).contains("0");
        System.out.println(n + (duck ? " IS" : " is NOT") + " a Duck Number.");
    }

    // ================================================================
    // Q18 – Disarium Number  (sum of digit^position == number)
    //       135 -> 1^1 + 3^2 + 5^3 = 1 + 9 + 125 = 135  ✓
    // ================================================================
    static void q18() {
        System.out.print("Enter number: ");
        String s = sc.next();
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += (int) Math.pow(s.charAt(i) - '0', i + 1);
        int n = Integer.parseInt(s);
        System.out.println("Disarium sum = " + sum);
        System.out.println(n + (sum == n ? " IS" : " is NOT") + " a Disarium Number.");
    }

    // ================================================================
    // Q19 – Circular Prime  (all rotations of the number are prime)
    //       197 -> rotations: 971, 719, 197 — all prime  ✓
    // ================================================================
    static void q19() {
        System.out.print("Enter number: ");
        String s = sc.next();
        boolean circular = true;
        String rot = s;
        System.out.println("Rotations of " + s + ":");
        for (int i = 0; i < s.length(); i++) {
            rot = rot.substring(1) + rot.charAt(0); // move first digit to end
            boolean p = isPrime(Integer.parseInt(rot));
            System.out.printf("  %-6s -> %s%n", rot, p ? "prime" : "NOT prime");
            if (!p) circular = false;
        }
        System.out.println(s + (circular ? " IS" : " is NOT") + " a Circular Prime.");
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; (long) i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }

    // ================================================================
    // Q20 – Staggered Pattern
    //   n=3:
    //   1         3         5
    //       2     4     6
    //           7         9
    //
    //   Odd-indexed rows   -> odd  numbers, wider gap, less indent
    //   Even-indexed rows  -> even numbers, narrower gap, more indent
    // ================================================================
    static void q20() {
        System.out.print("Enter n (rows): ");
        int n = sc.nextInt();
        System.out.println("Staggered Pattern:");
        int odd = 1, even = 2;
        for (int row = 0; row < n; row++) {
            System.out.print("  ".repeat(row * 2));   // increasing indent
            int cols = n - (row / 2);                 // columns reduce every 2 rows
            for (int col = 0; col < cols; col++) {
                if (row % 2 == 0) { System.out.printf("%-10d", odd);  odd  += 2; }
                else              { System.out.printf("%-6d",  even); even += 2; }
            }
            System.out.println();
        }
    }

    // ================================================================
    // Q21 – Move all zeros to the end of an array
    //       {0, 3, 0, 1, 5} -> {3, 1, 5, 0, 0}
    // ================================================================
    static void q21() {
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int[] res = new int[n];
        int idx = 0;
        for (int x : arr) if (x != 0) res[idx++] = x;
        // remaining positions are already 0 (default int array value)

        System.out.print("Result: ");
        for (int x : res) System.out.print(x + " ");
        System.out.println();
    }

    // ================================================================
    // Q22 – Find duplicate digits in a number
    //       122334 -> duplicate digits: 2 3
    // ================================================================
    static void q22() {
        System.out.print("Enter number: ");
        String n = sc.next();
        Set<Character> seen  = new HashSet<>();
        Set<Character> dupes = new LinkedHashSet<>();
        for (char c : n.toCharArray()) if (!seen.add(c)) dupes.add(c);
        if (dupes.isEmpty())
            System.out.println("No duplicate digits in " + n + ".");
        else {
            System.out.print("Duplicate digits in " + n + ": ");
            dupes.forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

    // ================================================================
    // Q23 – Mini Bank System (single user)
    // ================================================================
    static void q23() {
        double balance = 0.0;
        int opt;
        do {
            System.out.println("\n------- Mini Bank System -------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("Deposit amount: Rs.");
                    double dep = sc.nextDouble();
                    if (dep <= 0) { System.out.println("Amount must be positive."); break; }
                    balance += dep;
                    System.out.printf("Deposited Rs.%.2f  |  Balance: Rs.%.2f%n", dep, balance);
                    break;
                case 2:
                    System.out.print("Withdraw amount: Rs.");
                    double wd = sc.nextDouble();
                    if (wd <= 0)       { System.out.println("Amount must be positive."); break; }
                    if (wd > balance)  { System.out.println("Insufficient balance."); break; }
                    balance -= wd;
                    System.out.printf("Withdrawn Rs.%.2f  |  Balance: Rs.%.2f%n", wd, balance);
                    break;
                case 3:
                    System.out.printf("Current Balance: Rs.%.2f%n", balance);
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (opt != 4);
    }

    // ================================================================
    // Q24 – Print calendar for a given month and year
    //       e.g. February 2024
    // ================================================================
    static void q24() {
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        if (month < 1 || month > 12) { System.out.println("Invalid month."); return; }

        String[] monthNames = {"", "January","February","March","April","May","June",
                                   "July","August","September","October","November","December"};
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) daysInMonth[2] = 29;

        // Use Calendar to find the day of week of the 1st
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        int startDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // 0=Sun, 1=Mon, ... 6=Sat

        System.out.printf("%n        %s %d%n", monthNames[month], year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        // Leading blank cells
        for (int i = 0; i < startDay; i++) System.out.print("    ");

        for (int day = 1; day <= daysInMonth[month]; day++) {
            System.out.printf("%4d", day);
            if ((startDay + day) % 7 == 0) System.out.println(); // new row every Saturday
        }
        System.out.println();
    }

    static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    // ================================================================
    // Q25 – All Number Patterns from the Lab Image
    // ================================================================
    static void q25() {
        System.out.print("Enter n (e.g. 5): ");
        int n = sc.nextInt();

        // ------------------------------------------------------------------
        // P1: Repeated-digit triangle
        //  1
        //  22
        //  333
        //  4444
        //  55555
        // ------------------------------------------------------------------
        System.out.println("\n[P1] Repeated-digit triangle");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) System.out.print(i);
            System.out.println();
        }

        // ------------------------------------------------------------------
        // P2: Sequential triangle
        //  1
        //  12
        //  123
        //  1234
        //  12345
        // ------------------------------------------------------------------
        System.out.println("\n[P2] Sequential triangle");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j);
            System.out.println();
        }

        // ------------------------------------------------------------------
        // P3: Reverse sequential triangle
        //  1
        //  21
        //  321
        //  4321
        //  54321
        // ------------------------------------------------------------------
        System.out.println("\n[P3] Reverse sequential triangle");
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) System.out.print(j);
            System.out.println();
        }

        // ------------------------------------------------------------------
        // P4: Decreasing rows from current i
        //  54321
        //  4321
        //  321
        //  21
        //  1
        // ------------------------------------------------------------------
        System.out.println("\n[P4] Shrinking reverse triangle");
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) System.out.print(j);
            System.out.println();
        }

        // ------------------------------------------------------------------
        // P5: Shrinking sequential triangle
        //  12345
        //  1234
        //  123
        //  12
        //  1
        // ------------------------------------------------------------------
        System.out.println("\n[P5] Shrinking sequential triangle");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print(j);
            System.out.println();
        }

        // ------------------------------------------------------------------
        // P6: Left-trim staircase
        //  12345
        //   2345
        //    345
        //     45
        //      5
        // ------------------------------------------------------------------
        System.out.println("\n[P6] Left-trim staircase");
        for (int i = 1; i <= n; i++) {
            System.out.print(" ".repeat(i - 1));
            for (int j = i; j <= n; j++) System.out.print(j);
            System.out.println();
        }

        // ------------------------------------------------------------------
        // P7: Right-trim reverse staircase (right-aligned)
        //  54321
        //   5432
        //    543
        //     54
        //      5
        // ------------------------------------------------------------------
        System.out.println("\n[P7] Right-trim reverse staircase");
        for (int i = n; i >= 1; i--) {
            System.out.print(" ".repeat(n - i));
            for (int j = n; j > n - i; j--) System.out.print(j);
            System.out.println();
        }

        // ------------------------------------------------------------------
        // P8: Growing from right
        //  5
        //  45
        //  345
        //  2345
        //  12345
        // ------------------------------------------------------------------
        System.out.println("\n[P8] Growing-from-right triangle");
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j <= n; j++) System.out.print(j);
            System.out.println();
        }

        // ------------------------------------------------------------------
        // P9: Spaced sequential triangle (Floyd's style, with spaces)
        //  1
        //  1 2
        //  1 2 3
        //  1 2 3 4
        //  1 2 3 4 5
        // ------------------------------------------------------------------
        System.out.println("\n[P9] Spaced sequential triangle");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j + " ");
            System.out.println();
        }

        // ------------------------------------------------------------------
        // P10: Countdown Diamond (full diamond, counts down from n to 1)
        //           5
        //         5 4 5
        //       5 4 3 4 5
        //     5 4 3 2 3 4 5
        //   5 4 3 2 1 2 3 4 5
        //     5 4 3 2 3 4 5
        //       5 4 3 4 5
        //         5 4 5
        //           5
        // ------------------------------------------------------------------
        System.out.println("\n[P10] Countdown Diamond");
        // Upper half
        for (int i = 1; i <= n; i++) {
            System.out.print("  ".repeat(n - i));
            for (int j = n; j >= n - i + 1; j--) System.out.print(j + " ");
            for (int j = n - i + 2; j <= n; j++) System.out.print(j + " ");
            System.out.println();
        }
        // Lower half (mirror)
        for (int i = n - 1; i >= 1; i--) {
            System.out.print("  ".repeat(n - i));
            for (int j = n; j >= n - i + 1; j--) System.out.print(j + " ");
            for (int j = n - i + 2; j <= n; j++) System.out.print(j + " ");
            System.out.println();
        }
    }
}

