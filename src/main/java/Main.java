public class Main {
    public static void main(String[] args) {
        String expressao = "(1+2)(3+5(8*7))";
        Validador v = new Validador(expressao);
        System.out.printf("%s é %s", expressao ,v.isValido());
        System.out.println();

        expressao = "{1+2}(3+5[8*7])";
        v = new Validador(expressao);
        System.out.printf("%s é %s", expressao ,v.isValido());
        System.out.println();

        expressao = "{1+2)(3+5[8*7])";
        v = new Validador(expressao);
        System.out.printf("%s é %s", expressao ,v.isValido());
        System.out.println();

        expressao = "{1+2}(3+5[8*7])}";
        v = new Validador(expressao);
        System.out.printf("%s é %s", expressao ,v.isValido());
        System.out.println();

        expressao = "(";
        v = new Validador(expressao);
        System.out.printf("%s é %s", expressao ,v.isValido());
        System.out.println();

        expressao = "2)";
        v = new Validador(expressao);
        System.out.printf("%s é %s", expressao ,v.isValido());
        System.out.println();

        expressao = "2))";
        v = new Validador(expressao);
        System.out.printf("%s é %s", expressao ,v.isValido());
        System.out.println();

        expressao = "1 + 2";
        CalculadoraExpressao c = new CalculadoraExpressao(expressao);
        System.out.printf("%s = %.2f%n", expressao, c.calcular());

        expressao = "1 + 2 + 2";
        c = new CalculadoraExpressao(expressao);
        System.out.printf("%s = %.2f%n", expressao, c.calcular());
    }
}
