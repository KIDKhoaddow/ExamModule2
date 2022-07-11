package Config;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigReadAndWriteData {

    public static String PATH="C:\\Users\\Khoaddow\\Documents\\Project\\Exercise\\Exam\\src\\data\\";
    public void writeFileProduct(List<Product> productList) {
        try {
            File file = new File("FileProductList.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // AccountPartner accountTitle = new AccountPartner("C1","C2","C3","C4","C5");
            // accountPartnerList.add(0,accountTitle);
            for (Product product : productList) {
                bufferedWriter.write(product.getIdProduct() + "," + product.getNameProduct() + "," + product.getPriceProduct() + "," + product.getAmountProduct() + "," + product.getDescribeProduct()  +"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Lôi file");
        }
    }

    public List<Product> readFileProductList() {
       List<Product> products = new ArrayList<>();
        try {
            File file = new File("FileProductList.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Product product = new Product(strings[0], strings[1], Double.parseDouble(strings[2]), Integer.parseInt(strings[3]), strings[4]);
                products.add(product);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("loi file");
        }
        return products;
    }


}
