package poss.util.animation;


import java.awt.*;

public class DisplayTime implements Decorate{
    private int displayTime;
    public DisplayTime(int time) {
        displayTime = time;
    }

    @Override
    public void displayAction(Animation.Properties properties,Graphics g) {
        if(properties.getCount() / 25 >= displayTime && !properties.isEnd()){
            properties.getAnimationTickRegistory().remove();
            properties.setIsEnd(true);
        }
    }
}
