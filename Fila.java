import java.util.NoSuchElementException;
/*
  Fila com prioridades
  @author Davi Nascimento
  @author Kauã Marques
  @author Lucas Herlon
*/
public class Fila { 
	    private Pessoa inicio;
	    private Pessoa fim;
	    private int tamanho;
	    int normal, prioridade, atendida;

	    public Fila(){
	        this.inicio=null;
	        this.fim=null;
	        this.tamanho=0;
	        normal = prioridade = atendida = 0;
	    }
	    public void adicionar(String nome, int idade){
	        Pessoa pe = new Pessoa(nome, idade);
	        if (this.inicio==null){
	            this.inicio = pe;
	            this.fim = pe;
	            this.tamanho++;
	        }else if (pe.getIdade() > this.inicio.getIdade() && pe.getIdade() >= 60){
	            this.inicio.setAnterior(pe);
	            pe.setProximo(this.inicio);
	            pe.setAnterior(null);
	            this.inicio = pe;
	            this.tamanho++;
	        }else{
	            if (idade >= 60){
	                Pessoa atual = this.inicio;
	                while (idade <= atual.getIdade()){
	                    atual = atual.getProximo();
	                }
	                Pessoa anti = atual.getAnterior();
	                anti.setProximo(pe);
	                pe.setAnterior(anti);
	                pe.setProximo(atual);
	                atual.setAnterior(pe);
	                this.tamanho++;
	            }else{
	                this.fim.setProximo(pe);
	                pe.setAnterior(this.fim);
	                pe.setProximo(null);
	                this.fim = pe;
	                this.tamanho++;
	            }
	        }
	    }
	    public Pessoa remover(){
	        Pessoa pe = this.inicio;
	        if (this.tamanho>1){
	        	if(this.inicio.getIdade() >= 60)
	        		prioridade++;
	        	else
	        		normal++;
	        	atendida++;
	            this.inicio = this.inicio.getProximo();
	            this.inicio.setAnterior(null);
	            pe.setProximo(null);
	            this.tamanho--;
	        }else if (this.tamanho==1){
	        	if(this.inicio.getIdade() >= 60)
	        		prioridade++;
	        	else
	        		normal++;
	        	atendida++;
	            this.inicio=null;
	            this.fim=null;
	            this.tamanho--;
	        }else if (this.tamanho==0){
	            throw new NoSuchElementException("\nO fila não tem nenhuma pessoa!\n");
	        }
	        return pe;
	    }
	    @Override
	    public String toString() {
	        int i = 1;
	    	String show = "";
	        if (this.inicio!=null){
	            Pessoa atual = this.inicio;
	            while(atual!=null){
	                show += "\n" + i + " Lugar:" + atual.getNome() + " - Idade: " + atual.getIdade() + "\n";
	                atual = atual.getProximo();
	                i++;
	            }
	        }
	        return show;
	    
	    
	}
	    public String estatistica() {
	    	String nome = null;
	    	nome += "\nPorcentagem de Prioridades Atendidas: ";
			nome += ((double)prioridade/atendida)*100.0 + "%";
			nome += "\nPorcentagem de Pessoas Normais atendidas: ";
			nome += ((double)normal/atendida)*100.0 + "%" + "\nPessoas Atendidas: " + atendida;
	    	return nome;
	    }
	    public int getTamanho() {
	    	return tamanho;
	    }
}
