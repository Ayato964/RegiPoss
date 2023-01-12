package poss.system.tab;

import poss.system.ItemData;
import poss.system.RegiButton;
import poss.system.SQLoader;

import java.util.ArrayList;

public class NomalTab extends AbstractItemTab {

    public NomalTab(String category) {
        super(category);
    }

    @Override
    protected void getButton(ArrayList<RegiButton> buttons) {
        ItemData[] data = SQLoader.getBigData().gets(category);
        for(ItemData d : data)
            buttons.add(new RegiButton(d));
    }

}
