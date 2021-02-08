package Services.Implementation;

import DAO.DAO;
import DAO.Implementation.AccountDAO;
import Services.Services;
import entities.Account;
import exceptions.DaoException;
import exceptions.ServiceException;

import java.util.List;


public class AccountService extends Services<Account>{
    private final DAO<Account> dao= new AccountDAO();

    @Override
    public void create(Account entity) throws ServiceException {
        try {
            dao.insert(entity);
        }catch (DaoException e){
      throw new ServiceException();
        }
    }

    @Override
    public void delete() throws ServiceException {
try {
    dao.delete();
}catch (DaoException e){
    throw new ServiceException();

}
    }

    @Override
    public List<Account> read() throws ServiceException {
        try {
            return dao.select();
        }catch  (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(Account entity) throws ServiceException {
        try {
            dao.update(entity);
        }catch (DaoException e){
            throw new ServiceException();
        }

    }

    @Override
    public Account checkService(String username,String password) throws ServiceException {
        try {
            return dao.check(username,password);

       } catch (DaoException e) {
            throw new ServiceException();
        }
    }
}
