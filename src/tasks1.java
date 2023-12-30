import java.util.*;

public class tasks1 {
    public static void main(String[] args) {
        System.out.println("============Task 1=======");
        int gallons1 = 5;
        int gallons2 = 3;
        int gallons3 = 8;
        System.out.println(convert(gallons1)); // Выводит 18.925
        System.out.println(convert(gallons2)); // Выводит 11.355
        System.out.println(convert(gallons3)); // Выводит 30.28
        System.out.println("=========================");
        System.out.println("========Task 2=======");
        int caloriesBurned = calculateCaloriesBurned(15, 1);
        System.out.println("Сожжено калорий: " + caloriesBurned);
        caloriesBurned = calculateCaloriesBurned(24, 2);
        System.out.println("Сожжено калорий: " + caloriesBurned);
        caloriesBurned = calculateCaloriesBurned(41, 3);
        System.out.println("Сожжено калорий: " + caloriesBurned);
        System.out.println("=============================================");
        System.out.println("========Task 3=======");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println("=============================================");
        System.out.println("========Task 4=======");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println("=============================================");
        System.out.println("========Task 5 ===========");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println("=============================================");
        System.out.println("========Task 6 ===========");
        System.out.println(howManyItems(22, 1.4, 2)); // 3
        System.out.println(howManyItems(45, 1.8, 1.9)); // 6
        System.out.println(howManyItems(100, 2, 2)); // 12
        System.out.println("=============================================");
        System.out.println("========Task 7 ===========");
        System.out.println(factorial(3)); // 6
        System.out.println(factorial(5)); // 120
        System.out.println(factorial(7)); // 5040
        System.out.println("=============================================");
        System.out.println("========Task 8 ===========");

        System.out.println(gcd(48, 18)); // 6
        System.out.println(gcd(52, 8)); // 4
        System.out.println(gcd(259, 28)); // 1
        System.out.println("=============================================");
        System.out.println("========Task 9 ===========");
        System.out.println("Выручка: " + calculateRevenue(70, 1500));
        System.out.println("Выручка: " + calculateRevenue(24, 950));
        System.out.println("Выручка: " + calculateRevenue(53, 1250));
        System.out.println("=============================================");
        System.out.println("========Task 10 ===========");
        int result1 = tables(5, 2);
        System.out.println(result1); // 1

        int result2 = tables(31, 20);
        System.out.println(result2); // 0

        int result3 = tables(123, 58);
        System.out.println(result3); // 4
        System.out.println("====================ВСЁ!!!=========================");
    }

    //Задача № 1
    public static double convert(int gallons) {
        double liters = gallons * 3.785;
        return liters;
    }

    // Задача № 2
    public static int calculateCaloriesBurned(int workoutTime, int intensity) {
        int caloriesPerMinute = 0;

        switch (intensity) {
            case 1:
                caloriesPerMinute = 1;
                break;
            case 2:
                caloriesPerMinute = 2;
                break;
            case 3:
                caloriesPerMinute = 3;
                break;
            default:
                System.out.println("Неверная интенсивность тренировки!");
                break;
        }

        int totalCaloriesBurned = caloriesPerMinute * workoutTime;
        return totalCaloriesBurned;
    }
    // Задача № 3

    public static int containers(int boxes, int bags, int barrels) {
        int totalGoods = (boxes * 20) + (bags * 50) + (barrels * 100);
        return totalGoods;
    }
     // Задача № 4

         public static String triangleType(int x, int y, int z) {
             if (x + y <= z || x + z <= y || y + z <= x) {
                 return "не является треугольником";
             } else if (x == y && y == z) {
                 return "равносторонний";
             } else if (x == y || x == z || y == z) {
                 return "равнобедренный";
             } else {
                 return "разносторонний";
             }
         }
    // Задача № 5
    public static int ternaryEvaluation(int a, int b) {
        return a > b ? a : b;
    }
    // Задача № 6
    public static int howManyItems(double n, double w, double h) {
        double availableFabric = (n / 2);
        double areaPerPiece = w * h;
        return (int) (availableFabric / areaPerPiece);
    }
    // Задача № 7
        public static int factorial(int n) {
            if (n == 0 || n == 1) {
                return 1;
            } else {
                return n * factorial(n-1);
            }
        }
    // Задача № 8
    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
    // Задача № 9
    public static int calculateRevenue (int numberOfTickets, int ticketPrice) {
        double commission = 0.28;
        int totalRevenue = numberOfTickets * ticketPrice;
        double commissionAmount = totalRevenue * commission;
        int finalRevenue = (int) (totalRevenue - commissionAmount);
        return finalRevenue;
    }

    // Задача № 10
    public static int tables(int students, int desks) {
        int pairs = students / 2;
        int totalDesks = pairs + students % 2;
        int desksNeeded = totalDesks - desks;
        return desksNeeded > 0 ? desksNeeded : 0;
    }
}
