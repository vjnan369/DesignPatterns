package com.MachineCoding.HashMap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CustomHashMap<K, V> {
    static final int MAXIMUM_CAPACITY = 1<<30;
    static final float LOAD_FACTOR = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_CAPACITY = 64;

    static class Entry<K, V>{
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Entry<K, V>[] table;
    static final int DEFAULT_INITIAL_CAPACITY = 1<<4; // 16

    public CustomHashMap(){
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    public void put(K key, V value){
        if(key == null){
            return;
        }
        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<K, V>(key, value, null);
        if(table[hash] == null){
            table[hash] = newEntry;
        } else {
            Entry<K, V> current = table[hash];
            Entry<K, V> previous = null;
            while(current != null){
                if(current.key.equals(key)){
                    if(previous == null){
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            previous.next = newEntry;
        }
        return;
    }

    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while(temp != null){
                if(temp.key.equals(key)){
                    return temp.value;
                } else {
                    temp = temp.next;
                }
            }
            return null;
        }
    }

    public boolean remove(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return false;
        }
        Entry<K, V> current = table[hash];
        Entry<K, V> previous = null;
        while(current != null){
            if(current.key.equals(key)){
                if(previous == null){
                    table[hash] = current.next;
                    return true;
                } else {
                    previous.next = current.next;
                    return  true;
                }
            } else {
                previous = current;
                current = current.next;
            }
        }
        return false;
    }

    public void display(){
        for(int i=0; i<DEFAULT_INITIAL_CAPACITY; i++){
            if(table[i] != null){
                Entry<K, V> entry = table[i];
                while(entry != null){
                    System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
                    entry = entry.next;
                }
            }
        }
        System.out.println();
    }


    private int hash(K key){
        return Math.abs(key.hashCode())%DEFAULT_INITIAL_CAPACITY;
    }
}

class Main{
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.display();
        map.put("Jnan", 1);
        map.put("Sand", 3);
        map.display();
        System.out.println(map.get("Sand"));
        System.out.println(map.get("sdf"));
        System.out.println(map.remove("Sand"));
        map.display();
        System.out.println("=====Integer HashMap======");
        CustomHashMap<Integer, Integer> map2 = new CustomHashMap<>();
        map2.put(4, 1); map2.put(13, 1); map2.put(14, 2);
        map2.display();
        System.out.println(map2.get(13));
        map2.put(4, 11);
        map2.display();
    }
}

