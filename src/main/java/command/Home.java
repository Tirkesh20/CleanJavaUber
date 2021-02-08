package command;

import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class Home implements Command{
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        return null;
    }
    public void homeCommand(){
        System.out.println("Default");
    }
}
