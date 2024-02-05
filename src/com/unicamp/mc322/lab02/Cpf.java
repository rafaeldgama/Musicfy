package com.unicamp.mc322.lab02;

public class Cpf {
	
	private Double cpf;

	public Cpf(String cpf) {
		this.cpf = Double.parseDouble(cpf);
	}
	
	public Double getCpf() {
		return cpf;
	}
	
	public String toString() {
		double[] vect = new double[11];
		double aux = cpf;
		for(int i = 10; i >=0; i--) {
			vect[i] = aux%10;
			aux = aux/10;
		}
		int[] intArray = new int[11]; 
		for(int i = 0; i < 11; i++)
			intArray[i] = (int) vect[i];
		return String.format("%d%d%d", intArray[0], intArray[1], intArray[2]) + "."
				+ String.format("%d%d%d", intArray[3], intArray[4], intArray[5]) + "."
				+ String.format("%d%d%d", intArray[6], intArray[7], intArray[8]) + "-"
				+ String.format("%d%d", intArray[9], intArray[10]);
	}
	
}
