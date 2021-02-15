package command.Implementatiion.Location;
import DAO.Implementation.OrderDao;
import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Account;
import entities.Location;
import entities.Order;
import entities.enums.ReqStatus;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocationCreate implements Command {
    private final LocationService locationService=new LocationService();
    private final OrderDao dao=new OrderDao();
    private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Location location=new Location();
        Location location1=new Location();
        HttpSession session= request.getSession();
        Account sessionAccount=(Account)session.getAttribute("account");
        double lat=Double.parseDouble(request.getParameter("lat"));
        double lng=Double.parseDouble(request.getParameter("lng"));
        double lat2=Double.parseDouble(request.getParameter("lat2"));
        double lng2=Double.parseDouble(request.getParameter("lng2"));
        location.setLat(lat);
        location.setLng(lng);
        location.setReqStatus(ReqStatus.WAITING);
        location.setAccountId(sessionAccount.getId());
        locationService.create(location);
        location1.setLat(lat2);
        location1.setLng(lng2);
        location1.setReqStatus(ReqStatus.WAITING);
        location1.setAccountId(sessionAccount.getId());
        locationService.create(location1);
        Order order=new Order();
        order.setClient_id(sessionAccount.getId());
        order.setFrom_id(location.getId());
        order.setTo_id(location1.getId());
        page.setUrl("taxiAvailable.jsp");
        page.setRedirecet(true);
        return page;
    }
}
