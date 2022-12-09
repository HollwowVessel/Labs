import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Call implements Serializable  {
    private String outgoingPhoneNumber;
    private int id;
    private String incomingPhoneNumber;
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

    public String getIncomingPhoneNumber() {
        return incomingPhoneNumber;
    }

    public String getOutgoingPhoneNumber() {
        return outgoingPhoneNumber;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setIncomingPhoneNumber(String incomingPhoneNumber) {
        this.incomingPhoneNumber = incomingPhoneNumber;
    }

    public void setOutgoingPhoneNumber(String outgoingPhoneNumber) {
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
        String incoming = scanner.next();
        System.out.print("Input an outgoing number: ");
        String outgoing = scanner.next();
        System.out.print("Input a duration of call: ");
        this.callDuration = scanner.nextInt();
        this.incomingPhoneNumber = incoming;
        this.outgoingPhoneNumber = outgoing;
        this.setCalendar();
    }

    @Override
    public String toString() {
        return this.incomingPhoneNumber + " " +
                this.outgoingPhoneNumber + " " +
                this.callDuration +  " " +
                this.date.getTime() + " id: " + this.id;
    }
}
