# 173. Binary Search Tree Iterator
'''
Leetcode all test cases passed: Yes
Solution:
    h is the height of the tree

    def next(self)
        Space Complexity: O(h) 
        Time Complexity: O(h) -> O(1)
    def hasNext(self)
        Space Complexity: O(h) 
        Time Complexity: O(1)
'''
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
    def dfs(self,root):
        curr = root
        while curr != None:
            self.stack.append(curr)
            curr = curr.left
        
    def next(self) -> int:
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val
        

    def hasNext(self) -> bool:
        if len(self.stack) !=0 :
            return True
        return False
