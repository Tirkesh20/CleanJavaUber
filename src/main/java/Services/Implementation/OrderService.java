package Services.Implementation;

import DAO.DAO;
import DAO.Implementation.LocationDao;
import DAO.Implementation.OrderDao;
import Services.Services;
import entities.Location;
import entities.Order;
import exceptions.DaoException;
import exceptions.ServiceException;

import java.util.List;

public class OrderService extends Services<Order> {
    private DAO<Order> dao=new OrderDao();
    private LocationDao dao2=new LocationDao();
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

    public Order createOrder(Order order , Location from,Location to) throws ServiceException {
        try {
            from = dao2.insert(from);
            to =  dao2.insert(to);
            order.setClient_id(from.getAccount_id());
            order.setFrom_id(from.getId());
            order.setTo_id(to.getId());
            dao.insert(order);
        }catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
        return order;
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
    public List<Order> readClient(long id) throws ServiceException {
        try {
            return dao.selectByClientId(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Order> readTaxi() throws ServiceException {
        return super.readTaxi();
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
