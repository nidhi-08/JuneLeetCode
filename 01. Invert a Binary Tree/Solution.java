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
    public TreeNode invertTree(TreeNode root) {
        flip(root);
        return root;
    }
    private void flip(TreeNode node){       //recursive util function
        if(node == null){
            return;
        }
        TreeNode temp=node.right;
        node.right=node.left;
        node.left=temp;
        
        flip(node.left);
        flip(node.right);       //recursive calls to left and right
    }
}
