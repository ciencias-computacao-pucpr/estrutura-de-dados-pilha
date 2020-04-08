import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListaEncadeadaTest {

    @Test
    public void vaziaEmUmaListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        Assertions.assertTrue(lista.vazia());
    }

    @Test
    public void vaziaEmUmaListaPopulada() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.insereUltimo(10);
        lista.insereUltimo(21);

        Assertions.assertFalse(lista.vazia());
    }

    @Test
    public void adicionarItensNaLista() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.insereUltimo(10);
        lista.insereUltimo(21);

        Assertions.assertEquals("10, 21",lista.imprime());
    }

    @Test
    public void valorEmListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        Assertions.assertNull(lista.valorEm(0));
    }

    @Test
    public void valorEmListaPopulada() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.insereUltimo(10);
        lista.insereUltimo(21);

        Assertions.assertEquals(10,lista.valorEm(0).getInfo());
        Assertions.assertEquals(21,lista.valorEm(1).getInfo());
    }

    @Test
    public void adicionarDepoisDeNode() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.insereUltimo(10);
        lista.insereUltimo(21);

        ListaEncadeada.Node<Integer> valor0 = lista.valorEm(0);

        lista.insereDepois(valor0, 30);

        Assertions.assertEquals("10, 30, 21",lista.imprime());
    }

    @Test
    public void adicionarUltimoEmListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.insereUltimo(30);

        Assertions.assertEquals("30",lista.imprime());
    }
    @Test
    public void adicionarUltimoEmListaPopulada() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.insereUltimo(10);
        lista.insereUltimo(21);

        lista.insereUltimo(30);

        Assertions.assertEquals("10, 21, 30",lista.imprime());
    }

    @Test
    public void adicionarPrimeirEmListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserePrimeiro(30);

        Assertions.assertEquals("30",lista.imprime());
    }
    @Test
    public void adicionarPrimeiroEmListaPopulada() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.insereUltimo(10);
        lista.insereUltimo(21);

        lista.inserePrimeiro(30);

        Assertions.assertEquals("30, 10, 21",lista.imprime());
    }

    @Test
    public void adicionarOrdenadoEmListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.insereOrdenado(30);

        Assertions.assertEquals("30",lista.imprime());
    }
    @Test
    public void adicionarOrdenadoEmListaPopulada() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.insereUltimo(10);
        lista.insereUltimo(21);

        lista.insereOrdenado(15);

        Assertions.assertEquals("10, 15, 21",lista.imprime());

        lista.insereOrdenado(1);
        Assertions.assertEquals("1, 10, 15, 21",lista.imprime());

        lista.insereOrdenado(40);
        Assertions.assertEquals("1, 10, 15, 21, 40",lista.imprime());
    }

}
