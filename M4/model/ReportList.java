package model;

/**
 * Created by Brandon on 10/12/16.
 */

import javafx.collections.ObservableListBase;
import java.util.ArrayList;

public class ReportList<T> extends ObservableListBase<T> {

    private ArrayList<T> back;

    /**
     * Constructor for a ReportList
     */
    public ReportList() {
        back = new ArrayList<T>();
    }

    /**
     * Returns the size of a ReportList
     * @return size of a ReportList
     */
    public int size() {
        return back.size();
    }

    /**
     * Gets the report at index index in the ReportList
     * @param index index of desired element.
     * @return item at index index
     */
    public T get(int index) {
        return back.get(index);
    }

    /**
     * Adds item to the ReportList
     * @param item item to be added to the ReportList
     * @return whether or not the item was added
     */
    public boolean add(T item) {
        return back.add(item);
    }
}
