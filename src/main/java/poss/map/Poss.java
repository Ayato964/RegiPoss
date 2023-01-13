package poss.map;

import poss.system.ItemData;
import poss.system.SQLoader;
import poss.system.tab.NomalTab;
import poss.system.tab.Tabs;

import java.awt.*;

public class Poss extends Map {
    public Poss(){
    }
    @Override
    public void setup(Graphics g)  {
        ItemData d = SQLoader.getBigData().get(0);
        d.printData();
    }

    @Override
    public void display(Graphics g) {
        Tabs.getInstance().display(g);
    }
}
