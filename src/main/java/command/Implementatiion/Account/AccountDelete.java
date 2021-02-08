package command.Implementatiion.Account;

import Services.Implementation.AccountService;
import command.Command;
import command.Page;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class AccountDelete implements Command {
private AccountService accountService=new AccountService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        accountService.delete();
        return new Page();
    }
}
