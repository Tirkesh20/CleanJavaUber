package command.Implementatiion.Order;

import Services.Implementation.OrderService;
import command.Command;
import command.Page;
import entities.Order;
import exceptions.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminOrderRead implements Command {
    private final Page page = new Page();
    private final OrderService orderService = new OrderService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session = request.getSession();
        List<Order> orders = orderService.read();
        session.setAttribute("orders", orders);
        page.setRedirect(true);
        page.setUrl("orders.jsp");
        return page;
    }
}
