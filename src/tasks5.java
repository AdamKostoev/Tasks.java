import java.text.SimpleDateFormat;
import java.util.*;

public class tasks5 {

    public static void main(String[] args) {

        System.out.println("===================task 1=====================");
        System.out.println(sameLetterPattern("ABAB", "CDCD")); // true
        System.out.println(sameLetterPattern("ABCBA", "BCDCB")); // true
        System.out.println(sameLetterPattern("FFGG", "CDCD")); // false
        System.out.println(sameLetterPattern("FFFF", "ABCD")); // false
        System.out.println("==============================================");
        System.out.println("===================task 2=====================");
        System.out.println(spiderVsFly("H3", "E2")); // H3-H2-H1-A0-E1-E2
        System.out.println(spiderVsFly("A4", "B2")); // A4-A3-A2-B2
        System.out.println(spiderVsFly("A4", "C2")); // A4-A3-A2-B2-C2
        System.out.println("==============================================");
        System.out.println("===================task 3=====================");
        System.out.println(digitsCount(4666)); // 4
        System.out.println(digitsCount(544)); // 3
        System.out.println(digitsCount(121317)); // 6
        System.out.println(digitsCount(0)); // 1
        System.out.println(digitsCount(12345)); // 5
        System.out.println(digitsCount(1289396387328L)); // 13
        System.out.println("==============================================");
        System.out.println("===================task 4=====================");
        String[] guessedWords1 = {"cat", "create", "sat"};
        String scrambledWord1 = "caster";
        int points1 = totalPoints(guessedWords1, scrambledWord1);
        System.out.println(points1); // Output: 2

        String[] guessedWords2 = {"trance", "recant"};
        String scrambledWord2 = "recant";
        int points2 = totalPoints(guessedWords2, scrambledWord2);
        System.out.println(points2); // Output: 108

        String[] guessedWords3 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        String scrambledWord3 = "tossed";
        int points3 = totalPoints(guessedWords3, scrambledWord3);
        System.out.println(points3); // Output: 13
        System.out.println("===================task 5=====================");
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 7, 9};
        int[] arr3 = {10, 9, 7, 2, 8};
        int[] arr4 = {1, 6, 5, 4, 8, 2, 3, 7};

        System.out.println(Arrays.deepToString(sumsup(arr1)));
        System.out.println(Arrays.deepToString(sumsup(arr2)));
        System.out.println(Arrays.deepToString(sumsup(arr3)));
        System.out.println(Arrays.deepToString(sumsup(arr4)));
        System.out.println("==============================================");
        System.out.println("===================task 6=====================");
        String[] grades1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        String[] grades2 = {"10%"};
        String[] grades3 = {"53%", "79%"};

        System.out.println(takeDownAverage(grades1)); // Output: 54%
        System.out.println(takeDownAverage(grades2)); // Output: 0%
        System.out.println(takeDownAverage(grades3)); // Output: 51%
        System.out.println("==============================================");
        System.out.println("===================task 7=====================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите режим работы (1 - шифрование, 2 - дешифрование): ");
        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Введите сообщение: ");
        String message = scanner.nextLine();
        System.out.print("Введите сдвиг: ");
        int shift = scanner.nextInt();
        String result = "";
        if (mode == 1) {
            result = encrypt(message, shift);
        } else if (mode == 2) {
            result = decrypt(message, shift);
        } else {
            System.out.println("Ошибка: неверный режим работы.");
            System.exit(1);
        }
        System.out.println("Результат: " + result);
        System.out.println("==============================================");
        System.out.println("===================task 8=====================");
        int n1 = 5;
        int k1 = 3;

        int n2 = 7;
        int k2 = 3;

        int result11 = arrangement(n1, k1);
        int result22 = arrangement(n2, k2);

        System.out.println("Размещение " + k1 + " элементов из " + n1 + " элементов: " + result11);
        System.out.println("Размещение " + k2 + " элементов из " + n2 + " элементов: " + result22);
        System.out.println("==============================================");
        System.out.println("===================task 9=====================");
        String result1 = timeDifference("Los Angeles", "April 01, 2011 23:23", "Canberra");
        String result2 = timeDifference("London", "July 31, 1983 23:01", "Rome");
        String result3 = timeDifference("New York", "December 31, 1970 13:40", "Beijing");

        System.out.println(result1); // Output: 2011-04-02 17:23
        System.out.println(result2); // Output: 1983-08-01 00:01
        System.out.println(result3); // Output: 1970-12-31 13:40
        System.out.println("==============================================");
        System.out.println("===================task 10=====================");
        System.out.println(isNew(3));   // true
        System.out.println(isNew(30));  // true
        System.out.println(isNew(321)); // false
        System.out.println(isNew(123)); // true
        System.out.println("==============================================");
    }


    // Задача № 1
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int n = str1.length();
        char[] map1 = new char[26];
        char[] map2 = new char[26];

        for (int i = 0; i < n; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (map1[c1 - 'A'] == 0 && map2[c2 - 'A'] == 0) {
                map1[c1 - 'A'] = c2;
                map2[c2 - 'A'] = c1;
            } else if (map1[c1 - 'A'] != c2 || map2[c2 - 'A'] != c1) {
                return false;
            }
        }
        return true;
    }

    // Задача № 2
    public static String spiderVsFly(String str1, String str2) {

        int circleDif = Math.abs(str1.charAt(0) - str2.charAt(0));

        int walk = 1;

        if (circleDif > 8 - circleDif) {
            circleDif = 8 - circleDif;
            walk = -1;
        }

        int spiderHeight = Character.getNumericValue(str1.charAt(1));
        int flyHeight = Character.getNumericValue(str2.charAt(1));

        double minLen = 100000;

        int minI = 0;

        for (int i = 0; i < 5; i++) {
            double len = (Math.abs(spiderHeight - i)
                    + Math.abs(flyHeight - i)
            );


            len += circleDif * Math.sqrt(i * i * 2 - 2 * i * i * Math.cos(Math.toRadians(45)));

            if (len < minLen) {
                minLen = len;
                minI = i;
            }
        }

        StringBuilder path = new StringBuilder();

        int spiderMove = minI > spiderHeight ? 1 : -1;

        for (int i = spiderHeight; i != minI + spiderMove; i += spiderMove) {
            if (i == 0) {
                path.append('A');
            } else {
                path.append(str1.charAt(0));
            }

            path.append(i).append('-');
        }

        if (minI != 0) {
            for (int i = 0; i < circleDif; i++) {
                path.append(Character.toString(path.charAt(path.length() - 3) + walk))
                        .append(minI).append('-');
            }
        }

        int flyMove = minI > flyHeight ? -1 : 1;

        for (int i = minI + flyMove; i != flyHeight + flyMove; i += flyMove) {

            path.append(str2.charAt(0));
            path.append(i).append('-');
        }

        path.deleteCharAt(path.length() - 1);

        return path.toString();
    }
    // Задача № 3

    public static int digitsCount(long num) {

        if (num > 10) {
            return 1 + digitsCount(num / 10);
        }
        return 1;
    }

    // Задача № 4
        public static int totalPoints(String[] guessedWords, String scrambledWord) {
            int totalPoints = 0;
            HashMap<Character, Integer> letterCounts = countLetters(scrambledWord);

            for (String word : guessedWords) {
                if (isValidWord(word, letterCounts)) {
                    int wordLength = word.length();
                    int wordPoints = 0;

                    if (wordLength >= 3 && wordLength < 6) {
                        wordPoints = wordLength - 2;
                    } else if (wordLength == 6) {
                        wordPoints = 4 + 50;
                    }

                    totalPoints += wordPoints;
                }
            }

            return totalPoints;
        }

        private static HashMap<Character, Integer> countLetters(String word) {
            HashMap<Character, Integer> letterCounts = new HashMap<>();

            for (char c : word.toCharArray()) {
                letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
            }

            return letterCounts;
        }

        private static boolean isValidWord(String word, HashMap<Character, Integer> letterCounts) {
            HashMap<Character, Integer> wordCounts = countLetters(word);

            for (char c : wordCounts.keySet()) {
                if (!letterCounts.containsKey(c) || wordCounts.get(c) > letterCounts.get(c)) {
                    return false;
                }
            }

            return true;
        }
    // Задача № 5
    public static int[][] sumsup(int[] arr) {
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 8) {
                    int[] pair = new int[]{arr[i], arr[j]};
                    Arrays.sort(pair);
                    pairs.add(pair);
                }
            }
        }

        pairs.sort((a, b) -> {
            int counta = cyclecompleteness(a);
            int countb = cyclecompleteness(b);
            return counta - countb;
        });

        return pairs.toArray(new int[0][]);
    }

    public static int cyclecompleteness(int[] pair) {
        if (pair[0] == 2 || pair[0] == 6 || pair[1] == 2 || pair[1] == 6) {
            return 1;
        } else if (pair[0] == 3 || pair[0] == 5 || pair[1] == 3 || pair[1] == 5) {
            return 2;
        } else if (pair[0] == 1 || pair[0] == 7 || pair[1] == 1 || pair[1] == 7) {
            return 3;
        } else {
            return 0;
        }
    }

    // Задача № 6
    public static String takeDownAverage(String[] grades) {
        double total = 0;
        for (String grade : grades) {
            total += Double.parseDouble(grade.replaceAll("%", ""));
        }
        double average = total / grades.length;

        double reducedAverage = average - 5;
        double reducedTotal = reducedAverage * (grades.length + 1);

        int requiredGrade = (int) Math.round(reducedTotal - total);

        return String.valueOf(requiredGrade) + "%";
    }
    // Задача № 7
    public static String encrypt(String message, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char encryptedChar = (char) ((ch + shift - 'A') % 26 + 'A'); // ('C' + 2 - 'A') % 26 + 'A'
                                                                                 // = (67-65 + 2) % 26 + 65 = 4 % 26 + 65 = 4 + 65 = 69
                    result.append(encryptedChar);
                } else {
                    char encryptedChar = (char) ((ch + shift - 'a') % 26 + 'a');
                    result.append(encryptedChar);
                }
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt(String message, int shift) {
        return encrypt(message, 26 - shift); // Decryption is just shifting in the opposite direction
    }

    // Задача № 8
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int arrangement(int n, int k) {
        return factorial(n) / factorial(n - k);
    }


    // Задача № 9
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        // Установка часового пояса для города cityA
        TimeZone timezoneA = getTimeZone(cityA);
        inputFormat.setTimeZone(timezoneA);
        outputFormat.setTimeZone(timezoneA);

        // Парсинг входящего времени
        Calendar calendarA = Calendar.getInstance();
        try {
            calendarA.setTime(inputFormat.parse(timestamp));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        // Установка часового пояса для города cityB
        TimeZone timezoneB = getTimeZone(cityB);
        outputFormat.setTimeZone(timezoneB);

        // Вычисление новой даты и времени в cityB
        calendarA.setTimeZone(timezoneB);
        String newTimestamp = outputFormat.format(calendarA.getTime());

        return newTimestamp;
    }

    public static TimeZone getTimeZone(String city) {
        if (city.equals("Los Angeles")) {
            return TimeZone.getTimeZone("GMT-8");
        } else if (city.equals("New York")) {
            return TimeZone.getTimeZone("GMT-5");
        } else if (city.equals("Caracas")) {
            return TimeZone.getTimeZone("GMT-4:30");
        } else if (city.equals("Buenos Aires")) {
            return TimeZone.getTimeZone("GMT-3");
        } else if (city.equals("London")) {
            return TimeZone.getTimeZone("GMT+0");
        } else if (city.equals("Rome")) {
            return TimeZone.getTimeZone("GMT+1");
        } else if (city.equals("Moscow")) {
            return TimeZone.getTimeZone("GMT+3");
        } else if (city.equals("Tehran")) {
            return TimeZone.getTimeZone("GMT+3:30");
        } else if (city.equals("New Delhi")) {
            return TimeZone.getTimeZone("GMT+5:30");
        } else if (city.equals("Beijing")) {
            return TimeZone.getTimeZone("GMT+8");
        } else if (city.equals("Canberra")) {
            return TimeZone.getTimeZone("GMT+10");
        } else {
            return TimeZone.getDefault();
        }
    }



    // Задача № 10
    public static boolean isNew(int number) {
        String strNumber = String.valueOf(number);
        for (int i = number - 1; i >= 1; i--) {
            String strI = String.valueOf(i);
            if (isPermutation(strNumber, strI)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutation(String str1, String str2) {
        int[] count = new int[10];
        for (char c : str1.toCharArray()) {
            count[c - '0']++;
        }
        for (char c : str2.toCharArray()) {
            count[c - '0']--;
        }
        for (int i = 0; i <= 9; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

}


