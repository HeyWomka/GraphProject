package graph;

public class VertexList {

    private final int vertex;
    private final int weight;

    public VertexList (int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "v: " + vertex + " | w:" + weight;
    }
}
