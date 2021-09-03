package model.dao;

import java.util.List;

public interface SellerDao {

    void insert(SellerDao obj);
    void update(SellerDao obj);
    void deleteById(Integer id);
    SellerDao findById(Integer id);
    List<SellerDao> findAll();
}
