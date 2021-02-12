// Time Complexity : O(n) //number of nodes
// Space Complexity : O(max depth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack=deque()    //initialize stack 
        self.dfs(root)    //call dfs fuction to store all the nodes left of root
        

    def next(self) -> int:    //this will pop the top element from stack and again store all the left nodes of right of popped node.
        if not self.hasNext:
            return -1
        root=self.stack.pop()
        self.dfs(root.right)
        
        return root.val
        

    def hasNext(self) -> bool:
        if len(self.stack)!=0:    //this will simply check if the stack is empty or no 
            return True
        else:
            return False
        
    def dfs(self,root):
        if not root:
            return None
        while root:
            self.stack.append(root)
            root=root.left
        return root
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
