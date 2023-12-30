import java.util.*;


public class tasks6 {

    public static void main(String[] args) {
        System.out.println("===================task 1=====================");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("==============================================");
        System.out.println("===================task 2=====================");
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        System.out.println("==============================================");
        System.out.println("===================task 3=====================");
        System.out.println(nicocipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicocipher("andiloveherso", "tesha"));
        System.out.println(nicocipher("mubashirhassan", "crazy"));
        System.out.println(nicocipher("edabitisamazing", "matt"));
        System.out.println(nicocipher("iloveher", "612345"));
        System.out.println("==============================================");
        System.out.println("===================task 4=====================");
        int[] arr1 = {1, 2, 3, 9, 4, 5, 15};
        int[] arr2 = {1, 2, 3, 9, 4, 15, 3, 5};
        int[] arr3 = {1, 2, -1, 4, 5, 6, 10, 7};
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr5 = {100, 12, 4, 1, 2};

        int[] result1 = twoProduct(arr1, 45);
        int[] result2 = twoProduct(arr2, 45);
        int[] result3 = twoProduct(arr3, 20);
        int[] result4 = twoProduct(arr4, 10);
        int[] result5 = twoProduct(arr5, 15);

        if (result1.length > 0) {
            System.out.println("[" + result1[0] + ", " + result1[1] + "]");
        } else {
            System.out.println("[]");
        }

        if (result2.length > 0) {
            System.out.println("[" + result2[0] + ", " + result2[1] + "]");
        } else {
            System.out.println("[]");
        }

        if (result3.length > 0) {
            System.out.println("[" + result3[0] + ", " + result3[1] + "]");
        } else {
            System.out.println("[]");
        }

        if (result4.length > 0) {
            System.out.println("[" + result4[0] + ", " + result4[1] + "]");
        } else {
            System.out.println("[]");
        }

        if (result5.length > 0) {
            System.out.println("[" + result5[0] + ", " + result5[1] + "]");
        } else {
            System.out.println("[]");
        }
        System.out.println("==============================================");
        System.out.println("===================task 5=====================");
        System.out.println(Arrays.toString(isExact(6))); // Output: [6, 3]
        System.out.println(Arrays.toString(isExact(24))); // Output: [24, 4]
        System.out.println(Arrays.toString(isExact(125))); // Output: []
        System.out.println(Arrays.toString(isExact(720))); // Output: [720, 6]
        System.out.println(Arrays.toString(isExact(1024))); // Output: []
        System.out.println(Arrays.toString(isExact(40320))); // Output: [40320, 8]
        System.out.println("==============================================");
        System.out.println("===================task 6=====================");
        System.out.println(fractions("0.(6)")); // "2/3"
        System.out.println(fractions("1.(1)")); // "10/9"
        System.out.println(fractions("3.(142857)")); //"22/7"
        System.out.println(fractions("0.19(2367)")); // "5343/27775"
        System.out.println(fractions("0.1097(3)")); //"823/7500"
        System.out.println("==============================================");
        System.out.println("===================task 7=====================");
        System.out.println(pilish_string("33314444")); // "333 1 4444"
        System.out.println(pilish_string("TOP")); // "TOP"
        System.out.println(pilish_string("X")); // "XXX"
        System.out.println(pilish_string("")); // ""
        System.out.println("==============================================");
        System.out.println("===================task 8=====================");
        System.out.println(evaluateExpression("3 + 5 * (2 - 6)")); // -17
        System.out.println(evaluateExpression("6 - 18 / (-1 + 4)")); // 0
        System.out.println("==============================================");
        System.out.println("===================task 9=====================");
        System.out.println(isValid("aabbcd")); // NO
        System.out.println(isValid("aabbccddeefghi")); // NO
        System.out.println(isValid("abcdefghhgfedecba")); // YES
        System.out.println("==============================================");
        System.out.println("===================task 10=====================");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
        System.out.println("==============================================");
    }

    // Задача 1
    public static String hiddenAnagram(String sentence, String anagram) {

        String cleanSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();

        String cleanAnagram = anagram.replaceAll("[^a-zA-Z]", "").toLowerCase();


        char[] anagramArray = cleanAnagram.toCharArray();

        Arrays.sort(anagramArray);

        String sortedAnagram = new String(anagramArray);


        for (int i = 0; i <= cleanSentence.length() - cleanAnagram.length(); i++) {

            String substring = cleanSentence.substring(i, i + cleanAnagram.length());

            char[] substringArray = substring.toCharArray();

            Arrays.sort(substringArray);

            String sortedSubstring = new String(substringArray);


            if (sortedSubstring.equals(sortedAnagram)) {
                return substring;
            }
        }

        return "notfound";
    }

    // Задача 2
    public static List<String> collect(String word, int n) {
        List<String> result = new ArrayList<>();
        if (word.length() < n) {
            return result;
        }
        if (word.length() == n) {
            result.add(word);
            return result;
        }
        result.add(word.substring(0, n));
        result.addAll(collect(word.substring(n), n));
        Collections.sort(result);
        return result;
    }

    // Задача № 3
    public static String nicocipher(String message, String key) {
        int[] numbers = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            numbers[i] = key.charAt(i) - 'a' + 1;
        }

        int rows = (int) Math.ceil((double) message.length() / numbers.length);
        char[][] grid = new char[rows][numbers.length];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (index < message.length()) {
                    grid[i][j] = message.charAt(index);
                } else {
                    grid[i][j] = ' ';
                }
                index++;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;

                    for (int k = 0; k < rows; k++) {
                        char tempChar = grid[k][j];
                        grid[k][j] = grid[k][j + 1];
                        grid[k][j + 1] = tempChar;
                    }
                }
            }
        }

        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numbers.length; j++) {
                encodedMessage.append(grid[i][j]);
            }
        }

        return encodedMessage.toString();
    }
    // Задача № 4
    public static int[] twoProduct(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (n % arr[i] == 0 && map.containsKey(n / arr[i])) {
                return new int[]{n / arr[i], arr[i]};
            }
            map.put(arr[i], i);
        }

        return new int[]{};
    }

    // Задача № 5
    public static int[] isExact(int n) {
        int[] result = new int[2];
        int factorial = 1;
        int i = 1;

        while (factorial < n) {
            factorial *= i;
            if (factorial == n) {
                result[0] = factorial;
                result[1] = i;
                return result;
            }
            i++;
        }

        return new int[0];
    }
    // Задача № 6
   public static String fractions(String s) {
        int n = 1, m = 1;
        String t1 = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
        StringBuilder sb = new StringBuilder(s.substring(0, s.indexOf("(")));
        int len = sb.length();
        while (sb.length() - len <= 15) {
            sb.append(t1);
        }
        s = sb.substring(0, 16 + len);
        double k = Double.parseDouble(s);
        while ((double) n / (double) m != k) {
            if ((double) n / (double) m > k)
                m++;
            else
                n++;
        }

        return n + "/" + m;
    }
    // Задача № 7
    public static String pilish_string(String txt) {
        String piDigits = "314159265358979";

        if (txt.isEmpty()) {
            return "";
        }

        String result = "";
        int startIndex = 0;

        for (int i = 0; i < piDigits.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(piDigits.charAt(i)));
            if (startIndex >= txt.length()) {
                break;
            }

            String word = txt.substring(startIndex, Math.min(startIndex + digit, txt.length()));

            while (word.length() < digit) {
                word += word.charAt(word.length() - 1);
            }

            result += (result.isEmpty() ? "" : " ") + word;
            startIndex += digit;
        }

        return result;
    }
    // Задача № 8
    private static int index;
    private static String expression;

    public static int evaluateExpression(String exp) {
        expression = exp.replaceAll("\\s+", ""); // Удаление пробелов из выражения
        index = 0; // Индекс текущего символа

        try {
            int result = evaluateExpression();
            if (index != expression.length()) {
                throw new IllegalArgumentException("Неправильно введено выражение");
            }
            return result;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            return 0;
        }
    }

    private static int evaluateExpression() {
        List<Integer> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        while (index < expression.length()) {
            char c = expression.charAt(index);
            if (isDigit(c)) {
                operands.add(parseOperand());
            } else if (c == '(') {
                index++;
                operands.add(evaluateExpression());
            } else if (c == ')') {
                index++;
                break;
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && hasHigherPriority(operators.get(operators.size() - 1), c)) {
                    evaluateOperation(operands, operators);
                }
                operators.add(c);
                index++;
            } else {
                throw new IllegalArgumentException("Неправильно введено выражение");
            }
        }

        while (!operators.isEmpty()) {
            evaluateOperation(operands, operators);
        }

        if (operands.size() != 1 || !operators.isEmpty()) {
            throw new IllegalArgumentException("Неправильно введено выражение");
        }

        return operands.get(0);
    }

    private static int parseOperand() {
        int result = 0;
        while (index < expression.length() && isDigit(expression.charAt(index))) {
            result = result * 10 + (expression.charAt(index) - '0');
            index++;
        }
        return result;
    }

    private static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean hasHigherPriority(char op1, char op2) {
        return ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'));
    }

    private static int applyOperation(int leftOperand, char operator, int rightOperand) {
        switch (operator) {
            case '+':
                return leftOperand + rightOperand;
            case '-':
                return leftOperand - rightOperand;
            case '*':
                return leftOperand * rightOperand;
            case '/':
                if (rightOperand == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return leftOperand / rightOperand;
            default:
                throw new IllegalArgumentException("Неправильно введено выражение");
        }
    }

    private static void evaluateOperation(List<Integer> operands, List<Character> operators) {
        if (operands.size() < 2 || operators.isEmpty()) {
            throw new IllegalArgumentException("Неправильно введено выражение");
        }

        char operator = operators.remove(operators.size() - 1);
        int rightOperand = operands.remove(operands.size() - 1);
        int leftOperand = operands.remove(operands.size() - 1);
        int result = applyOperation(leftOperand, operator, rightOperand);
        operands.add(result);
    }

    // Задача № 9
    public static String isValid(String str) {
        int[] count = new int[26]; // Частота встречаемости каждого символа в строке
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        int oddCount = 0; // Количество символов с нечетной частотой встречаемости
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount == 0 || oddCount == 1) {
            return "YES";
        } else {
            return "NO";
        }
    }

    // Задача № 10
    public static String findLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }


}