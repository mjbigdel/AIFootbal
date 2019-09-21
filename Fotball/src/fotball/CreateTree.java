
package fotball;

import java.util.ArrayList;

public class CreateTree {
    public static int setdepth=0;
    public static String SahebT="";
    public String bestMove;  
    public CreateTree(){      
    }
    public void CreateTree(String input){
         int  rowW =Integer.parseInt(input.substring(0, 1));
         int columnW=Integer.parseInt(input.substring(1, 2));
         int rowY=Integer.parseInt(input.substring(2, 3));
         int ColumnY=Integer.parseInt(input.substring(3, 4));         
         SahebT=input.substring(4, 5);                      
//         String six=input.substring(5, 6);
//         ArrayList<String> a=new ArrayList<>();
         
        Tree root=new Tree("P", Integer.MIN_VALUE,Integer.MAX_VALUE , 0,0,null,null,null,null,null);                  
         
        if( "P".equals(SahebT))
        {
          if( win(rowW, columnW)){  
          bestMove="4";}
          else{
              setdepth = 4;
             root.alphaBeta1(root, setdepth, Integer.MIN_VALUE,Integer.MAX_VALUE, rowW, columnW, rowY, ColumnY, "P");
//        System.out.println("aphabeta");
//        root.printLevelOrderBFS2(root);
//        System.out.println();          
//        System.out.println("F ha");
//        root.printLevelOrderBFS(root);
//        System.out.println("bestmoveValue = "+root.bestMoveValueA(root));
        bestMove=root.SelectbestMoveA(root);  
          }
        }
        else{
            setdepth = 4;
         root.alphaBeta1(root, setdepth, Integer.MIN_VALUE,Integer.MAX_VALUE, rowW, columnW, rowY, ColumnY, "P");
//        System.out.println("aphabeta");
//        root.printLevelOrderBFS2(root);
//        System.out.println();          
//        System.out.println("F ha");
//       1111111111111 root.printLevelOrderBFS(root);
//        System.out.println("bestmoveValue = "+root.bestMoveValueA(root));
        bestMove=root.SelectbestMoveA(root);        
    }
        System.out.println("bestmove = "+bestMove);
//        a.add(input+bestMove);
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+learn(a, input));
//        
    }
    
//    public String learn(ArrayList<String> a, String input){
//        String bestM = null;
//        for(int i=a.size()-1 ; i>=0 ;i--){
//            if(a.get(i).substring(0, 5).equals(input.substring(0, 5)) && "L".equals(a.get(i).substring(5, 6))){
//             bestM= a.get(i).substring(26, 27);
//                
//            }else if(a.get(i).substring(0, 5).equals(input.substring(0, 5)) && "R".equals(a.get(i).substring(5, 6))){
//                
//                
//            }
//        }
//        return bestM;
//    }
//    
public boolean win(int rowWe, int columnWe) {
        if ((rowWe == 3 && columnWe == 9 ) || (rowWe == 4 && columnWe == 9 )) {
            return true;
        }
        return false;
    }    
}

