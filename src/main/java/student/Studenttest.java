/* "1. Create a class called Student with the following instance variables:
    - name (String)
    - age (int)
    - gpa (double)
2. Implement the Student class with appropriate constructors and getter and setter methods.
3. Create a class called StudentTest with a main method.
4. In the main method, create a List of Student objects and add a few Student objects to the list.
5. Iterate over the list and print out the name, age, and GPA of each student.
6. Use the Collections.sort method to sort the list by GPA (highest to lowest).
7. Iterate over the sorted list and print out the name and GPA of each student." */
package student;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;


class student{
    String name;
    int age;
    double gpa;
    
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getGpa() {
        return gpa;
    }
    student(String name, int age, double gpa){
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    
}
public class Studenttest{
    public static final Logger LOGGER = Logger.getLogger("InfoLogging");
    public static void main(String[] args) {
        ArrayList<student> sdlist = new ArrayList<student>();
        Scanner sc = new Scanner(System.in);   
        try{     
        while(true){
        LOGGER.info("\n1.Update\n2.Exit\nEnter choice: ");
        int choice = sc.nextInt();
        if(choice == 2){
            if(sdlist.size()==0){
                LOGGER.info("No data's present.");
            }
            LOGGER.info("Student detailes updated successfully.");
            break;
        }
        else if(choice ==1 ){
            LOGGER.info("Enter details...");
        }
        else{
            LOGGER.info("Enter a valid option (1/2):");
            continue;
        }
        LOGGER.info("Enter name: ");
        String name = sc.next();      
        
        LOGGER.info("Enter age: ");
        int age = sc.nextInt();
        
        LOGGER.info("Enter gpa: ");
        double gpa = sc.nextDouble();
        
        student stuobj1 = new student(name,age,gpa);
        sdlist.add(stuobj1);
           
        }
        for(int i=0; i<sdlist.size(); i++){
            String print = "Name: "+sdlist.get(i).getName()+" Age: "+sdlist.get(i).getAge()+" GPA: "+sdlist.get(i).getGpa();
        LOGGER.info(print);
        }
        Collections.sort(sdlist,new Comparator<student>()
        {
            public int compare(student s1,student s2)
            {
                return Double.compare(s2.getGpa(),s1.getGpa());
            }
        });
        if(sdlist.size()>=1){
            LOGGER.info("Sorted database. Based on GPA");
            for(int i=0; i<sdlist.size(); i++){
            String print1 = "Name: "+sdlist.get(i).getName()+" Age: "+sdlist.get(i).getAge()+" GPA: "+sdlist.get(i).getGpa();
            LOGGER.info(print1);
            } 
        }
        }
        catch(Exception e){
            String print = ""+e;
            LOGGER.info(print);
         }
    }
}