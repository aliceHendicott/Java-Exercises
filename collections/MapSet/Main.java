package coll.MapSet;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MapSet<String, Integer> map = new MapSet<>();
        map.addValue("B", 4);
        map.addValue("A", 0);
        map.addValue("A", 1);
        map.addValue("B", 3);
        map.addValue("A", 2);
        map.addValue("B", 6);
        map.addValue("B", 1);

        Iterator iterator = map.iterator();

        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }

}
