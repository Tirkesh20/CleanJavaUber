package Services;

import entities.Account;
import exceptions.ServiceException;

import java.util.List;

public abstract class Services <T> {
    public abstract void create(T entity)throws ServiceException;
    public abstract void delete()throws ServiceException;
    public abstract List<T> read() throws ServiceException;
    public abstract void update(T entity) throws ServiceException;
    public T checkService(String username,String password)throws  ServiceException{
     return null;
    }
    public  Account returnTaxi(){return null;}
}