/*
 *  Units of Measurement Desktop Demos for Java
 *  Copyright (c) 2019-2020, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of Units of Measurement nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.demo.desktop.jfx.fxlib;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import tech.units.indriya.AbstractUnit;

import javax.measure.Unit;

/**
 * @author Werner Keil
 */
public class UnitSelector extends AbstractFXMLComponent { //implements UnitSupplier {

	@FXML
	private ComboBox<Unit<?>> codeBox;

	@FXML
	private Label title;

	public UnitSelector(String title) {
		super("/fxml/UnitSelector.fxml");
		this.title.setText(title);
	}

	public Unit<?> getUnit() {
		var symbol = codeBox.getSelectionModel().getSelectedItem().getSymbol();
		if (symbol != null) {
			return AbstractUnit.parse(symbol);
		}
		return null;
	}

	public void setUnit(Unit<?> unit) {
		if (unit != null) {
			codeBox.getSelectionModel().select(unit);
		} else {
			codeBox.getSelectionModel().clearSelection();
		}
	}

}
