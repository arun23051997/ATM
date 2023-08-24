//package Atmpackage;
//
//import java.sql.*;
//
//public class ATMSystem {
//    static final String JDBC_URL = "jdbc:mysql://localhost:3306/atm_db";
//    static final String USERNAME = "your_username";
//    static final String PASSWORD = "your_password";
//
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
//            System.out.println("Connected to database.");
//
//            // Create a table to store account information if not exists
//            createAccountTable(connection);
//
//            // Your ATM operations go here
//            // Example:
//            // performWithdrawal(connection, accountNumber, amount);
//            // performDeposit(connection, accountNumber, amount);
//            // checkBalance(connection, accountNumber);
//            // viewStatement(connection, accountNumber);
//
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Create account table if not exists
//    private static void createAccountTable(Connection connection) throws SQLException {
//        String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
//                "id INT AUTO_INCREMENT PRIMARY KEY," +
//                "account_number VARCHAR(20) UNIQUE," +
//                "balance DOUBLE)";
//        Statement statement = connection.createStatement();
//        statement.executeUpdate(createTableSQL);
//        System.out.println("Account table created if not exists.");
//    }
//
//    // Withdraw amount from account
//    private static void performWithdrawal(Connection connection, String accountNumber, double amount) throws SQLException {
//        // Implement withdrawal logic here
//    }
//
//    // Deposit amount into account
//    private static void performDeposit(Connection connection, String accountNumber, double amount) throws SQLException {
//        // Implement deposit logic here
//    }
//
//    // Check account balance
//    private static void checkBalance(Connection connection, String accountNumber) throws SQLException {
//        // Implement balance check logic here
//    }
//
//    // View account statement
//    private static void viewStatement(Connection connection, String accountNumber) throws SQLException {
//        // Implement statement view logic here
//    }
//}
//import java.sql.*;
//import java.util.Scanner;
//
//public class ATMSystem {
//
//    static final String JDBC_URL = "jdbc:mysql://localhost:3306/atm_db";
//    static final String USERNAME = "your_username";
//    static final String PASSWORD = "your_password";
//
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
//            System.out.println("Connected to database.");
//
//            Scanner scanner = new Scanner(System.in);
//
//            while (true) {
//                System.out.println("Choose an option:");
//                System.out.println("1. Withdraw");
//                System.out.println("2. Check Balance");
//                System.out.println("3. Deposit");
//                System.out.println("4. Exit");
//                int choice = scanner.nextInt();
//                
//                scanner.nextLine(); // Consume the newline character
//
//                switch (choice) {
//                    case 1:
//                        System.out.print("Enter account number: ");
//                        String withdrawAccountNumber = scanner.nextLine();
//                        System.out.print("Enter withdrawal amount: ");
//                        double withdrawAmount = scanner.nextDouble();
//                        performWithdrawal(connection, withdrawAccountNumber, withdrawAmount);
//                        break;
//                    case 2:
//                        System.out.print("Enter account number: ");
//                        String balanceAccountNumber = scanner.nextLine();
//                        checkBalance(connection, balanceAccountNumber);
//                        break;
//                    case 3:
//                        System.out.print("Enter account number: ");
//                        String depositAccountNumber = scanner.nextLine();
//                        System.out.print("Enter deposit amount: ");
//                        double depositAmount = scanner.nextDouble();
//                        performDeposit(connection, depositAccountNumber, depositAmount);
//                        break;
//                    case 4:
//                        System.out.println("Exiting ATM system.");
//                        connection.close();
//                        System.exit(0);
//                    default:
//                        System.out.println("Invalid choice. Please choose a valid option.");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Withdraw amount from account
//    private static void performWithdrawal(Connection connection, String accountNumber, double amount) throws SQLException {
//        // Implement withdrawal logic here
//    }
//
//    // Deposit amount into account
//    private static void performDeposit(Connection connection, String accountNumber, double amount) throws SQLException {
//        // Implement deposit logic here
//    }
//
//    // Check account balance
//    private static void checkBalance(Connection connection, String accountNumber) throws SQLException {
//        // Implement balance check logic here
//    }
//}
//
