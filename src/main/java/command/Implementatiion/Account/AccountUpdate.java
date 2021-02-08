package command.Implementatiion.Account;

import Services.Implementation.AccountService;
import command.Command;
import command.Page;
import entities.Account;
import entities.enums.UserType;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class AccountUpdate implements Command {
private AccountService accountService=new AccountService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
Page page=new Page();
        Account account = new Account();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String usertype = request.getParameter("user_type");

        if (usertype.equals("client"))
            account.setUserType(UserType.CLIENT);
        else if (usertype.equals("taxi"))
            account.setUserType(UserType.TAXI);
        else if(usertype.equals("admin"))
            account.setUserType(UserType.ADMIN);
        account.setFirstName(firstname);
        account.setLastName(lastname);
        account.setUserName(username);
        account.setPassword(password);
        account.setEmail(email);
        accountService.update(account);
        page.setUrl("login.jsp");
        page.setRedirecet(true);
        return new Page();
    }
}
