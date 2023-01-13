package poss.system;

import org.jetbrains.annotations.NotNull;
import poss.util.Display;

import java.awt.*;

public class OrderView implements Display {
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;

    public void setBounds(int _x, int _y, int _w, int _h){
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }
    @Override
    public void display(@NotNull Graphics g) {

    }
}
