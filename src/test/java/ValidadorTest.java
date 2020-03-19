import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorTest {
    @Test
    void dadoStringVaziaValidacaoEValida() {
        assertTrue(new Validador("").isValido());
    }

    @Test
    void dadoStringSemParentezesValidacaoEValida() {
        assertTrue(new Validador("1 + 2 + 3 * 5").isValido());
    }

    @Test
    void dadoStringComParentesesComParesValidosValidaTrue() {
        assertTrue(new Validador("(1 + 2) + [3 * 5]").isValido());
    }

    @Test
    void dadoStringComDiferenteTiposDeParentesesComParesValidosValidaTrue() {
        assertTrue(new Validador("{{[(1 + 2)]} + [3 * 5]}").isValido());
    }

    @Test
    void dadoStringComDiferenteTiposDeParentesesSobrandoDisparaExcessao() {
        assertFalse(new Validador("{{[(1 + 2)]}} + [3 * 5]}").isValido());
    }

    @Test
    void dadoStringComDiferenteTiposDeParentesesSobrandoMasEmOrdemInlalidaValidaFalse() {
        assertFalse(new Validador("({1 + 2)}").isValido());
    }
}
