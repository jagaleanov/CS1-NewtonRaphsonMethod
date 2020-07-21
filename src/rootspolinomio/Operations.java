
package rootspolinomio;

import static java.lang.Math.sqrt;
import java.lang.reflect.Array;

public class Operations {


    public Polinomio derive(Polinomio function) {
        float total = 0;

        float[] coefficients = function.getCoefficients();

        float[] newPol = new float[coefficients.length];

        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients.length - 1 - i > 0) {
                //System.out.print(" + " + coeficientes[i] + "*" + (coeficientes.length - 1 - i) + 
                //"x^" + (coeficientes.length - 1 - 1 - i));
                newPol[i] = coefficients[i] * coefficients.length - 1 - i;
            }
        }
        //System.out.println();

        return new Polinomio(newPol);
    }

    public Polinomio synthDivision(Polinomio polinomio, float xi) {

        float[] coefficients = polinomio.getCoefficients();

        float[] tempo = new float[coefficients.length];
        float[] response = new float[tempo.length - 1];

        tempo[0] = coefficients[0];
        for (int i = 0; i < coefficients.length - 2; i++) {
            tempo[i + 1] = tempo[i] * xi + coefficients[i + 1];
        }
        
        
        for (int i = 0; i < tempo.length - 1; i++) {
            response[i] = tempo[i];
        }
        /*
        for (int i = 0; i < tempo.length - 1; i++) {
            System.out.print(tempo[i] + " ");
        }
        System.out.println();
        */

        return new Polinomio(response);
    }

    public int gradePolinomio(Polinomio polinomio) {

        float[] coefficients = polinomio.getCoefficients();

        return coefficients.length - 1;
    }

    public float[] solveQuadratic(Polinomio polinomio) {

        float[] coefficients = polinomio.getCoefficients();

        float[] response = new float[2];

        response[0] = (float) ((-coefficients[1] + sqrt((coefficients[1] * coefficients[1]) - 4 * 
                coefficients[0] * coefficients[2])) / (2 * coefficients[0]));
        response[1] = (float) ((-coefficients[1] - sqrt((coefficients[1] * coefficients[1]) - 4 * 
                coefficients[0] * coefficients[2])) / (2 * coefficients[0]));

        return response;
    }

    public float[] obtenerDivisores(float valor) {
        valor = Math.abs(valor);
        float[] divisores = new float[(int) valor * 2];
        int j = 0;

        for (int i = 1; i <= valor ; i++) {
            if (valor % i == 0) {
                divisores[j] = i;
                j++;
                divisores[j] = -i;
                j++;
            }
        }

        float[] resultado = new float[j];
        for (int i = 0; i < j-1; i++) {
            resultado[i] = divisores[i];
        }

        return resultado;
    }

    public float[] obtenerFactores(float[] listaP, float[] listaQ) {
        float[] factores = new float[listaP.length * listaQ.length];
        int n = 0;

        for (int i = 0; i < listaQ.length; i++) {
            for (int j = 0; j < listaP.length; j++) {
                float val = listaP[j] / listaQ[i];
                boolean flag = false;

                for (int k = 0; k < n; k++) {
                    if (val == factores[i]) {
                        flag = true;
                    }
                }

                if (!flag) {
                    factores[n] = val;
                    n++;
                }
            }
        }

        return factores;
    }

}
