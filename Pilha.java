package ufpi.estdados;

public class Pilha <Tipo> {

    private Tipo[] vetor;
    private int top;
    private final int TAM = 5;

    public Pilha() {
        this.vetor = (Tipo[]) new Object[TAM];
        this.top = 0;
    }

    public boolean estaVazia() {return this.top == 0;}

    public int tamanho() { return this.top;}

    public void empilhar(Tipo elemento) throws Exception {
        if(this.top >= TAM) {
            throw new Exception("Pilha cheia: não é possível empilhar");
        }
        this.vetor[this.top++] = elemento;
    }
    
    public Tipo desempilhar() throws Exception{
        if (estaVazia()) throw new Exception("Pilha Vazia: não é possível desempilhar");
       
        this.top--;
        Tipo elemento = this.vetor[this.top];
        this.vetor[this.top] = null;
        
        return elemento;
    }
    
    public Tipo getTopo() {
    	this.top--;
    	return this.vetor[this.top];
    }

}