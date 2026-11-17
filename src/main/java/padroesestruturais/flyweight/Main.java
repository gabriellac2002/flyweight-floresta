package padroesestruturais.flyweight;

public class Main {

    public static void main(String[] args) {
        Floresta floresta = new Floresta();

        for (int i = 0; i < 1000; i++) {
            floresta.plantarArvore(i, i * 2, 5 + i % 10, "Pinheiro", "verde-escuro", "agulhas");
            floresta.plantarArvore(i, i * 3, 8 + i % 5, "Carvalho", "verde", "folhas largas");
            floresta.plantarArvore(i, i * 4, 3 + i % 4, "Ipe", "amarelo", "flores");
        }

        System.out.println("Arvores plantadas: " + floresta.getQuantidadeArvores());
        System.out.println("Tipos criados (objetos compartilhados): " + FabricaTipoArvore.getTotalTipos());
        System.out.println(floresta.getArvores().get(0).desenhar());
    }
}
