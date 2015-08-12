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
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import org.joml.Matrix4f;

import static com.shc.webgl4j.client.WebGL10.*;

/**
 * @author Sri Harsha Chilakapati
 */
public class TexturedCubeExample extends Example
{
    private int      programID;
    private Matrix4f projView;

    public TexturedCubeExample(Canvas canvas)
    {
        super(canvas);
    }

    @Override
    public void init()
    {
        glClearColor(0, 0, 0, 1);

        glEnable(GL_DEPTH_TEST);

        // The vertex shader source
        String vsSource = "precision mediump float;                             \n" +
                          "                                                     \n" +
                          "uniform mat4 proj;                                   \n" +
                          "                                                     \n" +
                          "attribute vec3 position;                             \n" +
                          "attribute vec2 texCoords;                            \n" +
                          "                                                     \n" +
                          "varying vec2 vTexCoords;                             \n" +
                          "                                                     \n" +
                          "void main()                                          \n" +
                          "{                                                    \n" +
                          "    vTexCoords = texCoords;                          \n" +
                          "    gl_Position = proj * vec4(position, 1.0);        \n" +
                          "}";

        // The fragment shader source
        String fsSource = "precision mediump float;                         \n" +
                          "                                                 \n" +
                          "uniform sampler2D tex;                           \n" +
                          "                                                 \n" +
                          "varying vec2 vTexCoords;                         \n" +
                          "                                                 \n" +
                          "void main()                                      \n" +
                          "{                                                \n" +
                          "    gl_FragColor = texture2D(tex, vTexCoords);   \n" +
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
                        // Front face
                        -1, +1, +1,
                        -1, -1, +1,
                        +1, +1, +1,
                        +1, +1, +1,
                        -1, -1, +1,
                        +1, -1, +1,

                        // Right face
                        +1, +1, +1,
                        +1, -1, +1,
                        +1, +1, -1,
                        +1, +1, -1,
                        +1, -1, +1,
                        +1, -1, -1,

                        // Back face
                        +1, +1, -1,
                        +1, -1, -1,
                        -1, -1, -1,
                        -1, -1, -1,
                        -1, +1, -1,
                        +1, +1, -1,

                        // Left face
                        -1, +1, -1,
                        -1, -1, -1,
                        -1, -1, +1,
                        -1, -1, +1,
                        -1, +1, +1,
                        -1, +1, -1,

                        // Top face
                        -1, +1, -1,
                        -1, +1, +1,
                        +1, +1, -1,
                        +1, +1, -1,
                        -1, +1, +1,
                        +1, +1, +1,

                        // Bottom face
                        -1, -1, -1,
                        -1, -1, +1,
                        +1, -1, -1,
                        +1, -1, -1,
                        -1, -1, +1,
                        +1, -1, +1
                };

        int vboPosID = glCreateBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vboPosID);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        int positionLoc = glGetAttribLocation(programID, "position");
        glVertexAttribPointer(positionLoc, 3, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(positionLoc);

        // Create the colors VBO
        float[] texCoords =
                {
                        // Front face
                        0, 0,
                        0, 1,
                        1, 0,
                        1, 0,
                        0, 1,
                        1, 1,

                        // Right face
                        0, 0,
                        0, 1,
                        1, 0,
                        1, 0,
                        0, 1,
                        1, 1,

                        // Back face
                        0, 0,
                        0, 1,
                        1, 0,
                        1, 0,
                        0, 1,
                        1, 1,

                        // Left face
                        0, 0,
                        0, 1,
                        1, 0,
                        1, 0,
                        0, 1,
                        1, 1,

                        // Top face
                        0, 0,
                        0, 1,
                        1, 0,
                        1, 0,
                        0, 1,
                        1, 1,

                        // Bottom face
                        0, 0,
                        0, 1,
                        1, 0,
                        1, 0,
                        0, 1,
                        1, 1,
                };

        int vboTexID = glCreateBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vboTexID);
        glBufferData(GL_ARRAY_BUFFER, texCoords, GL_STATIC_DRAW);

        int texcoordLoc = glGetAttribLocation(programID, "texCoords");
        glVertexAttribPointer(texcoordLoc, 2, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(texcoordLoc);

        final Image image = new Image("texture.png");
        image.addLoadHandler(new LoadHandler()
        {
            @Override
            public void onLoad(LoadEvent event)
            {
                // Make current again, this is asynchronous event
                context.makeCurrent();
                int texID = glCreateTexture();
                glBindTexture(GL_TEXTURE_2D, texID);

                glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, GL_RGBA, GL_UNSIGNED_BYTE, image);

                glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
                glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);

                glUniform1i(glGetUniformLocation(programID, "tex"), 0);
            }
        });
        image.setVisible(false);
        RootPanel.get().add(image);

        projView = new Matrix4f();
    }

    private float angle = 0;

    @Override
    public void render()
    {
        angle++;

        projView.setPerspective((float) Math.toRadians(70), 640f / 480f, 0.1f, 100)
                .translate(0, 0, -4)
                .rotateX((float) Math.toRadians(angle))
                .rotateY((float) Math.toRadians(angle))
                .rotateZ((float) Math.toRadians(angle));

        glUniformMatrix4fv(glGetUniformLocation(programID, "proj"), false, projView.get(new float[16]));

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glDrawArrays(GL_TRIANGLES, 0, 36);
    }
}
