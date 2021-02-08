package Services.Implementation;

import DAO.DAO;
import DAO.Implementation.LocationDao;
import Services.Services;
import entities.Location;
import exceptions.DaoException;
import exceptions.ServiceException;

import java.util.List;

public class LocationService extends Services<Location> {

    private  final DAO<Location> dao = new LocationDao();

    @Override
    public void create(Location entity) throws ServiceException {
        try {
            dao.insert(entity);
        } catch (DaoException e) {
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
    public List<Location> read() throws ServiceException {
        try {
            return dao.select();
        }catch  (DaoException e) {
            throw new ServiceException();
        }

    }

    @Override
    public void update(Location entity) throws ServiceException {
        try {
            dao.update(entity);
        }catch (DaoException e){
            throw new ServiceException();
        }
    }

}
