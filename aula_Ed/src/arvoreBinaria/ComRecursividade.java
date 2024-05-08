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
	public int altura(No noDado) {
		No noAtual = noDado;
		int direita = 0 ;
		int esquerda = 0;
		if (noAtual == null ) {
			return 0;
		}
		if (noAtual.getDireita()!= null) {
			direita = altura(noAtual.getDireita());
			
		}
		if( noAtual.getEsquerda()!= null) {
			esquerda = altura(noAtual.getEsquerda());
		}
		if(noAtual == noRaiz) {
			return ((direita > esquerda) ? direita : esquerda);
		}
		
		return 1 + ((direita > esquerda) ? direita : esquerda);
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
	        No sucessor = noAtual;
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
	private boolean isEstritamenteBinaria(No no) {
        if (no == null)
            return true;
        if (no.getEsquerda() == null && no.getDireita() == null)
            return true;
        if (no.getEsquerda() != null && no.getDireita() != null)
            return isEstritamenteBinaria(no.getEsquerda()) && isEstritamenteBinaria(no.getDireita());
        return false;
    }

    private boolean isCompleta(No no, int indice, int totalNos) {
        if (no == null)
            return true;
        if (indice >= totalNos)
            return false;
        return (isCompleta(no.getEsquerda(), 2 * indice + 1, totalNos) &&
                isCompleta(no.getDireita(), 2 * indice + 2, totalNos));
    }

    private int contarNos(No no) {
        if (no == null)
            return 0;
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    private boolean isCheia(No no) {
        int totalNos = contarNos(no);
        int indice = 0;
        return isCompleta(no, indice, totalNos);
    }


    public String determinarTipoArvore(No raiz) {
        if (isEstritamenteBinaria(raiz))
            return "Árvore estritamente binária.";
        else if (isCheia(raiz))
            return "Árvore binária cheia.";
        else
            return "Árvore binária completa.";
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
		System.out.println("\n Altura");
		System.out.println("------------\n");
		System.out.println(carlinhos.altura(carlinhos.noRaiz));
		carlinhos.inserirNo(carlinhos.noRaiz, 5);
		System.out.println("\n Altura");
		System.out.println("------------\n");
		System.out.println(carlinhos.altura(carlinhos.noRaiz));
		carlinhos.inserirNo(carlinhos.noRaiz, 3);
		carlinhos.inserirNo(carlinhos.noRaiz, 4);
		carlinhos.inserirNo(carlinhos.noRaiz, 1);
		System.out.println("\n Altura");
		System.out.println("------------\n");
		System.out.println(carlinhos.altura(carlinhos.noRaiz));
		carlinhos.inserirNo(carlinhos.noRaiz, 2);
		carlinhos.inserirNo(carlinhos.noRaiz, 8);
		carlinhos.inserirNo(carlinhos.noRaiz, 7);
		carlinhos.inserirNo(carlinhos.noRaiz, 9);
		carlinhos.inserirNo(carlinhos.noRaiz, 6);
		carlinhos.inserirNo(carlinhos.noRaiz, 10);
		System.out.println("\n Altura");
		System.out.println("------------\n");
		System.out.println(carlinhos.altura(carlinhos.noRaiz));
		carlinhos.remover(8);
		System.out.println("\n Removido");
		System.out.println("------------\n");
		carlinhos.imprimirOrdenado(carlinhos.noRaiz);
		System.out.println("\n Tipo");
		System.out.println("------------\n");
		System.out.println(carlinhos.determinarTipoArvore(carlinhos.noRaiz));
		
	}
}
