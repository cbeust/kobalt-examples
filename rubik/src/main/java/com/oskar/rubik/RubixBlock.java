package com.oskar.rubik;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * A block of a rubix cube.
 * @author Oskar Veerhoek
 */
public class RubixBlock {
	public static enum Side { 
		WHITE(1, 1, 1), YELLOW(1, 1, 0), BLUE(0, 0, 1), GREEN(0, 1, 0), RED(1, 0, 0), ORANGE(1, 0.5f, 0);
		public final float r, g, b;
		Side(float red, float green, float blue) {
			this.r = red;
			this.g = green;
			this.b = blue;
		}
	}
	// TODO: Encapsulate variables.
	public Side leftSide, rightSide, topSide, bottomSide, frontSide, backSide;
	private int displayList;
	public RubixBlock(Side leftSide, Side rightSide, Side topSide, Side bottomSide, Side frontSide, Side backSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		this.topSide = topSide;
		this.bottomSide = bottomSide;
		this.frontSide = frontSide;
		this.backSide = backSide;
	}
	/**
	 * Performs initialisation, for example: creates rendering objects for OpenGL.
	 */
	public void initialise() {
		displayList = glGenLists(1);
		glNewList(displayList, GL_COMPILE);
		// Left Side
		glColor3f(leftSide.r, leftSide.g, leftSide.b);
		glBegin(GL_QUADS);
		glNormal3f(-1, 0, 0);
		glVertex3f(-1, 1, -1);
		glVertex3f(-1, -1, -1);
		glVertex3f(-1, -1, 1);
		glVertex3f(-1, 1, 1);
		glEnd();
		// Right Side
		glColor3f(rightSide.r, rightSide.g, rightSide.b);
		glBegin(GL_QUADS);
		glNormal3f(1, 0, 0);
		glVertex3f(1, 1, -1);
		glVertex3f(1, 1, 1);
		glVertex3f(1, -1, 1);
		glVertex3f(1, -1, -1);
		glEnd();
		// Front Side
		glColor3f(frontSide.r, frontSide.g, frontSide.b);
		glBegin(GL_QUADS);
		glNormal3f(0, 0, 1);
		glVertex3f(-1, -1, 1);
		glVertex3f(1, -1, 1);
		glVertex3f(1, 1, 1);
		glVertex3f(-1, 1, 1);
		glEnd();
		// Back Side
		glColor3f(backSide.r, backSide.g, backSide.b);
		glBegin(GL_QUADS);
		glNormal3f(0, 0, -1);
		glVertex3f(-1, -1, -1);
		glVertex3f(-1, 1, -1);
		glVertex3f(1, 1, -1);
		glVertex3f(1, -1, -1);
		glEnd();
		// Top Side
		glColor3f(topSide.r, topSide.g, topSide.b);
		glBegin(GL_QUADS);
		glNormal3f(0, 1, 0);
		glVertex3f(-1, 1, 1);
		glVertex3f(1, 1, 1);
		glVertex3f(1, 1, -1);
		glVertex3f(-1, 1, -1);
		glEnd();
		// Bottom Side
		glColor3f(bottomSide.r, bottomSide.g, bottomSide.b);
		glBegin(GL_QUADS);
		glNormal3f(0, -1, 0);
		glVertex3f(-1, -1, 1);
		glVertex3f(-1, -1, -1);
		glVertex3f(1, -1, -1);
		glVertex3f(1, -1, 1);
		glEnd();
		glEndList();
	}
	/**
	 * Draws the rubix block using the immediate rendering mode.
	 */
	public void drawInImmediateMode() {
		// Left Side
		glColor3f(leftSide.r, leftSide.g, leftSide.b);
		glBegin(GL_QUADS);
		glVertex3f(-1, 1, -1);
		glVertex3f(-1, -1, -1);
		glVertex3f(-1, -1, 1);
		glVertex3f(-1, 1, 1);
		glEnd();
		// Right Side
		glColor3f(rightSide.r, rightSide.g, rightSide.b);
		glBegin(GL_QUADS);
		glVertex3f(1, 1, -1);
		glVertex3f(1, 1, 1);
		glVertex3f(1, -1, 1);
		glVertex3f(1, -1, -1);
		glEnd();
		// Front Side
		glColor3f(frontSide.r, frontSide.g, frontSide.b);
		glBegin(GL_QUADS);
		glVertex3f(-1, -1, 1);
		glVertex3f(1, -1, 1);
		glVertex3f(1, 1, 1);
		glVertex3f(-1, 1, 1);
		glEnd();
		// Back Side
		glColor3f(backSide.r, backSide.g, backSide.b);
		glBegin(GL_QUADS);
		glVertex3f(-1, -1, -1);
		glVertex3f(-1, 1, -1);
		glVertex3f(1, 1, -1);
		glVertex3f(1, -1, -1);
		glEnd();
		// Top Side
		glColor3f(topSide.r, topSide.g, topSide.b);
		glBegin(GL_QUADS);
		glVertex3f(-1, 1, 1);
		glVertex3f(1, 1, 1);
		glVertex3f(1, 1, -1);
		glVertex3f(-1, 1, -1);
		glEnd();
		// Bottom Side
		glColor3f(bottomSide.r, bottomSide.g, bottomSide.b);
		glBegin(GL_QUADS);
		glVertex3f(-1, -1, 1);
		glVertex3f(-1, -1, -1);
		glVertex3f(1, -1, -1);
		glVertex3f(1, -1, 1);
		glEnd();
	}
	/**
	 * Draws the rubix block to the currently bound OpenGL Framebuffer.
	 */
	public void draw() {
		// TODO: Disable possibly malignant states (i.e.: lighting).
		// TODO: Add initialisation check.
		glCallList(displayList);
	}
	/**
	 * Frees all the resources that the rubix block was using.
	 */
	public void release() {
		glDeleteLists(1, displayList);
	}
}
