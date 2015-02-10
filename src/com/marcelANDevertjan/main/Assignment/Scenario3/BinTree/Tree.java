package com.marcelANDevertjan.main.Assignment.Scenario3.BinTree;

import com.marcelANDevertjan.main.Assignment.Scenario3.Data.Customer;

import java.util.ArrayList;

/**
 * This Class was created by Marcel and Evert-Jan on 9-2-2015
 * Time of creation : 16:26
 */
@SuppressWarnings("UnusedDeclaration")
public class Tree {

    private Node root;

    /**
     * Add a single node to the tree
     *
     * @param customer a single created customer
     * @return boolean, false when there was an error in adding the customer. Two customers share the same ID.
     *                  true when the customer in the list were added to the tree with no errors.
     */
    public boolean addNode(Customer customer){

        Node addedNode = new Node(customer);

        /**
         *  if root is equal to null,
         *  the added node becomes the root node
         */
        if(root == null) {
            root = addedNode;

            return true;
        }

        /**
         * else,
         * the new node needs a place in the tree
         */
        else {

            Node hover = root, parent;

            /**
             * no place has been found
             *
             * when an empty spot has found the
             * function returns out of the while
             */
            while (true) {
                parent = hover;

                /**
                 * if the added node's Id is the same as the checked node's id,
                 * notify and do not add
                 */
                if(addedNode.getID().compareToIgnoreCase(hover.getID()) == 0) {
                    System.out.println("node already exists");
                    return false;
                }

                /**
                 * if the added node's id has a lower value than the checked node,
                 * go left
                 */
                else if(addedNode.getID().compareToIgnoreCase(hover.getID()) < 0) {
                    hover = hover.getLeft();

                    /**
                     * when the spot is empty,
                     * add the newer node in this place
                     * and return
                     */
                    if(hover == null){
                        parent.setLeft(addedNode);
                        return true;
                    }
                }

                /**
                 * else, it should be a bigger value,
                 * so go to the right
                 */
                else {
                    hover = hover.getRight();

                    /**
                     * when the spot is empty,
                     * add the newer node in this place
                     * and return
                     */
                    if(hover == null){
                        parent.setRight(addedNode);
                        return true;
                    }
                }
            }
        }
    }

    /**
     * Adding a list of customers to the tree.
     *
     * @param customers list of created customers
     * @return boolean, false when there was an error in adding the customers. Two customers share the same ID.
     *                  true when all customers in the list were added to the tree with no errors.
     */
    public boolean addNodes(ArrayList<Customer> customers){

        /**
         * for each item in the arraylist,
         * create and add a node to the tree
         */
        for (Customer customer : customers) {

            /**
             * if a customer cannot be added to the tree
             * return false and exit.
             */
            if(!addNode(customer)){
                return false;
            }
        }
        /**
         * if all nodes were successfully added
         * return true and exit.
         */
        return true;
    }

    /**
     * Show all nodes in the tree ordered from lowest value to highest.
     *
     * @param node the node from where so start, most of the times this would be root.
     */
    public void inOrderTraverse(Node node) {
        if(node != null){
            inOrderTraverse(node.getLeft());

            System.out.println(node);

            inOrderTraverse(node.getRight());
        }
    }

    /**
     * Removes a specific node from the tree by its ID
     *
     * @param id this is the ID of the node which will be deleted from the tree.
     * @return boolean, false if node did not exists or could not be deleted.
     *                  true if node has been deleted successfully
     */
    public boolean removeNode(String id){

        /**
         * Creating both local variables for the hover node (node to delete) and his parent node
         */
        Node hover = root;
        Node parent = root;

        /**
         * Finding the node matching the ID.
         */
        while(!hover.getID().equals(id)) {

            parent = hover;
            /**
             * If the ID of the hover is bigger then the one that is checked.
             * It means the node to be deleted is on the left side of the current node
             */
            if(id.compareToIgnoreCase(hover.getID()) < 0) {
                hover = hover.getLeft();
            }

            /**
             * Else, the node is on the right side, so move to the right
             */
            else {
                hover = hover.getRight();
            }

            /**
             * if the current node is null
             * the node did not exist
             * so it can not be deleted
             */
            if(hover == null) {
                System.out.println(id+" was not found, check if id was right.");
                return false;
            }
        }



        /**
         * If both children of the node-to-remove are null,
         * remove the node with no further ado
         */
        if(hover.getLeft() == null && hover.getRight() == null){

            /**
             * If hover == root, make it null.
             */
            if(hover.equals(root)){
                root = null;
                return true;

            /**
             * else make his the parents left or right null
             */
            } else {

                if(parent.getLeft().getID().equals(id)){ /** left **/
                    parent.setLeft(null);
                    return true;
                }
                else { /** right **/
                    parent.setRight(null);
                    return true;
                }
            }
        }

        /**
         * if RIGHT is NULL
         * and LEFT is not NULL
         */
        else if (hover.getRight() == null && hover.getLeft() != null) {

            /**
             * If hover == root, make the left node of root the new root.
             */
            if(hover == root){
                root = root.getLeft();
                return true;
            }

            /**
             * If the parents left node is the node to delete,
             * move the left node of the hover to the left side of the parent
             */
            if(parent.getLeft() == hover){
                parent.setLeft(hover.getLeft());
                return true;
            }

            /**
             * Else move the left node of the hover to the right side of the parent node
             */
            else {
                parent.setRight(hover.getLeft());
                return true;
            }
        }

        /**
         * if RIGHT is not NULL
         * and LEFT is NULL
         */
        else if (hover.getRight() != null && hover.getLeft() == null) {

            /**
             * If hover == root, make the right node of root the new root.
             */
            if(hover == root){
                root = root.getRight();
                return true;
            }

            /**
             * If the parents left node is the node to delete,
             * move the right node of the hover to the left side of the parent
             */
            if(parent.getLeft() == hover){
                parent.setLeft(hover.getRight());
                return true;
            }

            /**
             * Else move the right node of the hover to the right side of the parent node
             */
            else {
                parent.setRight(hover.getRight());
                return true;
            }

        }

        /**
         * if RIGHT is not NULL
         * and LEFT is not NULL
         */
        else {

            /**
             * when a node has 2 subtrees and it is going to be deleted,
             * the highest value of the left subtree, or the lowest value of the right subtree has to replace it.
             *
             * the code below will get the lowest value of the right subtree.
             *
             * go into right subtree, get the left of the left until the left has no left anymore.
             */


            /**
             * if the right child of the node that is going to be deleted has no left child. place its right tree in his position.
             */
            if(hover.getRight().getLeft() == null) {
                if(id.equals(root.getID())){
                    /**
                     * if it was the root, the root will be the right of the deleted node.
                     * and the left of the root wil be the left of the deleted root.
                     */
                    root = hover.getRight();
                    root.setLeft(hover.getLeft());
                    return true;
                }

                /**
                 * Move the left subtree of the deleted node to the left (or right) of his parent.
                 */
                if(parent.getLeft().getID().equals(id)){ /** left **/
                    parent.setLeft(hover.getRight());
                    hover.getRight().setLeft(hover.getLeft());
                    return true;
                }
                else { /** right **/
                    parent.setRight(hover.getRight());
                    hover.getLeft().setLeft(hover.getLeft());
                    return true;
                }

            }

            /**
             * if the right child of the node that is going to be deleted does have a left child.
             */
            else {

                /**
                 * Save variables of for Replacement node (lowest in right subtree) and the Parent of the Replacement
                 */
                Node replacementParent = hover.getRight();
                Node replacement = hover.getRight().getLeft();

                /** While nothing has been changed (returns true to exit function) **/
                while (true) {

                    /**
                     * if the replacement node doesnot have any left nodes,
                     * then it has to be the smallest possible value.
                     */
                    if(replacement.getLeft() == null) {

                        /**
                         * if the replacement node had any right nodes,
                         * stick them to the replacements parent
                         *
                         * (if it were to be null, it will stay null)
                         */
                        replacementParent.setLeft(replacement.getRight());

                        /**
                         * Check if it were the left child or the right child of the parent to be deleted,
                         *
                         * The replacement node will be attached to the parent of te deleted node.
                         * The entire left subtree of the deleted node becomes the subtree of the replacement node.
                         */
                        if(parent.getLeft().getID().equals(id)){ /** left **/
                            parent.setLeft(replacement);
                            replacement.setLeft(hover.getLeft());
                            return true;
                        } else { /** right **/
                            parent.setRight(replacement);
                            replacement.setLeft(hover.getLeft());
                            return true;
                        }

                    /**
                     * if the replacement has a left child.
                     * move everything 1 more spot to the left.
                     */
                    } else {
                        replacementParent = replacement;
                        replacement = replacement.getLeft();
                    }
                }
            }
        }
    }


    /**
     * This function will search for A Node in the Tree.
     *
     * @param id the ID of the node that is searched
     * @return Node, if Node was found it will return this node, else it returns null.
     */
    public Node findNode(String id){
        /**
         * Hover node is the current node for inspection
         */
        Node hover = root;

        System.out.println("---------------- \nSearch Started;");
        System.out.println("Searching for "+id);

        /**
         * As long as the searched node does not equal the inspection node
         */
        while(!id.equals(hover.getID())){
            /**
             * When the id is lower than that of the inspection node, we need to dig to the left.
             */
            if(id.compareToIgnoreCase(hover.getID()) < 0) {
                hover = hover.getLeft();
            }

            /**
             * Else, we need to go to the right.
             */
            else {
                hover = hover.getRight();
            }

            /**
             * If the is not in the tree, it wil become null.
             * so we will send a message and return null.
             */
            if(hover == null){
                System.out.println(id+" was not found, returning null.\n----------------\n");
                return null;
            }
        }

        /**
         * when the nodes is found, return it.
         */
        System.out.println("Node found, user is : "+hover+"\n----------------");
        return hover;
    }

    public Node getRoot() {
        return root;
    }
}
