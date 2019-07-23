
/**
 * 
 * 统计1的个数，输入n，计算二进制n中1的个数
 * @author Administrator
 *
 */
public class Count1 {
	
	//对数字先用1相与，得到是否是1的结果，然后左移得到2，再左移得到4，直到32次，得到0
	public  int NumberOf1(int n) {
        int count = 0;
        int flag = 1;

        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }

        return count;
    }
	
	//优化算法，减去一与原来的数相与将最后一位1变0，有多少1就会进行多少次
	public static int NumberOf1Optimal(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = (n-1) & n;
        }

        return count;
    }
}
