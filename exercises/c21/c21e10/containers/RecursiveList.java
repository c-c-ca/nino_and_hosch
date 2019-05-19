package containers;

public class RecursiveList<Element> {

    // Private components:

    private ListState state;

    // Constructors:

    public RecursiveList () {
        this.state = new EmptyList<Element>();
    }

    // Queries:

    public boolean isEmpty () {
        return state.isEmpty();
    }

    public int size () {
        return state.size();
    }

    public Element get (int index) {
        return (Element)state.get(index);
    }

    public int indexOf (Element element) {
        return state.indexOf(element);
    }

    // Commands:

    public void add (Element element) {
        add(size(),element);
    }

    public void set (int index, Element element) {
        state.set(index,element);
    }

    public void add (int index, Element element) {
        state = state.add(index,element);
    }

    public void remove (int index) {
        state = state.remove(index);
    }

    private interface ListState<Element> {
        boolean isEmpty ();
        int size ();
        Element get (int index);
        int indexOf (Element element);
        void set (int index, Element element);
        ListState<Element> add (int index, Element element);
        ListState<Element> remove (int index);
    }

    private class EmptyList<Element>
        implements ListState<Element> {

        public boolean isEmpty () {
            return true;
        }

        public int size () {
            return 0;
        }

        public Element get (int index) {
            throw new IndexOutOfBoundsException();
        }

        public int indexOf (Element element) {
            return -1;
        }

        public void set (int index, Element element) {
            throw new IndexOutOfBoundsException();
        }

        public ListState<Element> add (int index, Element element) {
            if (index == 0)
                return new NonEmptyList<Element>(element,this);
            else
                throw new IndexOutOfBoundsException();

        }

        public ListState<Element> remove (int index) {
            throw new IndexOutOfBoundsException();
        }
    } // end of class EmptyList

    private class NonEmptyList<Element>
        implements ListState<Element> {

        private Element head;
        private ListState tail;

        public NonEmptyList (Element element,
            ListState<Element> tail) {
            this.head = element;
            this.tail = tail;
        }

        public boolean isEmpty () {
            return false;
        }

        public int size () {
            return tail.size() + 1;
        }

        public Element get (int index) {
            if (index == 0)
                return head;
            else
                return (Element)tail.get(index-1);
        }

        public int indexOf (Element element) {
            if (element.equals(head))
                return 0;
            else {
                int index = tail.indexOf(element);
                if (index != -1)
                    index = index + 1;
                return index;
            }
        }

        public void set (int index, Element element) {
            if (index == 0)
                head = element;
            else
                tail.set(index-1,element);
        }

        public ListState<Element> add (int index, Element element) {
            if (index == 0)
                return new NonEmptyList<Element>(element,this);
            else
                return new NonEmptyList<Element>(
                    head,tail.add(index-1,element));
        }

        public ListState<Element> remove (int index) {
            if (index == 0)
                return tail;
            else
                return new NonEmptyList<Element>(
                    head,tail.remove(index-1));
        }
    } // end of class NonEmptyList
} // end of class RecursiveList
