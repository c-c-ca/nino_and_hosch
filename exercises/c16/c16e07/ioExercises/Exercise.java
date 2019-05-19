package ioExercises;

import nhUtilities.containers.*;
import java.io.*;

public class Exercise {

    private static final int LIST_SIZE = 10;
    private static List<Integer> inlist;
    private static List<Integer> outlist;

    public static void main (String[] argv) {
        try {
            generateOutList();
            writeList(outlist,new DataOutputStream(
                new FileOutputStream("data")));
            inlist = readList(new DataInputStream(
                new FileInputStream("data")));
            displayList(inlist);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void generateOutList () {
        outlist = new DefaultList<Integer>();
        for (int i = 0; i < LIST_SIZE; i = i+1)
            outlist.add(Integer.valueOf(i));
    }

    private static void displayList (List<Integer> list) {
        String s = "{";
        if (list.size() > 0)
            s = s + list.get(0);
        for (int i = 1; i < list.size(); i = i+1)
            s = s + ", " + list.get(i);
        System.out.println(s + "}");
    }

    public static void writeList (List<Integer> list,
        DataOutputStream out) throws IOException {
        for (int i = 0; i < outlist.size(); i = i+1)
            out.writeInt(outlist.get(i).intValue());
        out.close();
    }

    private static List<Integer> readList (DataInputStream in)
        throws IOException {
        List<Integer> list = new DefaultList<Integer>();

        try {
            int i;
            while (true) {
                i = in.readInt();
                list.add(Integer.valueOf(i));
            }
        } catch (EOFException e) {
                in.close();
                return list;
        }
    }


}
