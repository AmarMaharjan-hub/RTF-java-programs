package newjavaprograms.listiteratorimplementation;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public class ListUser {
    public static void main(String[] args) {

        ListUser use = new ListUser();

        IntArrayList<Integer> object1 = new IntArrayList<>();
        for(int i=0; i<10; i++){
            object1.add(i);
        }
        object1.add(3);
        object1.add(45);
        object1.add(5);
        object1.add(2);
        object1.add(83);
        object1.add(29);
        object1.add(75);
        object1.add(42);



        System.out.println("Displaying the array list:");
        use.displayList(object1);


        HashSet<Integer> set = new HashSet<>();
//        ArrayList<Integer> set = new ArrayList<>();
//        IntArrayList<Integer> set = new IntArrayList<>();
        set.add(56);
        set.add(67);
        set.add(5);
        object1.addAll(set);
        System.out.println("Using addAll(Collection c): {56,67,5}");
        use.displayList(object1);

        System.out.println("Using addAll(index, Collection c): 2,{56,67,5}");
        object1.addAll(2,set);
        use.displayList(object1);


        object1.retainAll(set);
        System.out.println("Using retain(Collection): {56,67,5}");
        use.displayList(object1);

        ArrayList<Integer> remover = new ArrayList<>();
        remover.add(4);
        remover.add(54);
        remover.add(5);
        object1.removeAll(remover);
        System.out.println("Using removeAll(Collection): {4,54,5}");
        use.displayList(object1);

        System.out.println("Using containsAll(Collection c): {4,54,1}");
        System.out.println(object1.containsAll(remover));

        System.out.println("Using remove(Object o): 3");
        System.out.println("removed: " + object1.remove((Integer)3));

        System.out.println("Using remove(int index): 2");
        System.out.println("removed:" + object1.remove(2));

        object1.set(2,(Integer) 99);
        System.out.println("Using set(int index, Object o): 2,99");
        use.displayList(object1);

        object1.add(2, 44);
        System.out.println("Using add(int index, Object o): 2,44");
        use.displayList(object1);

        System.out.println("Using indexOf(Object o): 453");
        System.out.println(object1.indexOf((Integer) 453));

        System.out.println("Using lastIndexOf(Object o): 44");
        System.out.println(object1.lastIndexOf( 44));
        System.out.println("List at the end:");
        use.displayList(object1);


        System.out.println("\n\n\n");
//        Both works.
//        IntArrayList.ArrayListIteratorDemo list = (IntArrayList.ArrayListIteratorDemo) object1.listIterator();
        ListIterator list = object1.listIterator();

        while(list.hasNext()){
            System.out.println(list.next() + ", nextIndex: " + list.nextIndex());
            if(list.nextIndex() == 3){
                list.set(77);
            }
        }

        System.out.println("\n\n");

        while(list.hasPrevious()){
            System.out.println(list.previous() + ", previousIndex: " + list.previousIndex());
            if(list.previousIndex() == 0){
                list.remove();
            }
        }
        for(int i=0; i<5; i++){
            list.add(i+55);
        }
        System.out.println("\n\n");
        while(list.hasNext()){
            System.out.println(list.next());
        }

        System.out.print("\n\n\nClearing the list...\nList: ");
        object1.clear();
        use.displayList(object1);
    }

    public void displayList(IntArrayList list){
//        Both works
//        IntArrayList.ArrayIteratorDemo iterator = (IntArrayList.ArrayIteratorDemo) list.iterator();
        Iterator iterator = list.iterator();
        if(!iterator.hasNext()){
            System.out.println("List is empty!!!");
        }
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
        System.out.println("\n");
    }
}
