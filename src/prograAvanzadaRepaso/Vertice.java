package prograAvanzadaRepaso;

public class Vertice implements Comparable<Vertice>{
    int nodoPartida;
    int nodoDestino;
    int key;

    public Vertice(int nodoPartida, int nodoDestino, int key) {
        this.nodoPartida = nodoPartida;
        this.nodoDestino = nodoDestino;
        this.key = key;
    }

    @Override
    public int compareTo(Vertice other) {
        return Integer.compare(this.key, other.key);
    }
}
