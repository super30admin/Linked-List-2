class BSTIterator:
    

    def __init__(self, root: Optional[TreeNode]):
        self.s =[]
        self.dfs(root)

    def next(self) -> int:
        popped = self.s.pop()
        self.dfs(popped.right)
        return popped.val

    def hasNext(self) -> bool:
        # return s if s
        return len(self.s) != 0 
        
    def dfs(self, root):
        while root:
            self.s.append(root)
            root = root.left
#T.C=>O(N) we traverse whole tree
#S.C=>O(n)
#Approach=>It is a dfs method where we add all the nodes in a queue. Ones we then pop all the elemets from stack and return ones when the nextNode is null 