package ProjectBank;

import java.util.List;

public class Bank {
    private String bankName = "DemirBank";
    private List<User> custames;
    private List<Account> accounts;

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public List<User> getCustames() {
        return custames;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Bank(String bankName, List<User> custames, List<Account> accounts) {
        this.bankName = bankName;
        this.custames = custames;
        this.accounts = accounts;
    }
}
