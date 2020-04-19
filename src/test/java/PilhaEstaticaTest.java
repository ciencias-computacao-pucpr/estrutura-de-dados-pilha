import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pilha.PilhaEstatica;
import pilha.exception.PilhaCheiaException;
import pilha.exception.PilhaVaziaException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PilhaEstaticaTest {

    @Test
    void empilhando1NumeroEleDesempilha() {
        PilhaEstatica<String> pilha = new PilhaEstatica<>(1);

        pilha.empilha("a");
        assertEquals("a",pilha.desempilha());
    }

    @Test
    void chamandoTopoParaUmaPilhaVaziaNaoDeveDarErro() {
        PilhaEstatica<String> pilha = new PilhaEstatica<>(1);

        Assertions.assertDoesNotThrow(pilha::topo);
    }

    @Test
    void empilhando2NumeroEleDesempilhaDoUltimoParaOPrimeiro() {
        PilhaEstatica<String> pilha = new PilhaEstatica<>(2);

        pilha.empilha("a");
        pilha.empilha("b");
        assertEquals("b",pilha.desempilha());
        assertEquals("a",pilha.desempilha());
    }

    @Test
    void empilharMaisQueOTamanhoMaximoDisparaExcecao() {

        Assertions.assertThrows(PilhaCheiaException.class, () -> {
            PilhaEstatica<String> pilha = new PilhaEstatica<>(1);
            pilha.empilha("a");
            pilha.empilha("a");
            pilha.empilha("a");
        });

    }

    @Test
    void desempilharEmUmaPilhaVaziaDisparaExcecao() {

        Assertions.assertThrows(PilhaVaziaException.class, () -> {
            PilhaEstatica pilha = new PilhaEstatica(0);
            pilha.desempilha();
        });

    }

}
