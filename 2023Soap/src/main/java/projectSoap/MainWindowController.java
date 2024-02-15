package projectSoap;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainWindowController {

    @FXML
    private Pane btn0;

    @FXML
    private Pane btn1;

    @FXML
    private Pane btn2;

    @FXML
    private Pane btn3;

    @FXML
    private Pane btn4;

    @FXML
    private Pane btn5;

    @FXML
    private Pane btn6;

    @FXML
    private Pane btn7;

    @FXML
    private Pane btn8;

    @FXML
    private Pane btn9;

    @FXML
    private Pane btnClear;

    @FXML
    private ImageView btnClose;

    @FXML
    private Pane btnDivide;

    @FXML
    private Pane btnEquals;

    @FXML
    private ImageView btnMinimize;

    @FXML
    private Pane btnMinus;

    @FXML
    private Pane btnMultiply;

    @FXML
    private Pane btnPlus;

    @FXML
    private Label lblResult;

    @FXML
    private Pane titlePane;

    
    private double x, y;
    private double num1 = 0;
    private String operator = "+";
    
    private CalculatorService calculatorService;
    
    
//initialiser le controlleur et service web 
    public void init(Stage stage, CalculatorService calculatorService) {
    	
    	//renvoient les coordonnées du pointeur de la souris par rapport à la scène (to move the calculator)
    	
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        
        //la fenêtre est déplacée en fonction du mouvement de la souris par rapport à cette position initiale
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
        
        this.calculatorService = calculatorService;
        
    }
    
    @FXML
    void onNumberClicked(MouseEvent event) {
    	String symbol = ((Pane) event.getSource()).getId().replace("btn", "");
    	
        if (symbol.equals("Equals")) {
            double num2 = Double.parseDouble(lblResult.getText());
            
            switch (operator) {
                case "+" : {
                	
                    // Utilisez le service SOAP pour l'addition
                    int result = calculatorService.add((int) num1, (int) num2);
                    lblResult.setText(String.valueOf(result));
                    break;
                }
                
                case "-" : {
                    // Utilisez le service SOAP pour la soustraction
                    int result = calculatorService.sus((int) num1, (int) num2);
                    lblResult.setText(String.valueOf(result));
                    break;
                }
                
            }
            operator = ".";
            
        } else if (symbol.equals("Clear")) {
            lblResult.setText(String.valueOf(0));
            operator = ".";
            
        } else {
        	//le text afficher dans label et le sumbole clicker
        	lblResult.setText(lblResult.getText() + symbol);
            }
            
        }
    

    
    @FXML
    void onSymbolClicked(MouseEvent event) {
    	
    	String symbol = ((Pane)event.getSource()).getId().replace("btn","");
    	
        if(symbol.equals("Equals")) {
        	
            double num2 = Double.parseDouble(lblResult.getText());
            
            switch (operator) {
            
            case "+" : 
            	lblResult.setText((num1+num2) + "");
            	  break;
            case "-" : 
            	lblResult.setText((num1-num2) + "");
            	  break;
           
        }
            // Réinitialise l'opérateur pour la prochaine opération
           
            operator = ".";
        }
        else if(symbol.equals("Clear")) {
            lblResult.setText(String.valueOf(0));
            operator = ".";
        }
        else {
            switch (symbol) {
            case "Plus" :
            	operator = "+";
            	  break;
            case "Minus" :
            	operator = "-";
            	  break;
            
        }
            num1 = Double.parseDouble(lblResult.getText());
            lblResult.setText(String.valueOf(0));
        }
    }

}
