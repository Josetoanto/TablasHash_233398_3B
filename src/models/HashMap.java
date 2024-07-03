package models;

import java.util.ArrayList;

public class HashMap {

    private  ArrayList<Bussines>[] hashMap = new ArrayList[100];

    public void inicializar (){
        for (int i = 0; i < 100; i++) {
            hashMap[i] = new ArrayList<>();
        }
    }

    public boolean putValue(String key, Bussines bussines){
        int i = hashFunction1(key);
        return hashMap[i].add(bussines);
    }

   public Bussines searchBussines(String key){
    int index = hashFunction1(key);
        for (Bussines i: hashMap[index]){
            if (i.getId().equals(key)){
                return  i;
            }
        }
        return null;
   }

    public boolean putValue2(String key, Bussines bussines){
        int i = hashFunction2(key);
        return hashMap[i].add(bussines);
    }
    public Bussines searchBussines2(String key){
        int index = hashFunction2(key);
        for (Bussines i: hashMap[index]){
            if (i.getId().equals(key)){
                return  i;
            }
        }
        return null;
    }

    private int hashFunction1(String key) {
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            index = (index << 13) - (index >> 7) + key.charAt(i); // Rotar y sumar el valor ASCII
        }
        return Math.abs(index % 100);
    }
    private int hashFunction2(String key) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue ^= 31 * hashValue + key.charAt(i); // XOR y sumar el valor ASCII
        }

        return Math.abs(hashValue) % 100;
    }
}
