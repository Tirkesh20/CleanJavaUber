package command.Implementatiion.Location;

import command.Command;
import command.Page;
import entities.Account;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class TaxiSubmit implements Command {
    private final Page page = new Page();

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session = request.getSession();
        Account sessionAccount = (Account) session.getAttribute("account");
        List<Account> accountList = new ArrayList<>();
        accountList.add(sessionAccount);
        session.setAttribute("accountList", accountList);
        page.setRedirecet(true);
        page.setUrl("welcome.jsp");
        return page;
    }
}
