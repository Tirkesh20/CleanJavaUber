package command.Implementatiion.Location;
import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Account;
import entities.Location;
import entities.enums.ReqStatus;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocationCreate implements Command {
    private final LocationService locationService=new LocationService();
    private final  Account account=new Account();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Location location=new Location();
        HttpSession session= request.getSession();
        session.getAttribute("account");
        Page page=new Page();
        double lat=Double.parseDouble(request.getParameter("lat"));
        double lng=Double.parseDouble(request.getParameter("lng"));
        location.setLat(lat);
        location.setLng(lng);
        location.setReqStatus(ReqStatus.WAITING);
        locationService.create(location);
        page.setUrl("taxiAvailable.jsp");
        page.setRedirecet(true);
        return page;
    }
}
