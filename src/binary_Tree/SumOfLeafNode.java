/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 18/04/2022
 *   Time: 18:35
 *   File: SumOfLeafNode.java
 */

package binary_Tree;


public class SumOfLeafNode {
    public int sumNumbers(TreeNode root) {
        return SN(root, 0);
    }

    private int SN(TreeNode root, int n) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return n * 10 + root.val;
        }
        int left = SN(root.left, n * 10 + root.val);
        int right = SN(root.right, n * 10 + root.val);
        return left + right;
    }
}