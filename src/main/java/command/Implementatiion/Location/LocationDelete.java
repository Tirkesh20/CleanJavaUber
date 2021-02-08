package command.Implementatiion.Location;

import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class LocationDelete implements Command {
    private LocationService locationService=new LocationService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        return new Page();
    }
}
