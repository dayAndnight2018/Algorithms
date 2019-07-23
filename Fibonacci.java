/*
 * 
 * 求指定第N个斐波那契数
 * 
 */
public class Fibonacci {
	
	//方法一：采用递归的方法，方法简单但是太慢
	public int fib(int n) {
		
		if(n == 0 || n == 1) {
			return n;
		}
		
		return fib(n-1) + fib(n-2);
	}
	
	//方法二：从小往上依次归纳法，比递归节省很多多余的计算
	public int fib2(int n) {
		if(n == 0 || n == 1)
        {
            return n;
        }   
		
        int low = 0;
        int high = 1;
        int result = 0;
        for(int i =2; i<= n; i++){
            result = low + high;
            low = high;
            high = result;
        }
        return result;
	}
}
