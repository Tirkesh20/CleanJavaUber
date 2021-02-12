package command.Implementatiion.Account;

import Services.Implementation.AccountService;

import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Account;
import entities.enums.DriverStatus;
import entities.enums.UserType;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AccountRead  implements Command {
    private AccountService accountService=new AccountService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Page page=new Page();
        page.setRedirecet(true);
        Account account = accountService.checkService(username, password);
        if (account != null){
           HttpSession session=request.getSession();
           if (account.getType().equals(UserType.TAXI)) {
               LocationService locationService=new LocationService();
               locationService.randomize();
               session.setAttribute("taxi_location",locationService);
               account.setStatus(DriverStatus.WAITING);
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
