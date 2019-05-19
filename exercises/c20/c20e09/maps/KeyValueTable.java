package maps;

import nhUtilities.containers.*;

/**
 * A simple (key, value) table.
 */
public class KeyValueTable
    <Key, Entry extends Keyed<Key>> {

    private List<Entry> entries;     // the entries

    /**
     * Create a new empty table.
     */
    public KeyValueTable () {
        entries = new DefaultList<Entry>();
    }

    /**
     * Add the specified entry to this table. If entry.getKey()
     * is already in the table, replace the associated
     * entry with the one specified.
     */
    public void add (Entry entry) {
        Key key = entry.getKey();
        int i = indexOf(key);
        if (i == -1)
            entries.add(entry);
        else
            entries.set(i,entry);
    }
    /**
     * The entry associated with the specified key. Returns
     * null if the key is not in the table.
     */
    public Entry lookUp (Key key) {
        int i = indexOf(key);
        if (i != -1)
            return entries.get(i);
        else
            return null;
    }

    private int indexOf (Key key) {
        for (int i = 0; i < entries.size(); i = i+1)
            if (key.equals(entries.get(i).getKey()))
                return i;
        return -1;
    }

    /**
     * The number of entries in the table.
     */
    public int size () {
        return entries.size();
    }

    /**
     * Get the entry in the table at the specified index i.
     */
    public Entry get (int i) {
        return entries.get(i);
    }

    /**
     * Set the entry in the table at the specified index i.
     */
    public void set (int i, Entry entry) {
        entries.set(i,entry);
    }
}
