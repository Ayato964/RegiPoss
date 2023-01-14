package poss.system;

import org.jetbrains.annotations.NotNull;
import poss.main.Main;
import poss.util.Display;
import poss.util.TickRegistory;
import poss.util.animation.Animation;
import poss.util.animation.AnimationText;

import java.awt.*;
import java.util.ArrayList;
import java.util.Properties;

public class OrderView implements Display {
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    ArrayList<AnimationText> mes;
    int count = 0;
    private static final OrderView instance = new OrderView();

    private OrderView(){
        mes = new ArrayList<>();
    }
    public static void add(ItemData data){
        if(instance.mes.size() != 0)
            instance.shiftOrder();
        instance.mes.add(Animation.create(Main.getMainGraphics()));
        instance.mes.get(instance.count).draw(data.name + "  " + data.price + "yen", instance.x, instance.y + instance.h - 3, new Animation.Properties()
                .color(Color.BLACK)
                .size(28)
        );
        instance.count ++;
    }

    private void shiftOrder() {
        for(AnimationText mes : mes){
            mes.setY(mes.getY() - 4);
        }
    }

    public void setBounds(int _x, int _y, int _w, int _h){
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }
    @Override
    public void display(@NotNull Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x * Main.DW, y * Main.DH, w * Main.DW, h * Main.DH);
    }

    public static OrderView getInstance() {
        return instance;
    }
}
