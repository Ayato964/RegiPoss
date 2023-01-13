package poss.system.tab;

import org.jetbrains.annotations.NotNull;
import poss.util.Display;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Supplier;

public class Tabs implements Display{
    private static final Tabs ins = new Tabs();
    private Tabs(){

    }
    @Override
    public void display(@NotNull Graphics g) {
        ArrayList<AbstractItemTab> tab = FactoryTab.TABS.getAll();
        for(AbstractItemTab t : tab)
            t.display(g);
    }

    public static Tabs getInstance() {
        return ins;
    }
}
