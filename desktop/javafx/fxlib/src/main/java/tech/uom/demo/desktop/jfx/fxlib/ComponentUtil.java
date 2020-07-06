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
package tech.uom.demo.desktop.jfx.fxlib;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;

public final class ComponentUtil {

	private ComponentUtil() {
		// Singleton
	}

	public static Node lookup(Node root, String id) {
		if (id.startsWith("#")) {
			id = id.substring(1);
		}
		var node = root.lookup('#'+id);
		if(node == null){
			return lookupInternal(root, id);
		}
		return node;
	}

	private static Node lookupInternal(Node node, String id) {
		if (id.equals(node.getId())) {
			return node;
		}
		if (node instanceof Parent) {
			for ( var child : ((Parent) node).getChildrenUnmodifiable()) {
				var result = lookupInternal(child, id);
				if (result != null) {
					return result;
				}
			}
			if (node instanceof SplitPane) {
				var sp = (SplitPane) node;
				Node result = null;
				for(var child:sp.getItems()){
					result = lookupInternal(child, id);
					if (result != null) {
						return result;
					}
				}
			}
			if (node instanceof ScrollPane) {
				ScrollPane sp = (ScrollPane) node;
				Node result = null;
				if (sp.getContent() != null) {
					result = lookupInternal(sp.getContent(), id);
					if (result != null) {
						return result;
					}
				}
			}
			if (node instanceof BorderPane) {
				var sp = (BorderPane) node;
				Node result = null;
				if (sp.getBottom() != null) {
					result = lookupInternal(sp.getBottom(), id);
					if (result != null) {
						return result;
					}
				}
				if (sp.getTop() != null) {
					result = lookupInternal(sp.getTop(), id);
					if (result != null) {
						return result;
					}
				}
				if (sp.getLeft() != null) {
					result = lookupInternal(sp.getLeft(), id);
					if (result != null) {
						return result;
					}
				}
				if (sp.getRight() != null) {
					result = lookupInternal(sp.getRight(), id);
					if (result != null) {
						return result;
					}
				}
				if (sp.getCenter() != null) {
					result = lookupInternal(sp.getCenter(), id);
					if (result != null) {
						return result;
					}
				}
			}
			if (node instanceof TitledPane) {
				var sp = (TitledPane) node;
				Node result = null;
				if (sp.getContent() != null) {
					result = lookupInternal(sp.getContent(), id);
					if (result != null) {
						return result;
					}
				}
			}
			if (node instanceof Accordion) {
				for (var child : ((Accordion) node).getPanes()) {
					var result = lookupInternal(child, id);
					if (result != null) {
						return result;
					}
				}
			}
			if (node instanceof TabPane) {
				var bp = (TabPane) node;
				Node result = null;
				for (var tab : bp.getTabs()) {
					result = lookupInternal(tab.getContent(), id);
					if (result != null) {
						return result;
					}
				}
			}
		}
		return null;
	}

}
