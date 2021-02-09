package entities;

import entities.enums.DriverStatus;
import entities.enums.UserType;
import java.util.Objects;

public class Account {
    private long id;
    private int Client_id;
    private int taxi_id;
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private String email;
    private UserType userType;
    private int location_id;
    private DriverStatus status;

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public void setTaxi_id(int taxi_id) {
        this.taxi_id = taxi_id;
    }

    public void setClient_id(int client_id) {
        this.Client_id = client_id;
    }

    public int getTaxi_id() {
        return taxi_id;
    }

    public int getClient_id() {
        return Client_id;
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
                " id='" + Client_id+'\''+ taxi_id+'\''+

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



