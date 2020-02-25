package lesson_8;

public class TreeTestDrive {
    public static void main(String[] args) {
        Tree testTree = new Tree();
        testTree.root = new Node(0);

        testTree.insert(1, 0, testTree.root);
        testTree.insert(2, 0, testTree.root);
        testTree.insert(3, 1, testTree.root);
        testTree.insert(4, 3, testTree.root);
        testTree.insert(5, 4, testTree.root);
        testTree.insert(6, 0, testTree.root);

        testTree.directDfs(testTree.root);
    }
}
