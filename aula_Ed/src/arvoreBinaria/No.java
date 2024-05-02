package arvoreBinaria;

public class No{
	private int elemento;
	private No direita;
	private No esquerda;
	
	public No(int valor) {
		this.elemento = valor;
		this.direita = null;
		this.esquerda = null;
	}
	public int getElemento() {
		return elemento;
	}
	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	public No getDireita() {
		return direita;
	}
	public void setDireita(No direita) {
		this.direita = direita;
	}
	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
	public No getEsquerda() {
		return esquerda;
	}
	
	
}

