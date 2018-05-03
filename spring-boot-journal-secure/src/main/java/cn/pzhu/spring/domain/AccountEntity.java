package cn.pzhu.spring.domain;

import javax.persistence.Entity;

@Entity(name = "account")
public class AccountEntity extends AbstractEntity {

    private String accountName;
    private String password;
    private Boolean enabled;
    private String userEntityId;
    private String confirmationToken;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEntityId() {
        return userEntityId;
    }

    public void setUserEntityId(String userEntityId) {
        this.userEntityId = userEntityId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAccountName() {

        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
