package command;

import entities.Location;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UncheckedIOException;
import java.util.List;

public class getResponse implements Command {
    private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session=request.getSession();
        try {
            List<Location> taxiLocation = (List<Location>) session.getAttribute("taxiLocation");
            for (Location a : taxiLocation) {
            }
        }catch (UncheckedIOException exception){
            exception.addSuppressed(exception);
        }
        page.setRedirecet(true);
        page.setUrl("taxiAvailable.jsp");
        return page;
    }
}
