package UI;

import Model.Order;
import Model.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> productList=new ArrayList<>();
        List<Order> orderList=new ArrayList<>();
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
        //we can also find things with specific filters.
        //can take userinput for it
        List<Product> list=productList.stream()
                .filter(s->s.getCategory().equalsIgnoreCase("Book"))
                .filter(s->s.getPrice()>100)
                .collect(Collectors.toList());
        System.out.println("These are Product you required"+list);
        //for filtering out order with baby category
        List<Order> orderList1=orderList.stream()
                .filter(s->s.getProducts()
                        .stream()
                        .anyMatch(p->p.getCategory().equalsIgnoreCase("baby")))
                .collect(Collectors.toList());
        //find particular category porduct and give 10% discount on it.
        productList.stream()
                .filter(s->s.getCategory().equalsIgnoreCase("Book"))
                .forEach(r->r.setPrice(r.getPrice()*0.9));
        productList.stream()
                .filter(s->s.getCategory().equalsIgnoreCase("Book"))
                .forEach(System.out::println);

        //list of customer above a tier and between the dates
        orderList.stream()
                .filter(r->r.getCustomer().getTier()>=2)
                .filter(p->p.getOrderDate().compareTo(LocalDate.of(2022,06,13))<0)
                .filter(a->a.getOrderDate().compareTo(LocalDate.of(2022,04,12))>0)
                .distinct()
                .forEach(System.out::println);

        //Cheapest price for particular category

        Optional<Product> res=productList.stream()//used optional here as it will take required value or null.
                .filter(r->r.getCategory().equalsIgnoreCase("Book"))
                .min(Comparator.comparing(Product::getPrice));
        System.out.println(res);

        //most recent placed order
        orderList.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .forEach(System.out::println);
        //we can also collect it in the list using collector

        //get all orders on particular date
        orderList.stream()
                .filter(s->s.getOrderDate().isEqual(LocalDate.of(12,12,12)))
                .map(r->r.getProducts())
                .distinct()
                .forEach(System.out::println);

        //total order placed in a month
        Double sum= orderList.stream()
                .filter(s->s.getOrderDate().isAfter(LocalDate.of(12,12,31)))
                .filter(p->p.getOrderDate().isBefore(LocalDate.of(13,02,1)))
                .flatMap(a->a.getProducts().stream())
                .mapToDouble(product -> product.getPrice())
                .sum();
        System.out.println(sum);

        //average of order placed on particular day
        Double order=orderList.stream()
                .filter(p->p.getOrderDate().isEqual(LocalDate.of(12,12,12)))
                .flatMap(a->a.getProducts().stream())
                .mapToDouble(r->r.getPrice())
                .sum();
        System.out.println(order);


        //all statics about a particular category
        //used .summaryStatics to get it
        DoubleSummaryStatistics ans=productList.stream()
                .filter(r->r.getCategory().equalsIgnoreCase("Book"))
                .mapToDouble(p->p.getPrice())
                .summaryStatistics();
        System.out.println(ans);

        //Every Category most expensive product
       Map<String,Optional<Product>> kfl= productList.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))
                ));
    }
}
