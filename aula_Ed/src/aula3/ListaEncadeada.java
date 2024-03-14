package aula3;

public class ListaEncadeada {
    No fim;
    No comeco;
    int tamanho;

    ListaEncadeada() {
        this.fim = null;
        this.comeco = null;
        this.tamanho = 0;
    }

    public void inserirFim(int elemento) {
        No novoNo = new No(elemento);
        if (comeco == null) {
            comeco = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }
        tamanho++;
    }

    public void inserirInicio(int elemento) {
        No novoNo = new No(elemento);
        if (comeco != null) {
            novoNo.setProximo(comeco);
            comeco = novoNo;
        } else {
            comeco = novoNo;
            fim = novoNo;
        }
        tamanho++;
    }

    public void inserirPosicao(int elemento, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        if (posicao == 0) {
            inserirInicio(elemento);
        } else if (posicao == tamanho) {
            inserirFim(elemento);
        } else {
            No novoNo = new No(elemento);
            No temp = comeco;
            for (int i = 0; i < posicao - 1; i++) {
                temp = temp.getProximo();
            }
            novoNo.setProximo(temp.getProximo());
            temp.setProximo(novoNo);
            tamanho++;
        }
    }

    public int removerInicio() {
        if (comeco == null) {
            throw new IllegalStateException("Lista vazia!");
        }
        int removido = comeco.getElemento();
        comeco = comeco.getProximo();
        tamanho--;
        return removido;
    }

    public int removerFim() {
        if (comeco == null) {
            throw new IllegalStateException("Lista vazia!");
        }
        if (comeco == fim) {
            int removido = comeco.getElemento();
            comeco = null;
            fim = null;
            tamanho--;
            return removido;
        }
        No temp = comeco;
        while (temp.getProximo() != fim) {
            temp = temp.getProximo();
        }
        int removido = fim.getElemento();
        fim = temp;
        fim.setProximo(null);
        tamanho--;
        return removido;
    }

    public int removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        if (posicao == 0) {
            return removerInicio();
        } else if (posicao == tamanho - 1) {
            return removerFim();
        } else {
            No temp = comeco;
            for (int i = 0; i < posicao - 1; i++) {
                temp = temp.getProximo();
            }
            int removido = temp.getProximo().getElemento();
            temp.setProximo(temp.getProximo().getProximo());
            tamanho--;
            return removido;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void imprimir() {
        No temp = comeco;
        int posicao = 0;
        System.out.print("Lista: ");
        while (temp != null) {
            System.out.print(temp.getElemento() + "(posição: " + posicao + ") ");
            temp = temp.getProximo();
            posicao++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.inserirPosicao(5, 0);
        lista.inserirPosicao(3, 0);
        lista.inserirPosicao(7, 2);
        lista.inserirPosicao(2, 1);

        System.out.println("Tamanho da lista: " + lista.tamanho());
        System.out.println("Lista vazia? " + lista.estaVazia());
        lista.imprimir();

        System.out.println("Removendo o elemento da posição 0: " + lista.removerPosicao(0));
        System.out.println("Removendo o elemento da posição 3: " + lista.removerPosicao(3));
        System.out.println("Removendo o elemento da posição 1: " + lista.removerPosicao(1));

        System.out.println("Tamanho da lista: " + lista.tamanho());
        System.out.println("Lista vazia? " + lista.estaVazia());
        lista.imprimir();
    }
}
