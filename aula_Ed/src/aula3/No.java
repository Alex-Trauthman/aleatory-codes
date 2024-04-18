package aula3;

public class No{
	int elemento;
	No proximo;
	No anterior;
	public No(int valor) {
		this.elemento = valor;
		this.proximo = null;
		this.anterior = null;
	}
	public int getElemento() {
		return elemento;
	}
	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
	public No getAnterior() {
		return anterior;
	}
	
}
