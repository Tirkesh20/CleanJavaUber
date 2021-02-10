import DAO.Implementation.AccountDAO;
import DAO.Implementation.LocationDao;
import Services.Implementation.AccountService;
import Services.Implementation.LocationService;
import entities.Account;
import entities.Location;
import entities.enums.ReqStatus;
import entities.enums.UserType;
import exceptions.DaoException;
import exceptions.ServiceException;

import java.util.List;

public class Main {
    public static void  main(String[] args){
        LocationDao dao=new LocationDao();

//    AccountService s=new AccountService();
LocationService locationService=new LocationService();
Location location=new Location();
location.setLat(111.1);
location.setLng(111.2);
location.setReqStatus(ReqStatus.WAITING);
        try {
            locationService.create(location);
//          List<Account> accountList= s.read();
//            for (Account acc:accountList) {
//                System.out.println((acc))
            System.out.println("+++");
            } catch (ServiceException serviceException) {
            serviceException.printStackTrace();
        }

    }
}
