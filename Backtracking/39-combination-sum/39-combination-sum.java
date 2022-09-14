class Solution {
    
    /**             0 1 2 3
      candidates = [2,3,6,7], target = 7
      
      same number can be chosen multiple times.
      
                   f(0,7,[])
     pick2         /\
               f(0,5,[2])
     pick2      /       
              f(0,3,[2,2])
     pick2     /
            f(0,1,[2,2,2])
            /  \ not pick 2
           X    f(1,1,[2,2,3])
    (can't pick 2 further 2 > target)
    
    we keep on doing and back track by removing from list.
   
   
     TC 
     T is larget length 
     k is the average length of each combination generated.
      2 ^ T * k
   */
   List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       res = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
         findCombination(0,candidates,target,list);
        
        return res;
    }
    
    private void findCombination(int start,int [] candidates,int target,List<Integer> list){
        if(start == candidates.length){
           
            if(target == 0)
                 res.add(new ArrayList<>(list));
               
            return;
        }
        
        // picked
        if(target >= candidates[start] ){
            // if we pick the candidate we stay on same index.
            list.add(candidates[start]);
            findCombination(start,candidates,target-candidates[start],list);
            list.remove(list.size()-1);
        }
        // not picked
        findCombination(start+1,candidates,target,list);
        
    }
    
    /*
      can also be written in this way also 
      
    private void findCombination(int start,int [] candidates,int target,List<Integer> list){
        
        if(target < 0) return ;
        
       else if(target == 0){
                 res.add(new ArrayList<>(list));
               return;
       }else{
           for(int i = start;i<candidates.length;i++){
             list.add(candidates[i]);
            findCombination(i,candidates,target-candidates[i],list);
            list.remove(list.size()-1);
           }
       }
        
    }*/
}