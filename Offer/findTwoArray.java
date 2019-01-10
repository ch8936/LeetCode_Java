public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array.length==0 || array[0].length==0)
            return false;
        int m = array[0].length-1;
        int n = 0;
        int temp = array[n][m];
        while(target != temp){
            if(m>0 && n<array.length-1){
                if(target>temp){
                    n = n + 1;
                }else if(target<temp){
                    m = m - 1;
                }
                temp = array[n][m];
            }else{
                return false;
            }
        }
        return true;
    }
}
