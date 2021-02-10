package command.Implementatiion.Account;

import Services.Implementation.AccountService;
import command.Command;
import entities.Account;
import exceptions.ServiceException;
import command.Page;

import javax.servlet.http.HttpServletRequest;

public class AccountCreate implements Command {
    private final AccountService accountService = new AccountService();
     private accFetcher accFetcher =new accFetcher();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Account entity = accFetcher.fetchAcc(request);
        accountService.create(entity);
            Page page=new Page();
            page.setUrl("login.jsp");
            page.setRedirecet(true);
            return page;
        }

    }

