package arep.BST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void testAddAndSize() {
        assertTrue(bst.isEmpty());
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertEquals(3, bst.size());
    }

    @Test
    void testContains() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(3));
        assertFalse(bst.contains(10));
    }

    @Test
    void testRemoveAndSize() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertEquals(3, bst.size());
        bst.remove((Integer) 3);
        assertEquals(2, bst.size());
        assertFalse(bst.contains(3));
    }

    @Test
    void testGet() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertEquals(3, bst.get(0));  // In-order traversal: [3, 5, 7]
        assertEquals(5, bst.get(1));
        assertEquals(7, bst.get(2));
    }

    @Test
    void testInOrderTraversal() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        List<Integer> expectedOrder = Arrays.asList(3, 5, 7);
        assertEquals(expectedOrder, bst.inOrderTraversal());
    }

    @Test
    void testPreOrderTraversal() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        List<Integer> expectedOrder = Arrays.asList(5, 3, 7);
        assertEquals(expectedOrder, bst.preOrderTraversal());
    }

    @Test
    void testIndexOf() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertEquals(0, bst.indexOf(3)); // In-order traversal: [3, 5, 7]
        assertEquals(2, bst.indexOf(7));
        assertEquals(-1, bst.indexOf(10));
    }

    @Test
    void testClear() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.clear();
        assertTrue(bst.isEmpty());
        assertEquals(0, bst.size());
    }

    @Test
    void testToArray() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        Object[] expectedArray = {3, 5, 7};
        assertArrayEquals(expectedArray, bst.toArray());
    }
    @Test
    void testSearch() {
        bst.add(10);
        bst.add(5);
        bst.add(20);
        
        assertNotNull(bst.search(10)); // El valor 10 está presente
        assertNotNull(bst.search(5));  // El valor 5 está presente
        assertNull(bst.search(30)); // El valor 30 no está presente
    }
    @Test
    void testPostOrderTraversal() {
        
        bst.add(10);
        bst.add(5);
        bst.add(20);
        
        List<Integer> expectedPostOrder = Arrays.asList(5, 20, 10);
        List<Integer> result = bst.postOrderTraversal();
        assertEquals(expectedPostOrder, result);
    }
    @Test
    void testFindMin() {
        bst.add(10);
        bst.add(5);
        bst.add(20);
        
        assertEquals(5, bst.findMin());
    }

    @Test
     void testFindMax() {
        bst.add(10);
        bst.add(5);
        bst.add(20);
        
        assertEquals(20, (int) bst.findMax());
    }

    @Test
     void testHeight() {
        bst.add(10);
        bst.add(5);
        bst.add(20);
        
        assertEquals(1, bst.height());
    }
    @Test
     void testIsBalanced() {
        bst.add(10);
        bst.add(5);
        bst.add(20);
        
        assertTrue(bst.isBalanced());
    }

    @Test
    void testLevelOrderTraversal() {
        bst.add(10);
        bst.add(5);
        bst.add(20);
        
        List<Integer> expectedLevelOrder = Arrays.asList(10, 5, 20);
        List<Integer> result = bst.levelOrderTraversal();
        
        assertEquals(expectedLevelOrder, result);
    }
    

}
