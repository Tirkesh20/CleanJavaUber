package command.Implementatiion.Account;
import command.Command;
import command.Page;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Logout implements Command{
    private final Page page = new Page();
   @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session = request.getSession();
        session.invalidate();
        page.setRedirect(true);
        page.setUrl("index.jsp");
        return page;
    }
}
