package desafioBancoDio.model.entities;

import desafioBancoDio.model.exceptions.DomainException;

public class SavingsAccount extends Account{
	
	private Double withdrawLimit;


	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(String agency, Integer number, String holder, Double balance, Double withdrawLimit) {
		super(agency, number, holder, balance);
		this.withdrawLimit = withdrawLimit;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	@Override
	public void deposit(Double amount) {
//		if(amount < this.entryLimit)
//			throw new DomainException("Minimum deposit amount is " + this.entryLimit);
		super.deposit(amount);
	}
	
	public void withdraw(Double amount) {
		if(amount > withdrawLimit) {
			throw new DomainException("the amount esceeds withdraw limit");
		}
		if(amount > super.getBalance()) {
			throw new DomainException("not enough balance");
		}
		super.withdraw(amount);
	}

}
