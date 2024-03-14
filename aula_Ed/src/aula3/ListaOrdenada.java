package aula3;

public class ListaOrdenada {
	No comeco;
	
	ListaOrdenada(){
		this.comeco=null;
	}
	
	public void inserir(int elemento) {
		No novoNo = new No(elemento);
		No temp = comeco;
		if(temp!=null) {
			while (temp.getProximo() != null) {
				if (novoNo.getElemento() == temp.getProximo().getElemento()) {
					temp.setProximo(null);
				}else if (novoNo.getElemento()<temp.getElemento()) {
					novoNo.setProximo(temp);
					temp = novoNo;
					temp = temp.getProximo();
				}else {
					temp = temp.getProximo();
				}
			}
		}
		if (temp == null) {
			temp = novoNo; 
		}else if (novoNo.getElemento()>=temp.getElemento()) {
			temp.setProximo(novoNo);
		}
		
		
		comeco = temp;
	}
	
	public void imprimir() {
		No temp = comeco;
        System.out.print("Lista: ");
        System.out.println(" ");
        while (temp != null) {
            System.out.print(temp.getElemento());
            temp = temp.getProximo();
            System.out.println(" ");
        }
	}
	public static void main(String[] args) {
		
	}
}
