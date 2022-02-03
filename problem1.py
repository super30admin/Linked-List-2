#Time Complexity = O(n)
#Space Complexity = O(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    queue = []
    def __init__(self, root: Optional[TreeNode]):
        self.pop(root)
        
    def next(self) -> int:
        return self.queue.pop(0)
        

    def hasNext(self) -> bool:
        return (len(self.queue)!=0)
    
    def pop(self,root):
        if(root==None):
            return 
        self.pop(root.left)
        self.queue.append(root.val)
        self.pop(root.right)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()