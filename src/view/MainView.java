package view;

import controller.ProductController;

import java.util.Scanner;

public class MainView {
    ProductController productController=new ProductController();
    CommonView commonView =new CommonView();
    Scanner scanner=new Scanner(System.in);

    public MainView(){
        productController.chooseFunction(scanner,commonView);
    }

     public static void main(String[] args) {
        new MainView();
    }
}
