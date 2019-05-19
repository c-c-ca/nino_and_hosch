package maps;

/**
 * A simple (key, value) table.
 */
public class KeyValueTable<Key, Value> {

    private final static int TABLE_SIZE = 10;
    private final static double GROWTH_FACTOR = 1.5;

    // Private components:

    private Object[] keys;      // the keys
    private Object[] values;    // the values
    private int size;

    // Constructors:

    /**
     * Create a new empty table.
     */
    public KeyValueTable () {
        keys = new Object[TABLE_SIZE];
        values = new Object[TABLE_SIZE];
        size = 0;
    }

    /**
     * Add the specified (key, value) to this table. If the
     * key is already in the table, replace the associated
     * value with the specified one.
     */
    public void add (Key key, Value value) {
        if (size == keys.length)
            grow();
        int i = indexOf(key);
        if (i == -1) {
            keys[size] = key;
            values[size] = value;
            size = size+1;
        } else
            values[i] = value;
    }

    /**
     * The value associated with the specified key. Returns
     * null if the key is not in the table.
     */
    public Value lookUp (Key key) {
        int i = indexOf(key);
        if (i != -1)
            return (Value)values[i];
        else
            return null;
    }

    private int indexOf (Key key) {
        for (int i = 0; i < keys.length; i = i+1)
            if (key.equals(keys[i]))
                return i;
        return -1;
    }

    private void grow () {
        int newSize = (int) (size * GROWTH_FACTOR);
        Object[] tempKeys = new Object[newSize];
        Object[] tempValues = new Object[newSize];
        for (int i = 0; i < size; i = i+1) {
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }
        keys = tempKeys;
        values = tempValues;
    }
}
