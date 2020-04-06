import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilaMergerTest {
    @Test
    public void dadoDuasFilasOrdenadasMergeContinuaOrdenado() throws Fila.FilaCheiaException {
        Fila<Integer> fila1 = new Fila<>(3);
        fila1.adicionar(1);
        fila1.adicionar(8);
        fila1.adicionar(9);
        Fila<Integer> fila2 = new Fila<>(5);
        fila2.adicionar(7);
        fila2.adicionar(8);
        fila2.adicionar(10);
        fila2.adicionar(11);
        fila2.adicionar(20);
        Fila<Integer> resultado = new FilaMerger<>(fila1, fila2).merge();
        Assertions.assertEquals("1, 7, 8, 8, 9, 10, 11, 20",resultado.toString());

    }

}
