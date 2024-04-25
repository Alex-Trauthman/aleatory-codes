package aula3;

public class ListaDuplamenteEncadeada {
    private No head;
    private No tail;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }


    public void inserirNoInicio(int elemento) {
        No novoNo = new No(elemento);
        if (estaVazia()) {
            head = novoNo;
            tail = novoNo;
        } else {
            novoNo.proximo = head;
            head.anterior = novoNo;
            head = novoNo;
        }
        tamanho++;
    }


    public void inserirNoFim(int elemento) {
        No novoNo = new No(elemento);
        if (estaVazia()) {
            head = novoNo;
            tail = novoNo;
        } else {
            tail.proximo = novoNo;
            novoNo.anterior = tail;
            tail = novoNo;
        }
        tamanho++;
    }


    public void inserirNoMeio(int elemento) {
        No novoNo = new No(elemento);
        if (estaVazia() || head.elemento >= elemento) {
            inserirNoInicio(elemento);
        } else if (tail.elemento <= elemento) {
            inserirNoFim(elemento);
        } else {
            No atual = head;
            while (atual.proximo != null && atual.proximo.elemento < elemento) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo.anterior = novoNo;
            atual.proximo = novoNo;
            novoNo.anterior = atual;
            tamanho++;
        }
    }


    public void removerDoInicio() {
        if (!estaVazia()) {
            head = head.proximo;
            if (head != null) {
                head.anterior = null;
            } else {
                tail = null;
            }
            tamanho--;
        }
    }


    public void removerDoFim() {
        if (!estaVazia()) {
            tail = tail.anterior;
            if (tail != null) {
                tail.proximo = null;
            } else {
                head = null;
            }
            tamanho--;
        }
    }

 
    public void removerDoMeio(int elemento) {
        if (!estaVazia()) {
            if (head.elemento == elemento) {
                removerDoInicio();
            } else if (tail.elemento == elemento) {
                removerDoFim();
            } else {
                No atual = head;
                while (atual != null && atual.elemento != elemento) {
                    atual = atual.proximo;
                }
                if (atual != null) {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                    tamanho--;
                }
            }
        }
    }

   
    public int tamanho() {
        return tamanho;
    }

  
    public boolean estaVazia() {
        return tamanho == 0;
    }


    public void imprimirLista() {
        No atual = head;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.inserirNoMeio(5);
        lista.inserirNoMeio(3);
        lista.inserirNoMeio(7);
        lista.inserirNoMeio(1);

        lista.imprimirLista(); 

        lista.removerDoMeio(3);

        lista.imprimirLista(); 
    }
}