package command.Implementatiion.Location;

import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Location;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocationUpdate implements Command {
    private final LocationService locationService=new LocationService();
    private final Page page=new Page();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        HttpSession session= request.getSession();
        Location location=(Location) session.getAttribute("lo");
        locationService.update(location);
        page.setRedirecet(true);
        page.setUrl("");

        return new Page();
    }
}
