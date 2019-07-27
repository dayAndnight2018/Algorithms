//验证是否是二叉搜索树的后序遍历结果
public class VerifySequenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <=0) return false;
        
        return isBST(sequence,0,sequence.length-1);
    }
    
    public boolean isBST(int[] array, int start, int end)
    {
        if (array == null || start > end) {
            return false;
        }
        
        if(start == end)
        {
            return true;
        }
        
        int root = array[end];
        int i = start;
        for(;i < end;i++)
        {
            if(array[i] > root)
            {
                break;
            }
        }
        
        int j = i;
        for(;j<end;j++)
        {
            if(array[j] < root)
            {
                return false;
            }
        }
        
        boolean flagLeft = true;
        
        if(i > start)
        {
            flagLeft = isBST(array,start, i-1);
        }
        
        boolean flagRight = true;
        
        if(i<end)
        {
            flagRight = isBST(array,i,end-1);
        }
        
        return flagRight && flagLeft;
    }
}
