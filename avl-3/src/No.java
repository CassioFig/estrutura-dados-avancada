package src;

public class No {
    No direita, esquerda, pai;
    int elemento, cor; 

    public No(int elemento, int cor) {
        this.elemento = elemento;
        this.cor = cor; // 1 - VERMELHO, 2 - PRETO
    }

    public int getElemento() {
        return elemento;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getDireita() {
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
}
