package poss.main;

import poss.map.Map;
import poss.map.Title;
import poss.system.SQLoader;
import poss.util.Tick;

import javax.swing.*;

import java.awt.event.MouseListener;
import java.awt.image.*;
import java.awt.*;
import java.net.UnknownHostException;


public class Main extends JFrame{
    protected static Main main;
    public Map displayMap;
    public static String NAME;
    private final MainPanel panel;
    public static int DW;
    public static int DH;
    public static Rectangle DESCTOP_BOUNDS;
    private static  Graphics g;
    private static  Graphics2D animationGraphics;
    public Main(String title){
        setTitle(title);
        this.setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        NAME = title;
        main = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DESCTOP_BOUNDS = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        DW = (int) DESCTOP_BOUNDS.getWidth() / 198;
        DH =(int) DESCTOP_BOUNDS.getHeight() / 108;
        panel = new MainPanel();
        add("Center", panel);
        pack();
        g = panel.getGraphics();
        ((Graphics2D) g).setBackground(Color.WHITE);


        repaint();
    }
    public static Main getInstance(){
        return Main.main;
    }
    public static  Graphics getMainGraphics(){
        return g;
    }
    public static Graphics getAnimationGraphics(){
        return animationGraphics;
    }
    /** Main Method !!! **/
    public static void main(String[] args) {
        Main m = new Main("CodeToon");
        m.setVisible(true);
        m.run(new Title());
        System.out.println("Tick Loaded");
        Tick.getInstance();
       // SQLoader.getBigData().get(3).printData();
    }

    public void run(Map map){
        g.clearRect(0, 0, getWidth(), getHeight());

        MouseListener[] m = getMouseListeners();
        for(MouseListener i : m)
            removeMouseListener(i);
        Tick.getInstance().removeAllAnimation();
        displayMap = map;
        displayMap.setup(g);
        displayMap.display(g);
        repaint();
    }
    public Map getMap(){
        return displayMap;
    }
    private class MainPanel extends JLabel{
        BufferedImage image;
        final Graphics hackingPazzle;
        public MainPanel(){
            image = new BufferedImage((int) DESCTOP_BOUNDS.getWidth(),(int) DESCTOP_BOUNDS.getHeight(), BufferedImage.TYPE_INT_RGB);
            this.setIcon(new ImageIcon(image));
            hackingPazzle = image.createGraphics();
            repaint();
        }
        public Graphics getGraphics(){
            return hackingPazzle;
        }

    }
}