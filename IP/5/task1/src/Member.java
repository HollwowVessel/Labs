import java.util.Calendar;

enum Sex{
    Male,
    Female
}

enum TypeOfEducation{
    Paid,
    Free
}

public class Member {
    private String surname;
    private String name;
    private String middleName;
    private Sex sex;
    private Calendar birthdayDate;
    private TypeOfEducation type;
    private int quantityOfFailedExams;

    Member(String surname, String name, String middleName, Sex sex, Calendar birthdayDate, TypeOfEducation type, int quantityOfFailedExams){
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.sex = sex;
        this.birthdayDate = birthdayDate;
        this.type = type;
        this.quantityOfFailedExams = quantityOfFailedExams;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {

        this.sex = sex;
    }

    public Calendar getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Calendar birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public TypeOfEducation getType() {
        return type;
    }

    public void setType(TypeOfEducation type) {
        this.type = type;
    }

    public int getQuantityOfFailedExams() {
        return quantityOfFailedExams;
    }

    public void setQuantityOfFailedExams(int quantityOfFailedExams) {
        try{
            if(quantityOfFailedExams > 2 || quantityOfFailedExams < 0){
                throw new Exception("Failed exams could be only in range from 0 to 2");
            }
            this.quantityOfFailedExams = quantityOfFailedExams;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public String toString() {
        String sex = this.sex == Sex.Male ? "Male" : "Female";
        String type = this.type == TypeOfEducation.Free ? "Free" : "Paid";
        return "\nSurname: " + this.surname
                + "\nName: " + this.name +
                "\nMiddlename: " + this.middleName
                + "\nSex: " + sex
                + "\nType of education: " + type
                + "\nBirthday: " + birthdayDate
                + "\nQuantity of failed exams" + quantityOfFailedExams;
    }
}
