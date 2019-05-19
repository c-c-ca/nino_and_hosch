package students;

import java.util.Comparator;

public class AlphabeticalOrder
    implements Comparator<Student> {

        /**
         * Order Students alphabetically.
         */
        public int compare (Student first, Student second) {
            int order =
                first.lastName().compareTo(second.lastName());
            if (order == 0) {
                order =
                    first.firstName().compareTo(second.firstName());
            }
            return order;
        }
    }
