import java.util.ArrayList;

//栈的压入弹出序列
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      int flag = 0;
      int pointer = 0;
      int counter = pushA.length;

      while(flag < popA.length)
      {   
          if(pointer >= pushA.length) return false;
          
          if(pushA[pointer] != popA[flag])
          {
              if(pointer == pushA.length)
              {
                  return false;
              }
              pointer++;
              
          }
          else
          {
              pushA[pointer] = -1;
              while(pushA[pointer] == -1 && pointer >= 1)
              {
                  pointer--;
              }             
              flag++;
          }
      }
          
      return true;
    }
}
