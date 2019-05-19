package intUtilities;

import nhUtilities.containers.*;

public class Example {

    private static final int LIST_SIZE = 10;

    private static List<Integer> generateList (int size) {
        List<Integer> list = new DefaultList<Integer>();
        for (Integer i = Integer.valueOf(0); i.intValue() < size; i = i + 1)
            list.add(i);
        return list;
    }

    public static void main (String[] args) {
        IntegerUtility iu = new IntegerUtility();
        List<Integer> list = generateList(LIST_SIZE);
        int evens = iu.evens(list);
        System.out.println(evens);
    }
}
