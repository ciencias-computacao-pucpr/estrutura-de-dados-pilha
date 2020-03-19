package operadores;

public class Divisao extends Operador {
    @Override
    public float calcula(float direita, float esquerda) {
        return esquerda / direita;
    }

    @Override
    public boolean precedencia(Operador outro) {
        return outro instanceof Soma || outro instanceof Subtracao;
    }
}