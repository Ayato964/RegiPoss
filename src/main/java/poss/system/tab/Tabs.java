package poss.system.tab;

import org.jetbrains.annotations.NotNull;
import poss.main.Main;
import poss.util.Display;
import poss.util.animation.Animation;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Tabs implements Display {
    final int  x, y;
    private static final Tabs ins = new Tabs();
    private int categoryTabButton;
    private int beforeTabButton;
    private final ArrayList<AbstractItemTab> tab;

    private Tabs(){
        categoryTabButton = 0;
        beforeTabButton = 0;
        x = 5;
        y = 20;
        tab = FactoryTab.TABS.getAll();
        Main.getInstance().addMouseListener(tab.get(categoryTabButton));
    }
    public void setup(Graphics g){
        g.setColor(new Color(0xefefef));
        //g.fillRect(x * Main.DW, y * Main.DH, 150 * Main.DW, 15 * Main.DH);
        int size = 150 / tab.size();
        for(int i = 0; i < tab.size(); i ++){
           // System.out.println(tab.get(i).categoryName + "   " + (x + (size * i)));
            int finalI = i;
            Animation.create(g).draw(tab.get(i).getCategoryName(), x + (size * i), y + 15, new Animation.Properties()
                    .size(80)
                    .frame(Color.BLACK,(size * i) * Main.DW, 15 * Main.DH, () ->true)
                            .button(c -> categoryTabButton = finalI)
                    .color(Color.BLACK));
        }

    }
    @Override
    public void display(@NotNull Graphics g) {
        g.setColor(new Color(0xefefef));
        g.fillRect(x * Main.DW, y * Main.DH, 150 * Main.DW, 15 * Main.DH);
        tab.get(categoryTabButton).setBounds(x, y + 20, 150, 70);
        tab.get(categoryTabButton).display(g);
        changed();
    }
    private void changed(){
        if(categoryTabButton != beforeTabButton){
            Main.getInstance().removeMouseListener(tab.get(beforeTabButton));
            Main.getInstance().addMouseListener(tab.get(categoryTabButton));
        }
        beforeTabButton = categoryTabButton;
    }
    public static Tabs getInstance() {
        return ins;
    }
}
