package myAdapter;

/**
 * La classe MapAdapter implementa l'interfaccia HMap sfruttando un Hashtable 
 * come struttura dati sottostante (adaptee).
 */
public class MapAdapter implements HMap {

    public int size(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEmpty(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean containsKey(Object key){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean containsValue(Object value){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object get(Object key){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void put(Object key, Object value){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object remove(Object key){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void putAll(HMap m){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clear(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HSet keySet(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HCollection values(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HSet entrySet(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean equals(Object o){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int hashCode(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}