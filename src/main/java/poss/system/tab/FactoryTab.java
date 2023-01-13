package poss.system.tab;

import poss.regi.RegistoryList;
import poss.regi.RegistoryObject;

public class FactoryTab {
    public static final RegistoryList<AbstractItemTab> TABS = new RegistoryList<>("tab");

    public static final RegistoryObject<AbstractItemTab> BERGER_TAB = TABS.createRegistory("berger", () -> new NomalTab("H"));
    public static final RegistoryObject<AbstractItemTab> SIDE_TAB = TABS.createRegistory("side", () -> new NomalTab("S"));
    public static final RegistoryObject<AbstractItemTab> DRINK_TAB = TABS.createRegistory("drink", () -> new NomalTab("D"));
    public static final RegistoryObject<AbstractItemTab> DESERT_TAB = TABS.createRegistory("sweets", () -> new NomalTab("S"));

}
