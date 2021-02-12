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
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Location location=new Location();
        Location location1=new Location();
        HttpSession session= request.getSession();
        Account sessionAccount=(Account)session.getAttribute("account");
        Page page=new Page();
        double lat=Double.parseDouble(request.getParameter("lat"));
        double lng=Double.parseDouble(request.getParameter("lng"));
        double lat2=Double.parseDouble(request.getParameter("lat2"));
        double lng2=Double.parseDouble(request.getParameter("lng2"));
        location.setLat(lat);
        location.setLng(lng);
        location.setReqStatus(ReqStatus.WAITING);
        location.setAccount_id(sessionAccount.getId());
        locationService.create(location);
        location1.setLat(lat2);
        location1.setLng(lng2);
        location1.setReqStatus(ReqStatus.WAITING);
        location1.setAccount_id(sessionAccount.getId());
        locationService.create(location1);
        page.setUrl("welcome.jsp");
        page.setRedirecet(true);
        return page;
    }
}
