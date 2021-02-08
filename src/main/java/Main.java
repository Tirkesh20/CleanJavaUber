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
//LocationService locationService=new LocationService();
//Location location=new Location();
//location.setStreetFrom("ashgabat");
//location.setStreetTo("minsk");
//location.setReqStatus(ReqStatus.SEARCHING);
        try {
            dao.select();
//          List<Account> accountList= s.read();
//            for (Account acc:accountList) {
//                System.out.println((acc));
            System.out.println(dao);
            System.out.println("+++");
            } catch (DaoException serviceException) {
            serviceException.printStackTrace();
        }

    }
}
