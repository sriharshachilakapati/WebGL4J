package com.shc.webgl4j.client;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Document;

import static com.shc.webgl4j.client.WebGL10.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class TriangleTest implements EntryPoint
{
    public void onModuleLoad()
    {
        // Check if WebGL10 is supported
        if (!WebGL10.isSupported())
            throw new RuntimeException("This browser doesn't support WebGL10");

        // Get the <canvas> element to render on using WebGL
        final CanvasElement canvas = (CanvasElement) Document.get().getElementById("webgl");

        // Create the context and set the viewport
        WebGL10.createContext(canvas);
        glViewport(0, 0, canvas.getClientWidth(), canvas.getClientHeight());
        glClearColor(0, 0, 0, 1);

        // The vertex shader source
        String vsSource = "precision mediump float;                      \n" +
                          "attribute vec2 position;                      \n" +
                          "attribute vec4 color;                         \n" +
                          "                                              \n" +
                          "varying vec4 vColor;                          \n" +
                          "                                              \n" +
                          "void main()                                   \n" +
                          "{                                             \n" +
                          "    vColor = color;                           \n" +
                          "    gl_Position = vec4(position, 0.0, 1.0);   \n" +
                          "}";

        // The fragment shader source
        String fsSource = "precision mediump float;                      \n" +
                          "varying vec4 vColor;                          \n" +
                          "                                              \n" +
                          "void main()                                   \n" +
                          "{                                             \n" +
                          "    gl_FragColor = vColor   ;                 \n" +
                          "}";

        // Create the vertex shader
        int vsShaderID = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vsShaderID, vsSource);
        glCompileShader(vsShaderID);

        // Create the fragment shader
        int fsShaderID = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fsShaderID, fsSource);
        glCompileShader(fsShaderID);

        // Create the program
        int programID = glCreateProgram();
        glAttachShader(programID, vsShaderID);
        glAttachShader(programID, fsShaderID);
        glLinkProgram(programID);
        glUseProgram(programID);

        glBindAttribLocation(programID, 0, "position");
        glBindAttribLocation(programID, 1, "color");

        // Create the positions VBO
        float[] vertices =
                {
                        +0.0f, +0.8f,
                        +0.8f, -0.8f,
                        -0.8f, -0.8f,
                };

        int vboPosID = glCreateBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vboPosID);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, WebGL10.GL_FLOAT, false, 0, 0);

        // Create the colors VBO
        int[] colors =
                {
                        1, 0, 0, 1,
                        0, 1, 0, 1,
                        0, 0, 1, 1
                };

        int vboColID = glCreateBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vboColID);
        glBufferData(GL_ARRAY_BUFFER, colors, GL_STATIC_DRAW);

        glEnableVertexAttribArray(1);
        glVertexAttribPointer(1, 4, GL_FLOAT, false, 0, 0);

        AnimationScheduler.get().requestAnimationFrame(new AnimationScheduler.AnimationCallback()
        {
            @Override
            public void execute(double timestamp)
            {
                render();
                AnimationScheduler.get().requestAnimationFrame(this, canvas);
            }
        }, canvas);
    }

    private void render()
    {
        glClear(GL_COLOR_BUFFER_BIT);
        glDrawArrays(GL_TRIANGLES, 0, 3);
    }
}
