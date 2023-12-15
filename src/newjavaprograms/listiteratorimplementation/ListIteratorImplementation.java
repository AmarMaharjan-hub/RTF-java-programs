package newjavaprograms.listiteratorimplementation;

import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorImplementation<T> implements ListIterator<T> {

    T[] list;
    private int pointerIndex = -1;

    private int lastIndex;

    private int lastElement;

    public ListIteratorImplementation(T[] newArray){
//        list = new int[newArray.length];
        list =(T[]) new Object[newArray.length];
        System.arraycopy(newArray,0, list, 0, newArray.length);
        lastIndex = newArray.length - 1;
    }

    public boolean hasNext(){
        if(pointerIndex+1 < lastIndex+1){
            return true;
        }
        return false;
    }

    public boolean hasPrevious(){
        if(pointerIndex-1 >= -1){
            return true;
        }
        return false;
    }

    public T next(){
        pointerIndex++;
        lastElement = pointerIndex;
        return list[pointerIndex];
    }

    public int nextIndex(){
        if(hasNext()){
            return pointerIndex+1;
        }
        return -1;
    }

    public T previous(){
        pointerIndex--;
        lastElement = pointerIndex+1;
        return list[pointerIndex+1];
    }

    public int previousIndex(){
        if(hasPrevious()){
            return pointerIndex;
        }
        return -1;
    }

    public void remove(){
        list[lastElement].equals(0);
    }

    @Override
    public void set(T t) {
        list[lastElement] = t;
    }

    @Override
    public void add(T item) {
        if(lastIndex >= list.length - 1){
            increaseSize();
        }
        list[lastIndex+1] = item;
        lastIndex++;

    }

    private void increaseSize(){
        T[] temporaryArray =(T[]) new Object[list.length];
        System.arraycopy(list,0, temporaryArray,0,list.length);
        list =(T[]) new Object[list.length * 2];
        System.arraycopy(temporaryArray,0, list,0, temporaryArray.length);
    }

    public void display(){
        for(T i: list){
            System.out.println(i);
        }
    }
    public void llength(){
        System.out.println(list.length);
    }


}
