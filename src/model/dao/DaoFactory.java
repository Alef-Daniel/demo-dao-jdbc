package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDaoJDBC createSellerDao(){

        return new SellerDaoJDBC(DB.getConnection());

    }
}
