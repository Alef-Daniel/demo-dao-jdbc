package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1 Seller findById===");

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("=== Test 1 Seller findByDepartment===");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.FindByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

    }
}
