package desafioBancoDio.model.entities;

import desafioBancoDio.model.exceptions.DomainException;

public class Account implements IAccount{
	
	private String agency;
	private Integer number;
	private String holder;
	private Double balance;
	
	public Account() {
	}

	public Account(String agency, Integer number, String holder, Double balance) {
		super();
		this.agency = agency;
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}
	
	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public void deposit(Double amount) {
		this.balance += amount;
	}

	@Override
	public void withdraw(Double amount) {
		if(amount > balance)
			throw new DomainException("account cannot be negative ");
		this.balance -= amount;
	}
	

	@Override
	public void transfer(Double amount, Account sourceAccount) {
		this.withdraw(amount);
		sourceAccount.deposit(amount);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ACCOUNT");
		builder.append("\nAgency:");
		builder.append(this.agency);
		builder.append("\nNumber:");
		builder.append(this.number);
		builder.append("\nHolder:");
		builder.append(this.holder);
		builder.append("\nBalance:");
		builder.append(this.balance);
		return builder.toString();
	}
	
}
