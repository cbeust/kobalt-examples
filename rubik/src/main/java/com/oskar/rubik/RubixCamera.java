package com.oskar.rubik;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.ARBDepthClamp.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class RubixCamera {
	/**
	 * The rotation along the three axes, x, y, and z.
	 */
	private Vector3f rotation;
	/**
	 * The translation along the z-axis.
	 */
	private float zoom;
	public RubixCamera(float zoom) {
		this.rotation = new Vector3f(0, 0, 0);
		this.zoom = zoom;
	}
	public void handleInput() {
		boolean left = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
		boolean right = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
		boolean up = Keyboard.isKeyDown(Keyboard.KEY_UP);
		boolean down = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
		boolean zoomIn = Keyboard.isKeyDown(Keyboard.KEY_Q);
		boolean zoomOut = Keyboard.isKeyDown(Keyboard.KEY_Z);
		boolean rollRight = Keyboard.isKeyDown(Keyboard.KEY_COMMA);
		boolean rollLeft = Keyboard.isKeyDown(Keyboard.KEY_PERIOD);
		zoom += zoomIn  ?  0.3f : 0;
		zoom += zoomOut ? -0.3f : 0;
		zoom = zoom < 10 ? 10 : (zoom > 55 ? 55 : zoom);
		Vector3f movement = new Vector3f();
		movement.x += up 	?  1 : 0;
		movement.x += down	? -1 : 0;
		movement.y += right ?  1 : 0;
		movement.y += left  ? -1 : 0;
		movement.z += rollRight ? 1 : 0;
		movement.z += rollLeft ? -1 : 0;
		if (movement.length() != 0) {
			movement.normalise();
		}
		rotation = Vector3f.add(rotation, movement, rotation);
	}
	/**
	 * Call this method to apply the camera settings to the current OpenGL projection matrix.
	 */
	public void initialise() {
	//	if (GLContext.getCapabilities().GL_ARB_depth_clamp) {
    //        glEnable(GL_DEPTH_CLAMP);
    //    }	
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		glPushAttrib(GL_TRANSFORM_BIT);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		// TODO: Add configuration for fov.
		gluPerspective(40, (float) Display.getWidth() / (float) Display.getHeight(), 4.3f, 70);
		glPopAttrib();
	}
	/**
	 * Call this method to apply the camera coordinates to the current OpenGL modelview matrix.
	 */
	public void translate() {
		glPushAttrib(GL_TRANSFORM_BIT);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glTranslatef(0, 0, -zoom);
		glRotatef(-rotation.x, 1, 0, 0);
		glRotatef(-rotation.y, 0, 1, 0);
		glRotatef(-rotation.z, 0, 0, 1);
		glPopAttrib();
	}
}

