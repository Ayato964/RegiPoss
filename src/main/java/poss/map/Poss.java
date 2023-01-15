package poss.map;

import poss.system.Accountant;
import poss.system.ItemData;
import poss.system.OrderView;
import poss.system.SQLoader;
import poss.system.tab.NomalTab;
import poss.system.tab.Tabs;
import poss.util.animation.Animation;

import java.awt.*;

public class Poss extends Map {
    public Poss(){
    }
    @Override
    public void setup(Graphics g)  {
        ItemData d = SQLoader.getBigData().get(0);
        d.printData();
        Tabs.getInstance().setup(g);
        Accountant.getInstance().setPosition(160, 90);
        OrderView.getInstance().setBounds(160, 25, 50, 55);
        Animation.create(g).draw("Accountant", 160, 110, new Animation.Properties()
                .size(32)
                .color(Color.WHITE)
                .frame(Color.WHITE)
                .button(i -> {
                    SQLoader.getBigData().pushes(OrderView.getInstance().getData());
                    Accountant.getInstance().reset();
                    OrderView.getInstance().reset();

                })
        );
    }

    @Override
    public void display(Graphics g) {
        Tabs.getInstance().display(g);
        Accountant.getInstance().display(g);
        OrderView.getInstance().display(g);
    }
}
