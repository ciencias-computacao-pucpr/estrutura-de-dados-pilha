package operadores;

public class Subtracao extends Operador {
    @Override
    public float calcula(float direita, float esquerda) {
        return esquerda - direita;
    }

    @Override
    public boolean precedencia(Operador outro) {
        return false;
    }
}
