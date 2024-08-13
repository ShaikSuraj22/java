import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);

        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }


}
class solutions{

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> lis= new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode val=queue.poll();
                if (val.left!=null){
                    queue.offer(val.left);
                }
                if(val.right!=null){
                    queue.offer(val.right);
                }

            }
            result.add(lis);
        }
        return result;




    }


}

