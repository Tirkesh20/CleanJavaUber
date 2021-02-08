package command;

import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;


public interface Command  {

    Page execute(HttpServletRequest request) throws ServiceException;

}
