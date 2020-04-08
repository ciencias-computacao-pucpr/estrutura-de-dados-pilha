package pilha;

public class Validador {
    private final String expressao;
    private Pilha<String> pilha;
    private boolean paresCompletos;

    public Validador(String expressao) {
        this.expressao = expressao;
        int t = 0;
        for (char c : expressao.toCharArray()) {
            if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c =='}') {
                t++;
            }
        }

        paresCompletos = (t % 2 == 0);

        pilha = new Pilha<>(t);
    }

    public boolean isValido() {
        if (!paresCompletos)
            return false;

        for (char c : expressao.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pilha.empilha(String.valueOf(c));
                continue;
            }

            if (c ==')' || c == ']' || c == '}') {
                if (pilha.vazia()) return false;

                String valor = pilha.desempilha();
                if (valor.equals("(") && c != ')') return false;
                if (valor.equals("[") && c != ']') return false;
                if (valor.equals("{") && c != '}') return false;
            }

        }

        return pilha.vazia();
    }

    public static class ExpressaoInvalidaException extends RuntimeException {

    }
}
