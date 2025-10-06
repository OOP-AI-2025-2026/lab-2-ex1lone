package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0.0; // початкове значення комісії

    // Поповнення рахунку
    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума поповнення повинна бути більше 0");
        }
        balance += amount;
    }

    // Отримання поточного балансу
    double getBalance() {
        return this.balance;
    }

    // Зняття коштів (із врахуванням комісії)
    boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума зняття повинна бути більше 0");
        }

        double total = amount + transactionFee;
        if (total > balance) {
            return false; // недостатньо коштів
        }

        balance -= total;
        return true;
    }

    // Переказ коштів іншому рахунку
    boolean transfer(BankAccount receiver, double amount) {
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

        // списуємо з поточного рахунку суму + комісію
        balance -= total;
        // зараховуємо суму без комісії на рахунок отримувача
        receiver.balance += amount;

        return true;
    }
}
