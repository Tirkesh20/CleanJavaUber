package command.Implementatiion.Account;

import Services.Implementation.AccountService;

import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Account;
import entities.Location;
import entities.enums.DriverStatus;
import entities.enums.UserType;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AccountRead  implements Command {
    private final AccountService accountService=new AccountService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Page page=new Page();
        page.setRedirecet(false);
        Account account = accountService.checkService(username, password);
        if (account != null){
           HttpSession session=request.getSession();
           if (account.getUserType().equals(UserType.TAXI)){
               List<Location> locationTaxi=new ArrayList<>();
               Location location= accountService.UpdateLocation(account);
               locationTaxi.add(location);
               account.setStatus(DriverStatus.WAITING);
               session.setAttribute("taxi",location);
               session.setAttribute("taxiLocation",locationTaxi);
           }
            List<Account> accountList=new ArrayList<>();
            accountList.add(account);
            session.setAttribute("account",account);
           page.setUrl("main.jsp");
       }else{
           page.setUrl("login.jsp");
       }
        return page;
    }
}
