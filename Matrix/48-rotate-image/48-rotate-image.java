class Solution {
    public void rotate(int[][] matrix) {
        
        // transapose of matrix
        
        /**
           transapose of matrix
           a[i][j]    a[j][i]
           1  4 7
           2  5 8
           3  6 9
           
           swap first and last col and keep moving
           
           a[i][0] =   a[i][matix.length-1] 
        
        */
        int n = matrix.length;
        
        for(int i=0;i<n;i++){
            for(int j=i;j< n;j++){
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        /**
           transapose of matrix
           
[
[5,2,13,15],
[1,4,3,14],
[9,8,6,12],
[11,10,7,16]
]
           
           */
       for(int i=0;i<n;i++){
            for(int j=0;j <n/2;j++ ){
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
                
            }
        }
        
        
    }
}