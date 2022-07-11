package model;

import java.util.Comparator;

public class Product implements Comparator<Product> {
    private  String idProduct;
    private  String nameProduct;
    private  double priceProduct;
    private  int amountProduct;
    private  String describeProduct;

    public Product(String idProduct,String nameProduct, double priceProduct, int amountProduct, String describeProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.amountProduct = amountProduct;
        this.describeProduct = describeProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    @Override
    public int compare(Product o1, Product o2) {
        return (int)(o1.getPriceProduct()- o2.getPriceProduct());
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                ", amountProduct=" + amountProduct +
                ", describeProduct='" + describeProduct + '\'' +
                '}';
    }
}
