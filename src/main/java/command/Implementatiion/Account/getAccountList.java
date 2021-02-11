package command.Implementatiion.Account;

import Services.Implementation.AccountService;
import command.Command;
import command.Page;
import entities.Account;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class getAccountList implements Command {
     private AccountService accountService=new AccountService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page=new Page();
        List<Account> accountList=accountService.read();
        HttpSession sessions=request.getSession();
        sessions.setAttribute("list",accountList);
        page.setRedirecet(true);
        page.setUrl("users.jsp");
        return page;
    }
}
