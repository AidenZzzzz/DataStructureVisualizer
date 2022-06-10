package model.bst;

import util.Constant;

import java.awt.*;

import static util.Constant.*;

/**
 * @author aiden
 */
public class BinaryTree {
    public int offset;
    public BinaryTree left;
    public BinaryTree right;
    public Integer val;
    public int x;
    public int y;
    public int w = NODE_WIDTH;
    public int h = NODE_HEIGHT;
    public int depth;

    public BinaryTree(int val) {
        this.val = val;
        this.depth = 0;
        this.x = BST_INIT_X;
        this.y = BST_INIT_Y;
    }

    public BinaryTree(int x, int depth, int offset) {
        this.val = x;
        this.depth = depth;
        this.offset = offset;

        if(depth>1) {
            this.w /= depth;
            this.x = BST_INIT_X +offset+this.w;
        }
        else {
            this.x = BST_INIT_X + offset;
        }
        this.y = BST_INIT_Y +depth* NODE_HEIGHT*2;
    }

    public BinaryTree() {
        this.val=null;
        this.depth = 0;
        this.x = BST_INIT_X;
        this.y = BST_INIT_Y;
    }

    public void draw(Graphics g)
    {
        if(val!=null) {
            g.drawString(val.toString(), x + w / 2, y + h / 2);
            g.drawRect(x, y, w, h);
            if (left != null)
            {
                g.drawLine(x + w / 2, y + h, x, y + 2 * h);
                left.draw(g);
            }
            if (right != null){
                g.drawLine(x + w / 2, y + h, x + w, y + 2 * h);
                right.draw(g);
            }

        }
    }

    public static void insert(BinaryTree root, int key, int depth, int offset)  {
        insertRecursive(root, key, depth, offset);
    }

    static BinaryTree insertRecursive(BinaryTree root, int key, int depth, int offset) {
        if(root==null) {
            //leaf of tree is null
            root = new BinaryTree(key,depth,offset);
        }
        else if (root.val == null) {
            //root of tree's value is null
            root.val = key;
            root.depth = depth;
            root.offset = offset;
            return root;
        }

        if (key < root.val) {
            root.left = insertRecursive(root.left, key,depth+1,offset-(Constant.NODE_WIDTH/2));
        } else if (key > root.val) {
            root.right = insertRecursive(root.right, key,depth+1,offset+(Constant.NODE_WIDTH/2));
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

    /* TODO: 6/10/22 multi-level delete does not reset depth and xy */
    static BinaryTree deleteRecursive(BinaryTree root, int key)  {
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
                root.left.depth = root.depth;
                root.left.offset = root.offset;
                root.left.x = root.x;
                root.left.y = root.y;
                root.left.w = root.w;
                root.left.h = root.h;
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


    public static int getHeight(BinaryTree root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null & root.right ==null) {
            return 1;
        }
        return 1+ Math.max(getHeight(root.left),getHeight(root.left));
    }

    public static int getWidth(BinaryTree root) {
        return 2^getHeight(root);
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

