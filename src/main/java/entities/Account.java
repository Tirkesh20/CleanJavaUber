package entities;

import entities.enums.DriverStatus;
import entities.enums.UserType;
import java.util.Objects;

public class Account {
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private String email;
    private UserType userType;
    private DriverStatus status;

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserType[] getType() {
        return UserType.values();
    }

    public String getFirstName() {
        return firstName;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

public UserType getUserType(){return userType ;}
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                "lastName='" + lastName + '\'' +
                " password='" + password + '\'' +
                "userName='" + userName + '\'' +
                " email='" + email + '\'' +
                " usertype='" + userType+'\''+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getFirstName().equals(account.getFirstName()) && getLastName().equals(account.getLastName()) && getPassword().equals(account.getPassword()) && userName.equals(account.userName) && getEmail().equals(account.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), userName);
    }
}



