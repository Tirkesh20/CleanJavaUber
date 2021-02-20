package command.Implementatiion.Location;
import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocationCreate implements Command {
    private final LocationService locationService=new LocationService();
    private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session= request.getSession();
        page.setUrl("taxiAvailable.jsp");
        page.setRedirect(true);
        return page;
    }
}
