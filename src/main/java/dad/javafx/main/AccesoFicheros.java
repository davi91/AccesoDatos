package dad.javafx.main;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class AccesoFicheros extends Application {

	private Label nombreLbl, rutaLbl;
	private TextField rutaTxt, nombreFichTxt;
	private TextArea contentArea;
	private ListView<File> fileList;
	private Button createBt, removeBt, moveBt, viewBt, contentBt, modBt;
	private CheckBox folderBt, fichBt;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Declaración principal
		nombreLbl = new Label("David Fernández Nieves");
		nombreLbl.setPrefHeight(40);
		
		rutaLbl = new Label("Ruta actual");
		
		rutaTxt = new TextField();
		
		nombreFichTxt = new TextField();
		nombreFichTxt.setPromptText("Carpeta o fichero a crear, eliminar o destino a mover");
		
		contentArea = new TextArea();
		contentArea.setPromptText("Contenido del fichero");
		contentArea.setEditable(false);
		
		fileList = new ListView<>(); // De momento no sabbemos cuantos crear, así que TO DO.....
		
		createBt = new Button("Crear");
		removeBt = new Button("Eliminar");
		moveBt = new Button("Mover");
		viewBt = new Button("Ver ficheros y carpetas");
		contentBt = new Button("Ver contenido fichero");
		modBt = new Button("Modificar fichero");
		
		folderBt = new CheckBox("Es carpeta");
		fichBt = new CheckBox("Es fichero");
		
		// Ajuste del Grid Layout
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5,30,5,5));
		
		// Filas y columnas
		grid.addRow(0, rutaLbl, rutaTxt);
			
		HBox myBox = new HBox(50, createBt, removeBt, moveBt, folderBt, fichBt);
		myBox.setAlignment(Pos.BASELINE_CENTER);
		
		grid.addRow(1, myBox);
		GridPane.setColumnSpan(myBox, 2);
		
		grid.addRow(2, nombreFichTxt);
		GridPane.setColumnSpan(nombreFichTxt, 2);
		
		grid.addRow(3, viewBt);
		
		grid.addRow(4, fileList);
		fileList.setPrefHeight(100);
		GridPane.setColumnSpan(fileList, 2);

		grid.add(contentBt, 0, 5);
		grid.add(modBt, 0, 6);
		
		grid.add(contentArea, 1, 5);	
		
		GridPane.setHgrow(rutaTxt, Priority.ALWAYS);
		GridPane.setHgrow(fileList, Priority.ALWAYS);
		GridPane.setHgrow(nombreFichTxt, Priority.ALWAYS);
		GridPane.setHgrow(contentArea, Priority.ALWAYS);
		GridPane.setVgrow(fileList, Priority.ALWAYS);
		GridPane.setVgrow(contentArea, Priority.ALWAYS);
		
		GridPane.setFillWidth(rutaTxt, true);
		GridPane.setFillWidth(fileList, true);
		GridPane.setFillWidth(nombreFichTxt, true);
		GridPane.setFillWidth(contentArea, true);

		// Ajuste de Border y Tab layouts
		BorderPane border = new BorderPane();
		border.setTop(nombreLbl);
		border.setCenter(grid);
		border.setPadding(new Insets(5));
		
		BorderPane.setAlignment(nombreLbl, Pos.CENTER);
		BorderPane.setAlignment(grid, Pos.CENTER);
		
		TabPane root = new TabPane();
		
		Tab tab1 = new Tab("Acceso a ficheros");
		tab1.setContent(border);
		Tab tab2 = new Tab("Acceso aleatorio"); // UNUSED
		Tab tab3 = new Tab("Acceso XML"); // UNUSED
		root.getTabs().addAll(tab1, tab2, tab3);
		
		Scene scene = new Scene(root, 800, 600);
		
		primaryStage.setTitle("Acceso a datos");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
