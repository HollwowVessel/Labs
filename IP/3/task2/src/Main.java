import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

class dateComparator implements Comparator<Call>{
    @Override
    public int compare(Call c1, Call c2){
        int res = 0;

        if(c1.getDate().before(c2.getDate())) {
            res = 1;
        }
        else if(c2.getDate().before(c1.getDate())){
            res = -1;
        }
        return res;
    }
}

public class Main {




    private static void addCall(List<Call> calls){
        Call call = new Call();
        call.createCall();
        call.setId(calls.size());
        calls.add(call);
        writeFile(calls);
    }
    private static void writeFile(List<Call> calls){
        try {
            OutputStream os = new FileOutputStream("file.bin");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(Call value : calls){
                oos.writeObject(value);
            }
            oos.close();
        } catch(IOException e) {
            System.out.println("Невозможно сохранить файл");
        }
    }
    private static void readFile(List<Call> calls){
        try {
            InputStream is = new FileInputStream("file.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            boolean cont = true;
            while(cont) {
                Call obj = null;
                try {
                    obj = (Call) ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (obj != null) {
                    calls.add(obj);
                } else {
                    cont = false;
                }
            }
            ois.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    private static void editCall(List<Call> calls, int id){
        for(Call value: calls){
            System.out.println(value);
            System.out.println(value.getId());
        }
        Call call = calls.stream().filter(call1 -> call1.getId() == id).toList().get(0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to change numbers? 1 - yes");
        int handler = scanner.nextInt();
        if(handler == 1){
            System.out.print("Write an outgoing number: ");
            call.setOutgoingPhoneNumber(scanner.nextInt());
            System.out.print("Write an incoming number: ");
            call.setIncomingPhoneNumber(scanner.nextInt());
        }
        System.out.println("Do you want to change date? 1 - yes");
        handler = scanner.nextInt();
        if(handler == 1){
            call.setCalendar();
        }
        System.out.println("Do you want to change duration? 1 - yes");
        handler = scanner.nextInt();
        if(handler == 1){
            System.out.println("Write a duration: ");
            call.setCallDuration(scanner.nextInt());
        }
        calls.set(call.getId(), call);
    }

    private static void edit(List<Call> calls){
        System.out.print("Input an id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if(id > calls.size()){
            System.out.println("Incorrect id");
        } else{
            editCall(calls, id);
            writeFile(calls);
        }
    }

    private static void delete(List<Call> calls){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input an id: ");
        int id = scanner.nextInt();
        if(id > calls.size()){
            System.out.println("Incorrect id");
        }
        else{
            calls.remove(id);
            writeFile(calls);
        }
    }
    private static void print(List<Call> calls){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a phone number: ");
        int phoneNumber = scanner.nextInt();
        List<Call> incomingCalls = new ArrayList<>(calls.stream().filter(call -> call.getIncomingPhoneNumber() == phoneNumber).toList());
        List<Call> outgoingCalls = new ArrayList<>(calls.stream().filter(call -> call.getOutgoingPhoneNumber() == phoneNumber).toList());
        incomingCalls.sort(new dateComparator());
        outgoingCalls.sort(new dateComparator());
        int sumOfDurations = 0;
        System.out.println("Incoming: ");
        for(Call value : incomingCalls){
            System.out.println(value);
            sumOfDurations += value.getCallDuration();
        }
        System.out.println("Outgoing: ");
        for(Call value : outgoingCalls){
            System.out.println(value);
            sumOfDurations += value.getCallDuration();
        }
        System.out.println("General duration - " + sumOfDurations);
    }

    public static void main(String[] args) {

        List<Call> calls = new ArrayList<>();
        readFile(calls);
        Scanner scanner = new Scanner(System.in);
        System.out.print(calls.size());
        boolean work = true;
        while(work){
            System.out.println("1 - Add call to array of calls\n 2 - Edit call\n 3 - Delete call\n 4 - print\n");
            int handler = scanner.nextInt();
            switch (handler) {
                case States.ADD -> {
                    addCall(calls);
                }
                case States.EDIT -> {
                    edit(calls);
                }
                case States.DEL -> {
                    delete(calls);
                }
                case States.PRINT -> {
                    print(calls);
                    work = false;
                }
            }
        }
    }
}

class States{
        static final int ADD = 1;
        static final int EDIT = 2;
        static final int DEL = 3;
        static final int PRINT = 4;
}