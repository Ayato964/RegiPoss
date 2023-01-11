package poss.map;

import poss.main.Main;
import poss.util.animation.Animation;

import java.awt.*;
import java.net.UnknownHostException;

public class Title extends Map{
    @Override
    public void setup(Graphics g) {
        Animation.create(g).draw("Regi Poss Simulater", 20, 20, new Animation.Properties().size(60).center());
        Animation.create(g).draw("Begin Poss", 20, 40, new Animation.Properties()
                .size(40)
                .center()
                .frame(Color.WHITE)
                .button(i-> Main.getInstance().run(new Poss()))
        );
    }

    @Override
    public void display(Graphics g) {

    }
}
