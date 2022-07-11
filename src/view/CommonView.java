package view;

import model.Product;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommonView {

    public int inputInt(String string, Scanner scanner) {
        System.out.print(string);
        return scanner.nextInt();
    }

    public int inputInt(Scanner scanner) {
        return scanner.nextInt();
    }

    public String inputString(String string, Scanner scanner) {
        System.out.print(string);
        return scanner.next();
    }

    public String inputString(Scanner scanner) {
        return scanner.next();
    }

    public double inputDouble(String string, Scanner scanner) {
        System.out.println(string);
        return scanner.nextDouble();
    }

    public void showMessage(String string) {
        System.out.println(string);
    }
    public void displayObject(Object user) {
        try {
            System.out.println(user);
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
    }
    public boolean checkPassword(String string) {
        return Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-_]).{8,}$", string);
    }

    public boolean checkEmail(String string) {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", string);
    }

    public boolean checkInputNumber(int min, int max, String number) {
        String maxNumber = String.valueOf(max);
        String minNumber = String.valueOf(min);

        return Pattern.matches("[" + minNumber + "-" + maxNumber + "]", number);
    }

    public boolean checkPhoneNumber(String number) {
        return Pattern.matches("[0-9]{10}", number);
    }

    public boolean checkInputNumber(String number) {

        return Pattern.matches("[0-9]{1,2}", number);
    }
    public void displayList(List<Product> productList){
        for (Product element:productList) {
            displayObject(element);
        }
    }
}
