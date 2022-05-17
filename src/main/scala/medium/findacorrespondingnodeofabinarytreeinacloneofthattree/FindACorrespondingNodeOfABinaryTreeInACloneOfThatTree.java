package com.soumen.leetcodesolutions.medium.findacorrespondingnodeofabinarytreeinacloneofthattree;

/**
 * <a href="https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/submissions/">
 *     1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * </a>
 * */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        } else if (original == target) {
            return cloned;
        } else {
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left == null) {
                return getTargetCopy(original.right, cloned.right, target);
            } else {
                return left;
            }
        }
    }
}

//Runtime: 1 ms, faster than 99.60% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
//Memory Usage: 101.8 MB, less than 41.95% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.