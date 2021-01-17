# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:
    '''
    Time Complexity: O(1) amortized
    Space: O(h)
    '''

    def __init__(self, root: TreeNode):
        self.st = []
        self.leftIterate(root)
        
    def next(self) -> int:
        if(self.hasNext()):
            e = self.st.pop()
            self.leftIterate(e.right)
            return e.val
        
    
    '''
    Complexity: O(1)
    '''
    def hasNext(self) -> bool:
        if(len(self.st)>0):
            return True
        else:
            return False
    
    
    def leftIterate(self,root):
        while(root!=None):
            self.st.append(root)
            root = root.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
