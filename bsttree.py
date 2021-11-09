# Time Complexity :O(1) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class BSTIterator:
# TC---->O(1)
# SC---->O(n)
    def __init__(self, root: TreeNode):
        self.inorder, self.length = self.create_list(root)
        self.iterator = -1

    def next(self) -> int:
        self.iterator+=1
        return self.inorder[self.iterator]

    def hasNext(self) -> bool:
        return self.iterator<self.length-1

    def create_list(self, root):
        inorder = []
        l = 0
        stack = []

        while True: 

            if root is not None: 
                stack.append(root) 
                root = root.left  

            elif stack: 
                root = stack.pop()
                inorder.append(root.val)
                l+=1
                root = root.right  

            else: 
                break
        return (inorder,l)