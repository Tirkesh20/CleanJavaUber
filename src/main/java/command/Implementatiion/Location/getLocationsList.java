package command.Implementatiion.Location;

import Services.Implementation.AccountService;
import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Account;
import entities.Location;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class getLocationsList implements Command {
 private  final AccountService accountService=new AccountService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page=new Page();
        page.setRedirecet(true);
        page.setUrl("taxiAvailable.jsp");
        List<Account> locationList=accountService.read();
        HttpSession sessions=request.getSession();
        sessions.setAttribute("locationList",locationList);
        return page;
    }
}
