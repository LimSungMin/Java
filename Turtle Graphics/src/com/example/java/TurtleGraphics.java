package com.example.java;

import java.awt.Color;
import java.awt.Graphics;

public class TurtleGraphics {
	private double x; // 터틀의 위치
	private double y;
	private double degree; // 터틀의 방향 0~360도
	private boolean penup; // true이면 이동, false이면 그리기

	private Graphics g;

	TurtleGraphics(double x, double y, double degree, Graphics g) {
		this.x = x;
		this.y = y;
		this.degree = degree;
		this.g = g;

		penup = true;
	}

	public void penUp() {
		// 이동 준비
		penup = true;
	}

	public void penDown() {
		// 그리기 준비
		penup = false;
	}

	public void forward(double steps) {
		// 현재위치와 steps만큼 이동한 다음 위치 사이에 선 그리기
		// 1) Pen Up 상태인 경우에는 선을 그리고 터틀을 이동하고,
		// 2) Pen Down 상태에는 선을 그리지 않고 이동

		// steps만큼 이동한 위치의 x,y좌표
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
		// 현재 각도에서 인자로 주어진 각도를 빼기
		this.degree -= angle;
	}

	public void rightTurn(double angle) {
		// 현재 각도에서 인자로 주어진 각도를 더하기
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
