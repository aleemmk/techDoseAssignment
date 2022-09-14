class Solution {
    /**
     each number have two choices , + or - we have knapsak value is target
       nums = [1,1,1,1,1], target = 3
       (index, currSum)
        
        (0,0)
          /\
      +1 /  \-1
      (1,0+1) (1,-1)
         
     
    */
    int count=0;
    //int dp[][];
    Map<Integer,Integer> dp [] ;  // currSum and way mapping
    public int findTargetSumWays(int[] nums, int target) {
        
        int index = nums.length-1;
        int currSum = 0;
        dp = new HashMap[nums.length];
        
       // return targetSumWays1(index,nums,currSum,target);
        
         return targetSumWays2(0,nums,currSum,target);
    }
    
    
    
    //recusive with memoazied with map
    
    private int targetSumWays1(int index,int[] nums, int currSum,int target){
        // base case
    
        if(index < 0 && currSum == target)
            return 1;
        if(index < 0) return 0;
        
        Map<Integer,Integer> map = dp[index];
        
        if(map !=null && map.containsKey(currSum)) return map.get(currSum);
            
        int positive = targetSumWays1(index-1,nums,currSum+nums[index],target);
        int negative = targetSumWays1(index-1,nums,currSum+(-nums[index]),target);
        
        int ways = positive+negative;
        
        if(map == null)map = new HashMap<>(); 
        
        map.put(currSum,ways);
        dp[index] = map;
        return ways;
    }
     
    private int targetSumWays2(int index,int[] nums, int currSum,int target){
        
        if(index == nums.length) {
           if(target==currSum) return 1;
            else return 0;
        }else{
           Map<Integer,Integer> map= dp[index] ;
            if(map !=null && map.containsKey(currSum)) return map.get(currSum);
            
          int positive = targetSumWays2(index+1,nums,currSum+nums[index],target);
          int negative =targetSumWays2(index+1,nums,currSum-nums[index],target);
            
          if(map == null )map = new HashMap<>();
            
            map.put(currSum,positive+negative);
            dp[index] = map;
       
            return positive+negative;
            
        }
    } 
         
    }
