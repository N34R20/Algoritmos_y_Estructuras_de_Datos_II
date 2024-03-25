package aed;

class Funciones {
    int cuadrado(int x) {

        int res = x * x;

        return res;
    }

    double distancia(double x, double y) {

        double res = Math.sqrt(x * x + y * y);

        return res;
    }

    boolean esPar(int n) {
        boolean res;

        if (n % 2 == 0) {

            res = true;
        }

        else {

            res = false;
        }

        return res;
    }

    boolean divide(int x, int y) {
        boolean res;

        if (y % x == 0) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    boolean esBisiesto(int n) {

        boolean res;
        if (((divide(4, n) && !divide(100, n))) || divide(400, n)) {
            res = true;
        } else {
            res = false;
        }

        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;
        int i;
        for (i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    int factorialRecursivo(int n) {

        int res = n;

        if (n == 0) {
            res = 1;
        } else if (n == 1) {
            res = 1;
        } else {
            res *= factorialRecursivo(n - 1);
        }

        return res;
    }

    int buscarDivisior(int n, int k) {
        int res;
        if (k * k > n) {
            res = n;
        } else if (n % k == 0) {
            res = k;
        } else {
            res = buscarDivisior(n, (k + 1));
        }
        return res;
    }

    int menorDivisior(int n) {
        int res = buscarDivisior(n, 2);

        return res;
    }

    boolean esPrimo(int n) {

        boolean res;

        if (n == 0) {
            res = false;
        }

        else if (n == 1) {
            res = false;
        }

        else if (menorDivisior(n) == n) {
            res = true;
        }

        else {
            res = false;
        }
        return res;
    }

    int sumatoria(int[] numeros) {
        int res = 0;

        for (int i = 0; i <= numeros.length - 1; i++) {
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;

        for (int i = 0; i <= numeros.length - 1; i++) {
            if (numeros[i] == buscado) {
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int i = 0; i <= numeros.length - 1; i++) {
            if (esPrimo(numeros[i])) {
                res = true;
            }

        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int i = 0; i <= numeros.length - 1; i++) {
            if (!esPar(numeros[i])) {
                res = false;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;
        if (s1.length() > s2.length()) {
            res = false;
        } else {
            for (int i = 0; i <= s1.length() - 1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    res = false;
                }
            }
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = true;
        if (s1.length() > s2.length()) {
            res = false;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(s1.length() - i - 1) != s2.charAt(s2.length() - i - 1)) {
                    res = false;
                }
            }
        }
        return res;
    }
}
