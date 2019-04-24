package coll.MapSet;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class MapSet<K, V> extends AbstractMap<K, HashSet<V>> implements Iterable<V> {

    private AbstractMap<K, HashSet<V>> map;

    public MapSet (){
        map = new HashMap<>();
    }

    public void addValue(K key, V value){
        if (map.get(key) != null){
            map.get(key).add(value);
        } else{
            HashSet<V> hashSet = new HashSet<>();
            hashSet.add(value);
            map.put(key, hashSet);
        }
    }

    @Override
    public Set<Entry<K, HashSet<V>>> entrySet(){
        Set<Entry<K, HashSet<V>>> set = new HashSet<>();
        for (K key : map.keySet()){
            Entry<K, HashSet<V>> entry = new SimpleEntry<>(key, map.get(key));
            set.add(entry);
        }
        return set;
    }

    //HELPER FUNCTIONS
    List<V> orderMap(AbstractMap<K, HashSet<V>> currentMap){
        HashMap<K, Integer> sizeMap = new HashMap<>();
        for (K key : currentMap.keySet()){
            HashSet<V> values = currentMap.get(key);
            sizeMap.put(key, values.size());
        }

        LinkedHashMap<K, Integer> reverseSortedMap = new LinkedHashMap<>();
        sizeMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

//        Map sortedSizeMap = sizeMap.entrySet().stream()
//                .sorted(comparingByValue().reversed())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);

        List<V> orderedList = new ArrayList<V>();
        for (Object key : reverseSortedMap.keySet()){
            HashSet<V> values = currentMap.get(key);
            for (V value : values){
                orderedList.add(value);
            }
        }

        return orderedList;
    }
    //

    public Iterator<V> iterator(){
        List<V> list = orderMap(map);
        return list.iterator();
    }
}
