package poss.system;

import org.jetbrains.annotations.NotNull;
import poss.main.Main;
import poss.util.Display;

import java.awt.*;

public class Accountant implements Display {
    private int x = 0, y = 0;
    private int money = 0;
    
    private static final Accountant instance = new Accountant();
    private Accountant(){}
    public void setPosition(int _x, int _y){
        x = _x;
        y = _y;
    }

    @Override
    public void display(@NotNull Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x * Main.DW, y * Main.DH, 50 * Main.DW, 10 * Main.DH);
        g.setColor(Color.BLACK);
        g.setFont(new Font("", Font.BOLD, 32));
        g.drawString(getTotal(), x * Main.DW, y * Main.DH + 50);
    }
    public void sum(int money){
        this.money += money;
    }
    public void sub(int money){
        this.money -= money;
    }

    private String getTotal() {
        return new StringBuilder().append("Total:").append(money).append("yen").toString();
    }
    public void reset(){
        money = 0;
    }
    public static Accountant getInstance() {
        return instance;
    }
}
