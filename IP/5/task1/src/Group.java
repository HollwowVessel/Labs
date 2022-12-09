import java.util.ArrayList;

enum FormOfEducation{
    FullTime,
    Correspondence
}

public class Group {
    private String name;
    private int quantity;
    private String specialty;
    private ArrayList<Member> members;
    private int course;
    private FormOfEducation form;

    public Group(String name, int quantity, String specialty, ArrayList<Member> members, int course, FormOfEducation form) {
        this.name = name;
        this.quantity = quantity;
        this.specialty = specialty;
        this.members = members;
        this.course = course;
        this.form = form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        try{
            if(this.form == FormOfEducation.FullTime){
                if(quantity > 20 || quantity <= 0) {
                    throw new Exception("Quantity of fulltime students must be in range from 1 to 20");
                }
            }
            if(this.form == FormOfEducation.Correspondence) {
                if(quantity > 30 || quantity <= 0) {
                    throw new Exception("Quantity of correspondence students must be in range from 1 to 20");
                }
            }
            this.quantity = quantity;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }


    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        try{
            if(course < 0 || course > 5){
                throw new Exception("Course must be in range from 0 to 5");
            }
            this.course = course;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public FormOfEducation getForm() {
        return form;
    }

    public void setForm(FormOfEducation form) {
        this.form = form;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }
}
