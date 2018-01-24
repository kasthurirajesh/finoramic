
package finoramic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class validSudoke {
    
    public  static int isValidSudoku(final String[] A) {

        if(A.length!=9)
            return 0;
      
        //for 3*3 block 
        int col,row, startRow, endRow, startCol, endCol;
        for(col=0;col<9;col=col+3){
            for(row=0;row<9;row=row+3){
                startCol=col; endCol=startCol+3;
                startRow=row; endRow=startRow+3;
                if(sub(A,startCol,endCol,startRow,endRow)==0)
                    return 0;
            }
        }
        
        Character c;
         //row wise 
          for(int i=0;i<9;i++){
            Set<Character> set = new HashSet<Character>();
                for(int j=0;j<9;j++){
                    c=A[i].charAt(j);
                    if(c != '.')
                    {
                        if(set.contains(c)){
                           return 0;
                        }
                        else  set.add(c); 
                    }   
                        
                }
          }
          
          //column wise
        for(int i=0;i<9;i++){
            Set<Character> set = new HashSet<Character>();
                for(int j=0;j<9;j++){
                    c=A[j].charAt(i);
                    if(c != '.')
                    {
                       if(!set.contains(c)){
                            set.add(c);
                        }
                        else return 0;
                        
                    }
                }}
          
        
        
        return 1;
    }
    
    public static int sub(final String[] a, int startCol, int endCol , int startRow, int endRow){
            Set<Character> set = new HashSet<Character>();
            Character c;
        for(int i=startRow;i<endRow;i++){
                for(int j=startCol;j<endCol;j++){
                    c=a[i].charAt(j);
                    if(c!='.'){
                        if(set.contains(c))
                           return 0;
                        else
                            set.add(c);
                    }                
                }
                
        }
        return 1;
    }

    public static void main(String[] args) {
        
        String[]  A= new String[9];
        A[0]= "..5.....6";
        A[1]="....14..." ;
        A[2]="........." ;
        A[3]=".....92.." ;
        A[4]="5....2..." ;
        A[5]=".......3." ;
        A[6]="...54...." ;
        A[7]="3.....42." ;
        A[8]="...27.6..";
        
        System.out.println(isValidSudoku(A));
    }
}
