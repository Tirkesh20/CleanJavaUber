package command;

import entities.Account;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class getResponse implements Command {
    private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session=request.getSession();
        Account sessionAccount=(Account) session.getAttribute("account");
        sessionAccount.getId();
        page.setRedirecet(true);
        page.setUrl("taxiAvailable.jsp");
        return page;
    }
}
