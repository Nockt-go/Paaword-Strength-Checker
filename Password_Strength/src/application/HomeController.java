package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HomeController {

    @FXML private Button button;
    @FXML private Label label;
    @FXML private TextField password;
    
    String pass;
    @FXML
    void submit(ActionEvent event) {
    	pass = password.getText();
    	if(pass.length() < 6)
    		label.setText("Enter password more than 8 character");
    	else
    	label.setText(check_password(pass));
    }
    
    @FXML
    void try_again(ActionEvent event) {
    	password.setText("");
    }
    
    String check_password(String pass){
    	int digit = 0, char_big = 0, special = 0, char_small = 0;
    	int parcentage = 0;
    	
    	for(int i = 0; i < pass.length(); i++) {
    		if(pass.charAt(i) >= 48 && pass.charAt(i) <= 57)
    			digit++;
    		else if(pass.charAt(i) >= 65 && pass.charAt(i) <= 90)
    			char_big++;
    		else if(pass.charAt(i) >= 97 && pass.charAt(i) <= 122)
    			char_small++;
    		else if(pass.charAt(i) == ' ') 
    			return "Enter password without space character";
    		else special++;
    	}
    	
    	parcentage += parcent(digit);
    	parcentage += parcent(char_big);
    	parcentage += parcent(char_small);
    	parcentage += parcent(special);
    	if((char_big > 0 && char_small == 0) || (char_big == 0 && char_small > 0))
    		parcentage += 15;
    	if(special == 0)
    		return "enter atleast one special character";
    	if(parcentage >= 80)
    		return "your password is strong enough";
    	if(parcentage >= 70)
    		return "your password condition is good";
    	if(parcentage >= 60)
    		return "your password condition is medium";
    	
    	return "your password is very low";
    }
    int parcent(int val) {
    	if(val >= 4)
    		return 25;
    	else if(val >= 3)
    		return 20;
    	else if(val == 0)
    		return 0;
    	else return 15;
    }
}
