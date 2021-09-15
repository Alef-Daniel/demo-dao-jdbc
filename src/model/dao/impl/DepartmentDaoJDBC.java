package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO department " +
                    "(Id, Name) " +
                    "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, obj.getId());
            st.setString(2, obj.getName());

            int rowsAffected = st.executeUpdate();
            if(rowsAffected>0){
                    ResultSet rs = st.getGeneratedKeys();
                    if(rs.next()){
                        int id = rs.getInt(1);
                        obj.setId(id);
                    }
                DB.closeResultSet(rs);
            }else{
                throw new DbException("Erro inesperado nenhuma linha foi alterada!");
            }

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE department " +
                    "Name=? " +
                    "Where id=? ");
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

             st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("DELETE FROM department " +
                    "WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT Id, Name " +
                    "FROM department " +
                    "Where id= ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                Department department = new Department();
                department.setId(rs.getInt("Id"));
                department.setName(rs.getString("Name"));
                return department;
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * " +
                    "FROM department ");

            rs = st.executeQuery();
            List<Department> list = new ArrayList<>();
            while (rs.next()){
                Department department = new Department();
                department.setId(rs.getInt(1));
                department.setName(rs.getString(2));
                list.add(department);
            }
            return list;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
