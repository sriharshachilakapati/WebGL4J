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

package com.shc.webgl4j.client;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A class used to convert WebGL objects (WebGLTexture, WebGLBuffer etc.,) to integers just like the desktop OpenGL.
 * This class is package-private since there is no direct use of this class for users. It is simply expected to work in
 * the background.
 *
 * @author Sri Harsha Chilakapati
 */
final class WebGLObjectMap
{
    private final static Map<WebGLContext, WebGLObjectMap> contexts = new HashMap<>();

    private final Map<Integer, JavaScriptObject> shaders       = new HashMap<>();
    private final Map<Integer, JavaScriptObject> buffers       = new HashMap<>();
    private final Map<Integer, JavaScriptObject> programs      = new HashMap<>();
    private final Map<Integer, JavaScriptObject> textures      = new HashMap<>();
    private final Map<Integer, JavaScriptObject> frameBuffers  = new HashMap<>();
    private final Map<Integer, JavaScriptObject> renderBuffers = new HashMap<>();

    private final Map<Integer, Map<Integer, JavaScriptObject>> uniforms = new HashMap<>();

    // Field to store the current program
    private int currentProgram = 0;

    private WebGLObjectMap()
    {
    }

    public static WebGLObjectMap get()
    {
        WebGLObjectMap map = contexts.get(WebGLContext.getCurrent());

        if (map == null)
        {
            map = new WebGLObjectMap();
            contexts.put(WebGLContext.getCurrent(), map);
        }

        return map;
    }

    int createShader(JavaScriptObject shader)
    {
        if (shaders.values().contains(shader))
        {
            for (int key : shaders.keySet())
                if (shaders.get(key) == shader)
                    return key;
        }

        shaders.put(shaders.size() + 1, shader);
        return shaders.size();
    }

    JavaScriptObject toShader(int shaderID)
    {
        return shaders.get(shaderID);
    }

    int createBuffer(JavaScriptObject buffer)
    {
        if (buffers.values().contains(buffer))
        {
            for (int key : buffers.keySet())
                if (buffers.get(key) == buffer)
                    return key;
        }

        buffers.put(buffers.size() + 1, buffer);
        return buffers.size();
    }

    JavaScriptObject toBuffer(int bufferID)
    {
        return buffers.get(bufferID);
    }

    int createProgram(JavaScriptObject program)
    {
        if (programs.values().contains(program))
        {
            for (int key : programs.keySet())
                if (programs.get(key) == program)
                    return key;
        }

        programs.put(programs.size() + 1, program);
        return programs.size();
    }

    JavaScriptObject toProgram(int programID)
    {
        return programs.get(programID);
    }

    int createTexture(JavaScriptObject texture)
    {
        if (textures.values().contains(texture))
        {
            for (int key : textures.keySet())
                if (textures.get(key) == texture)
                    return key;
        }

        textures.put(textures.size() + 1, texture);
        return textures.size();
    }

    JavaScriptObject toTexture(int textureID)
    {
        return textures.get(textureID);
    }

    int createFramebuffer(JavaScriptObject frameBuffer)
    {
        if (frameBuffers.values().contains(frameBuffer))
        {
            for (int key : frameBuffers.keySet())
                if (frameBuffers.get(key) == frameBuffer)
                    return key;
        }

        frameBuffers.put(frameBuffers.size() + 1, frameBuffer);
        return frameBuffers.size();
    }

    JavaScriptObject toFramebuffer(int frameBuffer)
    {
        return frameBuffers.get(frameBuffer);
    }

    int createRenderBuffer(JavaScriptObject renderBuffer)
    {
        if (renderBuffers.values().contains(renderBuffer))
        {
            for (int key : renderBuffers.keySet())
                if (renderBuffers.get(key) == renderBuffer)
                    return key;
        }

        renderBuffers.put(renderBuffers.size() + 1, renderBuffer);
        return renderBuffers.size();
    }

    JavaScriptObject toRenderBuffer(int renderBuffer)
    {
        return renderBuffers.get(renderBuffer);
    }

    int createUniform(JavaScriptObject uniform)
    {
        Map<Integer, JavaScriptObject> progUniforms = uniforms.get(currentProgram);

        if (progUniforms == null)
        {
            progUniforms = new HashMap<>();
            uniforms.put(currentProgram, progUniforms);
        }

        if (progUniforms.values().contains(uniform))
        {
            for (int key : progUniforms.keySet())
                if (progUniforms.get(key) == uniform)
                    return key;
        }

        progUniforms.put(progUniforms.size() + 1, uniform);
        return progUniforms.size();
    }

    JavaScriptObject toUniform(int programID, int uniform)
    {
        return uniforms.get(programID).get(uniform);
    }

    JavaScriptObject toUniform(int uniform)
    {
        return toUniform(currentProgram, uniform);
    }

    void deleteShader(int shader)
    {
        shaders.remove(shader);
    }

    void deleteBuffer(int buffer)
    {
        buffers.remove(buffer);
    }

    void deleteProgram(int program)
    {
        programs.remove(program);
        uniforms.remove(program);
    }

    void deleteTexture(int texture)
    {
        textures.remove(texture);
    }

    void deleteFramebuffer(int frameBuffer)
    {
        frameBuffers.remove(frameBuffer);
    }

    void deleteRenderBuffer(int renderBuffer)
    {
        renderBuffers.remove(renderBuffer);
    }
}
