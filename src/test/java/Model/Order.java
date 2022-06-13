package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String Status;
    private Customer customer;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
}
