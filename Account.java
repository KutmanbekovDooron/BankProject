package ProjectBank;

import java.util.List;

public class Account {
    private int id;
    private double balanceSom;
    private double balanceDollor;
    private String name;
    private User accountHolderl;
    private List <Transaction> transaction;

    public Account(int id, String name, User accountHolderl,int balanceSom,int balanceDollor) {
        this.id = id;
        this.name = name;
        this.accountHolderl = accountHolderl;
        this.balanceDollor = balanceDollor;
        this.balanceSom = balanceSom;
    }

    public void setAccountHolderl(User accountHolderl) {
        this.accountHolderl = accountHolderl;
    }

    public int getId() {
        return id;
    }

    public double getBalanceSom() {
        return balanceSom;
    }

    public void setBalanceSom(double balanceSom) {
        this.balanceSom = balanceSom;
    }

    public double getBalanceDollor() {
        return balanceDollor;
    }

    public void setBalanceDollor(double balanceDollor) {
        this.balanceDollor = balanceDollor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAccountHolderl() {
        return accountHolderl;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }
    void addTransaction (List<Transaction> list){

    }


}
