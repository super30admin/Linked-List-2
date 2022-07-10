#Time complexity: O(1)
#Space complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    def __init__(self, root: Optional[TreeNode]):
        self.st = deque()
        self.dfs(root)       
    
    def next(self) -> int:
        curr = self.st.pop()
        temp = curr.val
        self.dfs(curr.right)
        return temp
        

    def hasNext(self) -> bool:
        return self.st
        
    
    def dfs(self, root):
        while root != None:
            self.st.append(root)
            root = root.left
        
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
