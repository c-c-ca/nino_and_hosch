package genericExercises;

import nhUtilities.containers.*;

public class Exercise {

    public static boolean disjoint (
        List<?> l1, List<?> l2) {

        for (int i = 0; i < l1.size(); i = i+1)
            for (int j = 0; j < l2.size(); j = j+1)
                if (l1.get(i).equals(l2.get(j)))
                    return false;
                    
        return true;
    }
}
