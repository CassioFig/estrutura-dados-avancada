package src;

public class main {
    public static void main(String[] args) {
        
        // 0 - preto
        // 1 - vermelho
        
        Arvore arvore = new Arvore(13);
                
        arvore.adiciona(8);
        arvore.adiciona(17);
        arvore.adiciona(1);
        arvore.adiciona(11);
        arvore.adiciona(15);
        arvore.adiciona(25);
        arvore.adiciona(6);
        arvore.adiciona(22);
        arvore.adiciona(27);
        
        //arvore.qualACor(13);
        //arvore.remove(8);
        //arvore.encontra(25);
        
        arvore.print();
    }
}
