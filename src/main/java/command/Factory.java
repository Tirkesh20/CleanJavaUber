package command;

import command.Implementatiion.Account.*;
import command.Implementatiion.Order.*;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class Factory implements Command {

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        return new Page();
    }
    public Command getCommand(String type){
        switch (type){
            case"orders":return new AdminOrderRead();
            case "client_accept":return new ClientsWaiting();
            case "taxi_confirm" : return new TaxiConfirm();
            case "clientOrder":return new ClientOrders();
            case "taxi_accept" : return new TaxiAcceptOrder();
            case"ordersWaiting": return new OrderRead();
            case "account_create": return new AccountCreate();
            case "account_update":return new AccountUpdate();
            case "logout":return new Logout();
            case "login":return new AccountRead();
            case"select":return new AccountSelect();
            case "create_order":return new OrderCreate();
            case "userList":return new getAccountList();
            case "getResponse":return new getResponse();
            default: return new Home();
        }
    }
}
