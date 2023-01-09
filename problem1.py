#time complexity: O(n)
#space complexity: O(maxdepth)
#ran on leetcode: Yes
#Using stack perform a controlled recusrion and recurse only till root.left exsist. Keep placing root.left in stack as long as it exsist. When this stops, pop out the top element from stack and return it
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stk=[]

        while(root):
            self.stk.append(root)
            root=root.left
        

        

    def next(self) -> int:
        data=self.stk[-1].val
        root=self.stk[-1]
        del(self.stk[-1])
        root=root.right
        while(root):
            self.stk.append(root)
            root=root.left
        return data

    def hasNext(self) -> bool:
        if(self.stk):
            return True
        else:
            return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
