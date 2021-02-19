package command.Implementatiion.Order;

import Services.Implementation.OrderService;
import command.Command;
import command.Page;
import entities.Order;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ordersWaiting implements Command {
private final OrderService orderService= new OrderService();
private final Page page=new Page();

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session= request.getSession();
        List<Order> list=orderService.readClient();
        session.setAttribute("ordersWaiting",list);
        page.setUrl("requests.jsp");
        page.setRedirecet(true);
        return page;
    }
}
