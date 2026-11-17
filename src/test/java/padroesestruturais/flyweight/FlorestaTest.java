package padroesestruturais.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class FlorestaTest {

    @BeforeEach
    void limparFabrica() {
        FabricaTipoArvore.limpar();
    }

    @Test
    void deveReutilizarMesmoTipoParaMesmosAtributos() {
        TipoArvore a = FabricaTipoArvore.getTipo("Pinheiro", "verde", "agulhas");
        TipoArvore b = FabricaTipoArvore.getTipo("Pinheiro", "verde", "agulhas");
        assertSame(a, b);
        assertEquals(1, FabricaTipoArvore.getTotalTipos());
    }

    @Test
    void deveCriarTiposDiferentesParaAtributosDiferentes() {
        TipoArvore a = FabricaTipoArvore.getTipo("Pinheiro", "verde", "agulhas");
        TipoArvore b = FabricaTipoArvore.getTipo("Carvalho", "verde", "folhas");
        assertNotSame(a, b);
        assertEquals(2, FabricaTipoArvore.getTotalTipos());
    }

    @Test
    void milArvoresDevemCompartilharUmUnicoTipo() {
        Floresta floresta = new Floresta();
        for (int i = 0; i < 1000; i++) {
            floresta.plantarArvore(i, i, 5, "Ipe", "amarelo", "flores");
        }
        assertEquals(1000, floresta.getQuantidadeArvores());
        assertEquals(1, FabricaTipoArvore.getTotalTipos());
    }

    @Test
    void arvoresDevemManterEstadoExtrinsecoProprio() {
        Floresta floresta = new Floresta();
        floresta.plantarArvore(1, 2, 3, "Ipe", "amarelo", "flores");
        floresta.plantarArvore(4, 5, 6, "Ipe", "amarelo", "flores");
        assertSame(floresta.getArvores().get(0).getTipo(), floresta.getArvores().get(1).getTipo());
        assertEquals("Ipe (amarelo, flores) em (1,2) com 3m", floresta.getArvores().get(0).desenhar());
        assertEquals("Ipe (amarelo, flores) em (4,5) com 6m", floresta.getArvores().get(1).desenhar());
    }
}
