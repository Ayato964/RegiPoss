package poss.map;

import poss.main.Main;
import poss.util.animation.Animation;

import java.awt.*;
import java.net.UnknownHostException;

public class Title extends Map{
    @Override
    public void setup(Graphics g) {
        Animation.create(g).draw("Regi Poss Simulater", 20, 20, new Animation.Properties().font("", Font.BOLD, 60).color(Color.BLACK).center());
        Animation.create(g).draw("Begin Poss", 20, 40, new Animation.Properties()
                .size(40)
                .center()
                .frame(Color.BLACK)
                        .color(Color.BLACK)
                .button(i-> Main.getInstance().run(new Poss()))
        );
        Animation.create(g).draw("End Poss", 20, 60, new Animation.Properties().size(40).center().frame(Color.BLACK).color(Color.BLACK)
                .button(i->System.exit(-1))
        );
    }

    @Override
    public void display(Graphics g) {

    }
}
