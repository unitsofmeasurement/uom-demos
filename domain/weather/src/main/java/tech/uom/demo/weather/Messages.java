/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2020, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.demo.weather;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

class Messages {
	private static final String BUNDLE_NAME = "tech.uom.demo.energy.messages"; //$NON-NLS-1$

	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	/**
	 * Loads the string using the default locale or using a language provided via <code>-Dlanguage={lang}</code>. 
	 * @param key
	 * @param missingKeyOnly if the key is missing, return the key only and no "!"
	 * @return the local string or an error message including the key
	 */
	public static String getString(String key, boolean missingKeyOnly) {
		final String language = System.getProperty("language");
		if (language != null) {
			if (!language.equals(RESOURCE_BUNDLE.getLocale().getLanguage())) {
				//System.out.println(language);
				RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, new Locale(language));
			}
		}

		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return missingKeyOnly ? key : '!' + key + '!';
		}
	}
	
	/**
	 * Loads the string 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return getString(key, false);
	}
}
