package padroesestruturais.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Floresta {

    private final List<Arvore> arvores = new ArrayList<>();

    public void plantarArvore(int x, int y, int altura, String nome, String cor, String textura) {
        TipoArvore tipo = FabricaTipoArvore.getTipo(nome, cor, textura);
        arvores.add(new Arvore(x, y, altura, tipo));
    }

    public int getQuantidadeArvores() {
        return arvores.size();
    }

    public List<Arvore> getArvores() {
        return arvores;
    }

    public String desenhar() {
        StringBuilder sb = new StringBuilder();
        for (Arvore arvore : arvores) {
            sb.append(arvore.desenhar()).append("\n");
        }
        return sb.toString();
    }
}
