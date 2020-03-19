package operadores;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

public abstract class Operador {
    public static Operador novo(char operador) {
        if (operador == '+') return new Soma();
        if (operador == '-') return new Subtracao();
        if (operador == '*') return new Multiplicacao();
        if (operador == '/') return new Divisao();

        return null;
    }

    public abstract float calcula(float direita, float esquerda);

    public abstract boolean precedencia(Operador outro);
}
