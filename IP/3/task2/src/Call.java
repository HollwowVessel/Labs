import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Call implements Serializable  {
    private int outgoingPhoneNumber;
    static int quantity;
    private int id;
    private int incomingPhoneNumber;
    private Calendar date;
    private int callDuration;

    public Calendar getDate() {
        return date;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public int getIncomingPhoneNumber() {
        return incomingPhoneNumber;
    }

    public int getOutgoingPhoneNumber() {
        return outgoingPhoneNumber;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setIncomingPhoneNumber(int incomingPhoneNumber) {
        this.incomingPhoneNumber = incomingPhoneNumber;
    }

    public void setOutgoingPhoneNumber(int outgoingPhoneNumber) {
        this.outgoingPhoneNumber = outgoingPhoneNumber;
    }
    public void setCalendar(){
        Calendar calendar = new GregorianCalendar();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a year of a call: ");
        int year = scanner.nextInt();
        System.out.print("Input a month of a call: ");
        int month = scanner.nextInt();
        System.out.print("Input a day of a call: ");
        int day = scanner.nextInt();
        System.out.print("Input an hour of a call: ");
        int hour = scanner.nextInt();
        System.out.print("Input a minute of a call: ");
        int minute = scanner.nextInt();
        System.out.print("Input a second of a call: ");
        int second = scanner.nextInt();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        this.date = calendar;
    }

    public void createCall(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input an incoming number: ");
        int incoming = scanner.nextInt();
        System.out.print("Input an outgoing number: ");
        int outgoing = scanner.nextInt();
        System.out.print("Input a duration of call: ");
        int duration = scanner.nextInt();
        this.callDuration = duration;
        this.incomingPhoneNumber = incoming;
        this.outgoingPhoneNumber = outgoing;
        this.setCalendar();
    }

    @Override
    public String toString() {
        return this.incomingPhoneNumber + " " +
                this.outgoingPhoneNumber + " " +
                this.callDuration +  " " +
                this.date.getTime().toString() + " ";
    }
}
