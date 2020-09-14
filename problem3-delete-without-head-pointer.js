//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
//// Time Complexity : O(1) constant number of operations
//// Space Complexity : O(1) no additional space taken
//// Did this code successfully run on Leetcode : not applicable
//// Any problem you faced while coding this :
// none pretty straightforward

//// Your code here along with comments explaining your approach

// usually you are given the node immediately before the one you wish to delete
// if you only have the node you wish to delete then all you can do is
// operate on that node and subsequent nodes

// node = node to delete
// copy value from node.next into node.value
// set node.next = node.next.next
var TreeNode, checkresult, deleteNode, node1, node20;

TreeNode = function(val = -1, next = null) {
  return Object.assign(Object.create(TreeNode.prototype), {
    val: val,
    next: next
  });
};

deleteNode = function(node) {
  node.val = node.next.val;
  return node.next = node.next.next;
};

node20 = TreeNode(20, TreeNode(4, TreeNode(30)));

checkresult = TreeNode(10, node20);

deleteNode(node20);

checkresult;

node1 = TreeNode(1, TreeNode(2));

deleteNode(node1);

node1;

//# sourceMappingURL=problem3-delete-without-head-pointer.js.map
