//https://leetcode.com/problems/binary-search-tree-iterator/
//// Time Complexity : O(n) we visit each node once in the tree inorder
//// Space Complexity : O(maxdepth of tree) we keep a stack as deep as the farthest left tree node
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// i got stuck on the javascript array size, i put [].size but it is [].length so hasNext() was failing

//// Your code here along with comments explaining your approach

// (1) visit all left children, pushing each node onto a stack as you go
// (2) when user calls pop(),
// (2a) return value at top of the stack, but before this...
// (2b)...if there's a right child of top of the stack, repeat (1) on right child
// (3) hasNext() will return whether the stack is empty
var BSTIterator, TreeNode;

BSTIterator = function(root) {
  var bstit, stack;
  stack = [];
  bstit = Object.assign(Object.create(BSTIterator.prototype), {
    stack: stack
  });
  bstit.dfs(root);
  return bstit;
};

BSTIterator.prototype.dfs = function(root) {
  var results;
  results = [];
  while (root !== null) {
    this.stack.push(root);
    results.push(root = root.left);
  }
  return results;
};

TreeNode = function(val, left = null, right = null) {
  return Object.assign(Object.create(TreeNode.prototype), {
    val: val,
    left: left,
    right: right
  });
};

BSTIterator.prototype.next = function() {
  var nextValue;
  if (this.stack.size < 1) {
    return null;
  }
  nextValue = this.stack.pop();
  if (nextValue.right !== null) {
    this.dfs(nextValue.right);
  }
  return nextValue.val;
};

BSTIterator.prototype.hasNext = function() {
  return this.stack.length > 0;
};

//root = TreeNode(7, TreeNode(3), TreeNode(15, TreeNode(9), TreeNode(20)))
//iterator = BSTIterator(root)
//iterator.next() is 3;    #// return 3
//iterator.next() is 7;    #// return 7
//iterator.hasNext() is true; #// return true
//iterator.next() is 9;    #// return 9
//iterator.hasNext() is true; #// return true
//iterator.next() is 15;    #// return 15
//iterator.hasNext() is true; #// return true
//iterator.next() is 20;    #// return 20
//iterator.hasNext() is false;# // return false

//# sourceMappingURL=problem1-bst-iterator.js.map
