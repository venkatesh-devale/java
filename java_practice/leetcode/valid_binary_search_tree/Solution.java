class Solution {
    
    class HistoryNode {
        TreeNode t;
        int lower;
        int upper;
        
        public HistoryNode(TreeNode temp, int low, int up) {
            t = temp;
            lower = low;
            upper = up;
        }
    }

    
    public boolean isValidBST(TreeNode root) {
         if(root == null)
             return true;
        
        Queue<HistoryNode> q = new LinkedList<HistoryNode>();
        q.add(new HistoryNode(root, int.MIN_VALUE, int MAX_VALUE));
        
        //while q is not empty
        while(!q.isEmpty()) {
            HistoryNode h = q.poll();
            if(h.t.val <= h.lower && h.t.val >= h.upper )
                return false;
            
            if(h.t.left != null)
                q.add(new HistoryNode(h.t.left, h.lower, h.t.val));
            
            if(h.t.right != null) 
                q.add(new HistoryNode(h.t.right, h.t.val, h.upper));
        }
        
        return true;
    }
}