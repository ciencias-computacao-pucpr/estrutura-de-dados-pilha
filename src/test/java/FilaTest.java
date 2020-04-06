import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaTest {

    @Test
    public void adicionarItensNaFila() throws Fila.FilaCheiaException, Fila.FilaVaziaException {
        Fila<Integer> fila = new Fila<>(1);
        fila.adicionar(1);
        assertEquals(1, fila.peek());
    }

    @Test
    public void adicionarEmUmaFilaCheiaDisparaException() throws Fila.FilaCheiaException {
        final Fila<Integer> fila = new Fila<>(1);
        fila.adicionar(1);
        Assertions.assertThrows(Fila.FilaCheiaException.class, () -> fila.adicionar(3));
    }

    @Test
    public void removerEmUmaFilaVaziaDisparaException() {
        Fila<Integer> fila = new Fila<>(1);
        assertNull(fila.remover());
    }

    @Test
    public void peekEmUmaFilaVaziaDisparaException() {
        Fila<Integer> fila = new Fila<>(1);
        assertNull(fila.peek());
    }

    @Test
    public void removerEmUmaFilaComItemRetornaOPrimeiroDaFilaEORemove() throws Fila.FilaCheiaException, Fila.FilaVaziaException {
        Fila<Integer> fila = new Fila<>(2);
        fila.adicionar(1);
        fila.adicionar(3);
        assertEquals(1, fila.remover());
    }

    @Test
    public void adicionandoRemovendoEAdicionandoNovamenteFuncionaNormalmente() throws Fila.FilaCheiaException, Fila.FilaVaziaException {
        Fila<Integer> fila = new Fila<>(2);
        fila.adicionar(1);
        assertEquals(1, fila.remover());
        fila.adicionar(3);
        fila.adicionar(5);
        assertEquals(3, fila.remover());
        assertEquals(5, fila.remover());
        assertNull(fila.remover());
    }

    @Test
    public void filaVazioToString() throws Fila.FilaCheiaException, Fila.FilaVaziaException {
        Fila<Integer> fila = new Fila<>(2);
        assertEquals("", fila.toString());
    }

    @Test
    public void filaQuandoPrimeiroMenorQueUltimoToStringFuncionaCorretamente() throws Fila.FilaCheiaException, Fila.FilaVaziaException {
        Fila<Integer> fila = new Fila<>(2);
        fila.adicionar(1);
        fila.remover();
        fila.adicionar(3);
        fila.adicionar(5);
        assertEquals("3, 5", fila.toString());
    }

    @Test
    public void filaQuandoPrimeiroMaiorQueUltimoToStringFuncionaCorretamente() throws Fila.FilaCheiaException, Fila.FilaVaziaException {
        Fila<Integer> fila = new Fila<>(2);
        fila.adicionar(1);
        fila.adicionar(3);
        fila.remover();
        fila.adicionar(5);
        assertEquals("3, 5", fila.toString());
    }


}
