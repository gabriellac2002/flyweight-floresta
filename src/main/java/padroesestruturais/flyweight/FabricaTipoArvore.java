package padroesestruturais.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaTipoArvore {

    private static final Map<String, TipoArvore> tipos = new HashMap<>();

    private FabricaTipoArvore() {
    }

    public static TipoArvore getTipo(String nome, String cor, String textura) {
        String chave = nome + "|" + cor + "|" + textura;
        return tipos.computeIfAbsent(chave, k -> new TipoArvore(nome, cor, textura));
    }

    public static int getTotalTipos() {
        return tipos.size();
    }

    public static void limpar() {
        tipos.clear();
    }
}
