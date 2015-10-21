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
public final class WEBGL_compressed_texture_s3tc
{
    public static final int GL_COMPRESSED_RGB_S3TC_DXT1_EXT  = 0x83F0;
    public static final int GL_COMPRESSED_RGBA_S3TC_DXT1_EXT = 0x83F1;
    public static final int GL_COMPRESSED_RGBA_S3TC_DXT3_EXT = 0x83F2;
    public static final int GL_COMPRESSED_RGBA_S3TC_DXT5_EXT = 0x83F3;

    /* Prevent instantiation */
    private WEBGL_compressed_texture_s3tc()
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
                case "WEBGL_compressed_texture_s3tc":
                case "O_WEBGL_compressed_texture_s3tc":
                case "IE_WEBGL_compressed_texture_s3tc":
                case "MOZ_WEBGL_compressed_texture_s3tc":
                case "WEBKIT_WEBGL_compressed_texture_s3tc":
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
            throw new RuntimeException("This browser does not support the WEBGL_compressed_texture_s3tc extension.");

        if (!isExtensionEnabled())
            nEnableExtension();
    }

    public static native boolean isExtensionEnabled() /*-{
        return typeof ($wnd.gl.wcts_ext) !== 'undefined';
    }-*/;

    private static native void nEnableExtension() /*-{
        $wnd.gl.wcts_ext = $wnd.gl.getExtension('WEBGL_compressed_texture_s3tc') ||
            $wnd.gl.getExtension('O_WEBGL_compressed_texture_s3tc') ||
            $wnd.gl.getExtension('IE_WEBGL_compressed_texture_s3tc') ||
            $wnd.gl.getExtension('MOZ_WEBGL_compressed_texture_s3tc') ||
            $wnd.gl.getExtension('WEBKIT_WEBGL_compressed_texture_s3tc');
    }-*/;
}
