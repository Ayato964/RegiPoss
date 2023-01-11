package poss.system;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import poss.util.Display;

import java.awt.*;

public class RegiButton implements Display {
    private int x = 0, y = 0, w = 0, h = 0;
    public RegiButton(String str, int x, int y){
        this.x = x;
        this.y = y;
    }
    public RegiButton(String str, int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    @Override
    public void display(@NotNull Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, w, h);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, w, h);
    }
}
