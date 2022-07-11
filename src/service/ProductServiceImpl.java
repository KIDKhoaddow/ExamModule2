package service;

import Config.ConfigReadAndWriteData;
import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    static String PRODUCT_PATH = ConfigReadAndWriteData.PATH + "product.csv";
    static private List<Product> productList = new ConfigReadAndWriteData().readFileProductList();

    @Override
    public List<Product> getList() {
        if(productList==null){
            return  null;
        }
        return productList;
    }

    @Override
    public int findProduct(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getIdProduct().equals(id)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public Product findProduct(int index) {
        if (productList == null) {
            return null;
        }
        return productList.get(index);
    }

    @Override
    public void saveList() {
        new ConfigReadAndWriteData().writeFileProduct(productList);
    }

    @Override
    public Product save(Product product) {
        productList.add(product);
        saveList();
        return product;
    }


    @Override
    public boolean setNameProduct(int index, String nameProduct) {
        if (productList.get(index).getNameProduct() == null) {
            return false;
        }
        productList.get(index).setNameProduct(nameProduct);
        saveList();
        return true;
    }

    @Override
    public boolean setAmountProduct(int index, int amountProduct) {
        if (amountProduct < 0) {
            return false;
        }
        productList.get(index).setAmountProduct(amountProduct);
        saveList();
        return true;

    }


    @Override
    public boolean setPriceProduct(int index, double priceProduct) {
        if (priceProduct < 0) {
            return false;
        }
        productList.get(index).setPriceProduct(priceProduct);
        saveList();
        return true;
    }

    @Override
    public boolean setDescribeProduct(int index, String describeProduct) {
        if (productList.get(index).getDescribeProduct() == null) {
            return false;
        }
        productList.get(index).setDescribeProduct(describeProduct);
        saveList();
        return true;
    }

    @Override
    public Product getHighestPriceProduct() {
        double price = productList.get(0).getPriceProduct();
        int index = 0;
        for (int i = 1; i < productList.size(); i++) {
            if (price < productList.get(i).getPriceProduct()) {
                price = productList.get(i).getPriceProduct();
                index = i;
            }
        }
        return productList.get(index);
    }

    @Override
    public Product deleteProduct(int index) {
        if (index < productList.size() - 1 || (index > productList.size() - 1)) {
            return null;
        }
        productList.remove(index);
        saveList();
        return null;
    }

    @Override
    public Void sortList() {
//         Collections.sort(productList);
         return null;
    }
}
