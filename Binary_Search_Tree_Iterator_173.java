import java.util.Stack;

class Treenode {
      int val;
      Treenode left;
      Treenode right;
      Treenode() {}
      Treenode(int val) { this.val = val; }
      Treenode(int val, Treenode left, Treenode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }


class Binary_Search_Tree_Iterator_173 {
    Stack<Treenode> st = new Stack<>();
    
    public Binary_Search_Tree_Iterator_173(Treenode root) {
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        Treenode poppedNode = st.pop();
        if(poppedNode.right != null)
            dfs(poppedNode.right);
        return poppedNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!st.isEmpty());
    }
    
    private void dfs(Treenode root)
    {
        while(root != null)
        {
            st.push(root);
            root = root.left;
        }
    }
}
