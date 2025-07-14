package Problem01.Problem_v;

public class Student {
    private String firstname;
    private String lastname;
    private int grade;
    //constructor
    public Student(String firstname, String lastname, int grade){
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
    }
    public String toString(){
        return firstname + " " + lastname + " " + grade;
    }

    //getters and setters
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
}