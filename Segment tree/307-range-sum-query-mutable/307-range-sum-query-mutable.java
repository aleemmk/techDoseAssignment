/**
  Range sum query mutable (with update);
   we can slve this segment tree 
   segment tree can be represented by array . total number of node in segment tree always 
    <=  4N N is the element in the array. proof is below
    
    https://www.quora.com/Why-does-4-*-N-space-have-to-be-allocated-for-a-segment-tree-where-N-is-the-size-of-the-original-array
    
    left node of ST 2*i
    right node of ST 2*i+1
    
    i start with 1
    
    we partion the array from mid and keep of doing until single element remins (start== end)
    
    each node value of ST is equal to sum of (left node + right node). we do this recursively.
    
   
*/


class NumArray {
       
    int st [];
    int st_idx;
    int start;
    int end;
    
    public NumArray(int[] nums) {
        int n = nums.length;
        st_idx =1;
        start=0;
        end= n-1;
        st = new int[4*n+1];
        buidSegTree(st_idx,nums,0,n-1);
    }
    
    private void buidSegTree(int st_idx,int nums[] ,int start,int end){
        
        if(start > end ) return ;
           
        // leaf node of segment tree
            if(start == end) {
                st[st_idx] = nums[start];
                return ;
            }
        // INTERNAL NODE of segmant 
        int mid = start+(end-start)/2;
        
        buidSegTree(2*st_idx,nums,start,mid);
        buidSegTree(2*st_idx+1,nums,mid+1,end);
        
        st[st_idx] = st[2*st_idx]+st[2*st_idx+1];
        
    }
    
    public void update(int index, int val) {
        updateNode(st_idx,start,end,index,val);
    }
    
    private void updateNode(int st_idx,int start,int end,int pos,int newVal ){
    
        if(start > pos || end < pos) return ;  // pos lies outside the boundry
        if(start == end){
            st[st_idx] = newVal;
            return ;
        }
        int mid = start+(end-start)/2;
        updateNode(2*st_idx,start,mid,pos,newVal);
        updateNode(2*st_idx+1,mid+1,end,pos,newVal);
        
        st[st_idx] = st[2*st_idx]+st[2*st_idx+1] ;
    
    }
    
    
    public int sumRange(int left, int right) {
        return query(left,right,st_idx,start,end);
    }
    private int query(int qs,int qe,int st_idx,int start,int end){
        
        // no overlap
        if( qs > end || qe < start) return 0;
        
        /* total overlap when node range totally lies in query range
            
        1. qs             qe        (node range in between query range)
               start end
            
          2.   qs          qe      (node range in starts with query range and end before query range)
               start  end
             
            3.  qs          qe      (node range in starts inbetween query range and end at query range)
                    start  end
         **/  
        if(start >= qs && end <= qe)
            return st[st_idx];
        
        // partial overlap  
        
        int mid = start+(end-start)/2;
        int lsum = query(qs,qe,2*st_idx,start,mid);
        int rsum = query(qs,qe,2*st_idx+1,mid+1,end);
        
        return lsum+rsum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */