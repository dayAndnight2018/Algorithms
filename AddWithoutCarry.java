public class Solution {
    public int Add(int num1,int num2) {
        int sum,carry;
        do{
            sum = num1 ^ num2; //不进位加法
            carry=(num1 & num2)<<1; //左移
            num1 = sum; //累积上次结果
            num2 = carry; //新的位
        }while(num2 != 0); //循环一遍了
        return sum; //结束
    }
}
