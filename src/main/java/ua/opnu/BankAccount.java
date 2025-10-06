package ua.opnu;

public class BankAccount {
    private String name;
    private double balance;
    private double transactionFee = 0.0; // початкове значення комісії

    // Конструктор
    public BankAccount(String name, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не може бути від’ємним");
        }
        this.name = name;
        this.balance = balance;
    }

    // Встановити комісію
    public void setTransactionFee(double fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("Комісія не може бути від’ємною");
        }
        this.transactionFee = fee;
    }

    // Отримати комісію
    public double getTransactionFee() {
        return transactionFee;
    }

    // Поповнення рахунку
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума поповнення повинна бути більше 0");
        }
        balance += amount;
    }

    // Отримання поточного балансу
    public double getBalance() {
        return balance;
    }

    // Зняття коштів (із врахуванням комісії)
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума зняття повинна бути більше 0");
        }

        double total = amount + transactionFee;
        if (total > balance) {
            return false; // недостатньо коштів, баланс не змінюємо
        }

        balance -= total;
        return true;
    }

    // Переказ коштів іншому рахунку
    public boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null) {
            throw new IllegalArgumentException("Отримувач не може бути null");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума переказу повинна бути більше 0");
        }

        double total = amount + transactionFee;
        if (total > balance) {
            return false; // недостатньо коштів
        }

        balance -= total;      // списуємо з поточного рахунку суму + комісію
        receiver.balance += amount; // зараховуємо суму на рахунок отримувача без комісії

        return true;
    }

    // Отримати ім'я власника рахунку
    public String getName() {
        return name;
    }
}
