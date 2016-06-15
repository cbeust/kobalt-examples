package com.oskar.rubik;

import static org.lwjgl.opengl.GL11.*;
import static com.oskar.rubik.RubixBlock.Side.*;

/**
 * A rubix cube.
 * @author Oskar Veerhoek
 */
public final class RubixCube {
	/**
	 * The width, height and length of the rubix cube in blocks.
	 */
	private final int size; 	
	private final RubixBlock[][][] blocks;
	private int displayList;
	public RubixCube(int size) {
		this.size = size;
		this.blocks = new RubixBlock[size][size][size];
		for (int x = 0; x < size; x++) 
			for (int y = 0; y < size; y++)
				for (int z = 0; z < size; z++) 
					blocks[x][y][z] = new RubixBlock(WHITE, YELLOW, BLUE, GREEN, RED, ORANGE);
	}
	public void initialise() {
		displayList = glGenLists(1);
		glNewList(displayList, GL_COMPILE);
		// TODO: Remove inside blocks and add lines between them.
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int z = 0; z < size; z++) {
					glPushMatrix();
					glTranslatef(2.2f*(x-1), 2.2f*(y-1), 2.2f*(z-1));
					blocks[x][y][z].drawInImmediateMode();
					glPopMatrix();
				}
			}
		}
		glEndList();
	}
	public void draw() {
		glCallList(displayList);
	}
}
