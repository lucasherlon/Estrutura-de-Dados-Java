package ufpi.estdados;

import java.util.NoSuchElementException;

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

    public void empilhar(Tipo elemento) {
        if(this.top >= TAM) throw new StackOverflowError("Pilha cheia: não é possível empilhar");
     
        this.vetor[top++] = elemento;
    }
    
    public Tipo desempilhar() {
        if (estaVazia()) throw new NoSuchElementException("Pilha Vazia: não é possível desempilhar");
        top--;
        Tipo elemento = this.vetor[top];
        this.vetor[top] = null;
        return elemento;
    }
    
    public Tipo getTopo() {
    	if(estaVazia()) throw new NoSuchElementException("A pilha está vazia");
    	return this.vetor[top-1];
    }

}
