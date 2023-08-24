
package Atmpackage;

import java.sql.SQLException;
import java.util.Scanner;

public class BankName
{
    public static void bankname() throws SQLException {
        System.out.println("1. Indian Bank");
        System.out.println("2. State Bank");
        System.out.println("3. Indian Overseas Bank");
        System.out.println("Which bank you want ? : ");
         Scanner Scan1 = new Scanner(System.in);
         String bank = Scan1.nextLine();
         FormFilling bank2 = new FormFilling(bank);
       FormFilling.formfilling();
       
    }
}