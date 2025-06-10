// ## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE

let stack = []
var BSTIterator = function(root) {
    // Time Complexity : O(h) not n because we never traverse the whole tree
// Space Complexity : O(h)
    if(!root) return null
  
    function dfs(root){
        while(root){
            stack.push(root)
            root = root.left
        }
    }

      dfs(root)
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function() {
    // Time Complexity : O(1) amortized
// Space Complexity : O(h) h = height
        function dfs(root){
        while(root){
            stack.push(root)
            root = root.left
        }
    }
    let temp = stack.pop() 
    if(temp.right)dfs(temp.right)
    return temp.val
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
    // Time Complexity : O(1)
// Space Complexity : O(1)
    return stack.length==0?false:true
};

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */