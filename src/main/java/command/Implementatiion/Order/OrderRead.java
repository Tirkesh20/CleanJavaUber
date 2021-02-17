package command.Implementatiion.Order;

import Services.Implementation.OrderService;
import command.Command;
import command.Page;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class OrderRead implements Command {
    private  final OrderService orderService=new OrderService();
    private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        orderService.read();
        page.setRedirecet(true);

        return new Page();
    }
}
