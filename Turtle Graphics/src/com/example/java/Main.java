package com.example.java;

import java.awt.Graphics;
import javax.swing.JApplet;

public class Main extends JApplet {
	public void init() {
		resize(1200, 720); // �ʱ� ȭ�� ũ��
	}

	public void paint(Graphics g) {
		TurtleGraphics tg = new TurtleGraphics(250, 360, 0, g); // ��Ʋ�� �ʱ�
																// ��ġ(600,360)��
																// ����(0��)
		Rectangle.draw(tg); // �簢�� �׸���
		tg.setX(tg.getX()+200);
		tg.setDegree(0);
		
		Pentagon.draw(tg);	// ������ �׸���
		tg.setX(tg.getX()+200);
		tg.setDegree(0);
		
		Octagon.draw(tg);	// ������ �׸���
		tg.setX(tg.getX()+200);
		tg.setDegree(0);

		Tree.draw(tg);		// ���� �׸���
	}
}