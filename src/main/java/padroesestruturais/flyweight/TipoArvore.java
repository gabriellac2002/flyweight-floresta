package padroesestruturais.flyweight;

public class TipoArvore {

    private final String nome;
    private final String cor;
    private final String textura;

    public TipoArvore(String nome, String cor, String textura) {
        this.nome = nome;
        this.cor = cor;
        this.textura = textura;
    }

    public String getNome() {
        return nome;
    }

    public String desenhar(int x, int y, int altura) {
        return nome + " (" + cor + ", " + textura + ") em (" + x + "," + y + ") com " + altura + "m";
    }
}
