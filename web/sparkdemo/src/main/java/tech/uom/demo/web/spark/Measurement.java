/*
Copyright 2016-2020 Werner Keil and others

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/
package tech.uom.demo.web.spark;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.UUID;

public class Measurement {
	private String id;
	private String name;
	private Number value;
	private String unit;
	private Temporal timestamp;

	public Measurement(String name, Number value, String unit) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.value = value;
		this.unit = unit;
		this.timestamp = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public Temporal getTimestamp() {
		return timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getValue() {
		return value;
	}

	public void setValue(Number val) {
		this.value = val;
	}

	public String getUnit() {
		return unit;
	}
}
