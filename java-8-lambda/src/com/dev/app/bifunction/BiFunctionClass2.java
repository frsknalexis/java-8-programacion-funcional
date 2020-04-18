package com.dev.app.bifunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionClass2 {

	public static void main(String[] args) {
		
		// Take two Integers, pow it into a Double, convert Double into a String.
		BiFunction<Integer, Integer, Double> biFunctionIntegerToDouble = (i1, i2) -> Math.pow(i1, i2);
		Function<Double, String> functionDoubleToString = (d) -> "Pow: " + String.valueOf(d);
		
		String resultString = convert(2, 4, biFunctionIntegerToDouble, functionDoubleToString);
		System.out.println(resultString);
		
		// Take two Integers, multiply into an Integer, convert Integer into a String.
		String resultString2 = convert(2, 4, (i1, i2) -> i1 * i2, (i) -> "Multiply: " + String.valueOf(i));
		System.out.println(resultString2);
		
		// Take two Strings, join both, join "cde"
		BiFunction<String, String, String> biFunctionString = (s1, s2) -> s1 + s2;
		String resultString3 = convert("a", "b", biFunctionString, (s) -> s + "cde");
		System.out.println(resultString3);
		
		// Take two Strings, join both, convert it into an Integer
		Integer resultInteger = convert("100", "200", biFunctionString, (s) -> Integer.valueOf(s));
		System.out.println(resultInteger);
		
		BiFunction<String, String, GPS> biFunctionStringToGPS = (s1, s2) -> new GPS(s1, s2);
		
		GPS objGps = factory("40.741895", "-73.989308", biFunctionStringToGPS);
		System.out.println(objGps);
	}
		
	static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2, BiFunction<A1, A2, R1> biFunction,
										Function<R1, R2> function) {
		return biFunction.andThen(function).apply(a1, a2);
	}
	
	static 	<R extends GPS> R factory(String latitude, String longitude, BiFunction<String, String, R> biFunction) {
		return biFunction.apply(latitude, longitude);
	}
}
class GPS {
	String Latitude;
    String Longitude;

    public GPS(String latitude, String longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "Latitude='" + Latitude + '\'' +
                ", Longitude='" + Longitude + '\'' +
                '}';
    }
}