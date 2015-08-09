package com.shc.webgl4j.examples.client;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.canvas.client.Canvas;
import com.shc.webgl4j.client.WebGL10;
import com.shc.webgl4j.client.WebGLContext;

/**
 * @author Sri Harsha Chilakapati
 */
public class Example
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

    public void init()
    {
    }

    public void render()
    {
    }

    public Example start()
    {
        init();

        AnimationScheduler.get().requestAnimationFrame(new AnimationScheduler.AnimationCallback()
        {
            @Override
            public void execute(double timestamp)
            {
                render();
                AnimationScheduler.get().requestAnimationFrame(this, canvas.getCanvasElement());
            }
        }, canvas.getCanvasElement());

        return this;
    }
}
