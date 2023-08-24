


package Atmpackage;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;

//
//Decompiled by Procyon v0.5.36
//



import java.util.Scanner;

public class Main
{
	
	 
 public static void main(final String[] args) throws SQLException {
     
	 boolean exitFlag = false;
	  Scanner Scan1 = new Scanner(System.in);
	 
	 while (!exitFlag) {
     System.out.println("1.Create Account");
     System.out.println("2.Already have Account");
     System.out.println("3. Exit");
     System.out.print("Choose Option : ");
   
     
     int UserSelect = Scan1.nextInt();
     switch (UserSelect) {
         case 1: {
             CreateAccount.dosomething();
             break;
         }
         case 2: {
             AleadyHaveAccount.alreadyhaveaccount();
             
             break;
         }
         case 3: {
        	 exitFlag = true;
             System.out.println("Thank you for using our ATM. Goodbye!");
             System.exit(0);
             
             break;
         }
         default: {
             System.out.println("Please click correct choice!");
             break;
         }
     }
 }
 }
}