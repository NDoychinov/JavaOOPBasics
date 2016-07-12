package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 9.7.2016 г..
 */
public class OldMan extends Man {

    private List<String> goodOldMemories;

    public OldMan(double salary) {
        super(salary);
        this.goodOldMemories = new ArrayList<>();
    }

    private List<String> getGoodOldMemories() {
        return goodOldMemories;
    }

    private void addMemorie(String memorie) {
        this.goodOldMemories.add(memorie);
    }
}
