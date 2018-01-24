
package finoramic;

import java.util.Map;
import java.util.TreeMap;

public class xpowern {

     
    public static int sum=0;
    public static void main(String[] args) {
    
      xpowern xp = new xpowern();
        System.out.println(xp.pow(71045970, 41535484, 64735492));
      
              
        
      
    }
   
   
    
    public int pow(int x, int n , int d){
        int no , i;
        long answer, temp=x;
        String s = Integer.toBinaryString(n);
        int length = s.length();
        
        
        if(s.charAt(length-1) - '0' ==1 )
            answer = x; else answer=1;
        
        i=length-2;
        while(i>=0){
            temp=(temp*temp) % d;
           if(s.charAt(i) - '0' == 1 )
               answer= (answer * temp)  % d;
           i--;
        }
        
       if(answer>=0)
           
           return  (int)(answer%d);
       else
           return (int)(d+answer);
        
       
        
        
    }
    
}
