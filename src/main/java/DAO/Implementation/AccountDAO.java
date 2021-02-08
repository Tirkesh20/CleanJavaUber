package DAO.Implementation;

import DAO.DAO;
import entities.Account;
import entities.enums.UserType;
import exceptions.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends DAO<Account> {
    @Override
    public void delete() throws DaoException {
        String sql = "DELETE from Account";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);

        } catch (SQLException e) {

        }
    }

    @Override
    public void deleteById(int id) throws DaoException {

        String sql = "DELETE FROM account WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }

    }

    @Override
    public void insert(Account entity) throws DaoException {

        String sql = "INSERT INTO account( first_name, last_name, username, email,password,user_type) VALUES (?,?,?,?,?,?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            fetchSet(stmt, entity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());

        }

    }


    @Override
    public void update(Account entity) throws DaoException {
        String sql = "UPDATE account set first_name=?,last_name=?,username=?,email=?,password=?,user_type=? where id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            fetchSet(stmt,entity);
            stmt.setInt(7, (int) entity.getId());
            stmt.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public Account check(String username, String password) throws DaoException {
       boolean state=false;

        String query = "select * from account where username=? and password=?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2,password);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return fetchResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return null;
    }


    @Override
    public List<Account> select() throws DaoException {

        String query = "select * from account";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (resultSet.next()) {
                accounts.add(fetchResultSet(resultSet));
            }
            return accounts;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public Account selectById(int id) throws DaoException {

        String query = "select * from account where id=?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            return (resultSet.next()) ? fetchResultSet(resultSet) : null;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }


    private Account fetchResultSet(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setFirstName(resultSet.getString("first_name"));
        account.setLastName(resultSet.getString("last_name"));
        account.setUserName(resultSet.getString("username"));
        account.setPassword(resultSet.getString("password"));
        account.setEmail(resultSet.getString("email"));
        account.setUserType(UserType.valueOf(resultSet.getString("user_type")));
        return account;
    }
    private void fetchSet(PreparedStatement stmt, Account entity) throws SQLException {
        stmt.setString(1, entity.getFirstName());
        stmt.setString(2, entity.getLastName());
        stmt.setString(3, entity.getUsername());
        stmt.setString(4, entity.getEmail());
        stmt.setString(5, entity.getPassword());
        stmt.setString(6,entity.getUserType().toString());

    }
}

