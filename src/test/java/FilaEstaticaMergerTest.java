import fila.FilaEstatica;
import fila.FilaMerger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilaEstaticaMergerTest {
    @Test
    public void dadoDuasFilasOrdenadasMergeContinuaOrdenado() throws FilaEstatica.FilaCheiaException {
        FilaEstatica<Integer> fila1 = new FilaEstatica<>(3);
        fila1.insere(1);
        fila1.insere(8);
        fila1.insere(9);
        FilaEstatica<Integer> fila2 = new FilaEstatica<>(5);
        fila2.insere(7);
        fila2.insere(8);
        fila2.insere(10);
        fila2.insere(11);
        fila2.insere(20);
        FilaEstatica<Integer> resultado = new FilaMerger<>(fila1, fila2).merge();
        Assertions.assertEquals("1, 7, 8, 8, 9, 10, 11, 20",resultado.toString());

    }

}
