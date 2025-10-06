package ua.opnu;

public class BankAccount {
  String name;
  double balance;
  double transactionFee = 0;

  void deposit(double amount) {
    // TODO: modify method body

    if (amount < 0) {
      return;
    }

    balance = balance + amount;
  }

  double getBalance() {
    return this.balance;
  }

  boolean withdraw(double amount) {
    // TODO: modify method body
    double a;
    a = balance - amount - transactionFee;

    if (a < 0 || amount <= 0) {
      return false;
    }

    balance = a;

    return true;
  }

  boolean transfer(BankAccount receiver, double amount) {
    // TODO: modify method body

    double a = this.balance - amount - transactionFee;
    if (a < 0 || amount <= 0) {
      return false;
    }

    this.balance = a;

    receiver.deposit(amount);

    return true;
  }
}
