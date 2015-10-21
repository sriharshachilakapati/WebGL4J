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

import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.typedarrays.shared.Int32Array;

/**
 * @author Sri Harsha Chilakapati
 */
public final class WEBGL_draw_buffers
{
    public static final int GL_COLOR_ATTACHMENT0_WEBGL     = 0x8CE0;
    public static final int GL_COLOR_ATTACHMENT1_WEBGL     = 0x8CE1;
    public static final int GL_COLOR_ATTACHMENT2_WEBGL     = 0x8CE2;
    public static final int GL_COLOR_ATTACHMENT3_WEBGL     = 0x8CE3;
    public static final int GL_COLOR_ATTACHMENT4_WEBGL     = 0x8CE4;
    public static final int GL_COLOR_ATTACHMENT5_WEBGL     = 0x8CE5;
    public static final int GL_COLOR_ATTACHMENT6_WEBGL     = 0x8CE6;
    public static final int GL_COLOR_ATTACHMENT7_WEBGL     = 0x8CE7;
    public static final int GL_COLOR_ATTACHMENT8_WEBGL     = 0x8CE8;
    public static final int GL_COLOR_ATTACHMENT9_WEBGL     = 0x8CE9;
    public static final int GL_COLOR_ATTACHMENT10_WEBGL    = 0x8CEA;
    public static final int GL_COLOR_ATTACHMENT11_WEBGL    = 0x8CEB;
    public static final int GL_COLOR_ATTACHMENT12_WEBGL    = 0x8CEC;
    public static final int GL_COLOR_ATTACHMENT13_WEBGL    = 0x8CED;
    public static final int GL_COLOR_ATTACHMENT14_WEBGL    = 0x8CEE;
    public static final int GL_COLOR_ATTACHMENT15_WEBGL    = 0x8CEF;

    public static final int GL_DRAW_BUFFER0_WEBGL          = 0x8825;
    public static final int GL_DRAW_BUFFER1_WEBGL          = 0x8826;
    public static final int GL_DRAW_BUFFER2_WEBGL          = 0x8827;
    public static final int GL_DRAW_BUFFER3_WEBGL          = 0x8828;
    public static final int GL_DRAW_BUFFER4_WEBGL          = 0x8829;
    public static final int GL_DRAW_BUFFER5_WEBGL          = 0x882A;
    public static final int GL_DRAW_BUFFER6_WEBGL          = 0x882B;
    public static final int GL_DRAW_BUFFER7_WEBGL          = 0x882C;
    public static final int GL_DRAW_BUFFER8_WEBGL          = 0x882D;
    public static final int GL_DRAW_BUFFER9_WEBGL          = 0x882E;
    public static final int GL_DRAW_BUFFER10_WEBGL         = 0x882F;
    public static final int GL_DRAW_BUFFER11_WEBGL         = 0x8830;
    public static final int GL_DRAW_BUFFER12_WEBGL         = 0x8831;
    public static final int GL_DRAW_BUFFER13_WEBGL         = 0x8832;
    public static final int GL_DRAW_BUFFER14_WEBGL         = 0x8833;
    public static final int GL_DRAW_BUFFER15_WEBGL         = 0x8834;

    public static final int GL_MAX_COLOR_ATTACHMENTS_WEBGL = 0x8CDF;
    public static final int GL_MAX_DRAW_BUFFERS_WEBGL      = 0x8824;

    /* Prevent instantiation */
    private WEBGL_draw_buffers()
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
                case "WEBGL_draw_buffers":
                case "O_WEBGL_draw_buffers":
                case "IE_WEBGL_draw_buffers":
                case "MOZ_WEBGL_draw_buffers":
                case "WEBKIT_WEBGL_draw_buffers":
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
            throw new RuntimeException("This browser does not support the WEBGL_draw_buffers extension.");

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

    public static void glDrawBuffersWEBGL(JsArrayInteger buffers)
    {
        checkExtension();
        nglDrawBuffersWEBGL(buffers);
    }

    public static void glDrawBuffersWEBGL(int... buffers)
    {
        JsArrayInteger array = JsArrayInteger.createArray(buffers.length).cast();

        for (int buffer : buffers)
            array.push(buffer);

        glDrawBuffersWEBGL(array);
    }

    public static void glDrawBuffersWEBGL(Int32Array buffers)
    {
        JsArrayInteger array = JsArrayInteger.createArray(buffers.length()).cast();

        for (int i = 0; i < buffers.length(); i++)
            array.push(buffers.get(i));

        glDrawBuffersWEBGL(array);
    }

    public static native boolean isExtensionEnabled() /*-{
        return typeof ($wnd.gl.wdb_ext) !== 'undefined';
    }-*/;

    private static native void nEnableExtension() /*-{
        $wnd.gl.wdb_ext = $wnd.gl.getExtension('WEBGL_draw_buffers') ||
            $wnd.gl.getExtension('O_WEBGL_draw_buffers') ||
            $wnd.gl.getExtension('IE_WEBGL_draw_buffers') ||
            $wnd.gl.getExtension('MOZ_WEBGL_draw_buffers') ||
            $wnd.gl.getExtension('WEBKIT_WEBGL_draw_buffers');
    }-*/;

    private static native void nglDrawBuffersWEBGL(JsArrayInteger buffers) /*-{
        $wnd.gl.wdb_ext.drawBuffersWEBGL(buffers);
    }-*/;
}
