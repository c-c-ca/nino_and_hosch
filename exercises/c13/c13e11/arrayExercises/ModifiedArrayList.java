package arrayExercises;

import java.util.*;

public class ModifiedArrayList<Element> extends ArrayList {

    public boolean equals (Object obj) {
        ModifiedArrayList arr;

        if (obj instanceof ModifiedArrayList)
            arr = (ModifiedArrayList)obj;
        else
            return false;

        if (this.size() == arr.size()) {
            for (int i = 0; i < this.size(); i = i+1)
                if (this.get(i) != arr.get(i))
                    return false;
            return true;
        } else
            return false;
    }
}
