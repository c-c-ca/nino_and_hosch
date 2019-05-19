package sets;

import nhUtilities.containers.*;

public class Example {

    private static final int ITEM1 = 5;
    private static final int ITEM2 = 2;
    private static final int ITEM3 = 34;
    private static final int ITEM4 = 14;
    private static final int ITEM5 = 4;
    private static final int ITEM6 = 5;


    public static void main (String[] argv) {
        Integer item;
        List<Integer> list = new DefaultList<Integer>();
        item = Integer.valueOf(ITEM1);
        list.add(item);
        item = Integer.valueOf(ITEM2);
        list.add(item);
        item = Integer.valueOf(ITEM3);
        list.add(item);
        item = Integer.valueOf(ITEM4);
        list.add(item);
        item = Integer.valueOf(ITEM5);
        list.add(item);
        item = Integer.valueOf(ITEM6);
        list.add(item);
        System.out.println(new IntegerSet(list));

    }
}
