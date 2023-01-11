package poss.map;

import poss.util.Display;

import java.awt.*;

public abstract class Map implements Display {
    public Map(){
    }
    public abstract void setup(Graphics g);
}