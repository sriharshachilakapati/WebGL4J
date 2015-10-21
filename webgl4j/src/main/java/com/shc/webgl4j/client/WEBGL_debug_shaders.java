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
public final class WEBGL_debug_shaders
{
    /* Prevent instantiation */
    private WEBGL_debug_shaders()
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
                case "WEBGL_debug_shaders":
                case "O_WEBGL_debug_shaders":
                case "IE_WEBGL_debug_shaders":
                case "MOZ_WEBGL_debug_shaders":
                case "WEBKIT_WEBGL_debug_shaders":
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
            throw new RuntimeException("This browser does not support the WEBGL_debug_shaders extension.");

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

    public static String glGetTranslatedShaderSource(int shader)
    {
        checkExtension();
        return nglGetTranslatedShaderSource(WebGLObjectMap.get().toShader(shader));
    }

    public static native boolean isExtensionEnabled() /*-{
        return typeof ($wnd.gl.wds_ext) !== 'undefined';
    }-*/;

    private static native void nEnableExtension() /*-{
        $wnd.gl.wds_ext = $wnd.gl.getExtension('WEBGL_debug_shaders') ||
            $wnd.gl.getExtension('O_WEBGL_debug_shaders') ||
            $wnd.gl.getExtension('IE_WEBGL_debug_shaders') ||
            $wnd.gl.getExtension('MOZ_WEBGL_debug_shaders') ||
            $wnd.gl.getExtension('WEBKIT_WEBGL_debug_shaders');
    }-*/;

    private static native String nglGetTranslatedShaderSource(JavaScriptObject shader) /*-{
        return $wnd.gl.wds_ext.getTranslatedShaderSource(shader);
    }-*/;
}
