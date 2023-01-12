package poss.system.tab;

import org.jetbrains.annotations.NotNull;
import poss.util.Display;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Supplier;

public class Tabs implements Display{
    private static final ArrayList<AbstractItemTab> tab_list = new ArrayList<>();
    private static final Tabs ins = new Tabs();
    private Tabs(){

    }
    @Override
    public void display(@NotNull Graphics g) {
        System.out.println(Tabs.tab_list.size());
        for (AbstractItemTab tab : Tabs.tab_list){
            tab.display(g);
        }
    }
    public static AbstractItemTab create(Supplier<AbstractItemTab> tab){
        tab_list.add(tab.get());
        return tab.get();
    }

    public static Tabs getInstance() {
        return ins;
    }
}
