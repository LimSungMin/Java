package com.example.java;

import java.awt.Color;
import java.awt.Graphics;

public class TurtleGraphics {
	private double x; // ��Ʋ�� ��ġ
	private double y;
	private double degree; // ��Ʋ�� ���� 0~360��
	private boolean penup; // true�̸� �̵�, false�̸� �׸���

	private Graphics g;

	TurtleGraphics(double x, double y, double degree, Graphics g) {
		this.x = x;
		this.y = y;
		this.degree = degree;
		this.g = g;

		penup = true;
	}

	public void penUp() {
		// �̵� �غ�
		penup = true;
	}

	public void penDown() {
		// �׸��� �غ�
		penup = false;
	}

	public void forward(double steps) {
		// ������ġ�� steps��ŭ �̵��� ���� ��ġ ���̿� �� �׸���
		// 1) Pen Up ������ ��쿡�� ���� �׸��� ��Ʋ�� �̵��ϰ�,
		// 2) Pen Down ���¿��� ���� �׸��� �ʰ� �̵�

		// steps��ŭ �̵��� ��ġ�� x,y��ǥ
		// 1) x + steps * sin(degree)
		// 2) y - steps * cos(degree)

		if (!penup) {
			g.drawLine((int) this.x, (int) this.y,
					(int) (this.x + steps * Math.sin(degree*Math.PI/180.0f)),
					(int) (this.y - steps * Math.cos(degree*Math.PI/180.0f)));
			this.x += steps * Math.sin(degree*Math.PI/180.0f);
			this.y -= steps * Math.cos(degree*Math.PI/180.0f);
		} else {
			this.x += steps * Math.sin(degree*Math.PI/180.0f);
			this.y -= steps * Math.cos(degree*Math.PI/180.0f);
		}

	}

	public void backward(double steps) {
		forward(-steps);
	}

	public void leftTurn(double angle) {
		// ���� �������� ���ڷ� �־��� ������ ����
		this.degree -= angle;
	}

	public void rightTurn(double angle) {
		// ���� �������� ���ڷ� �־��� ������ ���ϱ�
		this.degree += angle;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getDegree() {
		return degree;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}
}
