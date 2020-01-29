package hash;


public class HashTable<K, V> {
    private static final int DEFAULT_INIT_CAPACITY = 8;
    private static final float LOAD_FACTOR = 0.75f;
    private Entry<K, V>[] table;

    private int size = 0; //实际元素数量
    private int use = 0; //散列表索引数量

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashTable() {
        this.table = new Entry[DEFAULT_INIT_CAPACITY];
    }

    public void put(K key, V value) {
        int index = hash(key);
        System.out.println("index is : " + index);
        if(table[index] == null) {
            table[index] = new Entry<>(key, value, null);
            size++; //这个不要忘记
            use++; //这个不要忘记
            if(use >= LOAD_FACTOR * table.length) {
                resize();
            }
        } else {
            Entry head = table[index];
            Entry tmp = head;
            while (tmp != null) {
                if(tmp.key == key) {
                    tmp.value = value;
                    return;
                }
                tmp = tmp.next;
            }

            table[index] = new Entry<>(key, value, head);
            size++;
        }
    }

    private int hash(K key) {
        int h = key.hashCode();
        return (key == null) ? 0 : (h ^ (h >>> 16)) % table.length;
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        Entry<K, V>[] table = new Entry[oldTable.length * 2];
        use = 0;
        for(int i = 0; i < oldTable.length; i++) {
            if(oldTable[i] == null) {
                continue;
            } else {
                Entry<K,V> tmp = oldTable[i];
                while (tmp != null) {
                    int index = hash(tmp.key);
                    if(table[index] == null) {
                        table[index] = new Entry<>(tmp.key, tmp.value, null);
                        use++;
                    } else {
                        table[index] = new Entry<>(tmp.key, tmp.value, table[index]);
                    }
                    tmp = tmp.next;
                }
            }

        }

    }

    public V get(K key) {
        int index = hash(key);
        if(table[index] == null) return null;
        Entry<K,V> tmp = table[index];
        while (tmp != null) {
            if(tmp.key == key) {
                return tmp.value;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if(table[index] == null) return;

        if(table[index].key == key) {
            table[index] = table[index].next;
            size--;
        } else {
            Entry<K, V> tmp = table[index];
            Entry<K, V> prev = tmp;
            while (tmp != null) {
                if (tmp.key == key) {
                    break;
                }
                prev = tmp;
                tmp = tmp.next;
            }

            if (tmp == null) return;

            prev.next = tmp.next;
            tmp = null;
            size--;
        }

        if(table[index] == null) {
            use--;
        }

    }

    public static void main(String[] args) {
        HashTable<Integer, Integer> hashTable = new HashTable<>();
        hashTable.put(1, 1);
        hashTable.put(1, 2);
        hashTable.put(2, 3);
        hashTable.put(3, 4);
        hashTable.put(4, 5);
        hashTable.put(5, 6);
        hashTable.put(7, 8);
        hashTable.put(8, 9);
        hashTable.put(9, 10);
//        hashTable.remove(1);
//        hashTable.remove(3);
//        hashTable.remove(9);

        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(3));
        System.out.println(hashTable.get(9));
    }

}
