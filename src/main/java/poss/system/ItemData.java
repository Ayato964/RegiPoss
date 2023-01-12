package poss.system;

public class ItemData {
    private int id;
    private String name;
    private int price;
    private ItemData(int id){

    }
    private ItemData(String name){

    }
    public static ItemData get(int id){
        return new ItemData(id);
    }
    public static ItemData get(String name){
        return new ItemData(name);
    }
    public static ItemData[] gets(String category){
       return null;
    }
}
