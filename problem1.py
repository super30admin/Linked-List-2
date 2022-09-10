"""
Time Complexity  : For next(): Worst Case is O(h) where h is the height of the node tree and average case is O(1)
                   For hasNext() it is O(1)
Space Complexity : O(h) where h is the height of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Itertors are dynamic data structure which are concerned only about the next element. Hence, controlled recursion is required and therefore we need to implement the iterative stack over the hood. Normal recursion will result in uncontrolled recursion and hence under the hood stack implementation should be avoided.

Perform the inOrder traversal iteratively. Right call for the inOrder traversal will be made in next() to keep the latest element in a stack
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.helper(root)
    
    def helper(self, root):
        if root == None:
            return 
        
        while(root != None):
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        node = self.stack.pop()
        self.helper(node.right)
        return node.val
        
    def hasNext(self) -> bool:
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
