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
            String sql = "DELETE from Order";
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(sql);

            } catch (SQLException e) {

            }
        }

        @Override
        public void deleteById(int id) throws DaoException {

            String sql = "DELETE FROM order WHERE id=?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.getMessage();
            }

        }

        @Override
        public void insert(Order entity) throws DaoException {

            String sql = "INSERT INTO Order( client_id, taxi_id, from_id, to_id,status,order_date) VALUES (?,?,?,?,?,?);";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                fetchSet(stmt,entity);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());

            }

        }


    @Override
        public void update(Order entity) throws DaoException {
            String sql = "UPDATE order set client_id=?,taxi_id=?,from_id=?,to_id=?,status=?,order_date=? where id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                fetchSet(stmt,entity);
                stmt.setInt(6, (int) entity.getId());
                stmt.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

    @Override
        public List<Order> select() throws DaoException {

            String query = "select * from order";

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

        @Override
        public Order selectById(int id) throws DaoException {

            String sql = "select * from order where id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet resultSet = stmt.executeQuery();
                return (resultSet.next()) ? fetchResultSet(resultSet) : null;
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }


        private Order fetchResultSet(ResultSet resultSet) throws SQLException {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setClient_id(resultSet.getInt("Client_id"));
            order.setTaxi_id(resultSet.getInt("taxi_id"));
            order.setFrom_id(resultSet.getInt("from_id"));
            order.setTo_id(resultSet.getInt("to_id"));
            order.setStatus(OrderStatus.valueOf(resultSet.getString("status")));
            order.setOrder_date(Timestamp.valueOf(resultSet.getString("pay_date")));

            return order;
        }
        private void fetchSet(PreparedStatement stmt, Order entity) throws SQLException {
            stmt.setInt(1, entity.getId());
            stmt.setInt(2, entity.getClient_id());
            stmt.setInt(3, entity.getTaxi_id());
            stmt.setInt(4, entity.getFrom_id());
            stmt.setInt(5, entity.getTo_id());
            stmt.setTimestamp(6, Timestamp.valueOf("order_date"));
        }
    }


