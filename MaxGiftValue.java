//获取一条路径使得路径上的和最大
public static int GetMaxCe(int[][] array)
    {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return -1;
        }
        
    	int rows = array.length;
    	int cols = array[0].length;
    	int i = rows -1;
    	int j = cols -1;
    	int result = array[i][j];
      //逆向找出最大的一条路径即最大的路径
    	while(i != 0 || j!=0)
    	{
    		if(i == 0)
    		{
    			j--;
    			
    		}
    		else if(j == 0)
    		{
    			i--;
    		}
    		else
    		{
    			if(array[i-1][j]>array[i][j-1])
    			{
    				i--;
    			}
    			else
    			{
    				j--;
    			}
    		}
    		result += array[i][j];
    	}
    	return result;
    }
