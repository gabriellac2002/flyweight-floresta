package padroesestruturais.flyweight;

public class Arvore {

    private final int x;
    private final int y;
    private final int altura;
    private final TipoArvore tipo;

    public Arvore(int x, int y, int altura, TipoArvore tipo) {
        this.x = x;
        this.y = y;
        this.altura = altura;
        this.tipo = tipo;
    }

    public TipoArvore getTipo() {
        return tipo;
    }

    public String desenhar() {
        return tipo.desenhar(x, y, altura);
    }
}
