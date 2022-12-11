package listaligada;
/*
  Lista duplamente encadeada com dois descritores
  @author Davi Nascimento 
  @author Kauã Marques 
  @author Lucas Herlon
*/
import java.util.NoSuchElementException;

public class ListaEncadeada <Tipo> {
	
	private static class Node<Tipo> {
		private Tipo elemento;
		private Node<Tipo> anterior;
		private Node<Tipo> proximo;
		
		public Node(Tipo elemento) {
			this.elemento = elemento;
			this.anterior = null;
			this.proximo = null;
			
		}
	}

	private Node<Tipo> inicio;
	private Node<Tipo> fim;
	private int tamanho;
	
	public ListaEncadeada() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}
	
	public boolean estaVazia() {return this.tamanho == 0;}
	
	public int getTamanho() {return tamanho;}
	
	//adiciona novo nó no início da lista
	public void adicionaInicio(Tipo elemento) {
		if(estaVazia()) {
			Node<Tipo> node = new Node<>(elemento);
			this.inicio = node;
			this.fim = node;
			this.tamanho++;
		} else {
			if(estaNaLista(elemento)) {
				throw new IllegalArgumentException("Erro: o elemento já está na lista");
			}
			
			Node<Tipo> node = new Node<>(elemento);
			this.inicio.anterior = node;
			node.proximo = this.inicio;
			this.inicio = node;
			this.tamanho++;
		}
		
	}
	
	//Adiciona novo nó no final da lista
	public void adicionaFinal(Tipo elemento) {
		if(estaVazia()) {
			Node<Tipo> node = new Node<>(elemento);
			this.inicio = node;
			this.fim = node;
			this.tamanho++;
		} else {
			if(estaNaLista(elemento)) {
				throw new IllegalArgumentException("Erro: o elemento já está na lista");
			}
			Node<Tipo> node = new Node<>(elemento);
			this.fim.proximo = node;
			node.anterior = this.fim;
			this.fim = node;
			this.tamanho++;
		}
	}
	
	//Substitui o valor de um elemento na lista
	public void alteraElemento(Tipo elemento, Tipo novoElemento) {
		if(!estaNaLista(elemento)) {
			throw new NoSuchElementException("O elemento não está na lista");
		}
		
		Node<Tipo> atual = this.inicio;
		while(atual != null) {
			if (atual.elemento.equals(elemento)) {
				 atual.elemento = novoElemento;
				 return;
			}
			atual = atual.proximo;
		}
	}
	
	//Exclui o primeiro elemento da lista
	private Tipo excluirInicio() {
	    Tipo elemento = this.inicio.elemento;
	    this.inicio = this.inicio.proximo;
	    this.tamanho--;
	    if (estaVazia()) { 
	    	this.fim = null;
	    } else {
	    	this.inicio.anterior = null;
	    }
	    
	    return elemento;
	  }
	  
	//Exclui o último elemento da lista
	private Tipo excluirFim() {
	    Tipo elemento = this.fim.elemento;
	    this.fim = this.fim.anterior;
	    this.tamanho--;
	    
	    if (estaVazia()) { 
	    	this.inicio = null;
		}else {
		    this.fim.proximo = null;
		 }
		    return elemento;
	    }
	
	  //Exclui um elemento em qualquer posição da lista
	  public Tipo excluirElemento(Tipo elemento) {
		   if(!estaNaLista(elemento)) {
			   throw new NoSuchElementException("O elemento não está na lista");
		   }
		   Node<Tipo> node = elementoNaLista(elemento);
		   
		    if (node.anterior == null) { 
		    	return excluirInicio();
		    }
		    if (node.proximo == null) {
		    	return excluirFim();
		    }
		    node.proximo.anterior = node.anterior;
		    node.anterior.proximo = node.proximo;
		    Tipo aux = node.elemento;
		    node.elemento = null;
		    node = node.anterior = node.proximo = null;

		    this.tamanho--;

		    return aux;
	}

	//Imprime na tela os elementos da lista e o seu tamanho
	public void mostrarElementos() {
		if(estaVazia()) {
			System.out.println("[]");
			return;
		}
		Node<Tipo> atual = this.inicio;
		System.out.println(atual.elemento);
		while(atual.proximo != null) {
			atual = atual.proximo;
			System.out.println(atual.elemento);
		}
		System.out.println("Quantidade de elementos na lista: "+ this.tamanho);
	}
	
	//Diz se um elemento está ou não na lista
	public boolean estaNaLista(Tipo elemento) {
		Node<Tipo> atual = this.inicio;
		while(atual != null) {
			if (atual.elemento.equals(elemento)) {
				return true;
			}
			atual = atual.proximo;
		}
		return false;
	} 
	//Retorna um elemento da lista
	private Node<Tipo> elementoNaLista(Tipo elemento) {
		Node<Tipo> atual = this.inicio;
		while(atual != null) {
			if (atual.elemento.equals(elemento)) {
				return atual;
			}
			atual = atual.proximo;
		}
		return null;
	} 
	
}
