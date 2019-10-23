package com.bank.thebank.data.model;

/**Withdraw class
 * Receives the current balance and withdraw amount
 * Subtracts withdraw amount from balance
 */

public class Withdraw {

    private double balance;
    private double withdrawaldValue;

    //sets current balance
    public void setBalance(double bal) {

        balance = bal;

    }//end setBalance
    //set withdraw value entered by user
    public void setWithdraw (double withdrawAmnt) {


        withdrawaldValue = withdrawAmnt;
    }//end setWithdraw
    //calculate and return new balance
    public double getNewBalance() {

        return balance - withdrawaldValue;


    }//end getNewBalance
}//end Withdraw
