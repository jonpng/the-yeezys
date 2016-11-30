package app.model;

/**
 * Created by Brandon on 10/31/16.
 */

import javafx.collections.ObservableListBase;
import java.util.ArrayList;

public class PointList<T> extends ObservableListBase<T> {

    private ArrayList<T> data;

    public PointList() {
        data = new ArrayList<T>();
    }

    public int size() {
        return data.size();
    }

    public T get(int index) {
        return data.get(index);
    }

    public boolean add(T item) {
        return data.add(item);
    }
}
