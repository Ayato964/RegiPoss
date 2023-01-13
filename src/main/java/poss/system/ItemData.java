package poss.system;

public class ItemData {
     public int id;
    public String name;
    public int price;
    private ItemData(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public static ItemData create(int id, String name, int price){
        return new ItemData(id, name, price);
    }

    public void printData() {
        System.out.println(id + "    " + name + "    " + price);
    }
}
