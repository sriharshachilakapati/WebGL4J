package com.shc.webgl4j.examples.client;

import com.google.gwt.canvas.client.Canvas;
import com.shc.webgl4j.client.WebGL10;
import com.shc.webgl4j.client.WebGLContext;

/**
 * The abstract class that represents an example. Contains the context, the canvas, and a simple animation loop.
 *
 * @author Sri Harsha Chilakapati
 */
public abstract class Example
{
    protected WebGLContext context;
    protected Canvas       canvas;

    public Example(Canvas canvas)
    {
        this(canvas, WebGL10.createContext(canvas));
    }

    public Example(Canvas canvas, WebGLContext context)
    {
        this.canvas = canvas;
        this.context = context;
    }

    /**
     * Initializes the WebGL resources, and also the example.
     */
    public abstract void init();

    /**
     * Called every frame to draw the example onto the canvas.
     */
    public abstract void render();
}
