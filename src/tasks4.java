import java.util.*;
import java.util.Map.Entry;

public class tasks4 {

        public static void main(String[] args) {
            System.out.println("============Task 1=======");
            String input = "abracadabra";
            String inputt = "paparazzi";
            String result = nonRepeatable(input);
            String resultt = nonRepeatable(inputt);
            System.out.println(result);
            System.out.println(resultt);
            System.out.println("=========================");
            System.out.println("============Task 2=======");
            List<String> brackets = generateBrackets(3);
            for (String bracket : brackets) {
                System.out.println(bracket);
            }
            System.out.println("=========================");
            System.out.println("============Task 3=======");
            List<String> combinations = binarySystem(3);
            System.out.println(combinations); // ["010", "011", "101", "110", "111"]
            combinations = binarySystem(4);
            System.out.println(combinations); // ["0101", "0110", "0111", "1010", "1011", "1101", "1110", "1111"]
            System.out.println("=========================");
            System.out.println("============Task 4=======");
            System.out.println(alphabeticRow("abcdjuwx")); // abcd
            System.out.println(alphabeticRow("klmabzyxw")); // zyxw
            System.out.println("=========================");
            System.out.println("============Task 5=======");
            String str = "aaabbcdd";
            result = sortPatternString(str);
            System.out.println(result);
            System.out.println("=========================");
            System.out.println("============Task 6=======");
            System.out.println(convertToNum("eight"));
            System.out.println(convertToNum("five hundred sixty seven"));
            System.out.println(convertToNum("thirty one"));
            System.out.println("=========================");
            System.out.println("============Task 7=======");
            String str1 = "123412324";
            System.out.println(uniqueSubstring(str1)); // Output: "1234"
            String str2 = "111111";
            System.out.println(uniqueSubstring(str2)); // Output: "1"
            String str3 = "77897898";
            System.out.println(uniqueSubstring(str3)); // Output: "789"
            System.out.println("=========================");
            System.out.println("============Task 8=======");
            int[][] matrix1 = {{1, 3, 1},
                    {1, 5, 1},
                    {4, 2, 1}};

            int[][] matrix2 = {{2, 7, 3},
                    {1, 4, 8},
                    {4, 5, 9}};

            System.out.println(shortestWay(matrix1)); // Output: 7
            System.out.println(shortestWay(matrix2)); // Output: 21
            System.out.println("=========================");
            System.out.println("============Task 9=======");
            String result1 = numericOrder("t3o the5m 1One all6 r4ule ri2ng");
            System.out.println(result1); // Вывод: " One ring to rule them all"
            String result2 = numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat");
            System.out.println(result2); // Вывод: " With great power comes great responsibility"
            System.out.println("=========================");
            System.out.println("============Task 10=======");
            System.out.println(switchNums(511, 723));
            System.out.println(switchNums(491, 3912));
            System.out.println(switchNums(6274, 71259));
            System.out.println("=========================");
        }


        // Задача №1
        public static String nonRepeatable(String str) {
            // Базовый случай: если строка пустая или состоит только из одного символа,
            // то повторений нет, поэтому возвращаем исходную строку
            if (str.isEmpty() || str.length() == 1) {
                return str;
            }

            // Если первый символ строки встречается ещё раз в оставшейся части строки,
            // то пропускаем первый символ и рекурсивно вызываем функцию от оставшейся части строки
            if (str.substring(1).contains(String.valueOf(str.charAt(0)))) {
                return nonRepeatable(str.substring(1));
            }
            // В противном случае, возвращаем первый символ + рекурсивный вызов от оставшейся части строки
            return str.charAt(0) + nonRepeatable(str.substring(1));
        }

        // Задача № 2
    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    // Задача № 3

    public static List<String> binarySystem(int n) {
        List<String> combinations = new ArrayList<>();
        generateCombinations(combinations, new StringBuilder(), n);
        return combinations;
    }

    public static void generateCombinations(List<String> combinations, StringBuilder sb, int n) {
        if (sb.length() == n) {
            combinations.add(sb.toString());
            return;
        }

        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '0') {
            sb.append('0');
            generateCombinations(combinations, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append('1');
        generateCombinations(combinations, sb, n);
        sb.deleteCharAt(sb.length() - 1);
    }

    // Задача № 4
    public static String alphabeticRow(String str) {
        String longestRow = "";
        String currentRow = "";

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i + 1) - str.charAt(i) == 1 || str.charAt(i) - str.charAt(i + 1) == 1) {
                if (currentRow.isEmpty()) {
                    currentRow += str.charAt(i);
                }
                currentRow += str.charAt(i + 1);
            } else {
                if (currentRow.length() > longestRow.length()) {
                    longestRow = currentRow;
                }
                currentRow = "";
            }
        }

        if (currentRow.length() > longestRow.length()) {
            longestRow = currentRow;
        }

        return longestRow;
    }
    // Задача № 5
    public static String sortPatternString(String str) {
        Map<Character, Integer> countMap = new HashMap<>();

        // подсчитываем количество повторений каждого символа
        for(char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        List<Entry<Character, Integer>> entryList = new ArrayList<>(countMap.entrySet());

        // сортируем в порядке возрастания количества повторений
        entryList.sort(Comparator.comparingInt(Entry::getValue));

        StringBuilder result = new StringBuilder();

        // формируем строку результирующего паттерна
        for(Entry<Character, Integer> entry : entryList) {
            result.append(entry.getKey());
            result.append(entry.getValue());
        }

        return result.toString();
    }
    // Задача № 6
    public static int convertToNum(String str){
        int num = 0;

        String[] words = str.split(" ");

        for(int i = 0; i < words.length; i++){
            switch(words[i]){
                case "zero":
                    num += 0;
                    break;
                case "one":
                    num += 1;
                    break;
                case "two":
                    num += 2;
                    break;
                case "three":
                    num += 3;
                    break;
                case "four":
                    num += 4;
                    break;
                case "five":
                    num += 5;
                    break;
                case "six":
                    num += 6;
                    break;
                case "seven":
                    num += 7;
                    break;
                case "eight":
                    num += 8;
                    break;
                case "nine":
                    num += 9;
                    break;
                case "ten":
                    num += 10;
                    break;
                case "eleven":
                    num += 11;
                    break;
                case "twelve":
                    num += 12;
                    break;
                case "thirteen":
                    num += 13;
                    break;
                case "fourteen":
                    num += 14;
                    break;
                case "fifteen":
                    num += 15;
                    break;
                case "sixteen":
                    num += 16;
                    break;
                case "seventeen":
                    num += 17;
                    break;
                case "eighteen":
                    num += 18;
                    break;
                case "nineteen":
                    num += 19;
                    break;
                case "twenty":
                    num += 20;
                    break;
                case "thirty":
                    num += 30;
                    break;
                case "forty":
                    num += 40;
                    break;
                case "fifty":
                    num += 50;
                    break;
                case "sixty":
                    num += 60;
                    break;
                case "seventy":
                    num += 70;
                    break;
                case "eighty":
                    num += 80;
                    break;
                case "ninety":
                    num += 90;
                    break;
                case "hundred":
                    num *= 100;
                    break;
                case "thousand":
                    num *= 1000;
                    break;
            }
        }

        return num;
    }
    // Задача № 7
    public static String uniqueSubstring(String str) {
        String result = "";
        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {
            StringBuilder substring = new StringBuilder();

            for (int j = i; j < str.length(); j++) {
                if (substring.toString().contains(String.valueOf(str.charAt(j)))) {
                    break;
                }

                substring.append(str.charAt(j));

                if (substring.length() > maxLength) {
                    maxLength = substring.length();
                    result = substring.toString();
                }
            }
        }

        return result;
    }
    // Задача № 8
    public static int shortestWay(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Инициализация первой строчки и первого столбца матрицы dp
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }

        // Заполнение матрицы dp
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }

        return dp[n-1][n-1];
    }
    // Задача № 9
    public static String numericOrder(String str) {
        StringBuilder result = new StringBuilder();
        String[] words = str.split(" ");

        for (int i = 1; i <= words.length; i++) {
            for (String word : words) {
                if (word.contains(Integer.toString(i))) {
                    result.append(word.replace(Integer.toString(i), "")).append(" ");
                    break;
                }
            }
        }

        return result.toString().trim();
    }
    // Задача № 10
    public static int switchNums(int num1, int num2) {
        List<Integer> digits1 = getDigits(num1);
        List<Integer> digits2 = getDigits(num2);

        Collections.sort(digits1);
        Collections.reverse(digits1);

        int currentDigitIndex = 0;
        for (int i = 0; i < digits1.size(); i++) {
            if (currentDigitIndex < digits1.size() && digits2.get(i) < digits1.get(currentDigitIndex)) {
                digits2.set(i, digits1.get(currentDigitIndex));
                currentDigitIndex++;
            }
        }

        return buildNumber(digits2);
    }

    public static List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static int buildNumber(List<Integer> digits) {
        int num = 0;
        for (int digit : digits) {
            num = num * 10 + digit;
        }
        return num;
    }
}







