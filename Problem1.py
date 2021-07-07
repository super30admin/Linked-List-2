# Time Complexity : O(1) average | O(n) worst case
# Space Complexity :O(n) for stack. 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 

class BSTIterator:
    def __init__(self, root):
        self.stack = []
        self.root = root
        self.__dfs(self.root)
    def next(self):
        """
        @return the next smallest number
        """

        curr = self.stack.pop()
        self.__dfs(curr.right)
        return curr.val 
        

    def hasNext(self):
        """
        @return whether we have a next smallest number
        """
        if self.stack:
            return True 
        else: 
            return False 
        
    def __dfs(self,root):
        while root:
            self.stack.append(root)
            root = root.left 
    
if __name__ == "__main__":
    n = Node(50)
    n.left = Node(30)
    n.right = Node(70)
    n.left.left = Node(10)
    n.left.right = Node(40)
    n.right.left = Node(60)
    n.right.right = Node(80)
    s = BSTIterator(n)
    a = s.next()
    print(a)
    b = s.next()
    print(b)
    c = s.hasNext()
    print(c)