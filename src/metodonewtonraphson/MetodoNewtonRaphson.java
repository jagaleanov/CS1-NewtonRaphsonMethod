/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodonewtonraphson;

import rootspolinomio.NewtonRaphson;

/**
 *
 * @author jgale
 */
public class MetodoNewtonRaphson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            float raices[];
            float[] coef = {3,-14,-15,42,40};//3x^4-14x^3-15x^2+42x+40
            NewtonRaphson rp = new NewtonRaphson();
            
            raices = rp.findRoots(coef); //Este es el valor de retorno

            for (int i = 0; i < raices.length; i++) {
                System.out.println(raices[i]);
            }
    }
    
}
