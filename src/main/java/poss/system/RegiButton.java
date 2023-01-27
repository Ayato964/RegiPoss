package poss.system;
import org.jetbrains.annotations.NotNull;
import poss.main.Main;
import poss.util.Display;

import java.awt.*;
import java.awt.event.MouseEvent;

import static java.awt.Color.BLACK;

public class RegiButton implements Display {
    private int x = 0, y = 0, w = 100, h = 100;
    private final ItemData data;
    public RegiButton(ItemData data){
        this.data = data;
    }
    public void setBounds(int _x, int _y, int _w, int _h){
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }
    @Override
    public void display(@NotNull Graphics g) {
        g.setColor(new Color(0xefefef));
        g.fillRect(x * Main.DW, y * Main.DH, w * Main.DW, h * Main.DH);
        g.setColor(BLACK);
        g.drawRect(x * Main.DW, y * Main.DH, w * Main.DW, h * Main.DH);
        g.setFont(new Font("", Font.BOLD, 32));
        g.setColor(BLACK);
        if(data != null)
           g.drawString(data.name, x * Main.DW, (y + h) * Main.DH);
    }

    public boolean isClicked(MouseEvent e) {
        return e.getX() > x * Main.DW && e.getX() < (x + w) * Main.DW && e.getY() > y * Main.DH && e.getY() < (y + h) * Main.DH;
    }

    public ItemData getItem() {
        return data;
    }
}
