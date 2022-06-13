package Model;

public class Product {
    private  int id;
    private String Name;
    private String Category;
    private Double Price;
    public Product(int id,String Name,String Category,Double Price)
    {
        this.id=id;
        this.Name=Name;
        this.Category=Category;
        this.Price=Price;
    }

     public int getId() {
        return id;
    }

     public void setId(int id) {
        id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }


    @Override
    public String toString(){
        return "ID: "+id+"\nNAME: "+Name+"\nCATEGORY: "+Category+"\nPRICE: "+Price+"\n";
    }
}
