package DAO.Implementation;

import DAO.DAO;
import entities.Transactions;
import entities.enums.TransactionStatus;
import exceptions.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDao extends DAO<Transactions>{
        @Override
        public void delete() throws DaoException {
            String sql = "DELETE from transaction";
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(sql);

            } catch (SQLException e) {

            }
        }


        @Override
        public void deleteById(long id) throws DaoException, SQLException {
            String sql = "DELETE FROM transaction WHERE id=?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1, id);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.getMessage();
            }
        }

        @Override
        public Transactions insert(Transactions entity) throws DaoException {
            String sql = "INSERT INTO transaction( order_id, status) VALUES (?,?);";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                fetchSet(stmt,entity);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());

            }
return null;

        }


        @Override
        public void update(Transactions entity) throws DaoException {
            String sql = "UPDATE transaction set order_id=?,status=? where id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                fetchSet(stmt,entity);
                stmt.setInt(1, (int) entity.getId());
                stmt.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }


    @Override
        public List<Transactions> select() throws DaoException {
            String query = "select * from transaction";

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                ResultSet resultSet = stmt.executeQuery();
                List<Transactions> transactions = new ArrayList<>();
                while (resultSet.next()) {
                    transactions.add(fetchResultSet(resultSet));
                }
                return transactions;
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }

        @Override
        public Transactions selectById(long id) throws DaoException {
            String sql = "select * from transaction where id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1, id);
                ResultSet resultSet = stmt.executeQuery();
                return (resultSet.next()) ? fetchResultSet(resultSet) : null;
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }
        private Transactions fetchResultSet(ResultSet resultSet) throws SQLException {
            Transactions transactions = new Transactions();
            transactions.setId(resultSet.getInt("id"));
            transactions.setOrder_id(resultSet.getInt("order_id"));
            transactions.setType(TransactionStatus.valueOf(resultSet.getString("status")));
            transactions.setPay_date(Timestamp.valueOf(resultSet.getString("pay_date")));


            return transactions;
        }
        private void fetchSet(PreparedStatement stmt, Transactions entity) throws SQLException {
            stmt.setInt(1, entity.getOrder_id());
            stmt.setString(2, String.valueOf(TransactionStatus.IN_PROGRESS));;
            //  stmt.setTimestamp(3, Timestamp.valueOf("pay_date"));


        }
    }
