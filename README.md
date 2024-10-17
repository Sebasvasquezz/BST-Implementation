# BST

This project implements a Binary Tree data structure in Java. The Binary Tree supports various operations such as insertion, searching, traversal (in-order, pre-order, post-order, and level-order), finding minimum and maximum values, checking height, verifying balance, and clearing the tree.

## Features

- **Add**: Add elements to the tree.
- **Search**: Check if an element exists in the tree.
- **Traversal**:
  - **In-Order Traversal**: Visit left subtree, root, right subtree.
  - **Pre-Order Traversal**: Visit root, left subtree, right subtree.
  - **Post-Order Traversal**: Visit left subtree, right subtree, root.
  - **Level-Order Traversal**: Visit nodes level by level.
- **Find Min/Max**: Retrieve the smallest and largest values in the tree.
- **Height**: Calculate the height of the tree.
- **Is Balanced**: Determine if the tree is balanced.
- **Clear**: Remove all elements from the tree.

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