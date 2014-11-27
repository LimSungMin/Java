package com.example.java;

public class Pentagon {
	public static void draw(TurtleGraphics tg) {
		tg.penDown();

		for (int i = 0; i < 4; i++) {
			tg.forward(100);
			tg.leftTurn(72);
		}
		tg.forward(100);
	}
}
