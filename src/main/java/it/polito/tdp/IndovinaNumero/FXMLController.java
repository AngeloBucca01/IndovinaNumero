/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.IndovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {
	private int segreto;
	private final int tentativiMax=8;
	private final int numeriMax=100;
	private int tentativiFatti;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuovaPartita"
    private Button btnNuovaPartita; // Value injected by FXMLLoader

    @FXML // fx:id="btnProva"
    private Button btnProva; // Value injected by FXMLLoader

    @FXML // fx:id="lblIndovinaNumero"
    private Label lblIndovinaNumero; // Value injected by FXMLLoader

    @FXML // fx:id="lblTentativiRimasti"
    private Label lblTentativiRimasti; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtStampa"
    private TextArea txtStampa; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativi"
    private TextField txtTentativi; // Value injected by FXMLLoader

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	//gestione nuova partita
    	this.segreto= (int) ((Math.random() * numeriMax) + 1);
    	this.tentativiFatti=0;
    	//gestione interfaccia
    	this.txtTentativi.setText(Integer.toString(tentativiMax));
    	txtParola.setDisable(false);
    	btnProva.setDisable(false);
    	txtStampa.clear();
    	txtParola.clear();

    }

    @FXML
    void doTentativo(ActionEvent event) {
    	String inserimento= txtParola.getText();
    	int tentativo;
    	try {
    		tentativo= Integer.parseInt(inserimento);
    	} catch (NumberFormatException e) {
    		txtParola.setText("Devi inserire un numero tra 1 e 100");
    		return;
    	}
    	this.tentativiFatti++;
    	if(tentativo == this.segreto) {
    		txtStampa.setText("Hai indovinato con: " + this.tentativiFatti + " tentativi!");
    		txtParola.clear();
    		txtParola.setDisable(true);
    		btnProva.setDisable(true);
    		return;
    	}
    	if(this.tentativiFatti==tentativiMax) {
    		txtStampa.setText("Hai perso! Il numero segreto era: " + this.segreto);
    		txtParola.setDisable(true);
    		btnProva.setDisable(true);
    		return;
    	}
    	if(tentativo<this.segreto) {
    		txtStampa.setText("Tentativo troppo basso");
    	}	else {
    		txtStampa.setText("Tentativo troppo alto");
    	}
    	txtTentativi.setText(Integer.toString(tentativiMax-tentativiFatti));

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblIndovinaNumero != null : "fx:id=\"lblIndovinaNumero\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblTentativiRimasti != null : "fx:id=\"lblTentativiRimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStampa != null : "fx:id=\"txtStampa\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
