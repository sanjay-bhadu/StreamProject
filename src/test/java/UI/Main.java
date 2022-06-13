package UI;

import Model.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> productList=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        boolean loop=true;
        System.out.println("please add some products");
        while(loop)
        {
            System.out.println("Please enter Product Id");
            int id=scan.nextInt();
            System.out.println("Please Enter Product Name");
            String temp=scan.nextLine();//this is temporary scan.. used as we cannot directly use nextline() after nextInt();
            String Name=scan.nextLine();
            System.out.println("Enter the Category : Ex- Book,VideoGame,Electric Appliances etc...");
            String Category=scan.nextLine();
            System.out.println("Enter the Price");
            Double Price= scan.nextDouble();
            Product product=new Product(id,Name,Category,Price);
            System.out.println(product);
            productList.add(product);
            System.out.println("Do you want to add another product--- Y(yes) and N(No)");
            temp=scan.nextLine();
            String response=scan.nextLine();
            if(response.equalsIgnoreCase("n")) {
                loop = false;
                System.out.println(response);
                break;
            }
        }
        //finding all product of particular category and particular price range.
        List<Product> list=productList.stream()
                .filter(s->s.getCategory().equalsIgnoreCase("Book"))
                .filter(s->s.getPrice()>100)
                .collect(Collectors.toList());
        System.out.println("These are Product you required"+list);
    }
}
