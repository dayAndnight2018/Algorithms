//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）

public class Solution {
    public int Sum_Solution(int n) {       
         int res = n; 
         //利用&&的特性，前面不成立后面就不执行了
         boolean flag = (n>0)&&((res+=Sum_Solution(n-1))>0); 
         return res; 
    }
}
