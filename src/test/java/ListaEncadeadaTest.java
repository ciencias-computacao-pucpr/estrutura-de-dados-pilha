import lista.ListaEncadeada;
import lista.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaEncadeadaTest {
    ListaEncadeada<Integer> lista = null;

    @BeforeEach
    public void setup() {
        lista = new ListaEncadeada<>();
    }


    @Test
    public void vaziaEmUmaListaVazia() {
        Assertions.assertTrue(lista.vazia());
    }

    @Test
    public void vaziaEmUmaListaPopulada() {
        lista.insereUltimo(10);
        lista.insereUltimo(21);

        Assertions.assertFalse(lista.vazia());
    }

    @Test
    public void adicionarItensNaLista() {
        lista.insereUltimo(10);
        lista.insereUltimo(21);

        Assertions.assertEquals("10, 21",lista.toString());
    }

    @Test
    public void valorEmListaVazia() {
        Assertions.assertNull(lista.valorEm(0));
    }

    @Test
    public void valorEmListaPopulada() {
        lista.insereUltimo(10);
        lista.insereUltimo(21);

        Assertions.assertEquals(10,lista.valorEm(0).getInfo());
        Assertions.assertEquals(21,lista.valorEm(1).getInfo());
    }

    @Test
    public void adicionarDepoisDeNode() {
        lista.insereUltimo(10);
        lista.insereUltimo(21);

        Node<Integer> valor0 = lista.valorEm(0);

        lista.insereDepois(valor0, 30);

        Assertions.assertEquals("10, 30, 21",lista.toString());
    }

    @Test
    public void adicionarUltimoEmListaVazia() {
        lista.insereUltimo(30);

        Assertions.assertEquals("30",lista.toString());
    }
    @Test
    public void adicionarUltimoEmListaPopulada() {
        lista.insereUltimo(10);
        lista.insereUltimo(21);
        lista.insereUltimo(30);

        Assertions.assertEquals("10, 21, 30",lista.toString());
    }

    @Test
    public void adicionarPrimeirEmListaVazia() {
        lista.inserePrimeiro(30);

        Assertions.assertEquals("30",lista.toString());
    }
    @Test
    public void adicionarPrimeiroEmListaPopulada() {
        lista.insereUltimo(10);
        lista.insereUltimo(21);

        lista.inserePrimeiro(30);

        Assertions.assertEquals("30, 10, 21",lista.toString());
    }

    @Test
    public void adicionarOrdenadoEmListaVazia() {
        lista.insereOrdenado(30);

        Assertions.assertEquals("30",lista.toString());
    }
    @Test
    public void adicionarOrdenadoEmListaPopulada() {
        lista.insereUltimo(10);
        lista.insereUltimo(21);

        lista.insereOrdenado(15);

        Assertions.assertEquals("10, 15, 21",lista.toString());

        lista.insereOrdenado(1);
        Assertions.assertEquals("1, 10, 15, 21",lista.toString());

        lista.insereOrdenado(40);
        Assertions.assertEquals("1, 10, 15, 21, 40",lista.toString());
    }

    @Test
    public void insereSomenteUsandoOrdenado() {
        lista.insereOrdenado(45);
        lista.insereOrdenado(12);
        lista.insereOrdenado(100);
        lista.insereOrdenado(-2);
        lista.insereOrdenado(7);
        lista.insereOrdenado(99);
        lista.insereOrdenado(2000);
        lista.insereOrdenado(12);

        Assertions.assertEquals("-2, 7, 12, 12, 45, 99, 100, 2000", lista.toString());
    }

    @Test
    public void removerPrimeiroDeUmaListaVazia() {
        Assertions.assertNull(lista.removePrimeiro());
    }

    @Test
    public void removerPrimeiroDeUmaListaPopulada() {
        lista.insereOrdenado(45);
        lista.insereOrdenado(12);
        lista.insereOrdenado(100);
        Assertions.assertEquals(12, lista.removePrimeiro().getInfo());
        Assertions.assertEquals("45, 100", lista.toString());
    }

    @Test
    public void removerUltimoDeUmaListaVazia() {
        Assertions.assertNull(lista.removeUltimo());
    }

    @Test
    public void removerUltimoDeUmaListaPopulada() {
        lista.insereOrdenado(45);
        lista.insereOrdenado(12);
        lista.insereOrdenado(100);
        Assertions.assertEquals(100, lista.removeUltimo().getInfo());
        Assertions.assertEquals("12, 45", lista.toString());
    }

}
