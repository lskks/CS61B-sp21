package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    ;
    private final Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }

        T maxVal = get(0);
        for (int i = 0; i < size(); i++) {
            T val = get(i);
            if (comparator.compare(maxVal, val) < 0) {
                maxVal = val;
            }
        }
        return maxVal;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxVal = get(0);
        for (int i = 0; i < size(); i++) {
            T val = get(i);
            if (c.compare(maxVal, val) < 0) {
                maxVal = val;
            }
        }
        return maxVal;
    }
}
