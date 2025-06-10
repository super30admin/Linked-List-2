from collections import deque
class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right

def buildTree(values):
    if not values or values[0] is None:
        return None
    
    root=TreeNode(values[0])
    queue=deque([root])
    i=1

    while queue and i<len(values):
        node=queue.popleft()

        if i<len(values)and values[i] is not None:
            node.left=TreeNode(values[i])
            queue.append(node.left)
        i+=1

        if i<len(values) and values[i] is not None:
            node.right=TreeNode(values[i])
            queue.append(node.right)
        i+=1
    
    return root

class BSTIterator:
    def __init__(self,root):
        self.stack=[]
        self._leftmost_inorder(root)

    def _leftmost_inorder(self,node):
        while node:
            self.stack.append(node)
            node=node.left

    def next(self):
        topmost_node=self.stack.pop()
        if topmost_node.right:
            self._leftmost_inorder(topmost_node.right)

        return topmost_node.val
    
    def hasNext(self):
        return len(self.stack)>0
    
def simulate(commands,values):
    result=[]
    obj=None

    for cmd,val in zip(commands,values):
        if cmd=="BSTIterator":
            root=buildTree(val[0])
            obj=BSTIterator(root)
            result.append(None)
        elif cmd=="next":
            result.append(obj.next())
        elif cmd=="hasNext":
            result.append(obj.hasNext())
    return result

commands=["BSTIterator","next","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]
values=[[[7,3,15,None,None,9,20]],[],[],[],[],[],[],[],[],[]]

output=simulate(commands,values)
print(output)