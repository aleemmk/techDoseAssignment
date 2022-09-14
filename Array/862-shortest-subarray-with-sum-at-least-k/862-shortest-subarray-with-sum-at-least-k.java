class Solution {
    
    /*More Similar Sliding Window Problems

 Sliding window:

1248:Count Number of Nice Subarrays
1234:Replace the Substring for Balanced String
1004:Max Consecutive Ones III
930:Binary Subarrays With Sum
992:Subarrays with K Different Integers
904:Fruit Into Baskets
862:Shortest Subarray with Sum at Least K
209:Minimum Size Subarray Sum*/
    
    /**
    This problem is extension of 209. Minimum Size Subarray Sum 
    209 can be solved by twopinter sliding window
    
    here difference is array may have negative values.
    
    why not sliding window again ?
    
    because due to netaive values the cumuative sum is not not monotinically increasing .
    so we need to use deque here . we can make it monotonically increading from popping it back.
    
    STEP 1. 
    calculate cumulative sum if sum >=k window length is i+1;
    
    STEP 2: compress the window size , remove dq front (cumulative sum, index)
     keep doing untill (sum-front cmm sum) >=k
     
     STEP 3:
     make deque monotonically increasing by cheking back cumm. sum  
     kepp removing untill queue empty or got val at top <= curr index cumative sum
    
    
    
    
    */
    public int shortestSubarray1(int[] A, int K) {
        int N = A.length, res = N + 1;
        long[] B = new long[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] = B[i] + A[i];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >=  K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
    public int shortestSubarray(int[] nums, int k) {
     
        int n = nums.length;
        long sum[] = new long [n+1];  // take long for prefix sum ,out for one test cases.
        Deque<Integer> dq = new ArrayDeque<>();
       // int curr= Integer.MIN_VALUE;
        //sum[0] = nums[0];
        int winlen=n+1;
        
        for(int i=0;i<n;i++){
            sum[i+1] = sum[i]+nums[i];
        }
        
        for(int i=0;i < n+1;i++){
            
            //sum[i] = sum[i-1]+ nums[i];
            
          //  if(sum[i] >= k) winlen = Math.min(i+1,winlen);
            
            // compress window length
            
            while(!dq.isEmpty() && sum[i] - sum[dq.peekFirst()] >= k){
                winlen = Math.min(i-dq.pollFirst(),winlen);
            }
            
            /*if(curr !=Integer.MIN_VALUE){
                winlen = Math.min(i-curr,winlen);
            }*/
            
            // monotonically increasing
            
            while(!dq.isEmpty() && sum[dq.peekLast()] >= sum[i] ){
               dq.pollLast();
                
            }
            dq.offer(i);
            
        }
        return winlen <= n ? winlen:-1;
        
    }
  
}
