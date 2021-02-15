package command.Implementatiion.Order;
import Services.Implementation.OrderService;
import command.Command;
import command.Page;
import entities.Location;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class OrderCreate implements Command {
    private final OrderService orderService=new OrderService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page=new Page();
        HttpSession session=request.getSession();
        Location location= (Location)  session.getAttribute("location");
        page.setRedirecet(true);
        page.setUrl("");
        return new Page();
    }
}
