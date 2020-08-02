//Binary Search Tree Iterator (LC 173)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// BST Iterator - basically I'm trying to flatten the binary search tree and traverse the BST in inorder 

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 */
let sortedNodes = [];
let index = -1;
var BSTIterator = function(root) {
    sortedNodes = [];
    index = -1;
    inorder(root);
};

var inorder = function(root){
    if(root === null){
        return null;
    } 
    inorder(root.left);
    sortedNodes.push(root.val);
    inorder(root.right);
};

/**
 * @return the next smallest number
 * @return {number}
 */
BSTIterator.prototype.next = function() {
    index += 1;
    return sortedNodes[index];
};

/**
 * @return whether we have a next smallest number
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
    return index + 1 < sortedNodes.length;
};

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */