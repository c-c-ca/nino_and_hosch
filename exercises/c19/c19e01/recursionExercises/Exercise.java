package recursionExercises;

import java.util.Comparator;
import nhUtilities.containers.*;

public class Exercise {

    private static List<Integer> list;
    private static Integer item = Integer.valueOf(5);
    private static Comparator order =
        new Comparator<Integer>() {
            public int compare (Integer i, Integer j) {
                return i.intValue() - j.intValue();
            }
        };

    private static void generateList () {
        list = new DefaultList<Integer>();
        int[] v = new int[]{4,5,1,5,8,9};
        for (int i = 0; i < v.length; i = i+1)
            list.add(Integer.valueOf(v[i]));
    }

    public static void main (String[] argv) {
        generateList();
        System.out.println(list);
        ListUtilities.selectionSort(list,order);
        System.out.println(list);
        int i = BinarySearch.indexOf(item, list, order);
        System.out.println(i);
    }
}
