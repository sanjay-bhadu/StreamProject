package Model;

public class Customer {
    private int id;
    private String Name;
    private int tier;
    public Customer(int id,String Name,int tier)
    {
        this.id=id;
        this.Name=Name;
        this.tier=tier;
    }

    @Override
    public String toString(){
        return "ID: "+id+"\n NAME: "+Name+"\n TIER: "+tier;
    }
}