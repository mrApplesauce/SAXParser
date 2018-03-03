/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 *
 * @author taylor
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextArea textArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handleOpen (ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(textArea.getScene().getWindow());
        if (file != null) {
            try {
                ArrayList<XMLElement> dom = XMLLoader.load(file);
                
                for (int i = 0; i < dom.size(); i++) {
                    textArea.appendText(dom.get(i).getQName() + "\n");
                    for (int j = 0; j < dom.get(i).getAttributes().size(); j++) {
                        textArea.appendText("\t" + dom.get(i).getAttributes().get(j) + "\n");
                    }
                    textArea.appendText("-------------------------\n");
                }
            } catch (Exception ex) {
                System.out.println("Successfully detected error.");
            }
        }
    }
    
}