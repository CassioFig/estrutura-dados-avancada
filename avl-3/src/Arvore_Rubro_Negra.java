package src;

public class Arvore_Rubro_Negra {
    No raiz;

    public Arvore_Rubro_Negra(No raiz) {
        this.raiz = raiz;
    }
    
    public No avo(No no){
        if (no.getPai() == null) {
            return null;
        }
        
        No pai = no.getPai();
        
        return pai.getPai();
    }
    
    public No tio(No no){
        No avo = avo(no);
        No pai = no.getPai();
        
        if (pai.elemento > avo.elemento) {
            return avo.getEsquerda();
        }else{
            return avo.getDireita();
        }
    }
    
    public void inserir(int value) {
        this.raiz = this.inserirNo(this.raiz, value);
    }

    public No inserirNo(No no, int valor) {
        if (no == null) {
            return new No(valor, 1);
        }

        if (valor < no.elemento) {
            no.esquerda = this.inserirNo(no.esquerda, valor);

        } else if (valor > no.elemento) {
            no.direita = this.inserirNo(no.direita, valor);

        } else {
            return no;
        }
        
        return verificaDepoisDeInserir(no);
    }
    
    public No verificaDepoisDeInserir(No no){
        tioVermelho(no);
        
        return no;
    }
    
    public No tioVermelho(No no){
        No tio = tio(no);
        No pai = no.getPai();
        No avo = avo(no);
        
        if (tio.getCor() == 1) {
            pai.setCor(0);
            avo.setCor(0);
            tio.setCor(0);
        }
        return null;
    }
}
