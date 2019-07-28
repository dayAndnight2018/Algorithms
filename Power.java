//求double类型的乘方
public class Power {
    public double solution(double base, int exponent) {
        boolean flag = false;
        if(base == 0.0 && exponent <= 0)
        {
            return 0.0;
        }
        
        if(exponent < 0)
        {
            flag = true;
        }
        
        int exponent2 = Math.abs(exponent);
        
        double result = getResult(base,exponent2);
        if(flag)
        {
            return 1.0/result;
        }
        
        return result;
        
  }
    
    public double getResult(double base, int exponent)
    {
        double init = 1.0;
        for(int i = 1; i<= exponent; i++)
        {
            init *= base;
        }
        
        return init;
    }
    
    public double solution2(double base, int exponent)
    {
      if(exponent == 0)
      {
        return 1;
      }
      if(exponent == 1)
      {
        return base;
      }
      
      double result = solution2(base, exponent>>1);
      result *= result;
      
      if((exponent & 0x01) == 1)
      {
        result *= base;
      }
      
      return result;
    }
}
