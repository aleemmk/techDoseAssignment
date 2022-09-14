class MyHashMap {
    /**
       implement with array of linkedlist 
       
       initillly we have empty array of linkedlist of type HMNode.
       
       
    */

    private class HMNode{
        Integer key;
        Integer val;
        HMNode(Integer key, Integer val){
            this.key = key;
            this.val = val;
        }
    }
    
    private int size;  // total numbe rof hashmap element
    
    
    private LinkedList<HMNode> [] buckets;  // N
    
    /** this constucture start with any bucket size given (4 or anything);
    initilly each linkedlist is zero size 
    */
    public MyHashMap() {
        initBucket(4);
        size=0;
    }
    
    /**
      THis is to fill each bucket with empty linked list
    */
    private void initBucket(int N){
        
        buckets = new LinkedList[N];
        
        for(int i=0; i < buckets.length;i++){
            buckets[i] = new LinkedList<>();
        }
    }
    
    /** This is hash function which decide bucket index*/
    private int hashfn(Integer key){
        int hash = key.hashCode();
        
        return Math.abs(hash) % buckets.length;
    }
    
    /** As each bucket is having linkedlist this function return the index of key with the inked list when bucket index is given
    
    param key and bucket index
    */
  private int getIndexWithInbucket(int key ,int bi){
      
      int di = 0 ;
      
      for(HMNode node:buckets[bi]){
          if(node.key.equals(key)){
              return di;
          }
          di++;
      }
      return -1;
  }
    
    /**  this put function of hashmap*/
    public void put(Integer key, Integer val) {
        
        int bi = hashfn(key);
        
        int indexWithinbucket = getIndexWithInbucket(key,bi);
        
        if(indexWithinbucket == -1){
            HMNode node = new  HMNode(key,val);
            buckets[bi].add(node);
            size++;
        }else{
            HMNode node = buckets[bi].get(indexWithinbucket);
            node.val = val;
        }
        
        double lamda = (size * 1.0) / buckets.length;
        
        if(lamda > 2){
            rehash();
        }
        
    }
    
    /** this function is responsible to double the bucket size when (lamda > 2)
    
    lamda = curr_size_bucket(current size of map) / total declared capacity (size of buckets  arr);
    
    this function doubles size of array and put each key value new array again by hashmap put function.
    */
    private void rehash(){
        LinkedList<HMNode> [] oba = buckets;
        
        initBucket(oba.length *2);
       
        size = 0;
        
        for(int i=0;i< oba.length; i++){
            for(HMNode node:oba[i]){
                put(node.key,node.val);
            }
        }
    }
    
    /** get the value for a particular key*/
    public Integer get(Integer key) {
        int bi = hashfn(key);
        int indexWithinbucket = getIndexWithInbucket(key,bi);
        
        if(indexWithinbucket != -1){
           HMNode  node = buckets[bi].get(indexWithinbucket);
           return  node.val;
        }
        return -1;
    }
    
    /**remove particular key if exist in map */
    public void remove(Integer key) {
        int bi = hashfn(key);
      int indexWithinbucket = getIndexWithInbucket(key,bi);
        if(indexWithinbucket !=-1){
            buckets[bi].remove(indexWithinbucket);
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */