package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
//    private final Connection connection = Util.getConnection();

    public UserDaoJdbcImpl() {
    }

    public void createUsersTable()  {
//            String sql = "create table IF NOT EXISTS users (id serial primary key, name varchar(50) not null, last_name varchar(50) not null, age int not null);";
//            try (Statement statement = connection.createStatement()) {
//                statement.execute(sql);
//
//                System.out.println("Таблица базы данных успешно создана");
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
        }


    public void dropUsersTable() {
//        String sql = "drop table users;";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//            System.out.println("Таблица базы данных удалена");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        String sql = "insert into users (name, last_name, age) values (?,?,?);";
//        try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
//            prepareStatement.setString(1, name);
//            prepareStatement.setString(2, lastName);
//            prepareStatement.setInt(3, age);
//            prepareStatement.executeUpdate();
//            System.out.println("Новый пользователь по имени " + name + " успешно добавлена в таблицу");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public void removeUserById(long id) {
//        String sql = "delete from users where id = ?;";
//        try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
//            prepareStatement.setLong(1, id);
//            prepareStatement.executeUpdate();
//            System.out.println("Пользователь с №: " + id + " удален из таблицы базы данных");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
//        String sql = "select * from users;";
//        try (Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong(1));
//                user.setName(resultSet.getString(2));
//                user.setLastName(resultSet.getString(3));
//                user.setAge(resultSet.getByte(4));
//                list.add(user);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
      return list;
    }

    public void cleanUsersTable() {
//        String sql = "truncate users;";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//            System.out.println("Таблица очищена");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
