package br.ufpi.lucasherlon.estdados.pilha;
// Pilha feita com vetor sem reajuste de tamanho
public class Pilha <Tipo> {

    private Tipo[] vetor;
    private int top;
    private final int TAM = 1000;

    public Pilha() {
        this.vetor = (Tipo[]) new Object[TAM];
        this.top = 0;
    }

    public boolean estaVazia() {return top == 0;}

    public int tamanho() { return this.top;}

    public void empilhar(Tipo elemento) throws Exception {
        if(this.top >= TAM) {
            throw new Exception("Pilha cheia: não é possível empilhar");
        }
        this.vetor[top++] = elemento;
    }

    public void desempilhar() throws Exception {
        if (estaVazia()) {
            throw new Exception("Pilha Vazia: não é possível desempilhar");
        }
        this.vetor[top--] = null;
    }

}
