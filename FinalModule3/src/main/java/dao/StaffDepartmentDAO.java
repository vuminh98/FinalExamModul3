package dao;

import connection.MyConnection;
import model.Department;
import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDepartmentDAO {
    private final Connection connection;
    private final DepartmentDAO departmentDAO;
    private final String SELECT_ALL_STAFFS = "select * from staff;";
    private final String SELECT_ALL_STAFFS_BY_NAME = "select * from staff where name like ?;";

    private final String SELECT_STAFF_BY_ID = "select * from staff where id = ?;";
    private final String INSERT_STAFF = "insert into staff(name, email, address, phonenumber, salary, department_id) value (?,?,?,?,?,?);";

    private final String UPDATE_STAFF = "update staff set name = ?, email = ?, address = ?, phonenumber = ?, salary = ?, department_id = ? where id = ?;";
    private final String DELETE_STAFF = "delete from staff where id = ?";


    public StaffDepartmentDAO() {
        connection = MyConnection.getConnection();
        departmentDAO = new DepartmentDAO();
    }

    public List<Staff> findAll() {
        List<Staff> staffs = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_ALL_STAFFS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phonenumber = resultSet.getString("phonenumber");
                Double salary = resultSet.getDouble("salary");
                Long departmentId = resultSet.getLong("department_id");
                Department department = departmentDAO.findDepartmentById(departmentId);
                staffs.add(new Staff(id,name,email,address,phonenumber,salary,department));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffs;
    }

    public boolean updateStaff(Staff staff) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(UPDATE_STAFF)) {
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getEmail());
            preparedStatement.setString(3, staff.getAddress());
            preparedStatement.setString(4, staff.getPhoneNumber());
            preparedStatement.setDouble(5,staff.getSalary());
            preparedStatement.setLong(6,staff.getDepartment().getId());
            preparedStatement.setLong(7,staff.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean createStaff(Staff staff) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_STAFF)) {
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getEmail());
            preparedStatement.setString(3, staff.getAddress());
            preparedStatement.setString(4, staff.getPhoneNumber());
            preparedStatement.setDouble(5, staff.getSalary());
            preparedStatement.setLong(6, staff.getDepartment().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStaff(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_STAFF)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Staff findStaffById(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_STAFF_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phonenumber = resultSet.getString("phonenumber");
                Double salary = resultSet.getDouble("salary");
                Long departmentId = resultSet.getLong("department_id");
                Department department = departmentDAO.findDepartmentById(departmentId);
                return new Staff(id, name, email, address,phonenumber,salary,department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Staff> findAllByName(String search) {
        List<Staff> staffs = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_ALL_STAFFS_BY_NAME)) {
            preparedStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phonenumber = resultSet.getString("phonenumber");
                Double salary = resultSet.getDouble("salary");
                Long departmentId = resultSet.getLong("department_id");
                Department department = departmentDAO.findDepartmentById(departmentId);
                staffs.add(new Staff(id,name,email,address,phonenumber,salary,department));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffs;
    }


}
