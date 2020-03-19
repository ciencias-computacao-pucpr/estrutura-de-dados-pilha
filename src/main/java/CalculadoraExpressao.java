import operadores.Operador;

public class CalculadoraExpressao {

    private String expressao;

    public CalculadoraExpressao(String expressao) {
        this.expressao = expressao;
    }

    private Pilha<Float> empilharNumeros(String exp) {
        Pilha<Float> resultado = new Pilha<>(100);
        StringBuilder b = new StringBuilder();
        for (char c : exp.toCharArray()) {
            if (c >= '0' && c <= '9') {
                b.append(c);
            } else if (b.length() > 0) {
                resultado.empilha(Float.valueOf(b.toString()));
                b.setLength(0);
            }
        }

        if (b.length() > 0)
            resultado.empilha(Float.valueOf(b.toString()));

        return resultado;
    }

    private Pilha<Operador> empilharOperacoes(String exp) {
        Pilha<Operador> resultado = new Pilha<>(100);
        for (char c : exp.toCharArray()) {
            Operador operador = Operador.novo(c);
            if (operador != null)
                resultado.empilha(operador);
        }

        return resultado;
    }

    public float calcular() {
        if (!new Validador(expressao).isValido()) {
            throw new Validador.ExpressaoInvalidaException();
        }

        Pilha<Float> pilhaNumeros = empilharNumeros(expressao);
        Pilha<Operador> pilhaOperacoes = empilharOperacoes(expressao);

        while (!pilhaOperacoes.vazia()) {
            Operador op = pilhaOperacoes.desempilha();

            if (op != null) {
                Float direita = pilhaNumeros.desempilha();
                Float esquerda = pilhaNumeros.desempilha();
                float resultado = op.calcula(direita, esquerda);
                pilhaNumeros.empilha(resultado);
            }
        }

        return pilhaNumeros.desempilha();
    }
}
