package com.oskar.rubik;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluErrorString;
import static com.oskar.rubik.RubixBlock.Side.*;

/**
 * Shows a Rubik's cube that you can rotate but not yet modify.
 *  ARROW KEYS, COMMA, PERIOD = rotate
 *  X = zoom in
 *  Q = zoom out
 *  RETURN = terminate window
 * @author Oskar Veerhoek
 */
public class Main {
	public static void main(String[] args) throws LWJGLException {
		Display.setTitle("A Rubik's Cube in LWJGL");
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Display.create(new PixelFormat(32, 0, 24, 8, 4));
		} catch (LWJGLException e) {
			System.err.println("Failed to create multisampled OpenGL context. Creating normal one.");
			try {
				Display.create();
			} catch (LWJGLException ex) {
				ex.printStackTrace();
				Display.destroy();
				System.exit(1);
			}
		}
		RubixCamera camera = new RubixCamera(18);
		camera.initialise();
		RubixCube cube = new RubixCube(3);
		cube.initialise();
		boolean running = true;
		while (running) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			camera.translate();
			camera.handleInput();
			cube.draw();
			running = Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_RETURN) ? false : running;
			Display.update();
			Display.sync(60);
		}	
		System.out.println(gluErrorString(glGetError()));
		Display.destroy();
	}
}
