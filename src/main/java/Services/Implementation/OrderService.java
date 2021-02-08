package Services.Implementation;

import DAO.DAO;
import DAO.Implementation.OrderDao;
import Services.Services;
import entities.Order;
import exceptions.DaoException;
import exceptions.ServiceException;

import java.util.List;

public class OrderService extends Services<Order> {
    private DAO<Order> dao=new OrderDao();
    @Override
    public void create(Order entity) throws ServiceException {
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
    public List<Order> read() throws ServiceException {
        try {
            return dao.select();

        }catch  (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(Order entity) throws ServiceException {
        try {
            dao.update( entity);
        }catch (DaoException e){
            throw new ServiceException();
        }
    }

}
