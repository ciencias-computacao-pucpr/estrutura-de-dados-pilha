import fila.Fila;
import fila.FilaEncadeada;
import fila.FilaEstatica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FilaEncadeadaTest {
    Fila<Integer> fila;
    @BeforeEach
    public void setup() {
        fila = new FilaEncadeada<>();
    }

    @Test
    public void adicionarItensNaFila() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        fila.insere(1);
        assertEquals(1, fila.frente());
    }

    @Test
    public void removerEmUmaFilaVaziaDisparaException() {
        assertNull(fila.remove());
    }

    @Test
    public void peekEmUmaFilaVaziaDisparaException() {
        assertNull(fila.frente());
    }

    @Test
    public void removerEmUmaFilaComItemRetornaOPrimeiroDaFilaEORemove() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        fila.insere(1);
        fila.insere(3);
        assertEquals(1, fila.remove());
    }

    @Test
    public void adicionandoRemovendoEAdicionandoNovamenteFuncionaNormalmente() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        fila.insere(1);
        assertEquals(1, fila.remove());
        fila.insere(3);
        fila.insere(5);
        assertEquals(3, fila.remove());
        assertEquals(5, fila.remove());
        assertNull(fila.remove());
    }

    @Test
    public void filaVazioToString() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        assertEquals("", fila.toString());
    }

    @Test
    public void filaQuandoPrimeiroMenorQueUltimoToStringFuncionaCorretamente() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        fila.insere(1);
        fila.remove();
        fila.insere(3);
        fila.insere(5);
        assertEquals("3, 5", fila.toString());
    }

    @Test
    public void filaQuandoPrimeiroMaiorQueUltimoToStringFuncionaCorretamente() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        fila.insere(1);
        fila.insere(3);
        fila.remove();
        fila.insere(5);
        assertEquals("3, 5", fila.toString());
    }


}
