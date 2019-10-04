import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator2 extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		final TextField txtField = new TextField();
		final Label outputLabel = new Label();
		
		VBox window = new VBox(10);
		window.setPadding(new Insets(10));
		window.setAlignment(Pos.CENTER);
		
		//Creating Text Field where user enters math expression
		HBox firstRow = new HBox();
		firstRow.getChildren().add(new Label("Please enter an expression"));
		firstRow.getChildren().add(txtField);
		firstRow.setAlignment(Pos.CENTER);
		
		window.getChildren().add(firstRow);
		
		txtField.textProperty().addListener((observable, oldValue, newValue) -> //Lambda expression needed to implement the textField interface
		{
			
			newValue = newValue.trim();
			if (newValue.endsWith("="))
			{
				//Creating string EXPRESSION to evaluate
				String expression = newValue.replace("=", "");
				
				//String split method to split String into substring
				String[] array = expression.split("[-+*/]");
				if(array.length == 2) 
				{
					int num1 = Integer.parseInt(array[0].trim()); //trim() method returns new String to remove any white spaces
					int num2 = Integer.parseInt(array[1].trim());
					
					int result = 0;
					if(expression.contains("+")) //if String contains "+" use addition
					{
						result = num1 + num2;
					}
					else if(expression.contains("-")) //if String contains "-" use subtraction
					{
						result = num1 - num2;
					}
					else if(expression.contains("*")) //if String contains "*" use multiplication
					{
						result = num1 * num2;
					}
					else if(expression.contains("/")) //if String contains "/" use division
					{
						result = num1 / num2;
					}
					
					outputLabel.setText(result + ""); //Label will print result of user input expression
				}
				else
				{
					outputLabel.setText("");
				}
			}
			System.out.println(newValue);
		});
		
		//Creating Label beneath Text field
		HBox secondRow = new HBox();
		secondRow.getChildren().add(outputLabel);
		secondRow.setAlignment(Pos.CENTER);
		window.getChildren().add(secondRow);
		
		
		//Creating Scene
		Scene scene = new Scene(window);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Text Calculator");
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
