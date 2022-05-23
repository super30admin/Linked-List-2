/ Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
var BSTIterator = function(root) {
    var stack = [];
  return {hasNext, next};
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function() {
    while (root) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    var result = root.val;
    root = root.right;
    return result;
  }
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
     return root || stack.length;
};

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */