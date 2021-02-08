package command.Implementatiion.Account;

import Services.Implementation.LocationService;
import command.Command;
import command.Page;
import entities.Location;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class Meet implements Command {
    private final LocationService service=new LocationService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
      Page page=new Page();
        Location location=new Location();

        return page;
    }
}
