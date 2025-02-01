class Graph {
    String[] vertices;   // Düğümler (vertex) dizisi
    int[][] edges;       // Kenarları tutan matris
    int maxVartices;      // Maksimum düğüm sayısı
    int numberOfVertices; // Mevcut düğüm sayısı

    // Constructor: Grafı başlatır
    public Graph(int n) {
        vertices = new String[n];  // Düğümler dizisini oluştur
        edges = new int[n][n];     // Kenarlar matrisini oluştur
        maxVartices = n;            // Maksimum düğüm sayısını ayarla
        numberOfVertices = 0;       // Başlangıçta hiç düğüm yok
    }

    // Düğüm ekler
    boolean insertVertex(String newVertex) {
        if (numberOfVertices >= maxVartices)
            return false;  // Eğer kapasite dolmuşsa, düğüm eklenemez

        vertices[numberOfVertices++] = newVertex;  // Yeni düğümü ekle
        return true;
    }

    // Kenar ekler (Yönsüz grafik olduğu için her iki yönü de ekler)
    boolean insertEdge(int fromVertex, int toVertex) {
        if (fromVertex < 0 || fromVertex >= maxVartices || toVertex < 0 || toVertex >= maxVartices)
            return false;  // Geçersiz indeksler

        if (fromVertex == toVertex)
            return false;  // Bir düğüme kendisine kenar eklenemez

        edges[fromVertex][toVertex] = 1;  // Kenar ekle
        edges[toVertex][fromVertex] = 1;  // Yönsüz olduğu için, kenarın tersini de ekle
        return true;
    }

    // Düğüm bilgilerini gösterir
    void showVertex(int vertexNumber) {
        if (vertexNumber < 0 || vertexNumber >= numberOfVertices) {
            System.out.println("Geçersiz düğüm numarası.");
            return;
        }
        System.out.println("Vertex: " + vertices[vertexNumber]);
    }

    // Bir düğümden çıkan kenarları gösterir
    void showEdges(int vertexNumber) {
        if (vertexNumber < 0 || vertexNumber >= numberOfVertices) {
            System.out.println("Geçersiz düğüm numarası.");
            return;
        }

        System.out.println("Düğüm " + vertices[vertexNumber] + " ile bağlantılı düğümler:");
        for (int i = 0; i < numberOfVertices; i++) {
            if (edges[vertexNumber][i] == 1) {
                System.out.println(vertices[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 5 düğümlük bir graf oluştur
        Graph graph = new Graph(5);

        // Düğümleri ekle
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        // Kenarları ekle
        graph.insertEdge(0, 1);  // A - B
        graph.insertEdge(0, 2);  // A - C
        graph.insertEdge(1, 3);  // B - D
        graph.insertEdge(2, 4);  // C - E

        // Düğümleri ve kenarları göster
        graph.showVertex(0);  // A
        graph.showEdges(0);    // A'nın kenarları

        graph.showVertex(1);  // B
        graph.showEdges(1);    // B'nin kenarları
    }
}
