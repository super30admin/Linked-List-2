'''
173. Binary Search Tree Iterator

TIME COMPLEXITY: 
    next: O(h)
    hasNext: O(1)
SPACE COMPLEXITY: O(h)
LEETCODE: Yes
DIFFICULTIES: Yes, but I was able to solve after watching the class.

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    from collections import deque
    
    def helper(self, root):
        while root != None:
            self.st.append(root)
            root = root.left
    
    def __init__(self, root: Optional[TreeNode]):
        self.st = deque()
        self.helper(root)
        
    
    def next(self) -> int:
        node = self.st.pop()
        self.helper(node.right)
        return node.val
    

    def hasNext(self) -> bool:
        if len(self.st) != 0:
            return True
        else:
            return False


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
