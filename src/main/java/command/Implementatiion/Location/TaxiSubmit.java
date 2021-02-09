package command.Implementatiion.Location;

import command.Command;
import command.Page;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class TaxiSubmit implements Command {
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page=new Page();

//        page.setUrl();
//        page.setRedirecet();
        return null;
    }
}
