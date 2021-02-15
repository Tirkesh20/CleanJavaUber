package command.Implementatiion.Account;
import DAO.Implementation.LocationDao;
import Services.Implementation.AccountService;
import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Account;
import entities.Location;
import entities.enums.UserType;
import exceptions.DaoException;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class Logout implements Command{
    private final Page page = new Page();
   @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session = request.getSession();
        session.invalidate();
        page.setRedirecet(true);
        page.setUrl("index.jsp");
        return page;
    }
}
