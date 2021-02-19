package command;

import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class Home implements Command{
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
Page page=new Page();
homeCommand();
        return page;
    }
    public void homeCommand(){
        System.out.println("Default");
    }
}
