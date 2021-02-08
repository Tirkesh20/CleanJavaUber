package Services.Implementation;

import DAO.DAO;
import DAO.Implementation.TransactionsDao;
import Services.Services;
import entities.Order;
import entities.Transactions;
import exceptions.DaoException;
import exceptions.ServiceException;

import java.util.List;

public class TransactionService extends Services<Transactions> {
    private DAO<Transactions> dao=new TransactionsDao();
    @Override
    public void create(Transactions entity) throws ServiceException {
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
    public List<Transactions> read() throws ServiceException {
        try {
             return dao.select();
        }catch  (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(Transactions entity) throws ServiceException {
        try {
            dao.update( entity);
        }catch (DaoException e){
            throw new ServiceException();
        }
    }

}
