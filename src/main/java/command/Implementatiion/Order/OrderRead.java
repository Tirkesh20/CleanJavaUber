package command.Implementatiion.Order;

import Services.Implementation.OrderService;
import command.Command;
import command.Page;
import entities.Order;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderRead implements Command {
    private  final OrderService orderService=new OrderService();
    private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
       List<Order> orderList= orderService.read();
        HttpSession session=request.getSession();
        session.setAttribute("orderList",orderList);
        page.setRedirecet(true);
        page.setUrl("orders.jsp");
        return new Page();
    }
}
