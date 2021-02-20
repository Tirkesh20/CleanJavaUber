package DAO.Implementation;
import DAO.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entities.Order;
import entities.enums.OrderStatus;
import exceptions.DaoException;
public class OrderDao extends DAO<Order> {
        @Override
        public void delete() throws DaoException {
            String sql = "DELETE from \"order\"";
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }

        @Override
        public void deleteById(long id) throws DaoException {

            String sql = "DELETE FROM \"order\" WHERE id=?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1, id);
                stmt.executeUpdate();

            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }

        }

        @Override
        public Order insert(Order entity) throws DaoException {
            String sql = "INSERT INTO \"order\"( client_id, from_id, to_id,status,order_date) VALUES (?,?,?,?,?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                fetchSet(stmt,entity);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()){
                    entity.setId(rs.getInt(1));
                }
                return entity;
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());

            }
        }

    @Override
        public void update(Order entity) throws DaoException {
            String sql = "UPDATE \"order\" set client_id=?,taxi_id=?,from_id=?,to_id=?,status=?,order_date=? where id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                fetchSetForTaxi(stmt,entity);
                stmt.setLong(7,entity.getId());
                stmt.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

    @Override
        public List<Order> select() throws DaoException {
            String query = "select * from \"order\"";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                ResultSet resultSet = stmt.executeQuery();
                List<Order> orders = new ArrayList<>();
                while (resultSet.next()) {
                    orders.add(fetchResultSet(resultSet));
                }
                return orders;
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }
//    @Override
//    public List<Order> selectClient(long id) throws DaoException {
//        String query = "select * from \"order\" where client_id=?";
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setString(1, String.valueOf(OrderStatus.WAITING));
//            ResultSet resultSet = stmt.executeQuery();
//            List<Order> orders = new ArrayList<>();
//            while (resultSet.next()) {
//                orders.add(fetchResultSet(resultSet));
//            }
//            return orders;
//        } catch (SQLException e) {
//            throw new DaoException(e.getMessage());
//        }
//    }

        @Override
        public Order selectById(long id) throws DaoException
        {
            String sql = "select * from \"order\" where id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1, id);
                ResultSet resultSet = stmt.executeQuery();
                return (resultSet.next()) ? fetchResultSet(resultSet) : null;
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }
    public List<Order> selectByClientId(long id) throws DaoException
    {
        String sql = "select * from \"order\" where client_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(fetchResultSet(resultSet));
            }
            return  orders;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }
    public Order selectByTaxiId(long id) throws DaoException
    {
        String sql = "select * from \"order\" where taxi_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            return (resultSet.next()) ? fetchResultSet(resultSet) : null;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }
        private Order fetchResultSet(ResultSet resultSet) throws SQLException {
            Order order = new Order();
            order.setId(resultSet.getLong("id"));
            order.setClient_id(resultSet.getLong("Client_id"));
            order.setTaxi_id(resultSet.getLong("taxi_id"));
            order.setFrom_id(resultSet.getLong("from_id"));
            order.setTo_id(resultSet.getLong("to_id"));
            order.setStatus(OrderStatus.valueOf(resultSet.getString("status")));
            order.setOrder_date(resultSet.getTimestamp("order_date"));
            return order;
        }
        private void fetchSet(PreparedStatement stmt, Order entity) throws SQLException {
            stmt.setLong(1, entity.getClient_id());
            stmt.setLong(2, entity.getFrom_id());
            stmt.setLong(3, entity.getTo_id());
            stmt.setString(4, entity.getStatus().toString());
            stmt.setTimestamp(5, entity.getOrder_date());

        }
    private void fetchSetForTaxi(PreparedStatement stmt, Order entity) throws SQLException {
        stmt.setLong(1, entity.getClient_id());
        stmt.setLong(2,entity.getTaxi_id());
        stmt.setLong(3, entity.getFrom_id());
        stmt.setLong(4, entity.getTo_id());
        stmt.setString(5, entity.getStatus().toString());
        stmt.setTimestamp(6, entity.getOrder_date());

    }
}


