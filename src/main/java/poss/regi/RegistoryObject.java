package poss.regi;

import java.util.function.Supplier;

public class RegistoryObject<T> {
    private T t;
    private final String id;
    public RegistoryObject(String regiID, Supplier<T> sup){
        t = sup.get();
        id = regiID;
    }
    public T get(){
        return t;
    }
    public String getID(){
        return id;
    }
/*    public void run(){
        t.action();
    }
  */
  /*
    public  void set(HashMap<Integer, String> map){
        if(t.getCount() != 0){
            t.set(map);
        }
    }

   */
}
