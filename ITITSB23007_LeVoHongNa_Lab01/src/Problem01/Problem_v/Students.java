package Problem01.Problem_v;

import java.io.*;
import java.util.*;

public class Students {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<Student>();

        String fn, ln;
        int grade, totalGrade = 0, count = 0;
        int totalExl = 0, totalOk = 0, totalFail = 0;
        int countExl = 0, countOk = 0, countFail = 0;

        Scanner fileinput = new Scanner (new File("src/Problem01/Problem_v/Student.txt"));
        while (fileinput.hasNext()){
            fn = fileinput.next();
            ln = fileinput.next();
            grade = fileinput.nextInt();

            //tạo object mới dựa trên mấy cái đã nhập
            Student s = new Student(fn, ln, grade);
            students.add(s);
            //type of student
            if (grade > 89){
                System.out.println(s.toString() + " - Excellent student");
                totalExl += grade;
                countExl++;
            }
            else if (grade >= 60 && grade <= 89){
                System.out.println(s.toString() + " - Ok student");
                totalOk += grade;
                countOk++;
            }
            else if (grade < 60){
                System.out.println(s.toString() + " - Fail student");
                totalFail += grade;
                countFail++;
            }

            //avg grade
            totalGrade = totalGrade + grade;
            count++;
        }

        double average = (double)totalGrade / count;
        double avgExl = (double)totalExl / countExl;
        double avgOk = (double)totalOk / countOk;
        double avgFail = (double)totalFail / countFail;
        System.out.print("\n");
        System.out.println("The average grade of "+ count +" students is: " + average);
        System.out.println("There are " + countExl + " students with the excellent average grade of " + avgExl);
        System.out.println("There are " + countOk + " students with the ok average grade of " + avgOk);
        System.out.println("There are " + countFail + " students with the fail average grade of " + avgFail);

        //Sắp xếp theo điểm:
        students.sort((a, b) -> a.getGrade() - b.getGrade());
        System.out.println("Student list after sorting:");
        for (Student s: students) {
            System.out.println(s);
        }

        //Sắp xếp theo last name
        /*
        students.sort(Comparator.comparing(Student::getLastname));
        System.out.println("Student list after sorting:");
        for (Student s: students) {
            System.out.println(s);
        }
        */
    }
}
