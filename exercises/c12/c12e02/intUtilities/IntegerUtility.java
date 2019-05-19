package intUtilities;

import nhUtilities.containers.*;

public class IntegerUtility {

    public IntegerUtility () {}

    public int evens (List<Integer> list) {
        int count;  // the number of even integers
        int i;      // index of next Integer element
                    // to look at
                    
        count = 0;
        for (i = 0; i < list.size(); i = i + 1)
            if (list.get(i) % 2 == 0)
                count = count + 1;
        return count;
    }
}
