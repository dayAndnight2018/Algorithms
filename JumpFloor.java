/*
 * 跳台阶，一次可以跳1阶或2阶
 *把问题抽象成函数f(n) 
 * 如果第一次跳一阶，那么剩下n-1阶变成f(n-1),如果跳2阶，变成f(n-2)
 * 分类加法原则f(n-1)+f(n-2)
 * 
 */
public class JumpFloor {

	// 就是直接求斐波那契数列
	public int jump(int target) {
		if (target == 1 || target == 2) {
			return target;
		}

		return jump(target - 1) + jump(target - 2);
	}
	
	//从底部开始向上累加的方法，减少重复
	public int jump2(int target) {

		if (target == 1 || target == 2) {
			return target;
		}

		int jump1 = 1;
		int jump2 = 2;
		int jumpN = 0;

		for (int i = 3; i <= target; i++) {
			jumpN = jump1 + jump2;

			jump1 = jump2;
			jump2 = jumpN;
		}

		return jumpN;
	}
}
