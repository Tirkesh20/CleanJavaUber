package command.Implementatiion.Order;

import Services.Implementation.OrderService;
import command.Command;
import command.Page;
import entities.Account;
import entities.Order;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ClientOrders implements Command {
    private final Page page=new Page();
    private final OrderService service=new OrderService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session=request.getSession();
        Account account=(Account) session.getAttribute("account");
        List<Order> myOrders=service.readClient(account.getId());
      session.setAttribute("myOrders",myOrders);
        page.setUrl("clientOrders.jsp");
        page.setRedirect(true);
        return page;
    }
}
