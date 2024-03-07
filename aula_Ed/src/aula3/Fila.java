package aula3;

public class Fila {
    private No inicio;
    private No fim;
    private int tamanho;

    public Fila() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void inserir(int elemento) {
        No novoNo = new No(elemento);
        if (vazio()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }
        tamanho++;
    }

    public void retirar() {
        if (vazio()) {
            System.out.println("A fila está vazia. Não é possível remover.");
            return;
        }

        inicio = inicio.getProximo();
        tamanho--;

        if (vazio()) {
            fim = null;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean vazio() {
        return inicio == null;
    }

    public void imprimirFila() {
        No temp = inicio;
        System.out.print("Fila: ");
        while (temp != null) {
            System.out.print(temp.getElemento() + " ");
            temp = temp.getProximo();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Fila fila = new Fila();


        fila.inserir(104);
        fila.inserir(230);
        fila.inserir(130);

        fila.imprimirFila();

        System.out.println("A fila está vazia? " + fila.vazio());

        fila.retirar();

        fila.imprimirFila();
    }
}
