package rootspolinomio;

public class NewtonRaphson {

    public float[] findRoots(float[] coefficients) {

        Operations ops = new Operations();
        Polinomio f = new Polinomio(coefficients);

        float[] roots = new float[ops.gradePolinomio(f)];
        int rootCounter = 0;
        boolean operate = true;
        boolean flag = true;

        float[] q = ops.obtenerDivisores(f.getFirst());
        float[] p = ops.obtenerDivisores(f.getLast());

        float[] factores = ops.obtenerFactores(p, q);

        for (int w = 0; w < factores.length; w++) {
            float xi = factores[w];

            do {
                int loops = 2;
                Polinomio df = ops.derive(f);

                float temp = 1;

                do {
                    float y1 = f.eval(xi);
                    float y2 = df.eval(xi);
                    float xiNext = xi - (y1 / y2);

                    temp = xiNext - xi;
                    xi = xiNext;
                    loops++;

                } while (Math.abs(temp) > 0.00000001 && loops < 10000000);

                if (loops == 10000000) {
                    //System.out.println("No se encontraron raices en los reales");
                    flag = false;
                    break;
                }
                roots[rootCounter] = xi;
                rootCounter++;
                Polinomio newPolinomio = ops.synthDivision(f, xi);

                if (ops.gradePolinomio(newPolinomio) == 2) {
                    float[] root2 = ops.solveQuadratic(newPolinomio);

                    roots[roots.length - 2] = root2[0];
                    roots[roots.length - 1] = root2[1];

                    operate = false;
                }

                f = newPolinomio;

            } while (operate);

            if (!operate && !flag) {
                break;
            }
        }

        return roots;
    }

}
