import java.util.Stack;

// Iterator allows dynamism in the rest of the data structure, and makes us work on the immediate element

public class BSTIterator {

        Stack<TreeNode> st;
        public BSTIterator(TreeNode root) {

            this.st = new Stack<>();
            dfs(root);

        }
        public void dfs(TreeNode root) {

            while(root != null) {

                st.push(root);
                root = root.left;
            }
        }

        public int next() { // O(H) = worst,

        /*n/2 leaves O(1) + n/4 first level nodes from below O(1) = 75% nodes O(1)
        n/8 O(2) = 87.5% O(1). Therefore, Average Time Complexity = O(1)*/
            TreeNode node = st.pop();
            dfs(node.right);
            return node.val;
        }

        public boolean hasNext() { // O(1)

            return !st.isEmpty();
        }

}


/*
class BSTIterator {

    List<Integer> li;

    int i;

    public BSTIterator(TreeNode root) {

        this.li = new ArrayList<>();

        inorder(root);
    }
    private void inorder(TreeNode root) {

        //base
        if(root == null) return;

        //logic
        inorder(root.left);
        //st.pop()
        li.add(root.val);
        inorder(root.right);
        //st.pop()
    }

    public int next() { // O(1)

        int result = li.get(i);
        i++;
        return result;
    }

    public boolean hasNext() { //O(1)

        return i != li.size();
    }
} // But can't handle dynamism

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
