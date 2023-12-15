package newjavaprograms.listiteratorimplementation;

import java.util.*;

public class IntArrayList<T> implements List<T>{
    T[] array = (T[])new Object[10];
    int lastIndex = 0;
    int length = array.length;

    @Override
    public boolean add(T number){
        if(lastIndex >= array.length){
          increaseSize();
        }
        array[lastIndex] = number;
        lastIndex++;
        return true;
    }

    public void increaseSize(){
        T[] substituteArray =(T[]) new Object[array.length];
        System.arraycopy(array,0,substituteArray,0,array.length);
        length = array.length * 2;
        array =(T[]) new Object[length];
        System.arraycopy(substituteArray,0,array,0,substituteArray.length);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(T element: array){
            if(o.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIteratorDemo();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, lastIndex);
    }

    @Override
    public boolean remove(Object o) {
        for(int i=0; i<lastIndex; i++){
            if(o.equals(array[i])){
                return arrayShiftLeft(i);
            }
        }
        return false;
    }

    public boolean arrayShiftLeft(int index){
        T[] substituteArray =(T[]) new Object[array.length];
        System.arraycopy(array, 0, substituteArray, 0, index);
        for(int i=index+1; i<=lastIndex; i++){
            substituteArray[i-1] = array[i];
        }
        System.arraycopy(substituteArray,0, array, 0, array.length);
        lastIndex--;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Iterator<T> newDataSet = c.iterator();
        boolean added = false;
        while(newDataSet.hasNext()){
            added = true;
            add(newDataSet.next());
        }
        return added;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Iterator<T> newDataSet = c.iterator();
        boolean added = false;
        while(newDataSet.hasNext()){
            added = true;
            add(index,newDataSet.next());
            index++;
        }
        return added;
    }

    @Override
    public void clear() {
        array = (T[])new Object[10];
        lastIndex = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        T[] temporaryArray = (T[]) new Object[array.length];
        boolean retained = false;
        int index = 0;
        for(int i=0;i<lastIndex;i++){
            Iterator<T> newDataSet = c.iterator();
            while(newDataSet.hasNext()){
                T element = newDataSet.next();
                if(array[i].equals(element)){
                    retained = true;
                    temporaryArray[index]=element;
                    index++;
                }
            }
        }
        if(retained){
            System.arraycopy(temporaryArray,0,array,0,temporaryArray.length);
            lastIndex = index;
        }
        return retained;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean removed = false;

        Iterator<T> newDataSet = c.iterator();
        while(newDataSet.hasNext()){
            T element = newDataSet.next();
            while(contains(element)){
                remove(element);
                removed=true;
            }
        }

        return removed;
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator<T> newDataSet = c.iterator();
        boolean containsAllItem = true;
        while(newDataSet.hasNext()){
            T element = newDataSet.next();
            if(!contains(element)){
                containsAllItem = false;
                break;
            }
        }
        return containsAllItem;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public T get(int index){
        return array[index];
    }

    @Override
    public Object set(int index, Object element) {
        T temp = array[index];
        array[index] =(T) element;
        return temp;
    }

    @Override
    public void add(int index, Object element) {
        if(index+1 == lastIndex){
            T temp1 = array[index];
            set(index,element);
            add(temp1);
        }else {
            T temp1 = array[index];
            T temp2 = null;
            set(index, element);
            for (int i = index + 1; i < lastIndex; i++) {
                temp2 = array[i];
                set(i, temp1);
                temp1 = temp2;
            }
            add(temp2);
        }
    }

    @Override
    public T remove(int index) {
        T value = array[index];
        arrayShiftLeft(index);
        return value;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0; i<lastIndex; i++){
            if(o.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i=lastIndex-1; i>=0; i--){
            if(o.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator listIterator() {
        return new ArrayListIteratorDemo(-1);
    }

    @Override
    public ListIterator listIterator(int index) {
        return new ArrayListIteratorDemo(index);
    }


    public class ArrayIteratorDemo implements Iterator<T> {

        int pointerIndex = -1;
        int lastElement;

        ArrayIteratorDemo(){}

        public boolean hasNext(){
            if(pointerIndex+1 < lastIndex){
                return true;
            }
            return false;
        }

        public T next(){
            pointerIndex++;
            lastElement = pointerIndex;
            return (T)array[pointerIndex];
        }

        public void remove(){
            array[lastElement] = null;
            arrayShiftLeft(pointerIndex+1);
        }

        public void display(){
            for(T i: array){
                System.out.println(i);
            }
        }

        public void arrayLength(){
            System.out.println(array.length);
        }

    }

    public class ArrayListIteratorDemo extends ArrayIteratorDemo implements ListIterator<T>{
        public ArrayListIteratorDemo(int index) {
            super();
            pointerIndex = index;
        }

        public boolean hasPrevious(){
            if(pointerIndex-1 >= -1){
                return true;
            }
            return false;
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
            return array[pointerIndex+1];
        }

        public int previousIndex(){
            if(hasPrevious()){
                return pointerIndex;
            }
            return -1;
        }

        @Override
        public void set(T t) {
            array[lastElement] = t;
        }

        @Override
        public void add(T t) {
            if(lastIndex >= array.length - 1){
                increaseSize();
            }
            array[lastIndex+1] = t;
            lastIndex++;

        }

        private void increaseSize(){
            T[] temporaryArray =(T[]) new Object[array.length];
            System.arraycopy(array,0, temporaryArray,0,array.length);
            array =(T[]) new Object[array.length * 2];
            System.arraycopy(temporaryArray,0, array,0, temporaryArray.length);
        }

    }


}

