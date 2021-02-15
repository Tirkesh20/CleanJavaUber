package command.Implementatiion.Order;


import Services.Implementation.OrderService;
import command.Command;
import command.Page;
import entities.Order;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class OrderUpdate implements Command {
    private final OrderService orderService=new OrderService();
    private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        page.setRedirecet(true);
        HttpSession session=request.getSession();
        Order order=(Order) session.getAttribute("order");
        orderService.update(order);
        return new Page();
    }
}
