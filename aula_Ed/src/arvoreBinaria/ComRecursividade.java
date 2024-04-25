package arvoreBinaria;

public class ComRecursividade {
	public No noRaiz;

	public ComRecursividade() {
		this.noRaiz = null;
	}

	public void inserirNo(No noAtual, int elemento) {
		if (this.noRaiz == null) {
			
			noRaiz = new No(elemento);
			
		} else if (noAtual.getElemento() > elemento) {

			if (noAtual.getEsquerda() == null) {

				noAtual.setEsquerda(new No(elemento));
			} else {

				noAtual = noAtual.getEsquerda();
				inserirNo(noAtual, elemento);

			}
		}
		else if (noAtual.getElemento() < elemento) {

			if (noAtual.getDireita() == null) {

				noAtual.setDireita(new No(elemento));
			} else {

				noAtual = noAtual.getDireita();
				inserirNo(noAtual, elemento);

			}
		}
	}
	
	public void imprimirPreOrdem(No noAtual) {
			if (noAtual== null){
				return;
			}
			System.out.println(noAtual.getElemento());
				imprimirPreOrdem(noAtual.getEsquerda());
			
				imprimirPreOrdem(noAtual.getDireita());
			
	}
	public void imprimirOrdenado(No noAtual) {
	    if (noAtual == null) {
	        return;
	    }
	    imprimirOrdenado(noAtual.getEsquerda());
	    System.out.println(noAtual.getElemento());
	    imprimirOrdenado(noAtual.getDireita());
	}
	public void imprimirPosOrdem(No noAtual) {
		if (noAtual == null) {
			return;
		}
		imprimirPosOrdem(noAtual.getEsquerda());
		imprimirPosOrdem(noAtual.getDireita());
		System.out.println(noAtual.getElemento());
	}

	public static void main(String[] args) {
		ComRecursividade carlinhos = new ComRecursividade();
		carlinhos.inserirNo(carlinhos.noRaiz, 5);
		carlinhos.inserirNo(carlinhos.noRaiz, 3);
		carlinhos.inserirNo(carlinhos.noRaiz, 4);
		carlinhos.inserirNo(carlinhos.noRaiz, 1);
		carlinhos.inserirNo(carlinhos.noRaiz, 2);
		carlinhos.inserirNo(carlinhos.noRaiz, 8);
		carlinhos.inserirNo(carlinhos.noRaiz, 7);
		carlinhos.inserirNo(carlinhos.noRaiz, 9);
		carlinhos.inserirNo(carlinhos.noRaiz, 6);
		carlinhos.imprimirPreOrdem(carlinhos.noRaiz);
		System.out.println("\n ---------- \n");
		carlinhos.imprimirOrdenado(carlinhos.noRaiz);
		System.out.println("\n ---------- \n");
		carlinhos.imprimirPosOrdem(carlinhos.noRaiz);
	}
}