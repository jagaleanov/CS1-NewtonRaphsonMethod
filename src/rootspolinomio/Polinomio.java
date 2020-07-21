
package rootspolinomio;


public class Polinomio {

    float[] coefficients;

    public Polinomio(float[] coefficients) {
        this.coefficients = coefficients;
    }

    public float eval(float x) {
        float total = 0;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            total += coefficients[i] * Math.pow(x, coefficients.length - 1 - i);
        }
        return total;
    }

    public float[] getCoefficients() {
        return coefficients;
    }

    public float getFirst() {
        return coefficients[0];
    }

    public float getLast() {
        return coefficients[coefficients.length-1];
    }

}
