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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    @Override
    public String toString(){
        return "ID: "+id+"\n NAME: "+Name+"\n TIER: "+tier;
    }
}