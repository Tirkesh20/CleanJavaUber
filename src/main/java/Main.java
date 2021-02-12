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
        LocationService locationService=new LocationService();

        try {
            System.out.println(locationService.randomize());
            System.out.println("+++");
            } catch (ServiceException serviceException) {
            serviceException.printStackTrace();
        }

    }
}
