package poss.system.tab;

import org.jetbrains.annotations.NotNull;
import poss.system.RegiButton;
import poss.util.Display;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractItemTab implements Display {
    private ArrayList<RegiButton> buttons;
    public AbstractItemTab(){
        buttons = new ArrayList<>();
        getButton(buttons);
    }
    @Override
    public void display(@NotNull Graphics g) {
        for (RegiButton b : buttons){
            b.display(g);
        }
    }
    protected abstract void getButton(ArrayList<RegiButton> buttons);
}
