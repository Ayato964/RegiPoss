package poss.system.tab;

import org.jetbrains.annotations.NotNull;
import poss.system.Accountant;
import poss.system.OrderView;
import poss.system.RegiButton;
import poss.util.Display;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public abstract class AbstractItemTab implements Display, MouseListener {
    private int x = 0, y = 0, w = 0, h = 0;
    private ArrayList<RegiButton> buttons;
    protected String category;
    protected String categoryName;
    public AbstractItemTab(String category){
        buttons = new ArrayList<>();
        this.category = category;
        categoryName = category.equals("H") ? "Berger" : category.equals("S") ? "Side" : category.equals("D") ? "Drink" : "Sweet";
        getButton(buttons);
        if(buttons.size() < 25){
            for(int i = buttons.size(); i < 25; i ++){
                buttons.add(new RegiButton(null));
            }
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
        int b = 0;
        for(int i = 0; i < 5; i ++){
            for(int c = 0; c< 5; c ++){
                buttons.get(b).setBounds(x + (w / 5 * c), y + (h / 5 * i), w / 5, h / 5);
                buttons.get(b).display(g);
                b ++;
            }
        }
    }
    protected abstract void getButton(ArrayList<RegiButton> buttons);

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(RegiButton b : buttons){
            if(b.isClicked(e) && b.getItem() != null) {
                Accountant.getInstance().sum(b.getItem().price);
                OrderView.add(b.getItem());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
