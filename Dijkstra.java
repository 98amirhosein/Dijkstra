import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    static List<Node> map = new ArrayList<>();
    static int v = 9;
    static int matrix[][] = {{0, 7, 9, 11, 0, 0, 0, 0, 0},
            {7, 0, 0, 0, 5, 0, 0, 0, 0},
            {9, 0, 0, 0, 0, 3, 0, 0, 0},
            {11, 0, 0, 0, 0, 0, 10, 0, 0},
            {0, 5, 0, 0, 0, 5, 0, 0, 4},
            {0, 0, 3, 0, 5, 0, 0, 6, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 10, 10, 0, 0},
            {0, 0, 0, 0, 4, 0, 0, 0, 0}};

    public static void setGraph() {

        for (int i = 0; i < v; i++) {
            map.add(new Node(i));
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (matrix[i][j] != 0)
                    map.get(i).addNeighbor(map.get(j), matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        setGraph();
        map.get(0).setD(0);
        while (!map.isEmpty()) {
            int index = 0;
            int min=1000000000;
            for (int  m = 0; m < map.size(); m++){
                if (map.get(m).getD()<min){
                    index = m;
                    min = map.get(m).getD();
                }
            }
            for (int i = 0; i < map.get(index).neighbor.size(); i++) {
                int temp = map.get(index).getD() + map.get(index).cost.get(i);
                if (temp < map.get(index).neighbor.get(i).getD()) {
                    map.get(index).neighbor.get(i).setD(temp);
                }
            }
            System.out.println(map.get(index).n + "--->" + map.get(index).getD());
            map.remove(index);
        }
    }


}
