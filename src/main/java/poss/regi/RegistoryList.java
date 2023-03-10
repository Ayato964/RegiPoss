package poss.regi;

import java.util.ArrayList;
import java.util.function.Supplier;

public class RegistoryList<T>{
    private String ID;
    private ArrayList<RegistoryObject<T>> registory;
    public RegistoryList(String ID){
        this.ID = ID;
        registory = new ArrayList<RegistoryObject<T>>();
        
    }
    public  RegistoryObject<T> createRegistory(String ID, Supplier<T> sup){
        RegistoryObject<T> obj = new RegistoryObject<T>(ID, sup);
        isMethod(obj);
        registory.add(obj);
        return obj;
    }

    private void isMethod(RegistoryObject<T> obj) {
        for(int i = 0; i < registory.size(); i ++){
            if(obj.getID().equals(registory.get(i).getID())) {
                registory.remove(i);
                break;
            }
        }
    }

    public boolean search(String s){
        for(int i = 0; i < registory.size(); i ++){
            //System.out.println(s + "   " + registory.get(i).getID() + "   " + registory.get(i).getID().equals(s));
            if(registory.get(i).getID().equals(s)){
                return true;
            }
        }
        return false;
    }
    public void deleteAll(String id){
        for(int i = 0; i < registory.size(); i ++){
            if(isInClude(registory.get(i).getID(), id)){
                registory.remove(i);
                i = 0;
            }
        }
    }
    private boolean isInClude(String id, String search){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < id.length(); i ++){
            s.append(id.charAt(i));
            if(s.toString().equals(search)){
                return true;
            }
        }
        return false;
    }
    public T get(String id){
        for(int i = 0; i < registory.size(); i ++){
            if(id.equals(registory.get(i).getID())){
                return  registory.get(i).get();
            }
        }
        return null;

    }
    public ArrayList<T> getAll(){
        ArrayList<T> t = new ArrayList<>();
        for(int i = 0; i < registory.size(); i ++){
            t.add(registory.get(i).get());
        }
        return t;
    }
    public T getThis(String id){
        for(int i = 0; i < registory.size(); i ++){
            if(id.equals(registory.get(i).getID())){
                return  (T) registory.get(i).get();
            }
        }
        return null;

    }
}
