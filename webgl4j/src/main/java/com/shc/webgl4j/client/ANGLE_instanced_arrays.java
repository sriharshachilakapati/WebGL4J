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

/**
 * @author Sri Harsha Chilakapati
 */
public final class ANGLE_instanced_arrays
{
    public static final int VERTEX_ATTRIB_ARRAY_DIVISOR_ANGLE = 0x88FE;

    /* Prevent instantiation */
    private ANGLE_instanced_arrays()
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
                case "ANGLE_instanced_arrays":
                case "O_ANGLE_instanced_arrays":
                case "IE_ANGLE_instanced_arrays":
                case "MOZ_ANGLE_instanced_arrays":
                case "WEBKIT_ANGLE_instanced_arrays":
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
            throw new RuntimeException("This browser does not support the ANGLE_instanced_arrays extension.");

        if (!isExtensionEnabled())
            nEnableExtension();
    }

    private static void checkExtension()
    {
        if (!WebGL10.isContextCompatible())
            throw new RuntimeException("You must have a WebGL context >= 1.0 before accessing extension methods.");

        if (!isExtensionEnabled())
            throw new IllegalStateException("Extension must be enabled before using any functions.");
    }

    public static native boolean isExtensionEnabled() /*-{
        return typeof ($wnd.gl.aia_ext) !== 'undefined';
    }-*/;

    public static void glDrawArraysInstancedANGLE(int mode, int first, int count, int primCount)
    {
        checkExtension();
        nglDrawArraysInstancedANGLE(mode, first, count, primCount);
    }

    public static void glDrawElementsInstancedANGLE(int mode, int count, int type, int offset, int primCount)
    {
        checkExtension();
        nglDrawElementsInstancedANGLE(mode, count, type, offset, primCount);
    }

    public static void glVertexAttribDivisorANGLE(int index, int divisor)
    {
        checkExtension();
        nglVertexAttribDivisorANGLE(index, divisor);
    }

    private static native void nEnableExtension() /*-{
        $wnd.gl.aia_ext = $wnd.gl.getExtension('ANGLE_instanced_arrays') ||
            $wnd.gl.getExtension('O_ANGLE_instanced_arrays') ||
            $wnd.gl.getExtension('IE_ANGLE_instanced_arrays') ||
            $wnd.gl.getExtension('MOZ_ANGLE_instanced_arrays') ||
            $wnd.gl.getExtension('WEBKIT_ANGLE_instanced_arrays');
    }-*/;

    private static native void nglDrawArraysInstancedANGLE(int mode, int first, int count, int primCount) /*-{
        $wnd.gl.aia_ext.drawArraysInstancedANGLE(mode, first, count, primCount);
    }-*/;

    private static native void nglDrawElementsInstancedANGLE(int mode, int count, int type, int offset, int primCount) /*-{
        $wnd.gl.aia_ext.drawElementsInstancedANGLE(mode, count, type, offset, primCount);
    }-*/;

    private static native void nglVertexAttribDivisorANGLE(int index, int divisor) /*-{
        $wnd.gl.aia_ext.vertexAttribDivisorANGLE(index, divisor);
    }-*/;
}
