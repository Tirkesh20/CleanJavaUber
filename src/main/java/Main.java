import DAO.Implementation.LocationDao;
import Services.Implementation.AccountService;
import Services.Implementation.LocationService;
import entities.Account;
import entities.Location;
import entities.enums.ReqStatus;
import exceptions.ServiceException;

import java.util.List;

public class Main {
    public static void  main(String[] args){
        AccountService accountService=new AccountService();
  LocationService locationService=new LocationService();
  Location location=new Location();
  location.setReqStatus(ReqStatus.WAITING);
        try {
           List<Account> list= accountService.read();
            System.out.println(list);
            System.out.println("+++");
            } catch (ServiceException serviceException) {
            serviceException.printStackTrace();
        }

    }
}
