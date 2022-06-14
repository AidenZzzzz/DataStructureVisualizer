package model.bst;


import java.util.Vector;

/**
 * @author aiden
 */
public class BinaryTree {
    public BinaryTree left;
    public BinaryTree right;
    public Integer val;

    public BinaryTree(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public BinaryTree() {
        this.val = null;
        this.left = null;
        this.right = null;
    }

    public static BinaryTree balance(BinaryTree root) {
        Vector<BinaryTree> nodes = new Vector<>();
        storeNodes(root, nodes);
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }

    private static BinaryTree buildTreeUtil(Vector<BinaryTree> nodes, int start, int end)
    {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryTree node = nodes.get(mid);
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);
        return node;
    }


    private static void storeNodes(BinaryTree root, Vector<BinaryTree> nodes) {
        if (root == null) {
            return;
        }
        storeNodes(root.left, nodes);
        nodes.add(root);
        storeNodes(root.right, nodes);
    }

    public static void insert(BinaryTree root, int key)  {
        insertRecursive(root, key);
    }

    private static BinaryTree insertRecursive(BinaryTree root, int key) {
        if(root==null) {
            //leaf of tree is null
            root = new BinaryTree(key);
        }
        else if (root.val == null) {
            //root of tree's value is null
            root.val = key;
            return root;
        }

        if (key < root.val) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.val) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }


    public static void delete(BinaryTree root, int key) {
        deleteRecursive(root, key);
    }

    public static void prune(BinaryTree root, int key)
    {

        pruneRecursive(root, key);
    }

    private static BinaryTree pruneRecursive(BinaryTree root, int key) {
        if(root==null)
        {
            return null;
        }
        else if(key == root.val)
        {
            root = new BinaryTree();
        }
        else if(key < root.val)
        {
            root.left = pruneRecursive(root.left,key);
        }
        else {
            root.right = pruneRecursive(root.right,key);
        }
        return root;
    }

    private static BinaryTree deleteRecursive(BinaryTree root, int key)  {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.val) {
            root.right = deleteRecursive(root.right, key);
        } else  {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            BinaryTree nextMaxNode = minValue(root.right);
            root.val = nextMaxNode.val;

            root.right = deleteRecursive(root.right, root.val);
        }
        return root;
    }

    public static BinaryTree minValue(BinaryTree node)
    {
        BinaryTree current = node;
        while (true) {
            assert current != null;
            if (current.left == null) {
                break;
            }
            current = current.left;
        }

        return current;
    }


    public static int getMaxHeight(BinaryTree root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null & root.right ==null) {
            return 1;
        }
        return 1+ Math.max(getMaxHeight(root.left), getMaxHeight(root.left));
    }

    public static int getMaxWidth(BinaryTree root) {
        return 2^ getMaxHeight(root);
    }

    public static void preorder(BinaryTree root) {
        if(root != null)
        {
            if(root.val != null)
            {
                System.out.print(root.val+ " ");
            }
            preorder(root.left);
            preorder(root.right);

        }
    }

    /**
     * returns the node if exists
     * else returns null
     */
    public static BinaryTree find(BinaryTree root, int target) {
        if(root != null)
        {
            if(root.val != null)
            {
                if(root.val == target)
                {
                    return root;
                }
                if(target > root.val)
                {
                    return find(root.right,target);
                }
                else
                {
                    return find(root.left,target);
                }

            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    public static boolean exist(BinaryTree root , int target) {
        if(root != null)
        {
            if(root.val != null)
            {
                if(root.val == target)
                {
                    return true;
                }
                if(target > root.val)
                {
                    return exist(root.right,target);
                }
                else
                {
                    return exist(root.left,target);
                }

            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}

