import java.util.*;

public class tasks3 {


    public static void main(String[] args) {
        System.out.println("============Task 1=======");
        String word = "apple";
        String result = replaceVowels(word);
        System.out.println(result); // "*ppl*"
        System.out.println("=========================");
        System.out.println("============Task 2=======");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("=========================");
        System.out.println("============Task 3=======");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));   // true
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));   // true
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));   // false
        System.out.println("=========================");
        System.out.println("============Task 4=======");
        System.out.println(numCheck(243)); // true
        System.out.println(numCheck(52)); // false
        System.out.println("=========================");
        System.out.println("============Task 5=======");
        int[] coefficients1 = {1, -3, 2};
        int[] coefficients2 = {2, 5, 2};
        int[] coefficients3 = {1, -6, 9};
        System.out.println(countRoots(coefficients1)); // 2
        System.out.println(countRoots(coefficients2)); // 0
        System.out.println(countRoots(coefficients3)); // 1
        System.out.println("=========================");
        System.out.println("============Task 6=======");
        System.out.println(salesData(new String[][] {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},{"Banana", "Shop2", "Shop3", "Shop4"},{"Orange", "Shop1", "Shop3", "Shop4"},{"Pear", "Shop2", "Shop4"}}) );
        System.out.println("=========================");
        System.out.println("============Task 7=======");
        System.out.println(validSplit("apple eagle egg goat")); // true
        System.out.println(validSplit("cat dog goose fish")); // false
        System.out.println("=========================");
        System.out.println("============Task 8=======");
        int[] arr1 = {3, 1, 4, 2, 7, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {1, 2, -6, 10, 3};
        System.out.println(isWaveForm(arr1)); // true
        System.out.println(isWaveForm(arr2)); // false
        System.out.println(isWaveForm(arr3)); // true
        System.out.println("=========================");
        System.out.println("============Task 9=======");
        System.out.println(commonVowel("Hello world")); // "o"
        System.out.println(commonVowel("Actions speak louder than words.")); // "a"
        System.out.println("=========================");
        System.out.println("============Task 10=======");
        int[][] arr11 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };

        int[][] arr12 = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };

        System.out.println(Arrays.deepToString(dataScience(arr11)));
        System.out.println(Arrays.deepToString(dataScience(arr12)));

        System.out.println("=========================");

    }

    // Задача № 1
    public static String replaceVowels(String str) {
        return str.replaceAll("[aeiouAEIOU]", "*");
    }


    // Задача № 2
    public static String stringTransform(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // Проверяем, есть ли следующий символ
            if (i + 1 < str.length()) {
                char nextChar = str.charAt(i + 1);

                // Если текущий символ и следующий символ идут подряд
                if (currentChar == nextChar) {
                    result.append("Double"); // Добавляем "Double"
                    result.append(nextChar); // Добавляем повторяющуюся букву еще раз
                    i++; // Пропускаем повторяющуюся букву, чтобы не сравнивать ее в следующей итерации
                } else {
                    result.append(currentChar); // Добавляем текущий символ
                }
            } else {
                result.append(currentChar); // Добавляем текущий символ
            }
        }
        return result.toString();
    }

    // Задача № 3

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) || (a <= w && c <= h) || (a <= h && c <= w) || (b <= w && c <= h) || (b <= h && c <= w);
    }

    // Задача № 4

    public static boolean numCheck(int num) {
        int sum = 0;
        int tempNum = num;
        int digit;
        while (tempNum > 0) {
            digit = tempNum % 10;
            sum += digit * digit;
            tempNum /= 10;
        }
        if (sum % 2 == num % 2) {
            return true;
        } else {
            return false;
        }
    }

    // Задача № 5
    public static int countRoots(int[] coefficients) {
        double discriminant = coefficients[1] * coefficients[1] - 4 * coefficients[0] * coefficients[2];

        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // Задача 6
    public static String salesData (String[][] t) {
        int b =0;
        int i =0;

        int max=0;
        for (i=0;i<t.length;i++){

            if (t[i].length>max){
                max=t[i].length;
            }

        }
        String s ="";
        for (i=0;i<t.length;i++){
            if (t[i].length==max) {
                s = s + t[i][0] + " ";
            }
        }
        return s;

    }


        // Задача № 7
        public static boolean validSplit(String sentence) {
            String[] words = sentence.split(" ");
            if(words.length < 2) {
                return false;
            }
            for(int i = 1; i < words.length; i++) {
                if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length() - 1)) {
                    return false;
                }
            }
            return true;
        }
    // Задача № 8
    public static boolean isWaveForm(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++){
            if ((arr[i] > arr[i-1] && arr[i] > arr[i+1]) || (arr[i] < arr[i-1] && arr[i] < arr[i+1])) {
                continue;
            }
            return false;
        }

        return true;
    }

    // Задача № 9

    public static char commonVowel(String sentence) {
        sentence = sentence.toLowerCase();
        Map<Character, Integer> vowelCount = new HashMap<>();

        // Инициализация словаря vowelCount с гласными буквами
        vowelCount.put('a', 0);
        vowelCount.put('e', 0);
        vowelCount.put('i', 0);
        vowelCount.put('o', 0);
        vowelCount.put('u', 0);

        // Подсчет количества каждой гласной буквы в предложении
        for (char c : sentence.toCharArray()) {
            if (vowelCount.containsKey(c)) {
                vowelCount.put(c, vowelCount.get(c) + 1);
            }

        }
        char mostCommonVowel = 'a';
        int maxCount = 0;

        // Нахождение наиболее часто встречающейся гласной буквы
        for (char vowel : vowelCount.keySet()) {
            int count = vowelCount.get(vowel);
            if (count > maxCount) {
                maxCount = count;
                mostCommonVowel = vowel;
            }
        }

        return mostCommonVowel;
    }

// Задача 10
    public static int[][] dataScience (int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            int ans = 0;

            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    ans += arr[j][i];
                }
            }
            ans = Math.round(ans / 4.0f);
            arr[i][i] = ans;
        }
        return arr;
    }
}



