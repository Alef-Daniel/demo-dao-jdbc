package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1 Seller findById===");

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("=== Test 2 Seller findByDepartment===");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.FindByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("=== Test 3 Seller findAll===");

       list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("=== Test 4 Seller Insert===");
            Seller newSeller = new Seller(null, "greg", "greg@gmail.com", new Date(), 4000.00, department);
             sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = "+ newSeller .getId());

        System.out.println("=== Test 4 Seller Update===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update Completed");

        System.out.println("=== Test 6 Seller Delete===");
        System.out.println("Enter id for delete test");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete Completed!");
        sc.close();10

        }


    }

