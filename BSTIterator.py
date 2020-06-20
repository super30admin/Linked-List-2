#173. Binary Search Tree Iterator
#Time Complexity : O(n) 
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = None
        self.right = None
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.root = root
        self.helper(root)
        
        #node = ListNode()
        
    def helper(self,root):
        while root:
            self.stack.append(root)
            root = root.left
        
    def next(self) -> int:
        """
        @return the next smallest number
        """
        #node = ListNode()
        node = self.stack.pop()
        #root = root.right
        self.helper(node.right)
        return node.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if self.stack:
            return True 
        else: 
            return False