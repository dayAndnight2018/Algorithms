//对于输入的n个数，0~n-1,每次去除第m个元素，问最后剩下谁？

public class Josephus {
    public int LastRemaining_Solution(int n, int m) {
       
        if (n <= 0 || m <= 0) {
            return -1;
        }
        //将元素添加到List中
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //首次位置设为-1，也就是开始数的前一个位置
        int index = -1;
        //一直到最后剩余一个元素
        while (list.size() > 1) {
            //确定要移除的元素位置
            index = (index + m) % list.size();
            //移除元素
            list.remove(index);
            //位置为移除的下一个位置
            index--;
        }
        //返回剩余的那个元素
        return list.get(0);
    }

    /**
     * f(n, m) = [f(n-1, m) + m] % n (n > 1)
     *         =  0 (n=1)
     */
    public int LastRemaining_Solution1(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int lastRemain = 0;
        for (int i = 2; i <= n; i++) {
            lastRemain = (lastRemain + m) % i;
        }
        return lastRemain;
    }
    
    //按照过程模拟
    public int LastRemaining_Solution3(int n, int m) {
        int[] children = new int[n];
        for(int child : children)
        {
            child = 0;
        }
        
        int flag = 0;
        int delete = 0;
        for(int i =1; i<= n-1;i++)
        {
            int counter = m;           
            while(counter != 0)
            {      
            	if(flag == n)
                {
                    flag = 0;
                }
                if(children[flag] != -1)
                {
                    counter --;                    
                }
                if(counter == 0)
                {
                	delete = flag;
                }
                flag++;
            }            
            children[delete] = -1;
        }
        
        for(int i =0; i<= n-1;i++)
        {
            if(children[i] != -1) return i;
        }
        
        return -1;
    }
}
