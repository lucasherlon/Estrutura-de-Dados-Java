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
     
        this.vetor[this.top++] = elemento;
    }
    
    public Tipo desempilhar() {
        if (estaVazia()) throw new NoSuchElementException("Pilha Vazia: não é possível desempilhar");
        this.top--;
        Tipo elemento = this.vetor[this.top];
        this.vetor[this.top] = null;
        return elemento;
    }
    
    public Tipo getTopo() {
    	if(estaVazia()) throw new NoSuchElementException("A pilha está vazia");
    	return this.vetor[this.top-1];
    }

}