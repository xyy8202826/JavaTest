package com.xyy.datastructure;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树测试
 * @author XYY
 * @version Id: BinaryTreeTest.java, v 0.1 2017/12/5 20:19 xuyuanye Exp $$
 */
public class BinaryTreeTest<E extends Comparable<E>> {

    public static void main(String[] args){
        BinaryTreeTest<Integer> binaryTreeTest = new BinaryTreeTest<Integer>();
        binaryTreeTest.insertTreeNode(4);
        binaryTreeTest.insertTreeNode(5);
        binaryTreeTest.insertTreeNode(2);
        binaryTreeTest.insertTreeNode(3);
        binaryTreeTest.insertTreeNode(0);
        binaryTreeTest.insertTreeNode(1);
        binaryTreeTest.insertTreeNode(6);
        System.out.println(binaryTreeTest);
        System.out.println(binaryTreeTest.searchTreeNode(4));
        System.out.println(binaryTreeTest.searchTreeNode(10));
        System.out.println("先序遍历");
        binaryTreeTest.preOrder(binaryTreeTest.root);
        System.out.println("中序遍历");
        binaryTreeTest.middleOrder(binaryTreeTest.root);
        System.out.println("后序遍历");
        binaryTreeTest.followUp(binaryTreeTest.root);
        System.out.println("广度优先遍历");
        binaryTreeTest.breadthFirstOrder(binaryTreeTest.root);
        System.out.println();
        System.out.println("计算树深度(递归):"+binaryTreeTest.treeDepthRecursion(binaryTreeTest.root));

    }
    TreeNode<E> root;
     static class TreeNode<E>{
         private E element;
         public TreeNode<E> left;
         public TreeNode<E> right;
         public TreeNode(E e){
             this.element=e;
         }

         @Override
         public String toString() {
             return element.toString();
         }

     }

    /**
     * 插入节点
     * @param e
     * @return
     */
    public boolean insertTreeNode(E e){
        if(root == null){
            root = new TreeNode(e);
            return true;
        }else{
            // 否则就从根节点开始遍历 直到找到合适的父节点
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while(current != null){
                if(e.compareTo(current.element)>0){
                    parent = current;
                    current = current.right;
                }else if (e.compareTo(current.element)<0){
                    parent = current;
                    current = current.left;
                }else{
                    return false;
                }
            }
            //插入
            if(e.compareTo(parent.element)>0){
                parent.right = new TreeNode(e);
            }else{
                parent.left=new TreeNode(e);
            }

        }
        return true ;
    }

    /**
     * 二叉树查找
     * @param e
     * @return
     */
    public boolean searchTreeNode(E e){
        TreeNode<E> current = root;
        while(current != null){
            if(e.compareTo(current.element)>0){
                current = current.right;
            }else if (e.compareTo(current.element)<0){
                current = current.left;
            }else {
                return true;
            }
        }
        return false ;
    }


    /**
     * 先序遍历
     * @param root 树
     */
    public void preOrder(TreeNode<E> root){
        if(root == null){
            return ;
        }else{
            System.out.print(root.toString()+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    /**
     * 中序遍历
     * @param root 树
     */
    public void middleOrder(TreeNode<E> root){
        if(root == null){
            return ;
        }else{
            middleOrder(root.left);
            System.out.print(root.toString()+" ");
            middleOrder(root.right);
        }

    }

    /**
     * 后序遍历
     * @param root 树
     */
    public void followUp(TreeNode<E> root){
        if(root == null){
            return ;
        }else{
            followUp(root.left);
            followUp(root.right);
            System.out.print(root.toString()+" ");
        }

    }

    /**
     * 广度优先遍历
     * @param root 树
     */
    public void breadthFirstOrder(TreeNode<E> root){
        Queue<TreeNode<E>> queue = new LinkedBlockingQueue<TreeNode<E>>();
        if(root == null){
            return ;
        }else{
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode<E> e = queue.poll();
                System.out.print(e.toString()+" ");

                if(e.left !=null){
                    queue.add(e.left);
                }
                if(e.right != null){
                    queue.add(e.right);
                }

            }
        }

    }

    /**
     * 求树的深度（递归）
     * @return
     */
    public int treeDepthRecursion(TreeNode<E> root){
        if(root == null){
            return 0;
        }else{
            int leftDepth=1;
            int rightDepth=1;
            leftDepth+=treeDepthRecursion(root.left);
            rightDepth+=treeDepthRecursion(root.right);
            return Integer.max(leftDepth,rightDepth);
        }

    }

 /*   *//**
     * 求树的深度（非递归）
     * @return
     *//*
    public int treeDepth(TreeNode<E> root){
        if(root == null){
            return 0;
        }else{
            int leftDepth=1;
            int rightDepth=1;
            while()
            return Integer.max(leftDepth,rightDepth);
        }

    }*/




}
