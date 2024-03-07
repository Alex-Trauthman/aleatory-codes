package aula3;

public class Pilha {
    private No topo;

    public Pilha() {
        this.topo = null;
    }

    public void push(int elemento) {
        No novoNo = new No(elemento);
        novoNo.setProximo(this.topo);
        this.topo = novoNo;
    }

    public void pop() {
        if (!vazio()) {
            No noRemovido = this.topo;
            this.topo = this.topo.getProximo();
            noRemovido.setProximo(null);
        }
    }

    public int tamanho() {
        int n = 0;
        No temp = this.topo;
        while (temp != null) {
            n++;
            temp = temp.getProximo();
        }
        return n;
    }

    public boolean vazio() {
        return this.topo == null;
    }

    public void imprimirPilha() {
        No temp = this.topo;
        System.out.print("Pilha: ");
        while (temp != null) {
            System.out.print(temp.getElemento() + " ");
            temp = temp.getProximo();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.push(10);
        pilha.push(5111110);
        pilha.push(40);

        pilha.imprimirPilha();


        pilha.pop();

        pilha.imprimirPilha();
    }
}
