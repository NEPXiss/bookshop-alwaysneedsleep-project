package base;


import store.StoreDataBase;

public abstract class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayUsername() {
        return "ACCOUNT : " + getUsername();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return "ACCOUNT";
    }

    public boolean deleteAccount() {
        StoreDataBase.getStoreAccountDataBase().getAccountMap().remove(this.username);
        return true;
    }
}
