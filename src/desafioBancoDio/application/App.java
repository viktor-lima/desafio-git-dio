package desafioBancoDio.application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import desafioBancoDio.model.entities.Account;
import desafioBancoDio.model.entities.CurrentAccount;
import desafioBancoDio.model.entities.SavingsAccount;
import desafioBancoDio.model.exceptions.DomainException;

public class App {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Account cc = new CurrentAccount("223", 125, "viktor", 0.00);

		System.out.println("Current Account\n");
		// deposit
		System.out.println();
		System.out.println("Deposit Current Account");		
		cc.deposit(100.00);
		System.out.println(cc);
		// withdraw
		System.out.println();
		System.out.println("withdraw Current Account");
		try {

			cc.withdraw(0.00);
			System.out.println("Current Account: " + String.format("%.2f", cc.getBalance()));

		} catch (DomainException e) {
			System.out.println("withdraw error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Error: input nunber please!");
		}


		System.out.println();
		System.out.println("Savings Account\n");
		Account sa = new SavingsAccount(cc.getAgency(), cc.getNumber(), "joao", 0.00, 100.00);

		//transfer cc to sa
		System.out.println("\nTransfer Current Account to Savings Account");;
		try {

			cc.transfer(50.00, sa);
			System.out.println("new balance Current Account: " + String.format("%.2f", cc.getBalance()));

		} catch (DomainException e) {
			System.out.println("withdraw error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Error: input nunber please!");
		}
		System.out.println("Savings Account");
		System.out.println(sa);
		
		// deposit
		System.out.println();
		System.out.println("Deposit Savings Account");
		sa.deposit(200.00);
		System.out.println(sa);
		// withdraw
		System.out.println();
		System.out.println("withdraw Savings Account");
		try {

			sa.withdraw(100.00);
			System.out.println("new balance Savings Account: " + String.format("%.2f", sa.getBalance()));

		} catch (DomainException e) {
			System.out.println("withdraw error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Error: input nunber please!");
		}

		sc.close();
	}

}
