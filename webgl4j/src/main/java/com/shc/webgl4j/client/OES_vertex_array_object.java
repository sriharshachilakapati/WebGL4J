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

/**
 * @author Sri Harsha Chilakapati
 */
public final class OES_vertex_array_object
{
    public static final int GL_VERTEX_ARRAY_BINDING_OES = 0x85B5;

    /* Prevent instantiation */
    private OES_vertex_array_object()
    {
    }

    public static boolean isSupported()
    {
        if (!WebGL10.isSupported())
            return false;

        if (!WebGL10.isContextCompatible())
            throw new IllegalStateException("You must have a WebGL context >= 1.0 to check if extension is supported.");

        for (String supportedExtension : WebGL10.glGetSupportedExtensions())
        {
            switch (supportedExtension)
            {
                case "OES_vertex_array_object":
                case "O_OES_vertex_array_object":
                case "IE_OES_vertex_array_object":
                case "MOZ_OES_vertex_array_object":
                case "WEBKIT_OES_vertex_array_object":
                    return true;
            }
        }

        return false;
    }

    public static void enableExtension()
    {
        if (!WebGL10.isContextCompatible())
            throw new IllegalStateException("You must have a WebGL context >= 1.0 to enable this extension.");

        if (!isSupported())
            throw new RuntimeException("This browser does not support the OES_vertex_array_object extension.");

        if (!isExtensionEnabled())
            nEnableExtension();
    }

    private static void checkExtension()
    {
        if (!WebGL10.isContextCompatible())
            throw new RuntimeException("You must create a WebGL context before accessing extension methods.");

        if (!isExtensionEnabled())
            throw new IllegalStateException("Extension must be enabled before using any members.");
    }

    public static native boolean isExtensionEnabled() /*-{
        return typeof ($wnd.gl.ovao_ext) !== 'undefined';
    }-*/;

    public static void glBindVertexArrayOES(int vertexArrayOES)
    {
        checkExtension();
        nglBindVertexArrayOES(WebGLObjectMap.get().toVertexArrayObject(vertexArrayOES));
    }

    public static int glCreateVertexArrayOES()
    {
        checkExtension();
        return WebGLObjectMap.get().createVertexArrayObject(nglCreateVertexArrayOES());
    }

    public static void glDeleteVertexArrayOES(int vertexArrayOES)
    {
        checkExtension();
        nglDeleteVertexArrayOES(WebGLObjectMap.get().toVertexArrayObject(vertexArrayOES));
        WebGLObjectMap.get().deleteVertexArrayObject(vertexArrayOES);
    }

    @WebGLContext.HandlesContextLoss
    public static boolean glIsVertexArrayOES(int vertexArrayOES)
    {
        checkExtension();
        return nglIsVertexArrayOES(WebGLObjectMap.get().toVertexArrayObject(vertexArrayOES));
    }

    private static native void nEnableExtension() /*-{
        $wnd.gl.ovao_ext = $wnd.gl.getExtension('OES_vertex_array_object') ||
            $wnd.gl.getExtension('O_OES_vertex_array_object') ||
            $wnd.gl.getExtension('IE_OES_vertex_array_object') ||
            $wnd.gl.getExtension('MOZ_OES_vertex_array_object') ||
            $wnd.gl.getExtension('WEBKIT_OES_vertex_array_object');
    }-*/;

    private static native void nglBindVertexArrayOES(JavaScriptObject vertexArrayOES) /*-{
        $wnd.gl.ovao_ext.bindVertexArrayOES(vertexArrayOES);
    }-*/;

    private static native JavaScriptObject nglCreateVertexArrayOES() /*-{
        return $wnd.gl.ovao_ext.createVertexArrayOES();
    }-*/;

    private static native void nglDeleteVertexArrayOES(JavaScriptObject vertexArrayOES) /*-{
        $wnd.gl.ovao_ext.deleteVertexArrayOES(vertexArrayOES);
    }-*/;

    private static native boolean nglIsVertexArrayOES(JavaScriptObject vertexArrayOES) /*-{
        return $wnd.gl.ovao_ext.isVertexArrayOES(vertexArrayOES);
    }-*/;
}
