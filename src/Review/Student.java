package src.Review;

public class Student extends Person {
     private int studentNumber;
     private int studentID;
     private int grades;
     
     public Student(String name, int age, int height, int studentNumber, int studentID, int grades) {
          super(name, age, height);
          this.studentNumber = studentNumber;
          this.studentID = studentID;
          this.grades = grades;
     }

     public int getStudentNumber() {
          return this.studentNumber;
     }

     public int getStudentID() {
          return this.studentID;
     }

     public int grades() {
          return this.grades;
     }

     @Override
     public String talk() {
          return "Hello, my name is " + super.getName() + " and I am " + super.getAge() + " years old.";
     }
}
