 package DAO.Implementation;

import DAO.DAO;
import entities.Location;
import entities.enums.FromTo;
import entities.enums.ReqStatus;
import exceptions.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class LocationDao extends DAO<Location> {
        @Override
        public void delete() throws DaoException {
            String sql = "DELETE from location ";
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void deleteById(long id) {
            String sql = "DELETE FROM location WHERE account_id=?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(5, id);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.getMessage();
            }
        }

        @Override
        public Location insert(Location entity) throws DaoException {
            String sql = "INSERT INTO location( lat, lng,req_status,place,account_id) VALUES (?,?,?,?,?);";
            try (PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                fetchSet(stmt, entity);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()){
                    entity.setId(rs.getInt(1));
                }
                return entity;
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e.getMessage());

            }
        }

        @Override
        public void update(Location entity) throws DaoException {
            String sql = "UPDATE location set lat=?,lng=?,req_status=?,place=? where account_id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                fetchSet(stmt, entity);
                stmt.setInt(4, entity.getId());
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
        public Location selectById(long id) throws DaoException {
            String state = "select * from location where account_id=?";
            try (PreparedStatement stmt = connection.prepareStatement(state)) {
                stmt.setLong(1, id);
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
            location.setFromTo(FromTo.valueOf(resultSet.getString("place")));
            location.setAccountId(resultSet.getLong("account_id"));
            return location;
        }

        private void fetchSet(PreparedStatement stmt, Location entity) throws SQLException {
            stmt.setDouble(1, entity.getLat());
            stmt.setDouble(2, entity.getLng());
            stmt.setString(3, entity.getReqStatus().toString());
            stmt.setString(4, entity.getFromTo().toString());
            stmt.setLong(5, entity.getAccount_id());
        }

        public Location randomize() throws  DaoException {
            String sql = " SELECT *FROM location ORDER BY random() LIMIT 1";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                ResultSet resultSet = stmt.executeQuery();
                return (resultSet.next()) ? fetchResultSet(resultSet) : null;
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }

    }

