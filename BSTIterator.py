# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right  
    
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.r = []
        self.curr =  root
        self.inorder(root)
        # print(self.r)
        self.itr = 0 
        self.len_  = len(self.r)
    
    def inorder(self, root):
        '''
        T = O(N)
        S = O(N)
        '''
        if not root:
            return 
        self.inorder(root.left)
        self.r.append(root)
        self.inorder(root.right)
            
    def next(self) -> int:
        result_idx = self.itr 
        if self.itr < self.len_:
            self.itr += 1 
        return self.r[result_idx].val

    def hasNext(self) -> bool:
        if self.itr < self.len_:
            return True
        return False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
