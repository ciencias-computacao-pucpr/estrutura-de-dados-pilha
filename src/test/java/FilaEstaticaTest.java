import fila.FilaEstatica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaEstaticaTest {

    @Test
    public void adicionarItensNaFila() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        FilaEstatica<Integer> fila = new FilaEstatica<>(1);
        fila.insere(1);
        assertEquals(1, fila.frente());
    }

    @Test
    public void adicionarEmUmaFilaCheiaDisparaException() throws FilaEstatica.FilaCheiaException {
        final FilaEstatica<Integer> fila = new FilaEstatica<>(1);
        fila.insere(1);
        Assertions.assertThrows(FilaEstatica.FilaCheiaException.class, () -> fila.insere(3));
    }

    @Test
    public void removerEmUmaFilaVaziaDisparaException() {
        FilaEstatica<Integer> fila = new FilaEstatica<>(1);
        assertNull(fila.remove());
    }

    @Test
    public void peekEmUmaFilaVaziaDisparaException() {
        FilaEstatica<Integer> fila = new FilaEstatica<>(1);
        assertNull(fila.frente());
    }

    @Test
    public void removerEmUmaFilaComItemRetornaOPrimeiroDaFilaEORemove() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        FilaEstatica<Integer> fila = new FilaEstatica<>(2);
        fila.insere(1);
        fila.insere(3);
        assertEquals(1, fila.remove());
    }

    @Test
    public void adicionandoRemovendoEAdicionandoNovamenteFuncionaNormalmente() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        FilaEstatica<Integer> fila = new FilaEstatica<>(2);
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
        FilaEstatica<Integer> fila = new FilaEstatica<>(2);
        assertEquals("", fila.toString());
    }

    @Test
    public void filaQuandoPrimeiroMenorQueUltimoToStringFuncionaCorretamente() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        FilaEstatica<Integer> fila = new FilaEstatica<>(2);
        fila.insere(1);
        fila.remove();
        fila.insere(3);
        fila.insere(5);
        assertEquals("3, 5", fila.toString());
    }

    @Test
    public void filaQuandoPrimeiroMaiorQueUltimoToStringFuncionaCorretamente() throws FilaEstatica.FilaCheiaException, FilaEstatica.FilaVaziaException {
        FilaEstatica<Integer> fila = new FilaEstatica<>(2);
        fila.insere(1);
        fila.insere(3);
        fila.remove();
        fila.insere(5);
        assertEquals("3, 5", fila.toString());
    }


}
