import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Assignment extends Application{
	public static void main(String []args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("enter page");
		Label Name = new Label("Name:");
		Label lastName = new Label("Lastname:");
		Label email=new Label("Email:");
		Label username=new Label("Username");
		Label ps = new Label("Password");
		Label ps2 = new Label("Confirm password");
		Label account =new Label("Account Type");
		TextField NameTxt = new TextField();
		PasswordField psTxt = new PasswordField();
		PasswordField ps2Txt = new PasswordField();
		TextField usernameTxt=new TextField();	
		TextField emailTxt =new TextField();
		TextField lastNameTxt = new TextField();
		ComboBox TypeComboBox = new ComboBox();
		TypeComboBox.getItems().addAll("student","teacher","workers","guest");
		Button sublitBtn = new Button("sign in");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(20);
		grid.setHgap(20);
		sublitBtn.setOnAction(new EventHandler<ActionEvent>(){
			Label wrong1 = new Label("");
			
			@Override
			public void handle(ActionEvent arg0) {
				wrong1.setText("");
				String message1="";
				String message2="";
				String message="";
				String message3="";
				String name= NameTxt.getText();
				String lastName= lastNameTxt.getText();
				String username=usernameTxt.getText();
				String email= emailTxt.getText();
				String password1=psTxt.getText();
				String password2=ps2Txt.getText();
				String patternemail="\\w+@\\w+\\.\\w+";
				String patternpassword="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\!`<>?\"'#$%^&*()-+=,./:;@\\[\\]_?{|}~])(?=\\S+$).{8,64}";
				boolean chack=password1.equals(password2);
				boolean returns=true;
				if(name.isEmpty()){ message=message+"The name field cannot be empty.\n"; returns=false;}
				if(lastName.isEmpty()){ message=message+"The Last name field cannot be empty.\n";returns=false;}
				if(email.isEmpty()) {message=message+"The E-mail field cannot be empty.\n";returns=false;}
				if(username.isEmpty()){ message=message+"The username field cannot be empty.\n";returns=false;}
				if(password1.isEmpty()){ message=message+"The password field cannot be empty.\n";returns=false;}
				if(password2.isEmpty()) {message=message+"The password comfrim field cannot be empty.\n";returns=false;}
				if(!password1.isEmpty()&&!password2.isEmpty()){
				if(!chack){
					message1=message1+"Confirm password does \n not equal to password \n";
					returns=false;
				}}
				if(password1.length()<8 && !password1.matches(patternpassword) ){ message2=message2+"please use right format";returns=false;}
				if(!email.matches(patternemail)) {message3=message3+"please use right formate";returns=false;}
				Label wrong2 = new Label(message);
				Label wrong1 = new Label(message1);
				Label wrong3 = new Label(message2);
				Label wrong4 = new Label(message3);
				
				wrong1.setTextFill(javafx.scene.paint.Color.web("#FF0000"));
				wrong2.setTextFill(javafx.scene.paint.Color.web("#FF0000"));
				wrong3.setTextFill(javafx.scene.paint.Color.web("#FF0000"));
				wrong4.setTextFill(javafx.scene.paint.Color.web("#FF0000"));
				
				grid.add(wrong1, 2, 5);
				grid.add(wrong2, 0, 8);
				grid.add(wrong3, 2, 4);
				grid.add(wrong4, 2, 2);
					if(returns) JOptionPane.showMessageDialog(null, "You have successfully created an account with us.");
					System.out.println(returns);
				}
		
		});
		
		
		
		grid.add(lastName,0,1);
		grid.add(lastNameTxt, 1, 1);
		grid.add(NameTxt,1,0);
		grid.add(email, 0, 2);
		grid.add(emailTxt, 1, 2);
		grid.add(username, 0, 3);
		grid.add(usernameTxt, 1, 3);
		grid.add(psTxt,1,4);
		grid.add(ps2, 0, 5);
		grid.add(ps2Txt, 1, 5);
		grid.add(Name,0,0);
		grid.add(ps,0,4);
		grid.add(account, 0, 6);
		grid.add(TypeComboBox, 1, 6);
		grid.add(sublitBtn,1,7);
		
		
		Scene scene = new Scene(grid,700,1000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}