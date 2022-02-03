# Leetcode Execution :YES
# Time Complexity:O(1)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.mapp=[]
        temp=root
        stack=[]
        stack.append(root)
        temp=temp.left
        while(len(stack)>0 or temp!=None):
            while(temp!=None):
                stack.append(temp)
                temp=temp.left
            
            temp=stack.pop()
            self.mapp.append(temp.val)
            temp=temp.right
        # print(self.mapp)
      # we first do inorder traversal and keep everything in array
                
            
        

    def next(self) -> int:
        # we pop from left for next 
        return self.mapp.pop(0)
        
        # we check the size of the array for has next
    def hasNext(self) -> bool:
        if len(self.mapp)>0:
            return True
        else:
            return False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()