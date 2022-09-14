class Solution {
    /**
    recusion with backtracking 
    
               1 2 3
                /  \  \
               /    \  \    swap 1 with 3  3 2 1
swap 1 with 1 /      \ swap 1<->2
           1 2 3      2 1 3  
           
         1 is fixed keep doing on 23
          2 is fixed keep doing on 13
           3 is fixed keep doing on 21
           
           and the end of recusion we back track so that again 123 construct
           
        TC
        O(time to print one permutation * number of permutaion)
        O(n * n!)
    */
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res =  new ArrayList<>();
        int start=0;
        int end = nums.length;
        permuteUtil(nums,res,start,end);
        return res;
    }
    
    private void permuteUtil(int nums[] , List<List<Integer>> res ,int start,int end){
        
        if(start == end){
            res.add(convertArrayToList(nums));
        }
        for(int i=start;i<end;i++){
            swap(nums,start,i);   
            permuteUtil(nums,res,start+1,end);
            swap(nums,start,i); // back track
            
        }
    }
    
     public int [] swap(int arr[] ,int start, int end){
	        int temp = arr[start];
	        arr[start] = arr[end];
	        arr[end] = temp;
	        
	        return arr;
	    }
    
       public  List<Integer> convertArrayToList(int array[]) { 
        List<Integer> list = new ArrayList<>(); 
        for (int t : array) list.add(t);
        return list; 
    } 
}