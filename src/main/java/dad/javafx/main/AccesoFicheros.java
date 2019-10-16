package dad.javafx.main;

import java.io.File;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccesoFicheros extends Application {

	private Label nombreLbl, rutaLbl;
	private TextField rutaTxt, nombreFichTxt;
	private TextArea contentArea;
	private ListView<File> fileList;
	private Button createBt, removeBt, moveBt, viewBt, contentBt, modBt;
	private RadioButton folderCheck, ficheroCheck;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Declaración principal
		nombreLbl = new Label("David Fernández Nieves");
		nombreLbl.setPrefHeight(40);
		
		rutaLbl = new Label("Ruta actual:");
		
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
		
		contentBt.setMaxWidth(Double.MAX_VALUE);
		modBt.setMaxWidth(Double.MAX_VALUE);
		viewBt.setMaxWidth(Double.MAX_VALUE);
		
		folderCheck = new RadioButton("Es carpeta");
		ficheroCheck = new RadioButton("Es fichero");
		ToggleGroup grp = new ToggleGroup();
		grp.getToggles().addAll(folderCheck, ficheroCheck);
		
		// Ajuste del Grid Layout
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5,30,5,5));

		// Filas y columnas
		grid.addRow(0, rutaLbl, rutaTxt); // Ruta
		
		// Los botones en un Horizontal Box
		HBox btBox = new HBox(80, createBt, removeBt, moveBt, folderCheck, ficheroCheck); // Botones principales de manejo de ficheros
		btBox.setAlignment(Pos.BASELINE_CENTER);
		
		grid.addRow(1, btBox);
		GridPane.setColumnSpan(btBox, 2);
		
		grid.addRow(2, nombreFichTxt); // El nombre Del fichero
		GridPane.setColumnSpan(nombreFichTxt, 2);
		
		grid.addRow(3, viewBt); // Ver contenido
		
		grid.addRow(4, fileList); // Lista de ficheros
		fileList.setPrefHeight(100);
		GridPane.setColumnSpan(fileList, 2);

		VBox contentBtBox = new VBox(10, contentBt, modBt); // Botones de modificación y ver fichero
		grid.add(contentBtBox, 0, 5);
		
		grid.add(contentArea, 1, 5);	// Contenido del fichero
		
		// Ajustamos las filas y las columnas a nuestras necesidades
		ColumnConstraints[] cols = {
			
			new ColumnConstraints(),
			new ColumnConstraints()
		};
		
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setFillWidth(true);
		grid.getColumnConstraints().addAll(cols);
				
		GridPane.setVgrow(fileList, Priority.ALWAYS);
		GridPane.setVgrow(contentArea, Priority.ALWAYS);
		
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
