package poss.map;

import poss.util.animation.Animation;

import java.awt.*;
import java.net.UnknownHostException;

public class Title extends Map{
    @Override
    public void setup(Graphics g) throws UnknownHostException {
        Animation.create(g).draw("Regi Poss Simulater", 20, 20, new Animation.Properties().size(60).center());
    }

    @Override
    public void display(Graphics g) {

    }
}
