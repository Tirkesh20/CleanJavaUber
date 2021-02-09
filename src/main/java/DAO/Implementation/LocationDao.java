 package DAO.Implementation;

import DAO.DAO;
import entities.Location;
import entities.enums.ReqStatus;
import exceptions.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class LocationDao extends DAO<Location> {
        @Override
        public void delete() throws DaoException  {
            String sql = "DELETE from location ";
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(sql);

            } catch (SQLException e) {
              e.printStackTrace();
            }
        }

        @Override
        public void deleteById(int id)  {
            String sql = "DELETE FROM location WHERE id=?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.getMessage();
            }
        }

        @Override
        public void insert(Location entity) throws DaoException {
            String sql = "INSERT INTO location( lat, lng,req_status) VALUES (?,?,?);";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                fetchSet(stmt,entity);
                stmt.executeUpdate();
            } catch (SQLException|NullPointerException e) {
                throw new DaoException(e.getMessage());

            }
        }

        @Override
        public void update(Location entity) throws DaoException {
            String sql = "UPDATE location set lat=?,lng=?,req_status-? where id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                fetchSet(stmt,entity);
                stmt.setInt(4,  entity.getId());
                stmt.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        @Override
        public List<Location> select() throws DaoException {
            String query = "select * from location";

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                ResultSet resultSet = stmt.executeQuery();
                List<Location> location = new ArrayList<>();
                while (resultSet.next()) {
                    location.add(fetchResultSet(resultSet));
                }
                return location;
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }

        @Override
        public Location selectById(int id) throws DaoException {
            String sql = "select * from location where id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet resultSet = stmt.executeQuery();
                return (resultSet.next()) ? fetchResultSet(resultSet) : null;
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }
        private Location fetchResultSet(ResultSet resultSet) throws SQLException {
            Location location = new Location();
            location.setId(resultSet.getInt("id"));
            location.setLat(resultSet.getDouble("lat"));
            location.setLng((resultSet.getDouble("lng")));
            location.setReqStatus(ReqStatus.valueOf(resultSet.getString("req_status")));
            return location;
        }

        private void fetchSet(PreparedStatement stmt, Location entity) throws SQLException {
            stmt.setDouble(1,entity.getLat());
            stmt.setDouble(2, entity.getLng());
            stmt.setString(3,entity.getReqStatus().toString());
        }
    }

