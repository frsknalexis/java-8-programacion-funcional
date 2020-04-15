package com.dev.app.lambda;

public class Lambda implements PorDefecto {

	public static void main(String[] args) {
		// System.out.println(System.getProperty("java.runtime.version"));
		
		MiNombre miNombre = new MiNombre() {
			
			@Override
			public String miNombre() {
				return "Alexis Manuel";
			}
		};
		
		System.out.println(miNombre.miNombre());
		
		MiNombre miNombreLambda = () -> {
			return "Alexis Manuel usando lambda";
		};
		
		System.out.println("Lambda Expression: " + miNombreLambda.miNombre());
		
		Apply applyFunction = new Apply() {
			
			@Override
			public Integer apply(Integer a, Integer b) {
				return a + b;
			}
		};
		
		System.out.println("Aplicando suma: " + applyFunction.apply(2, 3));
		
		Apply applyFunctionLambda = (a, b) -> {
			return a + b;
		};
		
		System.out.println("Lambda Expression, Aplicando suma: " + applyFunctionLambda.apply(2, 3));
		
		Apply applyFunctionLambda2 = (a, b) -> {
			a = b * b;
			a += b;
			System.out.println("Mensaje dentro del lambda");
			return a;
		};
		
		System.out.println(applyFunctionLambda2.apply(2, 3));
		
		Lambda l = new Lambda();
		
		System.out.println("Mostra nombre por default: " + l.nombrePorDefecto("Alexis Manuel"));
	}

	@Override
	public void mostrarNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}
}
