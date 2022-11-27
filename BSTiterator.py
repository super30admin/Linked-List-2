'''
Time complexity -->

O(n) for number of nodes visited

Space Complexity -->
O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.dfs(root)
    
    
    def dfs(self, root):
        if root!=None:
            self.st.append(root)
            self.dfs(root.left)
        
            
        

    def next(self) -> int:
        node = self.st.pop(-1)
        #print(node.val)
        self.dfs(node.right)
        return node.val
        
        
        
        

    def hasNext(self) -> bool:
        if len(self.st)!=0:
            return True
        else:
            return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()