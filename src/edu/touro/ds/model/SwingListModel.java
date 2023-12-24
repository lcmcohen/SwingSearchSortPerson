package edu.touro.ds.model;

import javax.swing.*;
import java.util.List;

/**
 * A List Data Model that can be used as a swing-aware container for a list of Persons.
 * Provides necessary Swing actions for our list of Persons/Students.
 */
public class SwingListModel<E> extends AbstractListModel<E> {
    protected List<E> list;

    public SwingListModel(List<E> list) {
        this.list = list;
    }

    /**
     * Add an element to our list, and notify Swing that Model has changed.
     *
     * @param element Element to be added
     */
    public void addElement(E element) {
        list.add(element);
        int index = list.size();
        fireContentsChanged(element, index, index);
    }

    /**
     * Notify Swing that all of data has been changed.
     */
    public void fireDataChanged() {
        int index = list.size();
        fireContentsChanged(list.get(index - 1), index, index);
    }

    public int getSize() {
        return list.size();
    }

    public E getElementAt(int index) {
        return list.get(index);
    }
}