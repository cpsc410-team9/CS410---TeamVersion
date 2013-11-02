package control;

import java.io.File;
import java.util.ArrayList;

import preprocessing.Analyser;
import preprocessing.ClassDependency;
import preprocessing.ClassPacket;
import preprocessing.Parser;
import visualisation.Visualiser;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	Parser parser = new Parser();
	//Do not use this method
	public static void main(String[] args) {
        //Just a Test: Robert
		launch(args);
	}

	//For JavaFX, this is the main calling method. Don't worry about stages for now, it will be used in UI later on. 
	@Override
	public void start(Stage stage) throws Exception {
//		String uri = "C://Users//Shawn//git//orz//Leviathan";

		String uri = System.getProperty("user.dir");
//		store output of parser into arrayList
		ArrayList<ClassPacket> parserOutput;
		parserOutput = parser.parse(new File(uri));			//parser takes in a file as input, returns a list of ClassPackets
		
		//use arrayList in analyser
		ArrayList<ClassDependency> analyserOutput;
		analyserOutput = Analyser.analyse(parserOutput);	//Analyser takes in a list of ClassPackets as input,
															//returns a list of ClassDependencies
		
		Visualiser.process(analyserOutput);					//Takes in a list of ClassDependencies, returns nothing.
		
		//Basic way to shutdown the application. To be worked on.
		System.exit(0);
	}

}
