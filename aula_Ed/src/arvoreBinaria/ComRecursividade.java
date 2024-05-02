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
	public void remover(int elemento) {
	    No pai = null;
	    No noAtual = noRaiz;

	    while (noAtual != null && noAtual.getElemento() != elemento) {
	        pai = noAtual;
	        if (elemento < noAtual.getElemento()) {
	            noAtual = noAtual.getEsquerda();
	        } else {
	            noAtual = noAtual.getDireita();
	        }
	    }

	    if (noAtual == null) {
	        return;
	    }

	    if (noAtual.getEsquerda() == null && noAtual.getDireita() == null) {
	        if (noAtual != noRaiz) {
	            if (pai.getEsquerda() == noAtual) {
	                pai.setEsquerda(null);
	            } else {
	                pai.setDireita(null);
	            }
	        } else {
	            noRaiz = null;
	        }
	    } else if (noAtual.getEsquerda() != null && noAtual.getDireita() != null) {
	        No sucessor = noAtual.getDireita();
	        while (sucessor.getEsquerda() != null) {
	            pai = sucessor;
	            sucessor = sucessor.getEsquerda();
	        }
	        noAtual.setElemento(sucessor.getElemento());
	        if (pai == noAtual) {
	            pai.setDireita(sucessor.getDireita());
	        } else {
	            pai.setEsquerda(sucessor.getDireita());
	        }
	    } else {
	        No filho = (noAtual.getEsquerda() != null) ? noAtual.getEsquerda() : noAtual.getDireita();
	        if (noAtual != noRaiz) {
	            if (noAtual == pai.getEsquerda()) {
	                pai.setEsquerda(filho);
	            } else {
	                pai.setDireita(filho);
	            }
	        } else {
	            noRaiz = filho;
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
	public No buscar(int elemento) {
        No noAtual = noRaiz;
        while (noAtual != null) {
            if (elemento == noAtual.getElemento()) {
                return noAtual;
            } else if (elemento < noAtual.getElemento()) {
                noAtual = noAtual.getEsquerda();
            } else {
                noAtual = noAtual.getDireita();
            }
        }
        return null;
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
		System.out.println("\n Pre Ordem ");
		carlinhos.imprimirPreOrdem(carlinhos.noRaiz);
		System.out.println("\n ORDENADO");
		System.out.println("------------\n");
		carlinhos.imprimirOrdenado(carlinhos.noRaiz);
		System.out.println("\n Pos Ordem");
		System.out.println("------------\n");
		carlinhos.imprimirPosOrdem(carlinhos.noRaiz);
		System.out.println("\n BUSCAR");
		System.out.println("------------\n");
		System.out.println(carlinhos.buscar(9));
		carlinhos.remover(5);
		System.out.println("\n Removido");
		System.out.println("------------\n");
		carlinhos.imprimirOrdenado(carlinhos.noRaiz);
		
	}
}