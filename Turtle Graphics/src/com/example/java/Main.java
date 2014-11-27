package com.example.java;

import java.awt.Graphics;
import javax.swing.JApplet;

public class Main extends JApplet {
	public void init() {
		resize(1200, 720); // 초기 화면 크기
	}

	public void paint(Graphics g) {
		TurtleGraphics tg = new TurtleGraphics(250, 360, 0, g); // 터틀의 초기
																// 위치(600,360)와
																// 방향(0도)
		Rectangle.draw(tg); // 사각형 그리기
		tg.setX(tg.getX()+200);
		tg.setDegree(0);
		
		Pentagon.draw(tg);	// 오각형 그리기
		tg.setX(tg.getX()+200);
		tg.setDegree(0);
		
		Octagon.draw(tg);	// 육각형 그리기
		tg.setX(tg.getX()+200);
		tg.setDegree(0);

		Tree.draw(tg);		// 나무 그리기
	}
}