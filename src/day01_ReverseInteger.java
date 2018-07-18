/*
*Reverse digits of an integer.
*Example1: x = 123, return 321 
*Example2: x = -123, return -321
*/


public class Solution {
    public int reverseInteger(int x) {
        int res = 0; 
        while (x != 0) {
            int temp = res * 10 + x % 10;
            x = x / 10; //不断取前几位
            if (temp / 10 != res) {
                res = 0;
                break;
            }
            res = temp;
        }
        return res;
    }
}
