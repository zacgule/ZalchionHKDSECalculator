import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ZalchionHKDSECalculator {
    private static final List<String> customFormulas = new ArrayList<>();
    private static final List<String> calculationHistory = new ArrayList<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Zalchion HKDSE Mathematics Calculator!");
            boolean continueCalculating = true;

            while (continueCalculating) {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.println("5. Square Root (√)");
                System.out.println("6. Factorial");
                System.out.println("7. Permutation (nPr)");
                System.out.println("8. Combination (nCr)");
                System.out.println("9. Arithmetic Mean");
                System.out.println("10. Geometric Mean");
                System.out.println("11. Standard Deviation");
                System.out.println("12. Quadratic Equation Solver");
                System.out.println("13. Linear Equation Solver");
                System.out.println("14. Heron's Formula for Triangle Area");
                System.out.println("15. Arithmetic Sequence Sum");
                System.out.println("16. Geometric Sequence Sum");
                System.out.println("17. Store Custom Formula");
                System.out.println("18. View Custom Formulas");
                System.out.println("19. View Calculation History");
                System.out.println("20. Help");
                System.out.println("21. Exit");
                System.out.println("22. Start Quiz");

                int choice = getValidInteger(scanner);
                switch (choice) {
                    case 1 -> {
                        double result = performAddition(scanner);
                        System.out.println("Result: " + result);
                        calculationHistory.add("Addition Result: " + result);
                    }
                    case 2 -> {
                        double result = performSubtraction(scanner);
                        System.out.println("Result: " + result);
                        calculationHistory.add("Subtraction Result: " + result);
                    }
                    case 3 -> {
                        double result = performMultiplication(scanner);
                        System.out.println("Result: " + result);
                        calculationHistory.add("Multiplication Result: " + result);
                    }
                    case 4 -> {
                        double result = performDivision(scanner);
                        System.out.println("Result: " + result);
                        calculationHistory.add("Division Result: " + result);
                    }
                    case 5 -> {
                        System.out.print("Enter a number to find the square root: ");
                        double num = getValidDouble(scanner);
                        double result = squareRoot(num);
                        System.out.println("Result: √" + num + " = " + result);
                        calculationHistory.add("Square Root Result: " + result);
                    }
                    case 6 -> {
                        System.out.print("Enter a number for factorial: ");
                        int num = getValidInteger(scanner);
                        double result = factorial(num);
                        System.out.println("Result: " + num + "! = " + result);
                        calculationHistory.add("Factorial Result: " + result);
                    }
                    case 7 -> {
                        System.out.print("Enter n (total items): ");
                        int n = getValidInteger(scanner);
                        System.out.print("Enter r (items to choose): ");
                        int r = getValidInteger(scanner);
                        double result = permutation(n, r);
                        System.out.println("Result: " + n + "P" + r + " = " + result);
                        calculationHistory.add("Permutation Result: " + result);
                    }
                    case 8 -> {
                        System.out.print("Enter n (total items): ");
                        int n = getValidInteger(scanner);
                        System.out.print("Enter r (items to choose): ");
                        int r = getValidInteger(scanner);
                        double result = combination(n, r);
                        System.out.println("Result: " + n + "C" + r + " = " + result);
                        calculationHistory.add("Combination Result: " + result);
                    }
                    case 9 -> {
                        System.out.print("Enter the first number: ");
                        double a = getValidDouble(scanner);
                        System.out.print("Enter the second number: ");
                        double b = getValidDouble(scanner);
                        double result = arithmeticMean(a, b);
                        System.out.println("Result: Arithmetic Mean = " + result);
                        calculationHistory.add("Arithmetic Mean Result: " + result);
                    }
                    case 10 -> {
                        System.out.print("Enter the first number: ");
                        double a = getValidDouble(scanner);
                        System.out.print("Enter the second number: ");
                        double b = getValidDouble(scanner);
                        double result = geometricMean(a, b);
                        System.out.println("Result: Geometric Mean = " + result);
                        calculationHistory.add("Geometric Mean Result: " + result);
                    }
                    case 11 -> {
                        System.out.print("Enter the number of values for Standard Deviation: ");
                        int n = getValidInteger(scanner);
                        double[] values = new double[n];
                        System.out.println("Enter the values:");
                        for (int i = 0; i < n; i++) {
                            values[i] = getValidDouble(scanner);
                        }
                        double result = standardDeviation(values);
                        System.out.println("Result: Standard Deviation = " + result);
                        calculationHistory.add("Standard Deviation Result: " + result);
                    }
                    case 12 -> {
                        solveQuadraticEquation(scanner);
                    }
                    case 13 -> {
                        solveLinearEquation(scanner);
                    }
                    case 14 -> {
                        calculateHeronsFormula(scanner);
                    }
                    case 15 -> {
                        calculateArithmeticSequenceSum(scanner);
                    }
                    case 16 -> {
                        calculateGeometricSequenceSum(scanner);
                    }
                    case 17 -> {
                        storeCustomFormula(scanner);
                    }
                    case 18 -> {
                        viewCustomFormulas();
                    }
                    case 19 -> {
                        viewCalculationHistory();
                    }
                    case 20 -> {
                        displayHelp();
                    }
                    case 21 -> {
                        continueCalculating = false;
                        System.out.println("Exiting the calculator. Goodbye!");
                    }
                    case 22 -> {
                        startQuiz(scanner);
                    }
                    default -> System.out.println("Invalid operation selected. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Get a valid integer input
    public static int getValidInteger(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }

    // Get a valid double input
    public static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    // Perform Addition
    public static double performAddition(Scanner scanner) {
        List<Double> numbers = new ArrayList<>();
        double input;
        System.out.print("Enter a number to add (or type 'done' to finish): ");
        while (scanner.hasNextDouble()) {
            input = scanner.nextDouble();
            numbers.add(input);
            System.out.print("Enter another number to add (or type 'done' to finish): ");
        }
        scanner.next(); // Consume the non-double input (e.g., "done")
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

    // Perform Subtraction
    public static double performSubtraction(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double result = getValidDouble(scanner);
        double input;
        System.out.print("Enter a number to subtract (or type 'done' to finish): ");
        while (scanner.hasNextDouble()) {
            input = scanner.nextDouble();
            result -= input;
            System.out.print("Enter another number to subtract (or type 'done' to finish): ");
        }
        scanner.next(); // Consume the non-double input (e.g., "done")
        return result;
    }

    // Perform Multiplication
    public static double performMultiplication(Scanner scanner) {
        List<Double> numbers = new ArrayList<>();
        double input;
        System.out.print("Enter a number to multiply (or type 'done' to finish): ");
        while (scanner.hasNextDouble()) {
            input = scanner.nextDouble();
            numbers.add(input);
            System.out.print("Enter another number to multiply (or type 'done' to finish): ");
        }
        scanner.next(); // Consume the non-double input (e.g., "done")
        return numbers.stream().mapToDouble(Double::doubleValue).reduce(1, (a, b) -> a * b);
    }

    // Perform Division
    public static double performDivision(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double result = getValidDouble(scanner);
        double input;
        System.out.print("Enter a number to divide by (or type 'done' to finish): ");
        while (scanner.hasNextDouble()) {
            input = scanner.nextDouble();
            if (input != 0) {
                result /= input;
            } else {
                System.out.println("Error: Division by zero is not allowed.");
            }
            System.out.print("Enter another number to divide by (or type 'done' to finish): ");
        }
        scanner.next(); // Consume the non-double input (e.g., "done")
        return result;
    }

    // Square Root Function
    public static double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Square root is not defined for negative numbers.");
        }
        return Math.sqrt(a);
    }

    // Factorial Function
    public static double factorial(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        double result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    // Permutation Function
    public static double permutation(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    // Combination Function
    public static double combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    // Mean Functions
    public static double arithmeticMean(double a, double b) {
        return (a + b) / 2;
    }

    public static double geometricMean(double a, double b) {
        return Math.sqrt(a * b);
    }

    // Standard Deviation Function
    public static double standardDeviation(double[] values) {
        double mean = 0;
        for (double value : values) {
            mean += value;
        }
        mean /= values.length;

        double sumSquaredDiffs = 0;
        for (double value : values) {
            sumSquaredDiffs += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sumSquaredDiffs / values.length);
    }

    // Quadratic Equation Solver
    public static void solveQuadraticEquation(Scanner scanner) {
        System.out.print("Enter coefficient a: ");
        double a = getValidDouble(scanner);
        System.out.print("Enter coefficient b: ");
        double b = getValidDouble(scanner);
        System.out.print("Enter coefficient c: ");
        double c = getValidDouble(scanner);

        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are real and different: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Roots are real and the same: " + root);
        } else {
            System.out.println("Roots are complex and different.");
        }
    }

    // Linear Equation Solver
    public static void solveLinearEquation(Scanner scanner) {
        System.out.print("Enter coefficient a (for ax + b = 0): ");
        double a = getValidDouble(scanner);
        System.out.print("Enter coefficient b: ");
        double b = getValidDouble(scanner);

        if (a != 0) {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Heron's Formula for Triangle Area
    public static void calculateHeronsFormula(Scanner scanner) {
        System.out.print("Enter side a: ");
        double a = getValidDouble(scanner);
        System.out.print("Enter side b: ");
        double b = getValidDouble(scanner);
        System.out.print("Enter side c: ");
        double c = getValidDouble(scanner);

        double s = (a + b + c) / 2; // Semi-perimeter
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println("The area of the triangle is: " + area);
    }

    // Calculate the sum of an arithmetic sequence
    public static void calculateArithmeticSequenceSum(Scanner scanner) {
        System.out.print("Enter the first term (a1): ");
        double a1 = getValidDouble(scanner);
        System.out.print("Enter the common difference (d): ");
        double d = getValidDouble(scanner);
        System.out.print("Enter the number of terms (n): ");
        int n = getValidInteger(scanner);

        double sum = (n / 2.0) * (2 * a1 + (n - 1) * d);
        System.out.println("The sum of the arithmetic sequence is: " + sum);
    }

    // Calculate the sum of a geometric sequence
    public static void calculateGeometricSequenceSum(Scanner scanner) {
        System.out.print("Enter the first term (a1): ");
        double a1 = getValidDouble(scanner);
        System.out.print("Enter the common ratio (r): ");
        double r = getValidDouble(scanner);
        System.out.print("Enter the number of terms (n): ");
        int n = getValidInteger(scanner);

        double sum;
        if (r == 1) {
            sum = a1 * n; // If r is 1, the sum is simply n times the first term
        } else {
            sum = a1 * (1 - Math.pow(r, n)) / (1 - r);
        }
        System.out.println("The sum of the geometric sequence is: " + sum);
    }

    // Store Custom Formula
    public static void storeCustomFormula(Scanner scanner) {
        System.out.print("Enter your custom formula: ");
        scanner.nextLine(); // Consume newline
        String formula = scanner.nextLine();
        customFormulas.add(formula);
        System.out.println("Formula stored successfully!");
    }

    // View Custom Formulas
    public static void viewCustomFormulas() {
        if (customFormulas.isEmpty()) {
            System.out.println("No custom formulas stored.");
        } else {
            System.out.println("Stored Custom Formulas:");
            for (int i = 0; i < customFormulas.size(); i++) {
                System.out.println((i + 1) + ". " + customFormulas.get(i));
            }
        }
    }

    // View Calculation History
    public static void viewCalculationHistory() {
        if (calculationHistory.isEmpty()) {
            System.out.println("No calculations have been performed yet.");
        } else {
            System.out.println("Calculation History:");
            for (String entry : calculationHistory) {
                System.out.println(entry);
            }
        }
    }

    // Display Help
    public static void displayHelp() {
        System.out.println("Help Menu:");
        System.out.println("1. Addition: Adds multiple numbers together.");
        System.out.println("2. Subtraction: Subtracts numbers from the first input.");
        System.out.println("3. Multiplication: Multiplies multiple numbers together.");
        System.out.println("4. Division: Divides the first number by subsequent numbers.");
        System.out.println("5. Square Root: Calculates the square root of a number.");
        System.out.println("6. Factorial: Calculates the factorial of a non-negative integer.");
        System.out.println("7. Permutation: Calculates the number of ways to choose r items from n.");
        System.out.println("8. Combination: Calculates the number of combinations of r items from n.");
        System.out.println("9. Arithmetic Mean: Calculates the average of two numbers.");
        System.out.println("10. Geometric Mean: Calculates the geometric mean of two numbers.");
        System.out.println("11. Standard Deviation: Measures the dispersion of a set of values.");
        System.out.println("12. Quadratic Equation Solver: Solves equations of the form ax^2 + bx + c = 0.");
        System.out.println("13. Linear Equation Solver: Solves equations of the form ax + b = 0.");
        System.out.println("14. Heron's Formula: Calculates the area of a triangle given its sides.");
        System.out.println("15. Arithmetic Sequence Sum: Calculates the sum of an arithmetic sequence.");
        System.out.println("16. Geometric Sequence Sum: Calculates the sum of a geometric sequence.");
        System.out.println("17. Store Custom Formula: Allows you to store a custom formula for later use.");
        System.out.println("18. View Custom Formulas: Displays all stored custom formulas.");
        System.out.println("19. View Calculation History: Displays the history of calculations performed.");
        System.out.println("20. Exit: Exits the calculator.");
    }

    // Start Quiz

public static void startQuiz(Scanner scanner) {
    boolean continueQuiz = true;
    while (continueQuiz) {
        int score = 0;
        int totalQuestions = 20; // Number of questions in the quiz
        for (int i = 0; i < totalQuestions; i++) {
            int questionType = random.nextInt(17); // Randomly select a question type from 17 topics
            boolean answered = false; // Track if the question has been answered
            double correctAnswer = 0; // Variable to hold the correct ans

                while (!answered) {
                    switch (questionType) {
                        case 0 -> { // Square Root
                            int a = random.nextInt(1, 10);
                            correctAnswer = a; // Correct answer
                            askQuestion(scanner, "What is the square root of " + (a * a) + "? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        case 1 -> { // Factorial
                            int a = random.nextInt(0, 6); // Factorial of numbers 0 to 5
                            correctAnswer = factorial(a);
                            askQuestion(scanner, "What is " + a + "!? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        case 2 -> { // Permutation
                            int n = random.nextInt(1, 6); // n from 1 to 5
                            int r = random.nextInt(0, n + 1); // r from 0 to n
                            correctAnswer = permutation(n, r);
                            askQuestion(scanner, "What is " + n + "P" + r + "? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        case 3 -> { // Combination
                            int n = random.nextInt(1, 6); // n from 1 to 5
                            int r = random.nextInt(0, n + 1); // r from 0 to n
                            correctAnswer = combination(n, r);
                            askQuestion(scanner, "What is " + n + "C" + r + "? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        case 4 -> { // Arithmetic Mean
                            int a = random.nextInt(1, 10);
                            int b = random.nextInt(1, 10);
                            correctAnswer = arithmeticMean(a, b);
                            askQuestion(scanner, "What is the arithmetic mean of " + a + " and " + b + "? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        case 5 -> { // Geometric Mean
                            int a = random.nextInt(1, 10);
                            int b = random.nextInt(1, 10);
                            correctAnswer = geometricMean(a, b);
                            askQuestion(scanner, "What is the geometric mean of " + a + " and " + b + "? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                       
                        case 6 -> { // Standard Deviation
                    int n = random.nextInt(2, 6); // Number of values from 2 to 5
                    double[] values = new double[n];
                    System.out.print("Enter " + n + " values for standard deviation: ");
                    for (int j = 0; j < n; j++) {
                        values[j] = random.nextDouble() * 10; // Random values between 0 and 10
                        System.out.print(values[j] + " "); // Print the generated values for user reference
                    }
                    System.out.println(); // New line for better formatting
                    correctAnswer = standardDeviation(values); // Calculate the correct answer
                    // Ask the question using the generated values
                    askQuestion(scanner, "What is the standard deviation of these values? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                    answered = true; // Mark the question as answered
                }
                        case 7 -> { // Quadratic Equation Solver
                            double a = random.nextDouble() * 10 + 1; // Coefficient a (1 to 10)
                            double b = random.nextDouble() * 10 - 5; // Coefficient b (-5 to 5)
                            double c = random.nextDouble() * 10 - 5; // Coefficient c (-5 to 5)
                            double discriminant = b * b - 4 * a * c;
                            correctAnswer = (-b + Math.sqrt(discriminant)) / (2 * a); // One of the roots
                            askQuestion(scanner, "Solve the quadratic equation " + a + "x^2 + " + b + "x + " + c + " = 0. Enter one root: (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        case 8 -> { // Linear Equation Solver
                            double a = random.nextDouble() * 10 + 1; // Coefficient a (1 to 10)
                            double b = random.nextDouble() * 10 - 5; // Coefficient b (-5 to 5)
                            correctAnswer = -b / a;
                            askQuestion(scanner, "Solve the linear equation " + a + "x + " + b + " = 0. What is x? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        case 9 -> { // Heron's Formula
                            double a = random.nextDouble() * 10 + 1; // Side a (1 to 10)
                            double b = random.nextDouble() * 10 + 1; // Side b (1 to 10)
                            double c = random.nextDouble() * 10 + 1; // Side c (1 to 10)
                            double s = (a + b + c) / 2; // Semi-perimeter
                            correctAnswer = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                            askQuestion(scanner, "What is the area of a triangle with sides " + a + ", " + b + ", and " + c + "? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        case 10 -> { // Arithmetic Sequence Sum
                            double a1 = random.nextDouble() * 10 + 1; // First term (1 to 10)
                            double d = random.nextDouble() * 5 + 1; // Common difference (1 to 5)
                            int n = random.nextInt(1, 6); // Number of terms (1 to 5)
                            correctAnswer = (n / 2.0) * (2 * a1 + (n - 1) * d);
                            askQuestion(scanner, "What is the sum of the first " + n + " terms of an arithmetic sequence with first term " + a1 + " and common difference " + d + "? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        case 11 -> { // Geometric Sequence Sum
                            double a1 = random.nextDouble() * 10 + 1; // First term (1 to 10)
                            double r = random.nextDouble() * 2 + 1; // Common ratio (1 to 3)
                            int n = random.nextInt(1, 6); // Number of terms (1 to 5)
                            double sum;
                            if (r == 1) {
                                sum = a1 * n; // If r is 1, the sum is simply n times the first term
                            } else {
                                sum = a1 * (1 - Math.pow(r, n)) / (1 - r);
                            }
                            correctAnswer = sum;
                            askQuestion(scanner, "What is the sum of the first " + n + " terms of a geometric sequence with first term " + a1 + " and common ratio " + r + "? (Type 'help' for assistance or 'calculate' to perform calculations) ", correctAnswer);
                        }
                        default -> System.out.println("Invalid question type.");
                    }
                }
            }
            System.out.println("Quiz finished! Your score: " + score + "/" + totalQuestions);
            System.out.print("Would you like to redo the quiz? (yes/no): ");
            String redoQuiz = scanner.next();
            continueQuiz = redoQuiz.equalsIgnoreCase("yes");
        }
    }

    // Method to ask a question and handle user input
    private static void askQuestion(Scanner scanner, String question, double correctAnswer) {
        boolean answered = false;
        while (!answered) {
            System.out.print(question);
            String input = scanner.next();
            if (input.equalsIgnoreCase("help")) {
                displayHelp();
            } else if (input.equalsIgnoreCase("calculate")) {
                performCalculation(scanner); // Allow students to perform calculations
            } else {
                try {
                    double userAnswer = Double.parseDouble(input);
                    if (Math.abs(userAnswer - correctAnswer) < 0.01) {
                        System.out.println("Correct!");
                        answered = true;
                    } else {
                        System.out.println("Incorrect. The correct answer is " + correctAnswer + ".");
                        System.out.print("Would you like to try again? (yes/no): ");
                        String retry = scanner.next();
                        if (retry.equalsIgnoreCase("no")) {
                            answered = true; // Move to the next question
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or type 'help' for assistance.");
                }
            }
        }
    }

        // Method to perform calculations during the quiz
    private static void performCalculation(Scanner scanner) {
        boolean continueCalculating = true;
        while (continueCalculating) {
            System.out.println("You can perform calculations now. Choose an operation:");
            System.out.println("1. Addition: Adds multiple numbers together.");
            System.out.println("2. Subtraction: Subtracts numbers from the first input.");
            System.out.println("3. Multiplication: Multiplies multiple numbers together.");
            System.out.println("4. Division: Divides the first number by subsequent numbers.");
            System.out.println("5. Square Root: Calculates the square root of a number.");
            System.out.println("6. Factorial: Calculates the factorial of a non-negative integer.");
            System.out.println("7. Permutation: Calculates the number of ways to choose r items from n.");
            System.out.println("8. Combination: Calculates the number of combinations of r items from n.");
            System.out.println("9. Arithmetic Mean: Calculates the average of two numbers.");
            System.out.println("10. Geometric Mean: Calculates the geometric mean of two numbers.");
            System.out.println("11. Standard Deviation: Measures the dispersion of a set of values.");
            System.out.println("12. Quadratic Equation Solver: Solves equations of the form ax^2 + bx + c = 0.");
            System.out.println("13. Linear Equation Solver: Solves equations of the form ax + b = 0.");
            System.out.println("14. Heron's Formula: Calculates the area of a triangle given its sides.");
            System.out.println("15. Arithmetic Sequence Sum: Calculates the sum of an arithmetic sequence.");
            System.out.println("16. Geometric Sequence Sum: Calculates the sum of a geometric sequence.");
            System.out.println("17. Store Custom Formula: Allows you to store a custom formula for later use.");
            System.out.println("18. View Custom Formulas: Displays all stored custom formulas.");
            System.out.println("19. View Calculation History: Displays the history of calculations performed.");
            System.out.println("20. Exit to Quiz");

            int operation = getValidInteger(scanner);
            double result = 0;

            switch (operation) {
                case 1 -> result = performAddition(scanner);
                case 2 -> result = performSubtraction(scanner);
                case 3 -> result = performMultiplication(scanner);
                case 4 -> result = performDivision(scanner);
                case 5 -> {
                    System.out.print("Enter a number to find the square root: ");
                    double num = getValidDouble(scanner);
                    result = squareRoot(num);
                }
                case 6 -> {
                    System.out.print("Enter a number for factorial: ");
                    int num = getValidInteger(scanner);
                    result = factorial(num);
                }
                case 7 -> {
                    System.out.print("Enter n (total items): ");
                    int n = getValidInteger(scanner);
                    System.out.print("Enter r (items to choose): ");
                    int r = getValidInteger(scanner);
                    result = permutation(n, r);
                }
                case 8 -> {
                    System.out.print("Enter n (total items): ");
                    int n = getValidInteger(scanner);
                    System.out.print("Enter r (items to choose): ");
                    int r = getValidInteger(scanner);
                    result = combination(n, r);
                }
                case 9 -> {
                    System.out.print("Enter the first number: ");
                    double a = getValidDouble(scanner);
                    System.out.print("Enter the second number: ");
                    double b = getValidDouble(scanner);
                    result = arithmeticMean(a, b);
                }
                case 10 -> {
                    System.out.print("Enter the first number: ");
                    double a = getValidDouble(scanner);
                    System.out.print("Enter the second number: ");
                    double b = getValidDouble(scanner);
                    result = geometricMean(a, b);
                }
                case 11 -> {
                    System.out.print("Enter the number of values for Standard Deviation: ");
                    int n = getValidInteger(scanner);
                    double[] values = new double[n];
                    System.out.println("Enter the values:");
                    for (int i = 0; i < n; i++) {
                        values[i] = getValidDouble(scanner);
                    }
                    result = standardDeviation(values);
                }
                case 12 -> {
                    solveQuadraticEquation(scanner);
                    continue; // Skip result display for this operation
                }
                case 13 -> {
                    solveLinearEquation(scanner);
                    continue; // Skip result display for this operation
                }
                case 14 -> {
                    calculateHeronsFormula(scanner);
                    continue; // Skip result display for this operation
                }
                case 15 -> {
                    calculateArithmeticSequenceSum(scanner);
                    continue; // Skip result display for this operation
                }
                case 16 -> {
                    calculateGeometricSequenceSum(scanner);
                    continue; // Skip result display for this operation
                }
                case 17 -> {
                    storeCustomFormula(scanner);
                    continue; // Skip result display for this operation
                }
                case 18 -> {
                    viewCustomFormulas();
                    continue; // Skip result display for this operation
                }
                case 19 -> {
                    viewCalculationHistory();
                    continue; // Skip result display for this operation
                }
                case 20 -> {
                    continueCalculating = false; // Exit to quiz
                    continue; // Skip to the next iteration
                }
                default -> System.out.println("Invalid operation selected.");
            }

            System.out.println("Calculation Result: " + result);
        }
    }
}