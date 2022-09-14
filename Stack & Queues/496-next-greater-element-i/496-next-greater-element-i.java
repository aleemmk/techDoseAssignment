class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      /**
         [1,3, 4, 2]
          3 4 -1 -1
         calculate next greater nge arr[] .
         more intutive way is to iterate from right to left , pop all element from statck untill 
         we get an element less the the current arr[i] .
         
         if stack is empty means no element is grater than arr[i] put -1 in result.
         else current top of stack is next greater element store in result.
         
         use hash map to store elemt as key and next greater as value.
         
         */
        int n = nums2.length;
        int [] nge = new int[n];

        Stack<Integer> stack = new Stack();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=n-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
                int nxtgrt = 0;
                if(!stack.isEmpty())  
                    nxtgrt=stack.peek();
                else
                    nxtgrt=-1;
                
               map.put(nums2[i],nxtgrt);
            
              stack.push(nums2[i]);
        }
        System.out.println(Arrays.toString(nge));
        int res [] = new int[nums1.length];
        int i=0;
        for(int num:nums1){
            res[i++] =map.get(num);
        }

        return res;
    }
}