package controller;

import model.Product;
import service.ProductServiceImpl;
import view.CommonView;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    ProductServiceImpl productService=new ProductServiceImpl();
    public void chooseFunction(Scanner scanner,CommonView commonView){
        commonView.showMessage("-------- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ---------");
        commonView.showMessage("1. Xem danh sách");
        commonView.showMessage("2. Thêm mới ");
        commonView.showMessage("3. Cật nhật ");
        commonView.showMessage("4. Xóa");
        commonView.showMessage("5. Sắp xếp");
        commonView.showMessage("6. Tìm sản phẩm có giá đắt nhất");
        commonView.showMessage("7. Đọc từ file");
        commonView.showMessage("8. Ghi vào file");
        commonView.showMessage("9. Thoát");
        String selection= commonView.inputString("Chọn chức năng",scanner);
        while(true){
            if(!commonView.checkInputNumber(1,2,selection)){
                commonView.showMessage("Wrong number , try again please");
            }else {
             break;
            }
        }
        switch (Integer.parseInt(selection)){
            case 1:commonView.displayList(productService.getList());break;
            case 2:addNewProduct(commonView,scanner);break;
            case 3:editProduct(commonView,scanner);break;
            case 4:commonView.displayObject(removeProdcut(commonView, scanner));break;
            case 5:commonView.displayList(sortList());break;
            case 6:commonView.displayObject(productService.getHighestPriceProduct());break;
            case 7:commonView.displayList(productService.getList());break;
            case 8:productService.saveList();break;
            case 9 :return;
        }
        chooseFunction(scanner,commonView);
    }
    public List<Product> sortList(){
        productService.sortList();
        return productService.getList();
    }
    public Product removeProdcut(CommonView commonView,Scanner scanner){
       int index= findProduct(commonView,scanner);
       return  productService.deleteProduct(index);
    }

    public Product addNewProduct(CommonView commonView, Scanner scanner){
        String id= commonView.inputString("Xin mời nhập mã hang :",scanner);
        String name= commonView.inputString("Xin mời nhập tên hàng : ",scanner);
        double price=commonView.inputDouble("Xin mời nhập giá hàng : ",scanner);
        int amount=commonView.inputInt("Xin mời nhập sô lượng hàng : ",scanner);
        String describe=commonView.inputString("Xin mời nhập số mô tả :",scanner);
        Product product =new Product(id,name,price,amount,describe);
        productService.save(product);
        commonView.showMessage("Thêm mới thành công !");
        return product;
    }

    public  void editProduct(CommonView commonView , Scanner scanner){
       int index= findProduct(commonView,scanner);
       chooseFunctionEdit(commonView,scanner,index);

    }

    public int findProduct(CommonView commonView, Scanner scanner) {
        List<Product> listProduct = productService.getList();
        commonView.displayList(listProduct);
        String productId = commonView.inputString("Xin mời nhập mặt hàng muống sửa :", scanner);
        int index = productService.findProduct(productId);


        while (true) {
            if (index == -1) {
                productId = commonView.inputString("Không tồn tại mã hàng này , xin mời nhập lại  :", scanner);
                index = productService.findProduct(productId);
            } else {
                break;
            }
        }
        return index;
    }
    public void chooseFunctionEdit(CommonView commonView , Scanner scanner,int index){
        commonView.showMessage("1.Cập nhật Tên");
        commonView.showMessage("2.Cập nhật Giá");
        commonView.showMessage("3.Cập nhật Số Lượng");
        commonView.showMessage("4.Cập nhật Mô tả");
        commonView.showMessage("5.Quay lại ");
        String selection= commonView.inputString(scanner);
        while(true){
            if(!commonView.checkInputNumber(1,5,selection)){
                selection=commonView.inputString("Sai số rồi , nhập lại đi :",scanner);
            }else {
                break;
            }
        }
        switch ( Integer.parseInt( selection)){
            case 1:commonView.displayObject(editName(commonView, scanner, index));
            case 2:commonView.displayObject(editPrice(commonView, scanner, index));
            case 3:commonView.displayObject(editAmount(commonView, scanner, index));
            case 4:commonView.displayObject(editDescribe(commonView, scanner, index));
            case 5: return;
        }
        chooseFunctionEdit(commonView,scanner,index);
    }
    Product editName(CommonView commonView ,Scanner scanner,int index){
        String name=commonView.inputString("xin mời nhập vào tên muốn đổi",scanner);
        productService.getList().get(index).setNameProduct(name);
        return productService.getList().get(index);
    }
    Product editPrice(CommonView commonView ,Scanner scanner,int index){
        double price=commonView.inputDouble("xin mời nhập vào giá muốn đổi",scanner);
        productService.getList().get(index).setPriceProduct(price);
        return productService.getList().get(index);
    }
    Product editAmount(CommonView commonView ,Scanner scanner,int index){
        int amount=commonView.inputInt("xin mời nhập vào số lượng muốn đổi",scanner);
        productService.getList().get(index).setAmountProduct(amount);
        return productService.getList().get(index);
    }
    Product editDescribe(CommonView commonView ,Scanner scanner,int index){
        String describe=commonView.inputString("xin mời nhập vào mô tả muốn đổi",scanner);
        productService.getList().get(index).setNameProduct(describe);
        return productService.getList().get(index);
    }
}
