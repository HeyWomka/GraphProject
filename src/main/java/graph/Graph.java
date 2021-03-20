package graph;

import java.util.*;

import static graph.Matrix.isOrientedEdge;
import static utils.Utils.*;

public class Graph {
    private static final int MAX_VERTICES = 25;
    private static int edges = 0;
    private static int vertices = 0;
    private static Matrix adjMatrix;
    private static Matrix incidenceMatrix;
    private static LinkedList<VertexList>[] adjLists;

    public static void initialize() {
        System.out.print("\nВведите число вершин графа: ");
        Graph.vertices = getIntMinMax(1, MAX_VERTICES);
        System.out.print("Введите число рёбер в графе: ");
        Graph.edges = getIntMinMax(0, MAX_VERTICES * MAX_VERTICES);
    }

    public static void printAdjacencyList() {
        if(adjLists.length < 1) {
            System.out.println("\n[I] Список смежности пуст, сначала неоходимо ввести граф.");
            fillAll();
        } else {
            System.out.println("\nСписок смежности: ");
            for (int i = 0; i < adjLists.length; i++) {
                System.out.println("V: " + i + " => " + adjLists[i].toString());
            }
        }
    }

    public static void addEdgeToList(int v1, int v2, int weight, boolean oriented) {
        adjLists[v1].add(new VertexList(v2, weight));
        if(!oriented) adjLists[v2].add(new VertexList(v1, weight));
    }

    public static void printAdjacencyMatrix() {
        if(adjMatrix == null) {
            System.out.println("\n[I] Матрица смежности пуста, сначала неоходимо ввести граф.");
            fillAll();
        } else {
            adjMatrix.showMatrix("Матрица смежности");
        }
    }

    public static void printIncidenceMatrix() {
        if(incidenceMatrix == null) {
            System.out.println("\n[I] Матрица инцидентности пуста, сначала неоходимо ввести граф.");
            fillAll();
        } else {
            incidenceMatrix.showMatrix("Матрица инцидентности");
        }
    }

    public static void fillAll(){
        Graph.initialize();
        adjMatrix = new Matrix(vertices, vertices);
        incidenceMatrix = new Matrix(vertices, edges);
        adjLists = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<>();

        int firstVertex;
        int secondVertex;
        int edgeWeight;
        boolean oriented;

        for (int edge = 0; edge < edges; edge++) {

            System.out.print("Ребро " + (edge + 1) + " | Соединяет две вершины: " +
                            "\nПервая вершина: ");
            firstVertex = getIntMinMax(0, vertices - 1);
            System.out.print("Вторая вершина: ");
            secondVertex = getIntMinMax(0, vertices - 1);
            System.out.print("Вес вершины: ");
            edgeWeight = getInt();
            oriented = isOrientedEdge();
            if(edgeWeight < 1) edgeWeight = 1;

            adjMatrix.addAdjacencyEdge(firstVertex, secondVertex, edgeWeight, oriented);
            incidenceMatrix.addIncidenceEdge(firstVertex, secondVertex, edge, edgeWeight, oriented);
            addEdgeToList(firstVertex, secondVertex, edgeWeight, oriented);
        }
    }

    public static void printAll() {
        printAdjacencyMatrix();
        printIncidenceMatrix();
        printAdjacencyList();
    }
}


