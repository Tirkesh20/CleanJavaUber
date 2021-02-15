package command.Implementatiion.Location;

import DAO.Implementation.AccountDAO;
import Services.Implementation.AccountService;
import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Location;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class getLocationsList implements Command {
 private final LocationService service=new LocationService();
                AccountDAO dao=new AccountDAO();
 private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession sessions=request.getSession();
        List<Location> oldList=(List<Location>)sessions.getAttribute("taxiLocation");
        List<Location> newList=new ArrayList<>();
        newList.addAll(oldList);
        oldList.clear();
        sessions.setAttribute("newList",newList);
        page.setRedirecet(true);
        page.setUrl("taxiAvailable.jsp");
        return page;
    }
}
