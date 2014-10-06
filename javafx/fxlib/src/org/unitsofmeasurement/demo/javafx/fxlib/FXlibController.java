/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
 *  contributors by the @author tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.unitsofmeasurement.demo.javafx.fxlib;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.measure.Unit;
import javax.measure.function.UnitConverter;
import tec.uom.se.AbstractUnit;
import tec.uom.se.util.CommonUnits;
import tec.uom.se.util.SI;
import static tec.uom.se.util.SI.*;
import static tec.uom.se.util.SIPrefix.*;
import tec.uom.se.util.UCUM;
import static tec.uom.se.util.US.*;

/**
 *
 * @author Werner Keil
 */
public class FXlibController implements Initializable {
    private static final NumberFormat FORMAT = NumberFormat.getNumberInstance();
    
    @FXML
    private Label label;
    
    @FXML
    private ComboBox<Unit> fromCombo;
    
    @FXML
    private ComboBox<Unit> toCombo;
    
    @FXML
    private TextField fromFld;
    
    @FXML
    private TextField toFld;
    
    @FXML
    private void helloButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You selected " + event.getSource().toString());
        final String selection = ((Button)event.getSource()).getText();
        if (selection != null && !selection.equals(label.getText())) {
            label.setText(selection);
            clearAll();
            updateForSelection(selection);
        }
    }
    
    @FXML
    public void handleFromKey(KeyEvent evt) {
        /*
            String character = evt.getCharacter();
            if(!character.equals("1"))
            {
                //JOptionPane.showMessageDialog(null,evt.getCharacter());
                System.out.println("You typed " + evt.getCharacter());
                evt.consume();                
            }   
                */
            KeyCode code = evt.getCode();      
            System.out.println("Code " + code);
 /*           
            if (KeyCode.DELETE == code) System.out.println("Del");
            
            char ar[] = evt.getCharacter().toCharArray();
            char ch = ar[evt.getCharacter().toCharArray().length - 1];
            System.out.println("You entered " + String.valueOf(ar));
            if (!(ch >= '0' && ch <= '9') && 
         */
            if (!(code.isDigitKey()) &&
                    !(KeyCode.BACK_SPACE.equals(code) || KeyCode.DELETE == code)) {
               System.out.println("The char you entered is not a number");
               evt.consume();
            } else {
                final String text = ((TextField)evt.getSource()).getText();
                System.out.println("You entered " + text);
                /*
                Measurement from = AbstractMeasurement.of(new BigDecimal(text), fromCombo.getValue());
                System.out.println("From " + from);
                Measurement to = from.to(toCombo.getValue());
                System.out.println("To " + to);*/
                if (fromCombo != null && fromCombo.getValue() != null &&
                      toCombo != null && toCombo.getValue() != null) {
                    UnitConverter converter = fromCombo.getValue().getConverterTo(toCombo.getValue());
                    if (text != null && !text.isEmpty()) {
                        Number convertedValue = converter.convert(Double.valueOf(text));
                        System.out.println("Converted: " + convertedValue);
                        toFld.setText(FORMAT.format(convertedValue));
                    } else 
                        if (toFld.getText() != null && !toFld.getText().isEmpty()) {
                            toFld.clear();
                        }
                }
            }
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clearAll();
    }    
    
    private void clearAll() {
        fromCombo.getItems().clear();
        toCombo.getItems().clear();
        fromFld.clear();
        toFld.clear();
    }
    
    private void updateForSelection(String selection) {
        fromCombo.getItems().addAll(getUnits(selection));
        toCombo.getItems().addAll(getUnits(selection));
    }
    
    private Unit[] getUnits(String selection) {
          switch (selection) {
            case "length":
                return new Unit[] {
                    MILE,
                    KILO(METRE),
                    METRE,
                    CENTI(METRE),
                    DECI(METRE),
                    MILLI(METRE),
                    FOOT,
                    INCH,
                    YARD 
                };
             case "energy":
                return new Unit[] {
                    JOULE,
                    SI.ELECTRON_VOLT,                       
                    UCUM.BTU
                };
            case "area":
                return new Unit[] {
                    SQUARE_METRE,
                    SQUARE_FOOT,                       
                    ARE,
                    HECTARE,
                    ACRE
                };
             case "data":
                return new Unit[] {
                    BIT,
                    BYTE,                       
                    KILO(BIT),
                    MEGA(BIT),
                    KILO(BYTE),
                    MEGA(BYTE),
                    GIGA(BYTE),
                    TERA(BYTE),
                    EXA(BYTE),
                };      
             case "mass":
                return new Unit[] {
                    KILOGRAM,
                    GRAM,                       
                    POUND,
                    OUNCE,
                    TON
                };
            case "power":
                return new Unit[] {
                    HORSEPOWER,
                    WATT
                };
            case "angle":
                return new Unit[] {
                    SI.DEGREE_ANGLE,
                    SI.MINUTE_ANGLE,
                    SI.SECOND_ANGLE,
                    CENTIRADIAN,
                    GRADE,
                    SI.REVOLUTION
                };
            case "speed":
                return new Unit[] {
                    CommonUnits.KILOMETRES_PER_HOUR,
                    MILES_PER_HOUR
                };
            case "temperature":
                return new Unit[] {
                    CELSIUS,
                    FAHRENHEIT,
                    KELVIN,
                    RANKINE
                };
            default:
                return null;
          }
    }
    
    public Unit getFromUnit() {
            String symbol = fromCombo.getSelectionModel().getSelectedItem().getSymbol();
            if (symbol != null) {
                    return AbstractUnit.of(symbol);
            }
            return null;
    }

    public void setFromUnit(Unit unit) {
            if (unit != null) {
                    fromCombo.getSelectionModel().select(unit);
            } else {
                    fromCombo.getSelectionModel().clearSelection();
            }
    }
}
