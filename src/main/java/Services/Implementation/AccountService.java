package Services.Implementation;

import DAO.DAO;
import DAO.Implementation.AccountDAO;
import DAO.Implementation.LocationDao;
import Services.Services;
import entities.Account;
import entities.Location;
import exceptions.DaoException;
import exceptions.ServiceException;

import java.util.List;


public class AccountService extends Services<Account>{
    private final DAO<Account> dao= new AccountDAO();

public Account returnTaxi(Account entity) throws ServiceException {
    try {Account account=dao.selectById(entity.getId());
        return account;
    } catch (DaoException e) {
        throw new ServiceException();
    }
}

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
            List<Account> select = dao.select();
            return select;
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
    public  Location UpdateLocation(Account entity){
        LocationDao locationDao=new LocationDao();
        try {
            Location location= locationDao.randomize();
            location.setAccountId(entity.getId());
            locationDao.insert(location);
            return location;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
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
