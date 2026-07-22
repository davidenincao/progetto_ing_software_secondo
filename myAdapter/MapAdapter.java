package myAdapter;

/**
 * La classe MapAdapter implementa l'interfaccia HMap sfruttando un Hashtable 
 * come struttura dati sottostante (adaptee).
 */
public class MapAdapter implements HMap {

    /**
    * {@inheritDoc}
    */
    public int size(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public boolean isEmpty(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
    * {@inheritDoc}
    */
    public boolean containsKey(Object key){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public boolean containsValue(Object value){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public Object get(Object key){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public void put(Object key, Object value){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public Object remove(Object key){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public void putAll(HMap m){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public void clear(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public HSet keySet(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public HCollection values(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public HSet entrySet(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public boolean equals(Object o){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
    * {@inheritDoc}
    */
    public int hashCode(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}