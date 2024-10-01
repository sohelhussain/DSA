package java;

import java.util.Scanner;

public class input {
   // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter your name");
       
    //    String name = sc.nextLine();
    //    System.out.println("Hello " + name);


    Scanner sc = new Scanner(System.in);
    // System.out.println("Enter your name");
    // String name = sc.next();   //? <--- sirf space or nextlineSimbole ko nhi leta
    // System.out.println("Hello " + name);

    System.out.println("Enter your name");
    String name = sc.nextLine();  //? <--- ye puri line ko pic kar leta he
    System.out.println("Enter your age");
    int age = sc.nextInt();
    System.out.println("Hello " + name + " your age is " + age); 
}
