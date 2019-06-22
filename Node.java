import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> neighbor = new ArrayList<>();
    List<Integer> cost = new ArrayList<>();
    int n;
    private int d=1000000000;

    public Node(int n) {
        this.n = n;
    }

    public void addNeighbor(Node neighbor, int cost) {
        this.neighbor.add(neighbor);
        this.cost.add(cost);
    }

    public int getD() {
        return d;
    }


    public void setD(int d) {
        this.d = d;
    }
}
