package searches;

import java.util.Comparator;

import nhUtilities.containers.*;

public class Searches {

    /**
     * The proper place for the specified item on the
     * specified list, found using binary search.
     * @require    list is sorted according to order
     * @ensure     0 <= result && result <= list.size()
     *             for all indexes i: i < result implies
     *                order.compare(list.get(i),item) < 0
     *             for all indexes i: i >= result implies
     *                order.compare(list.get(i),item) >= 0
     */
    private <Element> int itemIndex (Element item,
        OrderedList<Element> list, Comparator<Element> order) {
        int low;       // the lowest index being examined
        int high;      // the highest index being examined

        /**
         * list.get(low)...list.get(high) is the segment
         * of the list still to be considered.
         * for all indexes i: i < low implies
         *    order.compare(list.get(i),item) < 0
         * for all indexes i: i > high implies
         *    order.compare(list.get(i),item) >= 0
         */

        int mid;       // the middle item between low and
                       // high.  mid == (low+high)/2

        low = 0;
        high = list.size() - 1;
        while (low <= high) {
            mid = (low+high)/2;
            if (order.compare(list.get(mid),item) < 0)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }

    /**
     * The index of the specified item on the specified
     * list, located by binary search.  Returns -1 if
     * the item is not on the list.
     * @require
     *    item != null
     *    the order is consistent with equals: that is,
     *    for any Elements x and y,
     *       x.equals(y) if and only if
     *       order.compare(x,y) == 0
     * @ensure
     *    if result == -1 then
     *       item equals no element of list
     *    else
     *       item.equals(list.get(result)),
     *       and result is the smallest index for which
     *       this is true
     */
    public <Element> int indexOf (Element item,
        OrderedList<Element> list, Comparator<Element> order) {
        int i = itemIndex(item, list, order);
        if (i < list.size() && order.compare(list.get(i),item) == 0)
            return i;
        else
            return -1;
    }

}
