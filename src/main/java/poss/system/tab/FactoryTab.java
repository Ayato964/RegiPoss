package poss.system.tab;

public class FactoryTab {
    public static final AbstractItemTab BERGER_TAB = Tabs.create((() -> new NomalTab("ハンバーガー")));
    public static final AbstractItemTab SIDE_TAB = Tabs.create((() -> new NomalTab("サイド")));
    public static final AbstractItemTab DRINK_TAB = Tabs.create((() -> new NomalTab("ドリンク")));
    public static final AbstractItemTab DESERT_TAB = Tabs.create((() -> new NomalTab("デザート")));
}
