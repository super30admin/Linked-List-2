# Time Complexity : O(1) average case
# Space Complexity : O(h) for stack size which has a maximum size of height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here we just keep track of the entire left branch and place them in the stack. 
# We pop, process an element and add its right child's left branch if any as well
# This simulates the recursive stack of the BST inorder recursion algorithm
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.traverseLeft(root)
        
    def traverseLeft(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        res = self.stack.pop()
        self.traverseLeft(res.right)
        return res.val
        

    def hasNext(self) -> bool:
        return self.stack
