package com.example.java;

public class Octagon {
	public static void draw(TurtleGraphics tg) {
		tg.penDown();

		for (int i = 0; i < 5; i++) {
			tg.forward(100);
			tg.leftTurn(60);
		}
		tg.forward(100);
	}
}
