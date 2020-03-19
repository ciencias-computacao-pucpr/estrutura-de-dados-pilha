import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PilhaTest {

    @Test
    void empilhando1NumeroEleDesempilha() {
        Pilha<String> pilha = new Pilha<>(1);

        pilha.empilha("a");
        assertEquals("a",pilha.desempilha());
    }

    @Test
    void empilhando2NumeroEleDesempilhaDoUltimoParaOPrimeiro() {
        Pilha<String> pilha = new Pilha<>(2);

        pilha.empilha("a");
        pilha.empilha("b");
        assertEquals("b",pilha.desempilha());
        assertEquals("a",pilha.desempilha());
    }

    @Test
    void empilharMaisQueOTamanhoMaximoDisparaExcecao() {

        Assertions.assertThrows(Pilha.PilhaCheiaException.class, () -> {
            Pilha<String> pilha = new Pilha<>(1);
            pilha.empilha("a");
            pilha.empilha("a");
            pilha.empilha("a");
        });

    }

    @Test
    void desempilharEmUmaPilhaVaziaDisparaExcecao() {

        Assertions.assertThrows(Pilha.PilhaVaziaException.class, () -> {
            Pilha pilha = new Pilha(0);
            pilha.desempilha();
        });

    }

}
