package src.Review;

public class Person {

     private String name;
     private int age;
     private int height;

     public Person(String name, int age, int height) {
          this.name = name;
          this.age = age;
          this.height = height;
     }

     public String getName() {
          return this.name;
     }

     public int getAge() {
          return this.age;
     }

     public int getHeight() {
          return this.height;
     }

     public String talk() {
          return "Hello, my name is " + getName() + " and I am " + getAge() + " years old.";
     }
}
