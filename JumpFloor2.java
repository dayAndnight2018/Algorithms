/*
 * 跳台阶，一次可以跳1阶或2阶···或n阶，一个多少种？
 *把问题抽象成函数f(n) 
 * 如果第一次跳一阶，那么剩下n-1阶变成f(n-1),如果跳2阶，变成f(n-2)···第一次跳n阶变成f(0)
 * 分类加法原则f(n-1)+f(n-2)+···+f(0)
 * 
 */
public class JumpFloor2 {

	// 就是直接求斐波那契数列
	public int jump(int target) {
		if (target == 1 || target == 0) {
			return 1;
		}

		int result = 0;
		for(int i = 0; i <= target -1; i++) {
			result += jump(target -1 - i);
		}
		
		return result;
	}
	
	/*
	 * 使用分析的方法发现，f(n) = f(n-1)+f(n-2)···+f(0)
	 * 已知f(n-1) = f(n-2)+f(n-3)+···+f(0)
	 * 则f(n) = f(n-1)+f(n-1)
	 * f(n) = 2*f(n-1) = 2^(n-1)
	 * 
	 * 
	 */
	public int jump2(int target) {

		if (target == 1 || target == 0) {
			return 1;
		}
		
		int result = 1;
		for (int i = 1; i <= target -1; i++) {
			result *= 2;
		}

		return result;
	}
	
	public static void main(String [] args) {
		JumpFloor2 jump = new JumpFloor2();
		System.out.println(jump.jump2(10));
	}
}
