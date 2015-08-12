/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Sri Harsha Chilakapati
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.shc.webgl4j.examples.client;

import com.google.gwt.canvas.client.Canvas;
import org.joml.Matrix4f;

import static com.shc.webgl4j.client.WebGL10.*;

/**
 * @author Sri Harsha Chilakapati
 */
public class RectangleExample extends Example
{
    private int programID;
    private Matrix4f projView;

    public RectangleExample(Canvas canvas)
    {
        super(canvas);
    }

    @Override
    public void init()
    {
        glClearColor(0, 0, 0, 1);

        // The vertex shader source
        String vsSource = "precision mediump float;                             \n" +
                          "                                                     \n" +
                          "uniform mat4 proj;                                   \n" +
                          "                                                     \n" +
                          "attribute vec2 position;                             \n" +
                          "attribute vec4 color;                                \n" +
                          "                                                     \n" +
                          "varying vec4 vColor;                                 \n" +
                          "                                                     \n" +
                          "void main()                                          \n" +
                          "{                                                    \n" +
                          "    vColor = color;                                  \n" +
                          "    gl_Position = proj * vec4(position, 0.0, 1.0);   \n" +
                          "}";

        // The fragment shader source
        String fsSource = "precision mediump float;                      \n" +
                          "varying vec4 vColor;                          \n" +
                          "                                              \n" +
                          "void main()                                   \n" +
                          "{                                             \n" +
                          "    gl_FragColor = vColor;                    \n" +
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
        programID = glCreateProgram();
        glAttachShader(programID, vsShaderID);
        glAttachShader(programID, fsShaderID);
        glLinkProgram(programID);
        glUseProgram(programID);

        // Create the positions VBO
        float[] vertices =
                {
                        -0.8f, +0.8f,
                        +0.8f, +0.8f,
                        -0.8f, -0.8f,
                        +0.8f, +0.8f,
                        +0.8f, -0.8f,
                        -0.8f, -0.8f
                };

        int vboPosID = glCreateBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vboPosID);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        int positionLoc = glGetAttribLocation(programID, "position");
        glVertexAttribPointer(positionLoc, 2, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(positionLoc);

        // Create the colors VBO
        float[] colors =
                {
                        1, 0, 0, 1,
                        0, 1, 0, 1,
                        0, 0, 1, 1,
                        0, 1, 0, 1,
                        1, 1, 1, 1,
                        0, 0, 1, 1
                };

        int vboColID = glCreateBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vboColID);
        glBufferData(GL_ARRAY_BUFFER, colors, GL_STATIC_DRAW);

        int colorLoc = glGetAttribLocation(programID, "color");
        glVertexAttribPointer(colorLoc, 4, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(colorLoc);

        projView = new Matrix4f();
    }

    private float angle = 0;

    @Override
    public void render()
    {
        angle++;

        projView.setPerspective((float) Math.toRadians(70), 640f / 480f, 0.1f, 100)
                .translate(0, 0, -2)
                .rotateZ((float) Math.toRadians(angle));

        glUniformMatrix4fv(glGetUniformLocation(programID, "proj"), false, projView.get(new float[16]));

        glClear(GL_COLOR_BUFFER_BIT);
        glDrawArrays(GL_TRIANGLES, 0, 6);
    }
}
