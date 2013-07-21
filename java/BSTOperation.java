Morning Fei, This is Henry from Airbnb, just give me a second to setup things



class TreeNode{
TreeNode left;
TreeNode right;
int val;
TreeNode(int _val){
   this.val=_val;
}

class Tree{
    TreeNode root;
    Tree(TreeNode _root){
         this.root=_root;
     }
    TreeNode insert(TreeNode root, int val ){
         if(root==null){
             this.root = new TreeNode(val);
             return root;
           }
        TreeNode curNode = root;
        while(curNode!=null){
           if(val==curNode.val) throw new Exception("duplicate value");
           if(val>curNode.val){
               if(curNode.right==null){
                 curNode.right = new TreeNode(val); 
                 break;
                }
              curNode=curNode.right;
           }
           else{
              if(curNode.left==null){
                curNode.left= new TreeNode(val);
                break;
               }
               curNode=curNode.left;
           }
        }
        return root;
    }

    

}


      TreeNode deleteNode(TreeNode root, int val){
          if(root==null) return null;
          TreeNode curNode =root;
          TreeNode parent = null;
          while(curNode!=null){
                if(curNode.val>val){
                    parent=curNode;
                    curNode=curNode.left;
                 }
                 else if(curNode.val<val){
                    parent=curNode;
                    curNode=curNode.right;
                 }
                //== 
                else{
                     if(curNode.left==null && curNode.right==null){
                           if(parent==null) curNode=null;
                           if(curNode==parent.left) parent.left=null;
                           else parent.right=null;
                      }
                      else if(curNode.left!=null && curNode.right==null){
                          parent.left= curNode.left;
                       }
                      else if(curNode.right!=null && curNode.left==null){
                          parent.right=curNode.right;
                      }
                      else if(curNode.left!=null && curNode.right!=null){
                            parent=curNode;
                            TreeNode leftNode = curNode.left;
                        while(leftNode.right!=null){
                              parent=leftNode;
                              leftNode=leftNode.right;
                            }
                          if(leftNode==parent.left){
                             parent.left=leftNode.left;
                           }
                           if(leftNode==parent.right){
                              parent.right=leftNode.left;
                           }
                           curNode.val=leftNode.val;
                        }
                    break;
                 }
          }
            return root;
       }

BST

operations:
insert
delete
find



