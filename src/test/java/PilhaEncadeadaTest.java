import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pilha.Pilha;
import pilha.PilhaEncadeada;
import pilha.PilhaEstatica;
import pilha.exception.PilhaCheiaException;
import pilha.exception.PilhaVaziaException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PilhaEncadeadaTest {
    Pilha<String> pilha;
    @BeforeEach
    public void setup() {
        pilha = new PilhaEncadeada<String>();
    }

    @Test
    void empilhando1NumeroEleDesempilha() {
        pilha.empilha("a");
        assertEquals("a",pilha.desempilha());
    }

    @Test
    void chamandoTopoParaUmaPilhaVaziaNaoDeveDarErro() {
        Assertions.assertDoesNotThrow(pilha::topo);
    }

    @Test
    void empilhando2NumeroEleDesempilhaDoUltimoParaOPrimeiro() {
        pilha.empilha("a");
        pilha.empilha("b");
        assertEquals("b",pilha.desempilha());
        assertEquals("a",pilha.desempilha());
    }

    @Test
    void desempilharEmUmaPilhaVaziaDisparaExcecao() {

        Assertions.assertThrows(PilhaVaziaException.class, () -> {
            pilha.desempilha();
        });

    }

}
