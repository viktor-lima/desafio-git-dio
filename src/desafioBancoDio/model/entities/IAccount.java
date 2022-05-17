package desafioBancoDio.model.entities;

public interface IAccount {
	
	void deposit(Double amount);
	void withdraw(Double amount);
	void transfer(Double amount, Account sourceAccount);
}
