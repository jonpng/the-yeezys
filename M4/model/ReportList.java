package model;

/**
 * Created by Brandon on 10/12/16.
 */

import javafx.collections.ObservableListBase;
import java.util.ArrayList;

public class ReportList<T> extends ObservableListBase<T> {

    private ArrayList<T> back;

    public ReportList() {
        back = new ArrayList<T>();
    }

    public int size() {
        return back.size();
    }

    public T get(int index) {
        return back.get(index);
    }

    public boolean add(T item) {
        return back.add(item);
    }
}
