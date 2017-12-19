package com.efimenko.list;

/**
 * Created by oiefymenko on 09/12/2015.
 */
public class ArrayList implements List{

    protected Object[] array;
    protected int last;

    protected void extend(int position) {
        Object[] newArray;
        int newSize;
        //need to add new element in the full array or need add value to the index out of bound
        if (array.length == last+1 || position>array.length) {
            //max
            newSize = (position+1 > array.length) ? position+1 : array.length;
            //new size will be 50% more
            newSize = (int)Math.ceil(newSize* 1.5);
            //extend array
            newArray = new Object[newSize];
            //copy all data to the new one
            for (int i = 0; i<=last; i++) {
                newArray[i]=array[i];
            }
            array = newArray;
        }

    }

    public ArrayList() {
        array = new Object[1];
        last = -1;
    }

    @Override
    public void add(Object value) {
        add(last+1, value);
    }

    @Override
    public void add(int index, Object value) {
        extend(index);

        //insert position before last inserted element
        if (index<=last) {
            //Shifts elements that have indexes bigger than insert position
            for (int i=last; i>=index; i--) {
                array[i+1]=array[i];
            }
            last++;
        }
        else {
            last = index;
        }

        array[index] = value;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object remove(int index) {
        Object returnObject = array[index];
        //Shifts elements
        for (int i=index; i<=last; i++) {
            array[i]=array[i+1];
            array[last]=null;
            last--;
        }
        return returnObject;
    }

    @Override
    public int indexOf(Object value) {
        int index = -1;
        for (int i=0; i<=last; i++) {
            if (value.equals(this.get(i))) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object value) {
        int index = -1;
        for (int i=last; i>=0; i--) {
            if (value.equals(this.get(i))) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void clear() {
        for (int i=0; i<=last; i++) {
            array[i]=null;
        }
        last=-1;
    }

    @Override
    public void set(int index, Object value) {
        extend(index);
        array[index]=value;
    }

    @Override
    public int size() {
        return last+1;
    }

    @Override
    public boolean isEmpty() {
        if (last<0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean contains(Object value) {
        for (int i=0; i<=last; i++) {
            if (value.equals(this.get(i))) {
                return true;
            }
        }
        return false;
    }
}
