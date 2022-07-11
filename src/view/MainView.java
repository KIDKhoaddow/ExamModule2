package view;

import controller.ProductController;
import jdk.jfr.internal.tool.Main;

import java.util.Scanner;

public class MainView {
    ProductController productController=new ProductController();
    CommonView commonView =new CommonView();
    Scanner scanner=new Scanner(System.in);

    public  void MainView(){
        productController.chooseFunction(scanner,commonView);
    }

     public static void main(String[] args) {
        new MainView();
    }
}
