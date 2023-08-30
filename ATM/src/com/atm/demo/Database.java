package com.atm.demo;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database extends FormFilling {

	 String bankname1;
	 String Name;
	 int Age;
	 String Gender;
	 String MobileNumber;
	 String Adhar;
	 String Email;
	 String AccountNumber;
	 String Pass;
	 Double Amount;
	 Double balance;
	Scanner Scanner = new Scanner(System.in);

	public Database() {

	}

	public Database(String bankname1,String name, int age, String gender, String mobileNumber, String adhar, String email,
			String accountNumber, String pass, double amount)

	{
		this.bankname1=bankname1;
		this.Name = name;
		this.Age = age;
		this.Gender = gender;
		this.MobileNumber = mobileNumber;
		this.Adhar = adhar;
		this.Email = email;
		this.AccountNumber = accountNumber;
		this.Pass = pass;
		this.Amount = amount;

	}
	AlreadyHaveAccount alreadyHaveAccountObject1 = new AlreadyHaveAccount();
	public Connection database() {
		//Database db = new Database();
		String url = "jdbc:mysql://localhost:3306/ATM";
		String username = "root";
		String password = "Zxcvbnm123.00";
		Connection c = null;

		try {
			Connection con = DriverManager.getConnection(url, username, password);

			c = con;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;

	}

	public void insert(Connection con) throws SQLException {
		
		String qry = "";
		qry = "insert into Form (Bank,Name,Age,Gender,MobileNumber,Adhar,Email,AccountNumber,Pass,Amount) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(qry);
		
		st.setString(1, bankname1);
		st.setString(2, Name);
		st.setInt(3, Age);
		st.setString(4, Gender);
		st.setString(5, MobileNumber);
		st.setString(6, Adhar);
		st.setString(7, Email);
		st.setString(8, AccountNumber);
		st.setString(9, Pass);
		st.setDouble(10, Amount);
		st.executeUpdate();
		System.out.println("Account created success");
	}

	public List<String> check(Connection con) throws SQLException {
		
		List<String> getNameBank = new ArrayList<>();

		System.out.println("Account Number: " +alreadyHaveAccountObject1.accountnumber1);

		String qry = "SELECT * FROM Form WHERE AccountNumber =" +alreadyHaveAccountObject1.accountnumber1;
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(qry);

		rs.next();

		String name = rs.getString("Name");
		String bank = rs.getString("Bank");

		getNameBank.add(name);
		getNameBank.add(bank);

		return getNameBank;

	}
	
	void performWithdrawal(Connection con) throws SQLException {
		AlreadyHaveAccount AlreadyHaveAccount = new AlreadyHaveAccount();
		String qry = "SELECT * FROM Form WHERE AccountNumber =" + AlreadyHaveAccount.accountnumber1;
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(qry);

		rs.next();
		Double name = rs.getDouble("Amount");

		if (name > 0 && AlreadyHaveAccount.withdrawamount < name) {
			balance = (name - AlreadyHaveAccount.withdrawamount);
		} else {
			System.out.println("Insufficiant Balance!!!!");
		}
		System.out.println("with draw amount--------" + AlreadyHaveAccount.withdrawamount);
		System.out.println("balance" + name);
		System.out.println("balance" + balance);

		qry = "UPDATE Form SET Amount =" + balance + "WHERE AccountNumber ="
				+ AlreadyHaveAccount.accountnumber1;

		PreparedStatement st1 = con.prepareStatement(qry);
		st1.executeUpdate(qry);

		System.out.println("Your withdraw amout : " + AlreadyHaveAccount.withdrawamount + "\n"
				+ "Your balance amount : " + balance);
		System.out.println("wihtdraw sucess!");
	}

	void performDeposit(Connection con) throws SQLException {
		System.out.println("deposite");
		System.out.println("Which account deposit : ");
		String accountnumber2 = Scanner.next();
		String qry = "SELECT * FROM Form WHERE AccountNumber =" + accountnumber2;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
		rs.next();
		Double name = rs.getDouble("Amount");
		Double name1 = name + alreadyHaveAccountObject1.deposit;

		qry = "UPDATE Form SET Amount =" + name1 + "WHERE AccountNumber=" + accountnumber2;
		PreparedStatement st1 = con.prepareStatement(qry);
		st1.executeUpdate(qry);
		System.out.println("Deposite Success!");
	}

	void checkBalance(Connection con) throws SQLException {
		System.out.println("Checkbalance");
		String qry = "SELECT * FROM Form WHERE AccountNumber =" +  alreadyHaveAccountObject1.accountnumber1;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
		rs.next();
		Double name = rs.getDouble("Amount");
		System.out.println("Your balance now : " + name);
	}

}