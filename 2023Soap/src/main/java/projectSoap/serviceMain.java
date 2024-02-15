package projectSoap;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;


public class serviceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Configuration du serveur SOAP avec Apache CXF
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		
		 // Spécification de la classe d'interface du service (calculator)
		factoryBean.setServiceClass(calculator.class);
		factoryBean.setServiceBean(new calculatorImpl());
		
	    // Spécification de l'adresse à laquelle le service sera exposé (utilisation de ?wsdl pour indiquer le fichier WSDL)
		factoryBean.setAddress("http://localhost:8080/calcul?wsdl");
		
		  Server server= factoryBean.create();
		  server.start();
		  System.out.println("calculator service is runnig");
		
		  MainWindow mainWindow = new MainWindow();
	      mainWindow.run();
		  try {
			  
		      // Keep the server running
		      Thread.sleep(Long.MAX_VALUE);
		      
		  } catch (InterruptedException e) {
		      e.printStackTrace();} 

	}
}
	 
	  


