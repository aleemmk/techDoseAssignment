class Trie {
    
    
    /**
       1.We have node that have Array of size 26 alphabets and type is Node itself.
       
       when we insert a word in trie i.e "apple"
       put Node in each letter  index (a = 1 , b=2 ,c=3 ...so on z=26) so tha we can reuse when inserting new word  "ape" (i.e and p reused here)
       
       2. to know what is the end of word we just make end flag True for the node (i.e 'e' in case of above)
       
       TC
       =======
       insert and serach O(key length) word length;
       
       memory required O(26*keylength*n);
       
    */
    
    class Node{
        Node links [] = new Node [26];
        boolean end;
        
        public Node(){
            
        }
        
        boolean containsKey(char c){
            return links[c - 'a'] != null;
        }
        
        void put(char c ,Node node){
            links[c-'a'] = node;
        }
        
        Node get(char ch){
            return links[ch-'a'];
        }
        
        void setEnd(){
            end = true;
        }
        boolean isEnd(){
            return end;
        }
    }

    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        
        for(int i=0;i< word.length();i++){
            char c = word.charAt(i);
           if(!node.containsKey(c)){
               node.put(c,new Node());
           }    
           node =  node.get(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(!node.containsKey(c)) return false;
            
            node = node.get(c);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
       Node node = root;
        
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            
            if(!node.containsKey(c)) return  false;
            
            node = node.get(c);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */