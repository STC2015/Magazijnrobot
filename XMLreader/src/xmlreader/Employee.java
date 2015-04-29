/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlreader;

/**
 *
 * @author jorian
 */
class Employee {

     private String ID;
     private String Firstname;
     private String Lastname;
     private int age;
     private double salary;

     public Employee(String ID, String Firstname, String Lastname, int age, double salary) {
          this.ID = ID;
          this.Firstname = Firstname;
          this.Lastname = Lastname;
          this.age = age;
          this.salary = salary;
     }

     @Override
     public String toString() {
          return "<" + ID + ", " + Firstname + ", " + Lastname + ", " + age + ", "
                                   + salary + ">";
     }
}
