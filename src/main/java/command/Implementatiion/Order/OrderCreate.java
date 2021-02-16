package command.Implementatiion.Order;
import DAO.Implementation.LocationDao;
import Services.Implementation.OrderService;
import command.Command;
import command.Page;
import entities.Account;
import entities.Location;
import entities.Order;
import entities.enums.FromTo;
import entities.enums.ReqStatus;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class OrderCreate implements Command {
    private final OrderService orderService=new OrderService();
    private final LocationDao dao=new LocationDao();
    private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session=request.getSession();
        Account sessionAccount=(Account)session.getAttribute("account");
        double lat=Double.parseDouble(request.getParameter("lat"));
        double lng=Double.parseDouble(request.getParameter("lng"));
        double lat2=Double.parseDouble(request.getParameter("lat2"));
        double lng2=Double.parseDouble(request.getParameter("lng2"));
        Order order=new Order();
        order.setClient_id(sessionAccount.getId());
        Location from = new Location();
        Location to = new Location();
        from.setLat(lat);
        from.setLng(lng);
        from.setFromTo(FromTo.FROM);
        from.setAccountId(sessionAccount.getId());
        to.setLat(lat2);
        to.setLng(lng2);
        to.setFromTo(FromTo.TO);
        to.setAccountId(sessionAccount.getId());
        order = orderService.createOrder(order,from,to);
        session.setAttribute("order",order);
        page.setUrl("taxiAvailable.jsp");
        page.setRedirecet(true);
        return page;
    }
}
