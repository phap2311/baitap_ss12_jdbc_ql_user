package com.example.ss12_baitap_user.services;

import com.example.ss12_baitap_user.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {


    public static final String SELECT_FROM_USERS = "select * from users";
    public static final String INSERT_INTO_USERS = "insert into users (name_user, email_user, country_user) values (?,?,?)";
    public static final String SELECT_FROM_USERS_WHERE_ID_USER = "select * from users where id_user = ?";
    public static final String UPDATE_USERS_SET = "update users set name_user = ?,email_user=? ,country_user = ? where id_user = ?";
    public static final String DELETE = "delete from users where id_user = ?";
    public static final String SELECT_FROM_USERS_WHERE_COUNTRY_USER = "select * from users where country_user = ?";

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id_user");
                String nameUser = resultSet.getString("name_user");
                String emailUser = resultSet.getString("email_user");
                String countryUser = resultSet.getString("country_user");
                User user = new User(id, nameUser, emailUser, countryUser);
                userList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void save(User user) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_USERS);
            statement.setString(1, user.getNameUser());
            statement.setString(2, user.getEmailUser());
            statement.setString(3, user.getCountryUser());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public User findById(Integer id) {
        Connection connection = DBConnection.getConnection();
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_USERS_WHERE_ID_USER);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id_u = resultSet.getInt("id_user");
                String nameUser = resultSet.getString("name_user");
                String emailUser = resultSet.getString("email_user");
                String countryUser = resultSet.getString("country_user");
                user = new User(id_u, nameUser, emailUser, countryUser);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return user;
    }

    @Override
    public void update(User user) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SET);
            statement.setString(1, user.getNameUser());
            statement.setString(2, user.getEmailUser());
            statement.setString(3, user.getCountryUser());
            statement.setInt(4, user.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(Integer id) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> searchByCountry(String countryUser) {
        Connection connection = DBConnection.getConnection();
        List<User>userList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_USERS_WHERE_COUNTRY_USER);
            statement.setString(1,countryUser);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id_user");
                String nameUser = resultSet.getString("name_user");
                String emailUser = resultSet.getString("email_user");
                String countryUse = resultSet.getString("country_user");
                User user = new User(id,nameUser,emailUser,countryUse);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    @Override
    public List<User> findAllArranged() {
        Connection connection = DBConnection.getConnection();
        List<User>userList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from users order by name_user asc");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id_user");
                String nameUser = resultSet.getString("name_user");
                String emailUser = resultSet.getString("email_user");
                String countryUser = resultSet.getString("country_user");
                User user = new User(id, nameUser, emailUser, countryUser);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return userList;
    }
}
