import java.util.*;

public class tasks2 {
    public static void main(String[] args) {
        System.out.println("============Task 1=======");
        System.out.println(duplicateChars("donald")); // true // 1
        System.out.println(duplicateChars("orange")); // false // 1
        System.out.println("=========================");
        System.out.println("========Task 2=======");
        System.out.println(getInitials("Ryan Gosling")); // 2
        System.out.println(getInitials("Barack Obama")); // 2
        System.out.println("=============================================");
        System.out.println("========Task 3=======");
        int[] array1 = {44, 32, 86, 19};
        int[] array2 = {22, 50, 16, 63, 31, 55};
        int difference1 = differenceEvenOdd(array1);
        int difference2 = differenceEvenOdd(array2);
        System.out.println(Math.abs(difference1));
        System.out.println(Math.abs(difference2));
        System.out.println("=============================================");
        System.out.println("========Task 4=======");
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(arr1));
        System.out.println(equalToAvg(arr2));
        System.out.println("=============================================");
        System.out.println("========Task 5 ===========");
        int[] arr11 = {1, 2, 3};
        int[] arr12 = {3, 3, -2, 408, 3, 31};
        int[] result1 = indexMult(arr11);
        int[] result2 = indexMult(arr12);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println("=============================================");
        System.out.println("========Task 6 ===========");
        System.out.println(reverse("Hello World")); //Output: dlroW olleH
        System.out.println(reverse("The quick brown fox.")); //Output: .xof nworb kciuq ehT
        System.out.println("=============================================");
        System.out.println("========Task 7 ===========");
        int n = 7;
        System.out.println("Tribonacci(" + n + ") = " + Tribonacci(n));
        n = 11;
        System.out.println("Tribonacci(" + n + ") = " + Tribonacci(n));
        System.out.println("=============================================");
        System.out.println("========Task 8 ===========");
        System.out.println(generation(5));
        System.out.println(generation(10));
        System.out.println(generation(0));
        System.out.println("=============================================");
        System.out.println("========Task 9 ===========");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println("=============================================");
        System.out.println("========Task 10 ===========");
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("eleven plus two", "twelve plus one")); // true
        System.out.println(isAnagram("hello", "world")); // false
        System.out.println("====================ВСЁ!!!=========================");
    }

    // Задача № 1
    public static boolean duplicateChars(String str) {
        int[] charCount = new int[256];

        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)]++;
        }

        // Проверяем, есть ли символ с счетчиком больше 1
        for (int i = 0; i < 256; i++) {
            if (charCount[i] > 1) {
                return true;
            }
        }

        return false;
    }

    // Задача № 2
    public static String getInitials(String fullName) {
        String[] names = fullName.split(" ");
        StringBuilder initials = new StringBuilder();

        for (String name : names) {
            initials.append(Character.toUpperCase(name.charAt(0)));
        }
        return initials.toString();
    }

    // Задача № 3
    public static int differenceEvenOdd(int[] array) {
        int sumEven = 0;
        int sumOdd = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
        }
        return sumEven - sumOdd;
    }

    // Задача № 4
    public static boolean equalToAvg(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = sum / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == avg) {
                return true;
            }
        }
        return false;
    }

    // Задача № 5
    public static int[] indexMult(int[] arr) {
        int[] result = new int[arr.length]; // создаем новый массив такой же длины, как исходный
        // умножаем каждый элемент на его индекс и записываем результат в новый массив
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * i;
        }
        return result;
    }


    // Задача № 6
    public static String reverse(String str) {
        String reverseStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr += str.charAt(i);
        }
        return reverseStr;
    }


    // Задача № 7
        public static int Tribonacci(int n) {
            if(n == 0 || n == 1) {
                return 0;
            } else if(n == 2) {
                return 1;
            }

            int[] tribonacci = new int[n + 1];
            tribonacci[0] = 0;
            tribonacci[1] = 0;
            tribonacci[2] = 1;

            for(int i = 3; i <= n; i++) {
                tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
            }

            return tribonacci[n];
        }
    // Задача № 8

    public static String generation(int len) {
        Random random = new Random();
        String str = "";
        for (int i = 0 ; i < len; i++){
            int ranInt = random.nextInt(16);
            str += Integer.toHexString(ranInt);
        }
        return str;
    }
    // Задача № 9
    public static String botHelper(String str) {
        if (str.toLowerCase().contains("help")) {
            return "Calling for a staff member";
        } else {
            return "Keep waiting";
        }
    }

    // Задача № 10

        public static boolean isAnagram(String str1, String str2) {
            str1 = str1.replaceAll("\\s", ""); // удаляем пробелы из первой строки
            str2 = str2.replaceAll("\\s", ""); // удаляем пробелы из второй строки

            if (str1.length() != str2.length()) {
                return false;
            }

            char[] charArray1 = str1.toLowerCase().toCharArray();
            char[] charArray2 = str2.toLowerCase().toCharArray();

            Arrays.sort(charArray1); // сортируем символы первой строки
            Arrays.sort(charArray2); // сортируем символы второй строки

            return Arrays.equals(charArray1, charArray2); // сравниваем отсортированные массивы символов
        }
    }



