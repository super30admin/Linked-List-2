# Time Complexity: next: O(1)(Average) hasNext: O(1) 
# Space Complexity: O(log(n))
# Passed Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    def create_branch(self, head):
        while True:
            self.memo.append(head)
            if head.left:
                head = head.left
            else:
                return
            
            
            
    def __init__(self, root: TreeNode):
        
        self.memo = []
        if root:
            self.create_branch(root)


    def next(self) -> int:
        """
        @return the next smallest number
        """
        
        node = self.memo.pop()
        
        if node.right:
            self.create_branch(node.right)
        return node.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if len(self.memo) > 0:
            return True
        return False


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()