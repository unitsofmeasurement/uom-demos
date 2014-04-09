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

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javax.measure.Unit;
import javax.measure.function.UnitSupplier;
import org.unitsofmeasurement.ri.AbstractUnit;


/**
 * @author Werner Keil
 */
public class UnitSelector extends AbstractFXMLComponent implements UnitSupplier {

	@FXML
	private ComboBox<Unit> codeBox;

	@FXML
	private Label title;

	public UnitSelector(String title) {
		super("/org/unitsofmeasurement/demo/javafx/fxlib/UnitSelector.fxml");
		this.title.setText(title);
	}

	public Unit getUnit() {
		String symbol = codeBox.getSelectionModel().getSelectedItem().getSymbol();
		if (symbol != null) {
			return AbstractUnit.of(symbol);
		}
		return null;
	}

	public void setUnit(Unit unit) {
		if (unit != null) {
			codeBox.getSelectionModel().select(unit);
		} else {
			codeBox.getSelectionModel().clearSelection();
		}
	}

}
