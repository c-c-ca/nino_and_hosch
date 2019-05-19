package operations;

import nhUtilities.containers.*;

public class OperatorUtilities {

    public int foldl (OperatorWithIdentity op,
        List<Integer> list) {
        int value = op.identity();
        for (int i = 0; i < list.size(); i = i+1)
            value = op.operate(value,list.get(i).intValue());
        return value;
    }

    public int foldr (OperatorWithIdentity op,
        List<Integer> list) {
        int value = op.identity();
        for (int i = list.size()-1; i >= 0; i = i-1)
            value = op.operate(value,list.get(i).intValue());
        return value;
    }
}
