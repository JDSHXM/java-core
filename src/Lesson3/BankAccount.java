package Lesson3;

public class BankAccount {
    private String fio;
    private Integer accountNumber;
    private Double balance;

    public Boolean deposit(double amount) {
        return balance + amount > 0;
    }

    public Boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public String getBalance() {
        return "Your balance is: " + balance;
    }
}
