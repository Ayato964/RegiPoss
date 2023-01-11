package poss.system.tab;

import org.jetbrains.annotations.NotNull;
import poss.util.Display;

import java.awt.*;
import java.util.ArrayList;

public class Tabs implements Display{
    private final ArrayList<AbstractItemTab> tab_list;
    private static final Tabs INSTANCE = new Tabs();
    private Tabs(){
        tab_list = new ArrayList<>();
    }
    @Override
    public void display(@NotNull Graphics g) {
        for (AbstractItemTab tab : tab_list){
            tab.display(g);
        }
    }
    public void add(AbstractItemTab tab){
        tab_list.add(tab);
    }
    public static Tabs getInstance(){
        return INSTANCE;
    }
}
