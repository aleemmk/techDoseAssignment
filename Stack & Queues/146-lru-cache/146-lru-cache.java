class LRUCache {
    
    /**
      Approach 1:
      
      we need DLL and HashMap<Integer,Node> 
      
           DLL
      
   HEAD -------  TAIL
   
      --------
      | KEY   |
      | Value |
      |(3,15) |
      ----------
        Node dllNode
      
      |           |
      |           |
      |(3,dllNode)|
      | key,Node  |
      |__________ |
        
         Map
      
      LRU element is just before tail. when a new element added it is added right after head.
      
      first check key is exist in map if not, check size if(size <capacity) inset the key and its node address in map
      
      insert node right after head.
      
      if size > capacity remove LRU (it is just before tail) and remove it from map .
      
      add new element right after head and add in map too.
    */
    
    Node head=new Node(0,0);;
    Node tail=new Node(0,0);;
    int capacity;
    
    Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail; 
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        
        remove(node);
        insert(node);
        
        return node.val;
        
     }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() ==  capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    
    private void remove(Node node){
        
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node){
     
        map.put(node.key,node);
        
        node.next = head.next;
        node.next.prev= node;
        head.next = node;
        node.prev = head;
    }
    
  class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */