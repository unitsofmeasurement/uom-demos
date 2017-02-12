/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tec.uom.demo.javafx.fxlib;

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
import si.uom.NonSI;

import javax.measure.Unit;
import javax.measure.UnitConverter;

import tec.uom.se.AbstractUnit;
import tec.uom.se.unit.Units;
import static tec.uom.se.unit.Units.*;
import static tec.uom.se.unit.MetricPrefix.*;
import static systems.uom.common.USCustomary.*;

/**
 * @author Werner Keil
 * @version 0.6
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
                    //Units.ELECTRON_VOLT,                       
//                    UCUM.BTU
                };
            case "area":
                return new Unit[] {
                    SQUARE_METRE,
                    SQUARE_FOOT,                       
                    ARE,
                    HECTARE,
                    ACRE
                };
                /* TODO integrate with other systems like ISO
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
                }; */      
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
                    NonSI.DEGREE_ANGLE,
                    NonSI.MINUTE_ANGLE,
                    NonSI.SECOND_ANGLE,
                    CENTIRADIAN,
                    GRADE //,
                    //Units.REVOLUTION
                };
            case "speed":
                return new Unit[] {
                    Units.KILOMETRE_PER_HOUR,
                    MILE_PER_HOUR
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
                    return AbstractUnit.parse(symbol);
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
