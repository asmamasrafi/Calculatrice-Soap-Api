// Interface
package projectSoap;

import jakarta.jws.WebService;

@WebService
public interface calculator {
    int add(int num1, int num2);
    int sus(int num1, int num2);
    int mul(int num1, int num2);
}