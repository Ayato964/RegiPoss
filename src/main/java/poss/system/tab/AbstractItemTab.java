package poss.system.tab;

import org.jetbrains.annotations.NotNull;
import poss.system.RegiButton;
import poss.util.Display;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractItemTab implements Display {
    private int x = 0, y = 0;
    private ArrayList<RegiButton> buttons;
    protected String category;
    public AbstractItemTab(String category){
        buttons = new ArrayList<>();
        this.category = category;
        getButton(buttons);
    }
    public void setPosition(int _x, int _y){
        x = _x;
        y = _y;
    }
    @Override
    public void display(@NotNull Graphics g) {

        for (RegiButton b : buttons){
            b.display(g);
        }
    }
    protected abstract void getButton(ArrayList<RegiButton> buttons);
}
