/**
 * Copyright (c) 2013-2014 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */

package org.unitsofmeasurement.demo.javafx.fxlib;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javax.measure.Unit;
import javax.measure.function.UnitSupplier;
import org.unitsofmeasurement.impl.AbstractUnit;


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
