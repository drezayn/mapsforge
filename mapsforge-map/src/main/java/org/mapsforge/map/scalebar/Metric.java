/*
 * Copyright 2010, 2011, 2012 mapsforge.org
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mapsforge.map.scalebar;

public final class Metric implements Adapter {
	public static final Metric INSTANCE = new Metric();
	private static final int ONE_KILOMETER = 1000;
	private static final int[] SCALE_BAR_VALUES = { 10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000,
			20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };

	private Metric() {
		// do nothing
	}

	@Override
	public int[] getScaleBarValues() {
		return SCALE_BAR_VALUES;
	}

	@Override
	public int getScaleValue(int mapScaleValue) {
		if (mapScaleValue < ONE_KILOMETER) {
			return mapScaleValue;
		}
		return mapScaleValue / ONE_KILOMETER;
	}

	@Override
	public String getUnitSymbol(int mapScaleValue) {
		if (mapScaleValue < ONE_KILOMETER) {
			return "m";
		}
		return "km";
	}

	@Override
	public double getMeterRatio() {
		return 1;
	}
}