package com.mnr.threads.wait.training;

public class Main {

	public static void main(String[] args) {
		MakeSome makeSome = new MakeSome();
		Giver giver = new Giver(makeSome);
		new Taker(makeSome);

	}

}
