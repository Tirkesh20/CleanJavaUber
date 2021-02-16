package command;

import command.Implementatiion.Account.*;
import command.Implementatiion.Location.TaxiSubmit;
import command.Implementatiion.Location.LocationCreate;
import command.Implementatiion.Location.getLocationsList;
import command.Implementatiion.Order.OrderCreate;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class Factory implements Command {


    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        return new Page();
    }
    public Command getCommand(String type){
        switch (type){
            case "account_create": return new AccountCreate();
            case "account_update":return new AccountUpdate();
            case "logout":return new Logout();
            case "login":return new AccountRead();
            case"select":return new AccountSelect();
            case "create_order":return new OrderCreate();
            case "taxi_accept":return new TaxiSubmit();
            case "userList":return new getAccountList();
            case "locationList":return new getLocationsList();
            case "getResponse":return new getResponse();
            default: return new Home();
        }
    }
}
