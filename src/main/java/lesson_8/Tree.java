package lesson_8;

import java.util.Comparator;

public class Tree {
    Node root;

    /*public void insert(int id, int parentId) {
        insert(id, parentId, root);
    }*/

    public void insert(int id, int parentId, Node subRoot) {
        if (parentId == subRoot.id) {
            subRoot.childs.add(new Node(id));
            subRoot.childs.sort(Comparator.comparingInt(n -> n.id));
        } else {
            for (int i = 0; i < subRoot.childs.size(); i++) {
                insert(id, parentId, subRoot.childs.get(i));
            }
        }
    }

    public void directDfs(Node subrootNode) {
        if (subrootNode != null) {
            subrootNode.info();
            for (int i = 0; i < subrootNode.childs.size(); i++) {
                directDfs(subrootNode.childs.get(i));
            }
        }
    }
}
