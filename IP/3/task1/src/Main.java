import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] fileInput;
        try {
            Reader reader = new FileReader("file.csv");
            BufferedReader buffReader = new BufferedReader(reader);
            String line;
            String[] resLine;
            while((line = buffReader.readLine()) != null) {
                resLine = line.split(";");
                
            }
            buffReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch(IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
        for(String item : fileInput){
            System.out.println(item);
        }

    }
}