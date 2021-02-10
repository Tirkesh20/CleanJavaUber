package command.Implementatiion.Account;
import command.Command;
import command.Page;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Logout implements Command{
@Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page();
        HttpSession session = request.getSession();
        session.invalidate();

        page.setRedirecet(true);
        page.setUrl("index.jsp");

  return page;
    }
}
