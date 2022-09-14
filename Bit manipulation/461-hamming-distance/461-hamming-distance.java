class Solution {
    public int hammingDistance(int x, int y) {
        
        
        // if we take XOR of two numbers then different bit will be 1 same will 0
        // this is problem is converted into counting the set bit in x ^ y
        
        int count = 0 ;
        int n = x ^ y;
        
        while(n !=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}