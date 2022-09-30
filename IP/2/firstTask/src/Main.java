import java.util.ArrayList;
import java.util.Comparator;


public class Main {

    public static void firstSort(String sub, String[] sortArr){
        int quantity = 0;
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - 1; j++) {
                if(count(sub, sortArr[j + 1]) > count(sub, sortArr[j])) {
                    String swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
                quantity++;
            }
        }
        System.out.println(quantity);
    }
    public static void secondSort(String sub, String[] sortArr){
        int quantity = 0;
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - 1; j++) {
                int quantityFirst = sortArr[j + 1].indexOf(sub),
                        quantitySecond = sortArr[j].indexOf(sub);
                if(quantitySecond <= quantityFirst) {
                    String swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
                quantity++;
            }
        }
        System.out.println(quantity);
    }

     public static int count(String sub, String s){
        int res = 0;
        for(int i = 0; i < s.length(); i+= sub.length()){
            if(s.substring(i, sub.length() + i).equals(sub)){
                res += 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        for(String item : args){
            System.out.print(item + " ");
        }
        System.out.println();
        String subString = args[0];
        firstSort(subString, args);
        for(String item : args){
            System.out.print(item + " ");
        }
        System.out.println(subString);
        secondSort(subString, args);
        for(String item : args){
            System.out.print(item + " ");
        }
    }
    //String for test ro word word road road rororoad goroda helpro road
}
