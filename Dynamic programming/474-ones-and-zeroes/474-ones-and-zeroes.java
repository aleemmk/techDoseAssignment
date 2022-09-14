class Solution {
    /**
     strs = ["10","0001","111001","1","0"], m = 5, n = 3
     
     m zeros and n 1 in the subset not in string (imp observation).
     
     for each element in input array we have two choices either include it or exclude it
     
     if we include then check how many zeros and ones, we eats up from m and n respectively .
     
     if not include just increase index and do the same .(clearly a recursive function).
     
     when recursion end ?
     
     when m ==0 && n==0 OR index==n (reach end of array)
     
     
     
    */
    public int findMaxForm(String[] strs, int m, int n) {
        // by constraints decide dp array size
        
        int dp [] [] [] = new int [strs.length+1][m+1][n+1];
        
        for(int [][] arr:dp){
            for(int [] a:arr){
                Arrays.fill(a,-1);
            }
        }
        List<int[]> list = new ArrayList<>();
       
        int i=0;
        
        for(String str:strs){
            list.add(countZeroOne(str));
        }
        
        return findMaxFormUtil(list,m,n,0,dp);
        
    }
    
    private int findMaxFormUtil( List<int[]> list, int m , int n ,int index,int dp [] [] []){
        
        if(index == list.size() || (m==0 && n==0))  return 0;
        
        
       if( dp[index][m][n] != -1) return dp[index][m][n];
            
        int count [] = list.get(index);
        
        if(count[0] > m  ||  count[1] > n)
            return dp [index] [m] [n] = findMaxFormUtil(list,m ,n,index+1,dp);
        
        int include =  1+findMaxFormUtil(list,m-count[0] ,n-count[1],index+1,dp);
        int exclude = findMaxFormUtil(list,m,n,index+1,dp);
        
         return dp[index][m][n] =  Math.max(include,exclude);
        
    }
    
    private int [] countZeroOne(String s){
        
        int count [] = new int [2];
        
        for(char c:s.toCharArray()){
            
            if(c == '0'){
                count[0]++;
            }else if(c== '1'){
                count[1]++;
            }
        }
        return count;
    } 
    
    
    
    
}