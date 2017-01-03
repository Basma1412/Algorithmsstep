
package project;

import java.util.Scanner;


public class Project {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("please enter number of nodes you need to initialize ");
        int n=sc.nextInt();
        WorkingArea.testProgram(n);
    }
    
}
