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
 * <p>A {@link WebGLContext} represents a WebGL rendering context that is used to draw WebGL graphics onto a HTML5
 * canvas. A <i>context</i> can represent many things, such as which objects are bound to which targets, and the state
 * associated with this instance of WebGL. It also provides the WebGL version that is used for it's functions, and also
 * the {@link WebGLContext.Attributes} of the context.</p>
 *
 * <p>This also contains the WebGL functions that does the drawing on a canvas. The static methods in {@link WebGL10}
 * class call the same methods present in the context which is <i>'current'</i> at that time. This allows for grouping
 * the methods by the version of WebGL they were first introduced, allowing to easily keep track of which version your
 * application is using.</p>
 *
 * <p>In order to render anything, a context <b><u>must</u></b> be current. If not, the {@link WebGL10} class will not
 * know from where to call the functions upon, and hence a ReferenceError will be generated.</p>
 *
 * @author Sri Harsha Chilakapati
 */
public final class WebGLContext extends JavaScriptObject
{
    protected WebGLContext()
    {
    }

    /**
     * Returns the native JS WebGL context object that this class wraps upon. This is a javascript object that contains
     * all the methods that are called by {@link WebGL10} and such classes.
     *
     * @return The native JS WebGL context object that this class wraps upon.
     */
    public native JavaScriptObject getGL() /*-{
        return this['gl'];
    }-*/;

    /**
     * Returns the WebGL context version as a float. This is {@code 1.0} for {@link WebGL10} context, and {@code 2.0}
     * for WebGL20 contexts.
     *
     * @return The WebGL context version as a float.
     */
    public native float getVersion() /*-{
        return this['glv'];
    }-*/;

    /**
     * Returns the WebGL context attributes that are used to create this context.
     *
     * @return The context attributes that are used to create this context.
     */
    public native Attributes getAttributes() /*-{
        return this['attribs'];
    }-*/;

    /**
     * Makes this context current, so that it will be used to render when the static WebGL methods are called. This will
     * result in the following WebGL calls have effect only on the canvas that this context is based upon.
     */
    public native void makeCurrent() /*-{
        $wnd.gl = this.gl;
        $wnd.attribs = this.attribs;
        $wnd.glv = this.glv;
        $wnd.context = this;
    }-*/;

    /**
     * A cross browser polyfill for the fullscreen API. Works on Google Chrome 15 and above, Firefox 9 and above,
     * Safari, Opera 32 and above, Internet Explorer 11 and the new Microsoft Edge. This method requests the browser to
     * enable fullscreen for the canvas that this WebGLContext uses.
     *
     * @return Returns whether the request succeeded or not.
     */
    public native boolean requestFullscreen() /*-{
        var canvas = $wnd['context']['gl']['canvas'];

        // For a modern browser that support the fullscreen API
        if (canvas['requestFullscreen'])
            canvas['requestFullscreen']();

        // For Microsoft browsers (Internet Explorer 11 and Microsoft Edge)
        else if (canvas['msRequestFullscreen'])
            canvas['msRequestFullscreen']();

        // For Mozilla browsers (Firefox)
        else if (canvas['mozRequestFullScreen'])
            canvas['mozRequestFullScreen']();

        // For WebKit browsers (Chrome, Safari, Chromium, Opera)
        else if (canvas['webkitRequestFullscreen'])
            canvas['webkitRequestFullscreen'](Element['ALLOW_KEYBOARD_INPUT']);

        // Simply return if not available
        else
            return false;

        // Return whether we are now in fullscreen (request succeeded)
        return @com.shc.webgl4j.client.WebGLContext::isFullscreen()();
    }-*/;

    /**
     * A cross-browser polyfill for FullScreen API.
     *
     * @return True if any context is in fullscreen mode, false otherwise.
     */
    public static native boolean isFullscreen() /*-{
        if ($doc['fullscreenElement'])
            return $doc['fullscreenElement'] != null;

        if ($doc['msFullscreenElement'])
            return $doc['msFullscreenElement'] != null;

        if ($doc['mozFullScreenElement'])
            return $doc['mozFullScreenElement'] != null;

        if ($doc['webkitFullscreenElement'])
            return $doc['webkitFullscreenElement'] != null;

        return false;
    }-*/;

    public static native boolean exitFullscreen() /*-{
        if ($doc['exitFullscreen'])
            $doc['exitFullscreen']();

        else if ($doc['msExitFullscreen'])
            $doc['msExitFullscreen']();

        else if ($doc['mozCancelFullScreen'])
            $doc['mozCancelFullScreen']();

        else if ($doc['webkitExitFullscreen'])
            $doc['webkitExitFullscreen']();

        else
            return false;

        return !(@com.shc.webgl4j.client.WebGLContext::isFullscreen()());
    }-*/;

    public void toggleFullscreen()
    {
        if (isFullscreen())
            exitFullscreen();
        else
            requestFullscreen();
    }

    /**
     * Returns the current context. If there is no context that is current, then {@code null} is returned.
     *
     * @return The current context.
     */
    public static native WebGLContext getCurrent() /*-{
        if ($wnd['context'] === undefined)
            return null;

        return $wnd['context'];
    }-*/;

    /**
     * This class represents the context attributes that were used to create a context, or the attributes that will be
     * used to create a context.
     */
    public static class Attributes extends JavaScriptObject
    {
        protected Attributes()
        {
        }

        public final native boolean getAlpha() /*-{
            return this.alpha;
        }-*/;

        public final native void setAlpha(boolean alpha) /*-{
            this.alpha = alpha;
        }-*/;

        public final native boolean getAntialias() /*-{
            return this.antialias;
        }-*/;

        public final native void setAntialias(boolean antialias) /*-{
            this.antialias = antialias;
        }-*/;

        public final native boolean getDepth() /*-{
            return this.depth;
        }-*/;

        public final native void setDepth(boolean depth) /*-{
            this.depth = depth;
        }-*/;

        public final native boolean getFailIfMajorPerformanceCaveat() /*-{
            return this.failIfMajorPerformanceCaveat;
        }-*/;

        public final native void setFailIfMajorPerformanceCaveat(boolean fail) /*-{
            this.failIfMajorPerformanceCaveat = fail;
        }-*/;

        public final native boolean getPremultipliedAlpha() /*-{
            return this.premultipliedAlpha;
        }-*/;

        public final native void setPremultipliedAlpha(boolean premultipliedAlpha) /*-{
            this.premultipliedAlpha = premultipliedAlpha;
        }-*/;

        public final native boolean getPreserveDrawingBuffer() /*-{
            return this.preserveDrawingBuffer;
        }-*/;

        public final native void setPreserveDrawingBuffer(boolean preserveDrawingBuffer) /*-{
            this.preserveDrawingBuffer = preserveDrawingBuffer;
        }-*/;

        public final native boolean getStencil() /*-{
            return this.stencil;
        }-*/;

        public final native void setStencil(boolean stencil) /*-{
            this.stencil = stencil;
        }-*/;

        public static native Attributes create() /*-{
            return {
                alpha: true,
                depth: true,
                stencil: false,
                antiAlias: true,
                preMultipliedAlpha: true,
                preserveDrawingBuffer: false,
                failIfMajorPerformanceCaveat: false
            };
        }-*/;
    }
}
