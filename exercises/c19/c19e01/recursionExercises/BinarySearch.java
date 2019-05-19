package recursionExercises;

import java.util.Comparator;
import nhUtilities.containers.*;

public class BinarySearch {

    private static <Element> int itemIndex (Element item,
        List<Element> list, Comparator<Element> order) {
        return itemIndex(item,list,order,0,list.size()-1);
    }

    private static <Element> int itemIndex (Element item,
        List<Element> list, Comparator<Element> order,
        int low, int high) {
            if (low > high)
                return low;
            else {
                int mid = (low+high)/2;
                if (order.compare(list.get(mid),item) < 0)
                    low = mid+1;
                else
                    high = mid-1;
                return itemIndex(item,list,order,low,high);
            }
    }

    public static <Element> int indexOf (Element item,
        List<Element> list, Comparator<Element> order) {
        int i = itemIndex(item, list, order);
        if (i < list.size() && list.get(i).equals(item))
            return i;
        else
            return -1;
    }
}
