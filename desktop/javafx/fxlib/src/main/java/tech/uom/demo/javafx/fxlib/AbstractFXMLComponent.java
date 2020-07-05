/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2018, Jean-Marie Dautelle, Werner Keil, V2COM.
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
package tech.uom.demo.javafx.fxlib;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * @author Werner Keil
 *
 */
public abstract class AbstractFXMLComponent extends AnchorPane {

	private static final String DEFAULT_BUNDLE = "i18n/translation";

	private String fxmlResource;
	private String resourceBundle;
	private Node ui;

	public AbstractFXMLComponent() {
		this(null, null);
	}

	public AbstractFXMLComponent(String fxmlResource) {
		this(fxmlResource, null);
	}

	public AbstractFXMLComponent(String fxmlResource, String resourceBundle) {
		super();
		setId(getClass().getSimpleName());
		initComponent(fxmlResource, resourceBundle);
            try {
                initFields();
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AbstractFXMLComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	public String getFXMLResource() {
		return fxmlResource;
	}

	public String getResourceBundle() {
		return this.resourceBundle;
	}

	private void initComponent(String fxmlResource, String resourceBundle) {
		// init rest
		if (fxmlResource == null || fxmlResource.isEmpty()) {
			this.fxmlResource = getClass().getName() + ".fxml";
		} else {
			this.fxmlResource = fxmlResource;
		}
		this.resourceBundle = resourceBundle;
		if (this.resourceBundle == null) {
			this.resourceBundle = DEFAULT_BUNDLE;
		}
		// initUI
		var userLocale = Locale.ENGLISH; // TODO i18n
		try {
			ui = FXMLLoader.load(getClass().getResource(this.fxmlResource),
					ResourceBundle.getBundle(this.resourceBundle, userLocale));
			this.getChildren().add(ui);
			AnchorPane.setBottomAnchor(ui, 0d);
			AnchorPane.setTopAnchor(ui, 0d);
			AnchorPane.setLeftAnchor(ui, 0d);
			AnchorPane.setRightAnchor(ui, 0d);
		} catch (IOException e) {
			throw new IllegalArgumentException("Failed to load component: "
					+ this, e);
		}
	}

	private void initFields() throws IllegalAccessException {
		var clazz = getClass();
		while (clazz != null) {
			var fields = clazz.getDeclaredFields();
			Arrays.stream(fields).forEach(f-> {
			    if (f.getAnnotation(FXML.class) != null) {
                    Node value = ComponentUtil.lookup(ui, f.getName());
                    if (value == null) {
                        throw new IllegalArgumentException("Lookup failed of "
                                + f.getName() + " in " + this.fxmlResource);
                    }
                    if (!f.isAccessible()) {
                        f.setAccessible(true);
                    }
                        try {
                            f.set(this, value);
                        } catch (IllegalArgumentException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
			    }
                    
			});
			clazz = (Class<? extends AbstractFXMLComponent>) clazz.getSuperclass();
		}
		
	}

}
