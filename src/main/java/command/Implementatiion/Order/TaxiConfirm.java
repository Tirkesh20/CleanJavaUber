
package command.Implementatiion.Order;

        import Services.Implementation.OrderService;
        import command.Command;
        import command.Page;
        import entities.Account;
        import entities.Order;
        import entities.enums.OrderStatus;
        import exceptions.ServiceException;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpSession;
        import java.util.List;
        import java.util.Optional;
public class TaxiConfirm implements Command {
    private final OrderService orderService = new OrderService();
    private final Page page = new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        List<Order> list = orderService.read();
        HttpSession session = request.getSession();
        long id = Long.parseLong(request.getParameter("taxiConfirmId"));
        Optional<Order> order = list.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
        order.ifPresent(o -> {
            try {
                o.setStatus(OrderStatus.DONE);
                orderService.update(o);
            } catch (ServiceException e) {
                System.out.println("service error in class TAXi confirm");
            }
        });
        page.setUrl("main.jsp");
        page.setRedirect(false);
        return page;
    }

}

