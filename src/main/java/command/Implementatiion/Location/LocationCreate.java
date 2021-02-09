package command.Implementatiion.Location;

import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Location;
import entities.enums.ReqStatus;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocationCreate implements Command {
    private final LocationService locationService=new LocationService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Location location=new Location();
        HttpSession session= request.getSession();

        request.getSession();
        Page page=new Page();
        Double streetFrom=Double.parseDouble(request.getParameter("street_from"));
        Double streetTo=Double.parseDouble(request.getParameter("street_to"));
        location.setStreetFrom(streetFrom);
        location.setStreetTo(streetTo);


        location.setReqStatus(ReqStatus.WAITING);
        locationService.create(location);
        session.setAttribute("locations",location);
        page.setUrl("taxiAvailable.jsp");
        page.setRedirecet(true);
        return page;
    }
}
