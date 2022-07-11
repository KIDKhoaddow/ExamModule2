package service;

import model.Product;

import java.util.List;

public interface IProductService {
    int findProduct(String id);
    Product findProduct(int index);
    void saveList();
    Product save(Product product);
    boolean setNameProduct(int index , String nameProduct);
    boolean setPriceProduct(int index , double priceProduct);
    boolean setAmountProduct(int index, int amountProduct);
    boolean setDescribeProduct(int index , String describeProduct);

    Product getHighestPriceProduct();
    Product deleteProduct(int index );
    Void sortList();

    List<Product> getList();
}
