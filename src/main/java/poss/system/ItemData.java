package poss.system;

public class ItemData {
    private int id;
    private String name;
    private int price;
    private ItemData(int id, String name, int price){

    }
    public static ItemData create(int id, String name, int price){
        return new ItemData(id, name, price);
    }
}
