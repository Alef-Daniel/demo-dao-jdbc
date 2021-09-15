package model.dao;

import model.entities.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {

    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer id);
    Department findById(Integer id) throws SQLException;
    List<Department> findAll() throws SQLException;

}
