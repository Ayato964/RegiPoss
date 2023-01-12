package poss.map;

import poss.system.SQLoader;
import poss.system.tab.NomalTab;

import java.awt.*;

public class Poss extends Map {
    public Poss(){
    }
    @Override
    public void setup(Graphics g)  {
        SQLoader.getBigData();
    }

    @Override
    public void display(Graphics g) {

    }
}
