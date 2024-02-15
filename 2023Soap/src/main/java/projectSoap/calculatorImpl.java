// Implémentation
package projectSoap;

import jakarta.jws.WebService;

//implementer l'interface et exposer ses methodes comme sw via jax-ws 
@WebService(endpointInterface = "projectSoap.calculator")
public class calculatorImpl implements calculator {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int sus(int num1, int num2) {
        return num1 - num2;
    }
    public int mul(int num1, int num2) {
        return num1 * num2;
    }
}