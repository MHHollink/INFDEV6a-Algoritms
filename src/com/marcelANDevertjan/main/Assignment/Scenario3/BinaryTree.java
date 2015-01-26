package com.marcelANDevertjan.main.Assignment.Scenario3;

import java.util.Arrays;

/**
 * This Class was created by marcel on 25-1-2015
 * Time of creation : 20:41
 */
public class BinaryTree {

    Node root;

    public void addNode(char[] keyName, String name){
        Node newNode = new Node(keyName, name);

        if(root == null){
            root = newNode;
        } else {
            Node focusNode = root;
            Node parrent;

            while (true){
                parrent = focusNode;
                if(keyName[0] < focusNode.keyName[0]){
                    focusNode = focusNode.left;
                    if(focusNode == null) {
                        parrent.left = newNode;
                        return;
                    }
                } else if (keyName[0] == focusNode.keyName[0]) {
                    for (int i = 0; i < keyName.length; i++) {
                        if(keyName[i] < focusNode.keyName[i]) {
                            focusNode = focusNode.left;
                            if (focusNode == null) {
                                parrent.left = newNode;
                                return;
                            }
                        } else if(keyName[i] > focusNode.keyName[i]){
                            focusNode = focusNode.right;
                            if(focusNode == null){
                                parrent.right = newNode;
                                return;
                            }
                        }

                    }
                    return;
                } else {
                    focusNode = focusNode.right;
                    if(focusNode == null){
                        parrent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverse(Node focusNode){

        if(focusNode != null) {
            inOrderTraverse(focusNode.left);

            System.out.println(focusNode);

            inOrderTraverse(focusNode.right);
        }

    }

    public boolean remove(char[] keyName){

        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while (focusNode.keyName[0] != keyName[0]) {

            parent = focusNode;

            if (keyName[0] < focusNode.keyName[0]) {

                isItALeftChild = true;

                focusNode = focusNode.left;
            } else {
                isItALeftChild = false;

                focusNode = focusNode.right;
            }

            if (focusNode == null)
                return false;

        }

        if(focusNode.left == null && focusNode.right == null){

            if(focusNode == root){
                root = null;
            } else if (isItALeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (focusNode.right == null) {
            if(focusNode == root){
                root = null;
            } else if (isItALeftChild) {
                parent.left = focusNode.left;
            } else {
                parent.right = focusNode.right;
            }
        } else {
            Node replacement = getReplacementNode(focusNode);

            if(focusNode == root){
                root = replacement;
            } else if (isItALeftChild){
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }

            replacement.left = focusNode.left;
        }

        return true;
    }

    private Node getReplacementNode(Node replaceNode) {
        Node replacementParent =  replaceNode;
        Node replacement = replaceNode;

        Node focusNode = replaceNode.right;

        while (focusNode != null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.left;
        }

        if(replacement != replaceNode.right){
            replacementParent.left = replacement.right;
            replacement.right = replaceNode.right;
        }

        return replacement;
    }

    public Node getRoot() {
        return root;
    }
}

class Node {

    char[] keyName;
    String name;

    Node left;
    Node right;

    Node(char[] keyName, String name){

        this.keyName = keyName;
        this.name = name;

    }

    public String toString() {
        return name + " has key " + Arrays.toString(keyName);
    }
}