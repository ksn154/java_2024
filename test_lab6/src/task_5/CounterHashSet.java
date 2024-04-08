package task_5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CounterHashSet extends HashSet<Integer> {
    private int count;

    public CounterHashSet() {
        super();
        count = 0;
    }

    @Override
    public boolean add(Integer element) {
        count++;
        return super.add(element);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        return super.addAll(collection);
    }

    public int getCount() {
        return count;
    }
}

class Main {
    public static void main(String[] args) {

        CounterHashSet set = new CounterHashSet();

        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Număr elemente: " + set.getCount());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);

        set.addAll(list);

        System.out.println("Număr elemente: " + set.getCount());

        System.out.println(set); // Afișează [1, 2, 3, 4, 5, 6]
    }
}
