// Time Complexity : O(n) where n is number of tree nodes
// Space Complexity : O(n)
// Did this code successfully run on GeeksForGeeks : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

// Creating a stack and pushing nodes
/**
 * @param {TreeNode} root
 */
var BSTIterator = function(root) {
    this.stack = [];
    this.push(root);
};

// Returning the next node
/**
 * @return {number}
 */
BSTIterator.prototype.next = function() {
    const node = this.stack.pop()
    this.push(node.right)
    return node.val
};

// checking stack length
/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
    return this.stack.length > 0
};

// pushing node in stack while next node is present 
BSTIterator.prototype.push = function (node) {
  while (node) {
    this.stack.push(node)
    node = node.left
  }
}

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */