
package finoramic;

import java.util.ArrayList;

public class haspath2 {
    
   ArrayList<ArrayList<Integer>> answer;
    public int[][] pathSum(Node A, int B) {        
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        hasPath(A, B, "" , answer);
        int[][] res = new int[answer.size()][];
        int colSize;
        for(int i=0;i<answer.size();i++){
            colSize=answer.get(i).size();
            res[i]=new int[answer.get(i).size()];
            for(int j=0;j<colSize;j++)
              res[i][j]=answer.get(i).get(j);
        }
       
        return res;
        
    }
    
        public  static void hasPath(Node root, int sum , String s, ArrayList<ArrayList<Integer>> answer ){
            ArrayList<ArrayList<Integer>> answer1,answer2;
            if( root.data > sum )
                return ;
            
                sum = sum-root.data;
                if(root.left==null & root.right == null){
			if(sum!=0)
				return;
			s =  s+root.data+",";
                    ArrayList<Integer> al = new ArrayList<Integer>();
                    int x;
                    String[] arr = s.split(",");
                    for(int i=0;i<arr.length;i++)
                    {     x=Integer.parseInt(arr[i]);
                         al.add(x);
                    }
                    answer.add(al);
                    

		}               
                    s =  s+root.data+",";
                    if(root.left !=null)
                        hasPath(root.left, sum, s, answer);
                    if(root.right!=null)
                        hasPath(root.right, sum, s , answer);
                    
                    
                }
        
        public static void main(String[] args) {
		
            ArrayList<String> al=new ArrayList<String>();  

            Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		Finoramic ii = new Finoramic();
                
		int[][]  al2=ii.pathSum(root, 10);
              
                
	}
            }
            
            
        

    	
    


