package ProjectBank;

import SchoolProject.Employee.Accountant;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private List<Account> accountList;
    private String login;
    private String possword;

    private int balanceCom;
    private int balanceDollor;

    public int getBalanceCom() {
        return balanceCom;
    }
    public void setBalanceCom(int balanceCom) {
        this.balanceCom = balanceCom;
    }
    public void manaySom(int maony){
        this.balanceCom += maony;
    }

    public int getBalanceDollor() {
        return balanceDollor;
    }

    public void setBalanceDollor(int balanceDollor) {
        this.balanceDollor = balanceDollor;
    }
    public void manayDollor(int maony){
        this.balanceDollor += maony;
    }

    public User(int id, String firstName, String lastName, String login, String possword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.possword = possword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPossword(String possword) {
        this.possword = possword;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public String getLogin() {
        return login;
    }

    public String getPossword() {
        return possword;
    }
}
