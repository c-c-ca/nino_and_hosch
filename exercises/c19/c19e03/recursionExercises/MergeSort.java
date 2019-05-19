package recursionExercises;

import java.util.Comparator;
import nhUtilities.containers.*;

public class MergeSort<Element> {

    /**
     * Sort the specified List using merge sort.
     */
    public static <Element> void sort (
        List<Element> list, Comparator<Element> order) {
        sort(list,order,0,list.size()-1);
    }

    public static <Element> void sort (
        List<Element> list, Comparator<Element> order,
        int low, int high) {
        if (low < high) {
            int mid = (low+high)/2;
            sort(list,order,low,mid);
            sort(list,order,mid+1,high);
            merge(list,order,low,high);
        }
    }

    public static <Element> void merge (List<Element> list,
        Comparator<Element> order, int low, int high) {
        List<Element> temp = list.copy();
        int mid = (low+high)/2;
        int i, j;

        i = low;
        j = mid+1;
        while (i <= mid && j <= high) {
            int index;
            if (order.compare(temp.get(i),temp.get(j)) < 0) {
                index = i;
                i = i+1;
            } else {
                index = j;
                j = j+1;
            }
            list.set(low,temp.get(index));
            low = low+1;
        }

        int first, last;
        if (i <= mid) {
            first = i;
            last = mid;
        } else {
            first = j;
            last = high;
        }
        while (first <= last) {
            list.set(low,temp.get(first));
            first = first+1;
            low = low+1;
        }
    }
}
