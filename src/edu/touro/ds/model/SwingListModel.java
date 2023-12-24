package edu.touro.ds.model;

import javax.swing.*;
import java.util.Collection;
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
     * Add a collection of elements to our list, and notify Swing that Model has changed.
     *
     * @param elements Element to be added
     */
    public void addElements(Collection<E> elements) {
        list.addAll(elements);
        int index = list.size();
        fireContentsChanged(this, 0, index);
    }
    /**
     * Notify Swing that all of the data has been changed.
     */
    public void fireDataChanged() {
        int index = list.size();
        fireContentsChanged(this, 0, index);
    }

    public int getSize() {
        return list.size();
    }

    public E getElementAt(int index) {
        return list.get(index);
    }
}