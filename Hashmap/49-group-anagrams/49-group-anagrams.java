class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        
        Map< Map<Character,Integer>, List<String> > bigMap = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            Map<Character,Integer> fm = getFrequecyMap(arr[i]);
         
            if(!bigMap.containsKey(fm))bigMap.put(fm,new ArrayList());
            
            bigMap.get(fm).add(arr[i]);
         }
   
        return new ArrayList<>(bigMap.values());
        }
    
    private Map<Character,Integer> getFrequecyMap(String s){
             Map<Character , Integer> map = new HashMap<>();
        
        for(Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        return map;
     }
}