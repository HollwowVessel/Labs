import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static int[] findMin(int[] initValues, ArrayList<String[]> initArr){
        int ind1 = initValues[0], ind2 = initValues[1];
        int min = Integer.parseInt(initArr.get(0)[0]);
        int resInd1 = 0, resInd2 = 0;
        for(int i = ind1; i > -1; i--){
            for(int j = ind2; j > -1; j--){
                int temp = Integer.parseInt(initArr.get(0)[0]);
                if(min >= temp){
                    min = temp;
                    resInd2 = j;
                    resInd1 = i;
                }
            }
        }

        return new int[]{min, resInd1, resInd2};
    }
    public static int[] findMax(ArrayList<String[]> init){
        int[] res = new int[2];
        int max = Integer.parseInt(init.get(0)[0]);
        for(int i = init.size() - 1; i > -1;i--){
            for(int j = init.size() - 1; j > -1; j--){
                int temp = Integer.parseInt(init.get(i)[j]);
                if(max < temp){
                    res[0] = i;
                    res[1] = j;
                    max = temp;
                }
            }
        }
        return new int[]{max, res[0], res[1]};
    }
    public static void findResult(ArrayList<String[]> init){
        int[] maxValues = findMax(init);
        int[] minValues = findMin(new int[]{maxValues[1], maxValues[2]}, init);
        System.out.println("Max value: " + maxValues[0]);
        System.out.print("Indexes are: " + maxValues[1]);
        System.out.println(", " + maxValues[2]);
        System.out.println("Min value: " + minValues[0]);
        System.out.print("Indexes are: " + minValues[1]);
        System.out.print(", " + minValues[2]);
    }
    public static void main(String[] args) {
        ArrayList<String[]> fileInput = new ArrayList<>();
        try {
            Reader reader = new FileReader("file.csv");
            BufferedReader buffReader = new BufferedReader(reader);
            String line;
            String[] resLine;
            while((line = buffReader.readLine()) != null) {
                resLine = line.split(";");
                fileInput.add(resLine);
            }
            buffReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch(IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
        findMax(fileInput);

    }
}