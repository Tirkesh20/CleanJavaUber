package command.Implementatiion.Account;

import Services.Implementation.AccountService;
import command.Command;
import command.Page;
import entities.Account;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AccountSelect implements Command {
    private AccountService accountService=new AccountService();
Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        List<Account> read = accountService.read();
        page.setRedirecet(true);
        page.setUrl("welcome.jps");
        return page;
    }

}
