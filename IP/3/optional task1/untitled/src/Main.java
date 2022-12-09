

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int readInt(Scanner s, String prompt) {
        while (true) {
            System.out.println(prompt);
            String line = s.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: wrong integer");
            }
        }
    }

    public static int choose_fill(Scanner scan) {
        String p = "Введите 1 для заполнения массива случайным образом\n"
                + "Введите 2 для заполнения массива с клавиатуры";
        int ch1 = readInt(scan, p);
        do {
            if (ch1 != 1 && ch1 != 2) {
                System.out.println("Ошибка: wrong number");
                ch1 = readInt(scan, p);
            }
        } while (ch1 != 1 && ch1 != 2);
        return ch1;
    }

    public static double[] fill_array(int ch1, Scanner scan) {
        String p;
        int n = 0;
        double[] array = new double[n];
        if (ch1 == 1) {
            p = "\nВведите количество элементов: ";
            n = readInt(scan, p);
            array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = Math.random()*n*10;
            }
        }
        if (ch1 == 2) {
            p = "\nВведите количество элементов: ";
            n = readInt(scan, p);
            array = new double[n];
            System.out.println("Введите элементы массива: ");
            String line = scan.nextLine();
            array = Arrays.stream(line.split(" ")).mapToDouble(Double::parseDouble).toArray();
        }
        return array;
    }

    public static void print_array(double[] array) {
        System.out.println("Массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    public static double processing_array(double[] array) {
        int n = array.length;
        int first = -1;
        int last = n;
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            if (Math.sin(array[i]) > 0) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            System.out.println("Нет чисел, подходходящих под условие");
            System.out.println("Сумма = " + sum);
        } else {
            for (int i = n - 1; i > first; i--) {
                if (Math.abs(Math.sqrt(array[i]) - Math.cbrt(array[i])) <= Math.pow(10, -5)) {
                    last = i;
                    break;
                }
            }
            for (int i = first + 1; i < last; i++) {
                sum += array[i];
            }
            System.out.println("Сумма = " + sum);
        }
        return sum;
    }

    public static double[] changing_array(double[] array) {
        List<Double> arrlist = new ArrayList<Double>();
        int n = array.length;

        int sum;
        String tmp;
        for (int i = 0; i < n; i++) {
            sum = 0;
            tmp = String.valueOf(array[i]);
            for(int j = 0; j < tmp.length(); j++){
                if(Integer.parseInt(String.valueOf(j)) % 2 == 0){

                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (array[i] != 0) {
                arrlist.add(array[i]);
            }
        }
        array = arrlist.stream().mapToDouble(Double::doubleValue).toArray();

        return array;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String p;

        double[] array = fill_array(choose_fill(scan), scan);
        int ch2;
        do {
            p = "\nВведите 3 для вывода элементов массива на экран в строку\n"
                    + "Введите 4 для обработки массива\n"
                    + "Введите 5 для изменения массива\n"
                    + "Введите 6 для выхода из программы";
            ch2 = readInt(scan, p);
            if (ch2 != 3 && ch2 != 4 && ch2 != 5 && ch2 != 6) {
                System.out.println("Ошибка: wrong number");
            }
            if (ch2 == 3) {
                print_array(array);
            }
            if (ch2 == 4) {
                processing_array(array);
            }

            if (ch2 == 5) {
                array = changing_array(array);
            }

        } while (ch2 != 6);
    }

}
