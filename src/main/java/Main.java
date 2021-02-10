import DAO.Implementation.LocationDao;
import Services.Implementation.AccountService;
import Services.Implementation.LocationService;
import entities.Account;
import entities.Location;
import entities.enums.ReqStatus;
import entities.enums.UserType;
import exceptions.ServiceException;

import java.util.List;

public class Main {
    public static void  main(String[] args){
        AccountService accountService=new AccountService();
        Account account=new Account();
        account.setPassword("1234");
        account.setEmail("123.com");
        account.setLastName("123");
        account.setFirstName("men");
        account.setUserName("yyy");
        account.setUserType(UserType.ADMIN);
        //account.setLocation_id(1);
        try {
           accountService.create(account);
            System.out.println(account);
            System.out.println("+++");
            } catch (ServiceException serviceException) {
            serviceException.printStackTrace();
        }

    }
}
