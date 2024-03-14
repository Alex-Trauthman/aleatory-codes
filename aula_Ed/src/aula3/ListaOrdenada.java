package aula3;

public class ListaOrdenada {
    private No comeco;

    ListaOrdenada() {
        this.comeco = null;
    }

    public void inserir(int elemento) {
        No novoNo = new No(elemento);
        if (comeco == null || elemento < comeco.getElemento()) {
            novoNo.setProximo(comeco);
            comeco = novoNo;
        } else {
            No temp = comeco;
            while (temp.getProximo() != null && elemento > temp.getProximo().getElemento()) {
                temp = temp.getProximo();
            }
            novoNo.setProximo(temp.getProximo());
            temp.setProximo(novoNo);
        }
    }

    public void excluir(int elemento) {
        if (comeco == null) {
            return; 
        }

        if (comeco.getElemento() == elemento) {
            comeco = comeco.getProximo();
            return;
        }

        No anterior = comeco;
        No atual = comeco.getProximo();

        while (atual != null && atual.getElemento() != elemento) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null) {
            anterior.setProximo(atual.getProximo());
        }
    }

    public void imprimir() {
        No temp = comeco;
        System.out.print("Lista: ");
        while (temp != null) {
            System.out.print(temp.getElemento() + " ");
            temp = temp.getProximo();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaOrdenada lista = new ListaOrdenada();
        lista.inserir(5);
        lista.inserir(3);
        lista.inserir(8);
        lista.inserir(2);
        lista.inserir(7);
        lista.imprimir();

        lista.excluir(3);
        lista.imprimir();
    }
}