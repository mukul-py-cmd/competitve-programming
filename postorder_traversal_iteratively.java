//Link : https://leetcode.com/problems/binary-tree-postorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        Set<TreeNode> visit = new HashSet<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(root != null){
            
            if(visit.add(root)){
                st.add(root);
            }
            
            if(root.left != null && !visit.contains(root.left)){
                
                
                root = root.left;
                
            }else if(root.right != null && !visit.contains(root.right)){
                
               
                root = root.right;
            }else{
                TreeNode temp = st.pop();
                ans.add(temp.val);
              
                if(st.size() > 0){
                    root = st.peek();
                }else{
                    break;
                }
            }
        }
        
        return ans;
        
        
    }
}