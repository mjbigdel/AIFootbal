
package fotball;

import static java.lang.Math.*;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    double F;
    double value;
    String SahebT;
    int depth;
    double alpha;
    double beta;
    Tree left, right, Top, Down, Stop;
    public Tree(String SahebT, double alpha,double beta, double F, int depth, Tree left, Tree right, Tree Top, Tree Down, Tree Stop) {
        this.alpha = alpha;
        this.beta=beta;
        this.depth = depth;
        this.F = F;
        this.SahebT = SahebT;
        this.left = left;
        this.right = right;
        this.Top = Top;
        this.Down = Down;
        this.Stop = Stop;
    }
    public boolean win(int rowWe, int columnWe) {
        if ((rowWe == 4 && columnWe == 10 ) || (rowWe == 3 && columnWe == 10 )) {
            return true;
        }
        return false;
    } 
    public double alphaBeta1(Tree root, int depth, double alpha, double beta, int rowI, int columnI, int rowY, int columnY, String SahebTop) {
            if (depth == 0 || win( rowI , columnI) ) {
            return root.F;
        } else if (SahebTop.equals("P")) { // ai tries to maximize the score                                             
            while (true) {                
                 if (columnI < 9) {
                value=getFWE(rowI, columnI+1, rowY, columnY,CreateTree.setdepth - depth, SahebTop );
                    root.right = new Tree(SahebTop, Integer.MIN_VALUE,Integer.MAX_VALUE, value, depth, null, null, null, null, null);
                    alpha = Math.max(alpha, alphaBeta1(root.right, depth - 1, alpha, beta, rowI, columnI+1, rowY, columnY , changePlayer(SahebTop)));
                 }
                 if (beta <= alpha) {                   
                    break; // cutoff
                }                  
                if (rowI > 1) {
                value=getFWE(rowI-1, columnI, rowY, columnY,CreateTree.setdepth - depth, SahebTop);
                    root.Top = new Tree(SahebTop,  Integer.MIN_VALUE,Integer.MAX_VALUE, value, depth, null, null, null, null, null);
                    alpha = Math.max(alpha, alphaBeta1(root.Top, depth - 1, alpha, beta, rowI-1, columnI, rowY, columnY, changePlayer(SahebTop)));
                }
                
                if (beta <= alpha) {               
                    break; // cutoff
                }
                if (rowI < 6) {
                value= getFWE(rowI+1, columnI, rowY, columnY,CreateTree.setdepth - depth, SahebTop);
                    root.Down = new Tree(SahebTop,  Integer.MIN_VALUE,Integer.MAX_VALUE, value, depth, null, null, null, null, null);
                    alpha = Math.max(alpha, alphaBeta1(root.Down, depth - 1, alpha, beta, rowI+1, columnI, rowY, columnY, changePlayer(SahebTop)));
                }
                
                if (beta <= alpha) {                   
                    break; // cutoff
                }
                value= getFWE(rowI, columnI, rowY, columnY,CreateTree.setdepth - depth, SahebTop);               
                root.Stop = new Tree(SahebTop,  Integer.MIN_VALUE,Integer.MAX_VALUE,value , depth, null, null, null, null, null);
                alpha = Math.max(alpha, alphaBeta1(root.Stop, depth - 1, alpha, beta, rowI, columnI, rowY, columnY, changePlayer(SahebTop)));
                if (beta <= alpha) {
                    break; // cutoff
                }
                if (columnI > 1) {                   
                    value= getFWE(rowI, columnI-1, rowY, columnY,CreateTree.setdepth - depth, SahebTop);
                    root.left = new Tree(SahebTop,  Integer.MIN_VALUE,Integer.MAX_VALUE, value, depth, null, null, null, null, null);
                    alpha = Math.max(alpha, alphaBeta1(root.left, depth - 1, alpha, beta, rowI, columnI-1, rowY, columnY, changePlayer(SahebTop)));                    
                }
                
                if (beta <= alpha) {                 
                    break; // cutoff                         
                }               
                break;
            }
            root.alpha = alpha;
            return alpha;
        } else { // enemy tries to minimize the score
            while (true) {                
                 if (columnY < 9) {
                value= getFWE(rowI, columnI, rowY, columnY+1,CreateTree.setdepth - depth, SahebTop);
                    root.right = new Tree(SahebTop,  Integer.MIN_VALUE,Integer.MAX_VALUE, value , depth, null, null, null, null, null);
                    beta = Math.min(beta, alphaBeta1(root.right, depth - 1, alpha, beta, rowI, columnI , rowY, columnY+1, changePlayer(SahebTop)));
                 }
                 
                if (beta <= alpha) {                  
                    break; // cutoff
                }
                if (rowY > 1) {                    
                value= getFWE(rowI, columnI, rowY-1, columnY,CreateTree.setdepth - depth, SahebTop);
                   root.Top = new Tree(SahebTop, Integer.MIN_VALUE,Integer.MAX_VALUE, value, depth, null, null, null, null, null);
                    beta = Math.min(beta, alphaBeta1(root.Top, depth - 1, alpha, beta, rowI , columnI, rowY-1, columnY, changePlayer(SahebTop)));
                }
                
                if (beta <= alpha) {              
                    break; // cutoff
                }
                if (rowY < 6) {
                value=getFWE(rowI, columnI, rowY+1, columnY,CreateTree.setdepth - depth, SahebTop);
                    root.Down = new Tree(SahebTop, Integer.MIN_VALUE,Integer.MAX_VALUE, value, depth, null, null, null, null, null);
                    beta = Math.min(beta, alphaBeta1(root.Down, depth - 1, alpha, beta, rowI , columnI, rowY+1, columnY, changePlayer(SahebTop)));
                }
                if (beta <= alpha) {                    
                    break; // cutoff
                }
                value=getFWE(rowI, columnI, rowY, columnY,CreateTree.setdepth - depth, SahebTop);
                root.Stop = new Tree(SahebTop, Integer.MIN_VALUE,Integer.MAX_VALUE, value, depth, null, null, null, null, null);
                beta = Math.min(beta, alphaBeta1(root.Stop, depth - 1, alpha, beta, rowI, columnI, rowY, columnY, changePlayer(SahebTop)));
                if (beta <= alpha) {
                    break; // cutoff
                }                
                if (columnY > 1) {
                    value=getFWE(rowI, columnI, rowY, columnY-1,CreateTree.setdepth - depth, SahebTop);
                    root.left = new Tree(SahebTop, Integer.MIN_VALUE,Integer.MAX_VALUE, value, depth, null, null, null, null, null);
                    beta = Math.min(beta, alphaBeta1(root.left, depth - 1, alpha, beta, rowI, columnI, rowY, columnY-1, changePlayer(SahebTop)));
                }
                if (beta <= alpha) {              
                    break; // cutoff
                }
               
                break;
            }
           root.alpha = beta;
            return beta;
        }
    }
    public double getFWE(int rowI, int columnI, int rowY, int columnY, int depth, String SahebTop) {
        double F = 0;
        double a1,a2;
        double G = (depth)*100;
        if ("P".equals(CreateTree.SahebT)) 
        {   
            a1 = (Math.min(Math.sqrt(Math.pow((10 - columnI), 2) + Math.pow((4 - rowI), 2)),
                    Math.sqrt(Math.pow((10 - columnI), 2) + Math.pow((3 - rowI), 2))))  ;
            a2 = Math.sqrt(Math.pow((columnI - columnY), 2) + Math.pow((rowI - rowY), 2));
                        
            if(a1<=1)
                F+=2000;
            if(a1<2)
                F+=1000;
            if(a1<3)
                F+=500;
            if(a1<4)
                F+=250;
            if(a1<5)
                F+=150;
            if(a1<7)                
                F+=100;
            if(a1<10)
                F+=50;
            if(a1<=10)
                F+=10;
            if(a2==0 )
                F-=10000;
            if(a2==1 && columnI<=columnY)
                F-=41;
            if(a2<2 && columnI<=columnY)
                F-=20;
            if(a2<4 && columnI<=columnY)
                F-=15;
            if(a2<6 && columnI<=columnY)
                F-=10;
            if(a2<10 && columnI<=columnY)
                F-=5;            
            F=F+G;
        }                 
        else
        {          
            a1 = Math.sqrt(Math.pow((columnY - columnI), 2) + Math.pow((rowY - rowI), 2));
            a2 = (Math.min(Math.sqrt(Math.pow((0 - columnY), 2) + Math.pow((4 - rowY), 2)),
                    Math.sqrt(Math.pow((0 - columnY), 2) + Math.pow((3 - rowY), 2))));                      
            if( columnI>columnY-2)
                F-=10000;
//            if(rowI==rowY && columnI==columnY)
//                F+=10000;
            if(a1==0 && columnI==columnY  )
                F+=10000;
            if(a1<=1)
                F+=800;
            if( (a1 == Math.sqrt(2)) )
                F+=500;
            if(a1<3)
                F+=400;
            if(a1<5)
                F+=300;
            if(a1<8)
                F+=200;
            if(a1<10)
                F+=100; 
            if(a2<=1 )
                F-=10000;
//            if(a2<2 && a2>1 )
//                F-=150;
//            if(a2<4 )
//                F-=110;
//            if(a2<6 )
//                F-=50;
//            if(a2<10 )
//                F-=20;
         F=F+G;                                                  
    }
        return F;
    }
    
    public String changePlayer(String sahebetop) {
        if ("O".equals(sahebetop)) {
            return "P";
        } else {
            return "O";
        }
    }

    public String SelectbestMoveA(Tree root) {      
        if (root.right != null) {
            if (root.alpha == root.right.alpha) {
                return "4";
            }
        }
 if (root.Top != null) {
            if (root.alpha == root.Top.alpha) {
                return "1";
            }
        }
                if (root.Down != null) {
            if (root.alpha == root.Down.alpha) {
                return "2";
            }
        }
       

        if (root.Stop != null) {
            if (root.alpha == root.Stop.alpha) {
                return "0";
            }
        }
        if (root.left != null) {
            if (root.alpha == root.left.alpha) {
                return "3";
            }
        }
        return "-1";
    }
    public double bestMoveValueA(Tree root) {
        if (root.right != null) {
            if (root.alpha == root.right.alpha) {
                return root.right.alpha;
            }
        }
        if (root.Stop != null) {
            if (root.alpha == root.Stop.alpha) {
                return root.Stop.alpha;
            }
        }
        if (root.Top != null) {
            if (root.alpha == root.Top.alpha) {
                return root.Top.alpha;
            }
        }
        if (root.Down != null) {
            if (root.alpha == root.Down.alpha) {
                return root.Down.alpha;
            }
        }
        if (root.left != null) {
            if (root.alpha == root.left.alpha) {
                return root.left.alpha;
            }
        }
        return -1;
    }

//    public double alphaBeta(Tree root, int depth, double alpha, double beta, int rowWe, int columnWe, String sahebeTop) {
//        if (win(rowWe, columnWe)) {
//            return root.F;
//        } else if (depth < 0) {
//            return root.F;
//        } else if (sahebeTop.equals("P")) { // ai tries to maximize the score           
//            for (int option = 1; option < 6; option++) {
//                switch (option) {
//                    case 1:
//                        if (root.Stop != null) {
//                            alpha = Math.max(alpha, alphaBeta(root.Stop, depth - 1, alpha, beta, rowWe, columnWe, changePlayer(sahebeTop)));
//                        }
//                        if (beta <= alpha) {
//                            break; // cutoff
//                        }
////                          if(root.alphabeta<alpha){
////                            root.alphabeta=alpha; 
////                         }
//                        break;
//                    case 2:
//                        if (root.Top != null) {
//                            alpha = Math.max(alpha, alphaBeta(root.Top, depth - 1, alpha, beta, rowWe - 1, columnWe, changePlayer(sahebeTop)));
//                        }
//                        // sahebeTop=changePlayer(sahebeTop);
//                        if (beta <= alpha) {
//                            break; // cutoff
//                        }
////                          if(root.alphabeta<alpha){
////                            root.alphabeta=alpha; 
////                         }
//                        break;
//                    case 3:
//                        if (root.Down != null) {
//                            alpha = Math.max(alpha, alphaBeta(root.Down, depth - 1, alpha, beta, rowWe + 1, columnWe, changePlayer(sahebeTop)));
//                        }
//                        if (beta <= alpha) {
//                            break; // cutoff
//                        }
////                          if(root.alphabeta<alpha){
////                            root.alphabeta=alpha; 
////                         }
//                        break;
//                    case 4:
//                        if (root.left != null) {
//                            alpha = Math.max(alpha, alphaBeta(root.left, depth - 1, alpha, beta, rowWe, columnWe - 1, changePlayer(sahebeTop)));
//                        }
//                        if (beta <= alpha) {
//                            break; // cutoff                         
//                        }
////                          if(root.alphabeta<alpha){
////                            root.alphabeta=alpha; 
////                         }
//                        break;
//                    case 5:
//                        if (root.right != null) {
//                            alpha = Math.max(alpha, alphaBeta(root.right, depth - 1, alpha, beta, rowWe, columnWe + 1, changePlayer(sahebeTop)));
//                        }
//                        if (beta <= alpha) {
//                            break; // cutoff
//                        }
////                         if(root.alphabeta<alpha){
////                            root.alphabeta=alpha; 
////                         }
//                        break;
//                }
//            }
//            //root.alphabeta=alpha;
//            return alpha;
//        } else { // enemy tries to minimize the score
//            for (int option = 1; option < 6; option++) {
//                switch (option) {
//                    case 1:
//                        if (root.Stop != null) {
//                            beta = Math.min(beta, alphaBeta(root.Stop, depth - 1, alpha, beta, rowWe, columnWe, sahebeTop));
//                        }
//                        if (beta <= alpha) {
//                            break; // cutoff
//                        }
////                          if(root.alphabeta<beta){
////                            root.alphabeta=beta; 
////                         }
//                        break;
//                    case 2:
//                        if (root.Top != null) {
//                            beta = Math.min(beta, alphaBeta(root.Top, depth - 1, alpha, beta, rowWe, columnWe, sahebeTop));
//                        }
//                        if (beta <= alpha) {
//                            break; // cutoff
//                        }
////                         if(root.alphabeta<beta){
////                            root.alphabeta=beta; 
////                         }
//                        break;
//                    case 3:
//                        if (root.Down != null) {
//                            beta = Math.min(beta, alphaBeta(root.Down, depth - 1, alpha, beta, rowWe, columnWe, sahebeTop));
//                        }
//                        if (beta <= alpha) {
//                            break; // cutoff
//                        }
////                          if(root.alphabeta<beta){
////                            root.alphabeta=beta; 
////                         }
//                        break;
//                    case 4:
//                        if (root.left != null) {
//                            beta = Math.min(beta, alphaBeta(root.left, depth - 1, alpha, beta, rowWe, columnWe, sahebeTop));
//                        }
//                        if (beta <= alpha) {
//                            break; // cutoff
//                        }
////                        if(root.alphabeta<beta){
////                            root.alphabeta=beta; 
////                         }
//                        break;
//                    case 5:
//                        if (root.right != null) {
//                            beta = Math.min(beta, alphaBeta(root.right, depth - 1, alpha, beta, rowWe, columnWe, sahebeTop));
//                        }
//                        if (beta <= alpha) {
//                            break; // cutoff
//                        }
//                        break;
//                }
//            }
//            return beta;
//        }
//
//    }

    
    public void printLevelOrderBFS(Tree root) {
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        int currentLevelCount = 1;
        int nextLevelCount = 0;

        while (!queue.isEmpty()) {
            Tree n = queue.remove();
            System.out.print(n.SahebT + " " + n.F + "       ");
            if (n.right != null) {
                queue.add(n.right);
                nextLevelCount++;
            }
            
            if (n.Top != null) {
                queue.add(n.Top);
                nextLevelCount++;
            }
            if (n.Down != null) {
                queue.add(n.Down);
                nextLevelCount++;
            }
            if (n.Stop != null) {
                queue.add(n.Stop);
                nextLevelCount++;
            }
            if (n.left != null) {
                queue.add(n.left);
                nextLevelCount++;
            }
            currentLevelCount--;
            if (currentLevelCount == 0) {
                System.out.println("");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
    }

    public void printLevelOrderBFS2(Tree root) {
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        int currentLevelCount = 1;
        int nextLevelCount = 0;

        while (!queue.isEmpty()) {
            Tree n = queue.remove();
            System.out.print(n.alpha+"  "+n.beta+"       ");
           if (n.right != null) {
                queue.add(n.right);
                nextLevelCount++;
            }
            if (n.Top != null) {
                queue.add(n.Top);
                nextLevelCount++;
            }
            if (n.Down != null) {
                queue.add(n.Down);
                nextLevelCount++;
            }
             if (n.Stop != null) {
                queue.add(n.Stop);
                nextLevelCount++;
            }
            if (n.left != null) {
                queue.add(n.left);
                nextLevelCount++;
            }
            
            currentLevelCount--;
            if (currentLevelCount == 0) {
                System.out.println("");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
    }

}

