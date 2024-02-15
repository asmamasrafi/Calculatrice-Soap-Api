package projectSoap;

import jakarta.xml.ws.Service;
import java.net.URL;
import javax.xml.namespace.QName;

public class CalculatorService {

    private calculator calculatorr;

    public CalculatorService() {
      
        try {
        	// une convention courante pour indiquer que vous souhaitez récupérer le fichier WSDL associé à ce service.
        	URL wsdlURL = new URL("http://localhost:8080/calcul?wsdl");
        	//creer une instance d service web 
        	Service service = Service.create(wsdlURL, new QName("http://projectSoap/", "calculatorService"));
        	//recupere le port du service web
        	calculatorr = service.getPort(calculator.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Méthode pour effectuer une addition en utilisant le service web SOAP
    public int add(int num1, int num2) {
        return calculatorr.add(num1, num2);
    }

    public int sus(int num1, int num2) {
        return calculatorr.sus(num1, num2);
    }
    public int mul(int num1, int num2) {
        return calculatorr.mul(num1, num2);
    }

}
