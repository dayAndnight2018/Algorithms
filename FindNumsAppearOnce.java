public class FindNumsAppearOnce {
    public void find(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < length; i++) {
            insert(map,array[i]);            
        }
        
        Object[] values= map.keySet().toArray();
        int num=0;
        
        for(int i=0;i<values.length;i++){
            int value=(Integer)values[i];
            if(map.get(value)==1&&num==0) num1[num++]=value;
            else if(map.get(value)==1&&num==1){
                num2[--num]=value;
                break;
            }
        }
    }
    
    public void insert(HashMap<Integer, Integer> map, int value){
        if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else map.put(value, 1);
    }
    
    
    public void find2(int [] array,int num1[] , int num2[]) {
        
        num1[0] = -1;
        num2[0] = -1;
        if(array == null || array.length <= 0){
            return;
        }
        
        for(int i =0;i<array.length -1;i++)
        {
            boolean flag = false;
            for(int j = 0;j<array.length-1-i;j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    flag = true;
                }               
            }
            if(!flag)
            {
               break;
            }
        }
        
        if(array[0] != array[1]){
            num1[0] = array[0];
        }
        if(array[array.length -2] != array[array.length -1])
        {
                if(num1[0] == -1)
                {
                    num1[0] = array[array.length -1];
                }
                else
                {
                    num2[0] = array[array.length -1];
                }
        }
        
        for(int i =1;i<array.length -1;i++)
        {
            if(array[i-1] != array[i] && array[i+1] != array[i]){
                if(num1[0] == -1)
                {
                    num1[0] = array[i];
                }
                else
                {
                    num2[0] = array[i];
                    break;
                }
            }
        }
        
    }
}
