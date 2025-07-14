/*need to do:
person
constructor
sort (selection)
*/

import java.util.ArrayList;

class person {
    private String firstname;
    private String lastname;
    private int grade;
    //constructor
    public person(String firstname, String lastname, int grade) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
    }
    public void display() {
        System.out.println(firstname + " - " + lastname + " - " + grade);
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public int getGrade() {
        return grade;
    }
}
//sort
class ArrayOfPersons {
    private person[] a;
    int numEle;
    //constructor
    public ArrayOfPersons(int size) {
        a = new person[size];
        numEle = 0;
    }

    public void insertPerson(String firstname, String lastname, int grade) {
        a[numEle] = new person(firstname, lastname, grade);
        numEle++;
    }

    public void display() {
        for (int i = 0; i < numEle; i++) {
            a[i].display();
        }
        System.out.println();
    }

    public void FirstnameSort(){
        int in, out;
        for(out=1; out < numEle; out++) {
            person temp = a[out];
            in = out;
            while(in>0 && a[in-1].getFirstname().compareTo(temp.getFirstname())>0) {
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }
    }

    public void LastnameSort(){
        int in, out;
        for(out=1; out < numEle; out++) {
            person temp = a[out];
            in = out;
            while(in>0 && a[in-1].getLastname().compareTo(temp.getLastname())>0) {
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }
    }

    public void GradeSort(){
        for(int i=0; i< numEle; i++){
            person temp= a[i];
            int j=i;
            while(j>0 && a[j-1].getGrade() >= temp.getGrade()){
                a[j]= a[j-1];
                --j;
            }
            a[j]= temp;
        }
    }

    public void Sorting(String types) {
        switch (types) {
            case "First name":
                FirstnameSort();
                break;
            case "Last name":
                LastnameSort();
                break;
            case "Grade":
                GradeSort();
                break;
            default:
                break;
        }
    }
}
class ObjectSortApp {
    public static void main(String[] args) {
        int size = 100;
        ArrayOfPersons arr = new ArrayOfPersons(size);
        arr.insertPerson("John", "Doe", 85);
        arr.insertPerson("Alice", "Smith", 90);
        arr.insertPerson("Bob", "Johnson", 78);
        arr.insertPerson("Charlie", "Brown", 95);
        arr.insertPerson("David", "Miller", 82);
        System.out.println("Before sorting:");
        arr.display();

        arr.Sorting("First name");
        System.out.println("After sorting first name:");
        arr.display();

        arr.Sorting("Last name");
        System.out.println("After sorting last name:");
        arr.display();

        arr.Sorting("Grade");
        System.out.println("After sorting grade:");
        arr.display();
    }
}
