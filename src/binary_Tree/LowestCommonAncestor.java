/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 18/04/2022
 *   Time: 15:20
 *   File: LowestCommonAncestor.java
 */

package binary_Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);

        if (root.val == p.val || root.val == q.val)
            return root;
        // for same root this condition is applied
        if (leftAns != null && rightAns != null) {
            return root;
        }
        if (leftAns != null)
            return leftAns;
        return rightAns;

    }
}