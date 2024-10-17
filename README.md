# Binary Search Tree (BST) Implementation

This project implements a generic *Binary Search Tree (BST)* in Java, which adheres to the Java List interface. The BST provides efficient operations for insertion, deletion, searching, and traversals while supporting multiple data types using Java generics. It includes functionalities to check if the tree is balanced, calculate its height, and perform level-order, in-order, pre-order, and post-order traversals.

### Key Features Implemented

1. *Insertion (add)*
   - *Purpose*: Adds a new node to the tree while maintaining the binary tree properties. Each new value is placed in the correct position to ensure the tree's structure remains valid.
   - *Implementation*: The method is recursive and places the value in the left or right subtree depending on its comparison to the current node.

2. *Search (search)*
   - *Purpose*: Finds and returns the node containing the specified value, or returns null if the value is not present in the tree.
   - *Implementation*: The method traverses the tree recursively, comparing the target value with the current node to find the desired node.

3. *Deletion (remove)*
   - *Purpose*: Removes a node while maintaining the BST properties. It handles three cases: deleting a leaf node, a node with one child, and a node with two children.
   - *Implementation*: For nodes with two children, the in-order successor or predecessor is used to replace the node, ensuring the tree's structure is maintained.

4. *Traversal Methods*
   - *In-order Traversal (inOrderTraversal)*: Visits nodes in ascending order. This method is used to produce a sorted sequence of node values.
   - *Pre-order Traversal (preOrderTraversal)*: Visits the root first, followed by the left and right subtrees.
   - *Post-order Traversal (postOrderTraversal)*: Visits the left and right subtrees first, then the root. Useful for freeing or deleting nodes.
   - *Level-order Traversal (levelOrderTraversal)*: Visits all nodes at each level, starting from the root, using a queue for breadth-first traversal.

5. *Find Minimum (findMin)*
   - *Purpose*: Finds the smallest value in the tree, which is located at the leftmost node.
   - *Implementation*: The method recursively traverses the left subtree to find and return the leftmost node.

6. *Find Maximum (findMax)*
   - *Purpose*: Finds the largest value in the tree, located at the rightmost node.
   - *Implementation*: The method traverses the right subtree to find and return the rightmost node.

7. *Height (height)*
   - *Purpose*: Calculates the height of the tree, defined as the longest path from the root to any leaf.
   - *Implementation*: This recursive method computes the height of the left and right subtrees and returns the greater value plus one for the current node.

8. *Check if the Tree is Balanced (isBalanced)*
   - *Purpose*: Determines if the tree is balanced by comparing the height of its left and right subtrees.
   - *Implementation*: The method recursively checks each subtree and returns true if the height difference between left and right is at most one for all nodes.

9. *Level-Order Traversal (levelOrderTraversal)*
   - *Purpose*: Traverses the tree level by level starting from the root, using a breadth-first search.
   - *Implementation*: This function uses a queue to process each node, visiting all nodes at each level before moving to the next level.

10. *Clear (clear)*
    - *Purpose*: Removes all nodes from the tree, effectively making it empty.
    - *Implementation*: The method sets the root node to null, clearing the entire tree.

11. *Count Nodes (countNodes)*
    - *Purpose*: Returns the total number of nodes present in the tree.
    - *Implementation*: This function recursively traverses the tree, counting each node as it traverses both the left and right subtrees.

### Additional Implemented Functions

- *toArray*: Converts the tree to an array, allowing for easier manipulation of its elements outside the tree structure.
- *contains*: Checks if a specific value exists in the tree using the search function.
- *size*: Returns the total number of nodes in the tree, leveraging the countNodes method.
- *iterator*: Provides an in-order iterator for traversing the tree in sorted order.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You need to install the following tools and configure their dependencies:

1. **Java** (versions 8 or higher)
    ```sh
    java -version
    ```
    Should return something like:
    ```sh
    java version "1.8.0"
    Java(TM) SE Runtime Environment (build 1.8.0-b132)
    Java HotSpot(TM) 64-Bit Server VM (build 25.0-b70, mixed mode)
    ```

2. **Maven**
    - Download Maven from [here](http://maven.apache.org/download.html)
    - Follow the installation instructions [here](http://maven.apache.org/download.html#Installation)

    Verify the installation:
    ```sh
    mvn -version
    ```
    Should return something like:
    ```sh
    Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
    Maven home: /usr/share/maven
    Java version: 1.8.0_241, vendor: Oracle Corporation
    Default locale: en_US, platform encoding: UTF-8
    ```

3. **Git**
    - Install Git by following the instructions [here](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

    Verify the installation:
    ```sh
    git --version
    ```
    Should return something like:
    ```sh
    git version 2.25.1
    ```


## How to Use the Binary Search Tree

This Binary Search Tree (BST) implementation allows users to insert, delete, search, and traverse nodes. It supports various data types using Java generics, enabling operations on integers, strings, doubles, and more.

### Features:
1. *Insert Values*: Add values to the tree while maintaining BST properties.
2. *Delete Values*: Remove values from the tree while preserving its structure.
3. *Search Values*: Find specific values within the tree.
4. *Traversals*:
   - In-order: Ascending order for numbers.
   - Pre-order: Root node first.
   - Post-order: Root node last.
   - Level-order: Breadth-first traversal.
5. *Tree Properties*:
   - Calculate the height of the tree.
   - Check if the tree is balanced.
6. *Support for Different Data Types*: Perform the above operations on different data types (e.g., Integer, String, Double).

## Installing

1. Clone the repository and navigate into the project directory:
    ```sh
    git clone https://github.com/Sebasvasquezz/BST-Implementation.git
    cd BST
    ```

2. Run the test of the implementation:
    ```sh
    mvn tests
    ```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Git](http://git-scm.com/) - Version Control System

## Versioning

I use [GitHub](https://github.com/) for versioning. For the versions available, see the [tags on this repository](https://github.com/Sebasvasquezz/BST-Implementation).

## Authors

* **Juan Sebastian Vasquez Vega**  - [Sebasvasquezz](https://github.com/Sebasvasquezz)

## Date

October 16, 2024

## License

This project is licensed under the GNU License - see the [LICENSE.txt](LICENSE.txt) file for details.