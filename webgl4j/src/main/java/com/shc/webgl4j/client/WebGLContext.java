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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
     * A cross-browser polyfill for FullScreen API. Works on Google Chrome 15 and above, Firefox 9 and above, Safari,
     * Opera 32 and above, Internet Explorer 11 and the new Microsoft Edge. Returns true if any of the context or even
     * any other element in the page is fullscreen.
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

    /**
     * A cross-browser polyfill for FullScreen API. Works on Google Chrome 15 and above, Firefox 9 and above, Safari,
     * Opera 32 and above, Internet Explorer 11 and the new Microsoft Edge. This method requests the browser to exit the
     * fullscreen state.
     *
     * @return Returns whether the request is successful.
     */
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
     * This class represents the context attributes that were used to create a context, or the attributes that will be
     * used to create a context. The attributes are nothing but the properties of the context. Note that there will be
     * no effect to the context even if you change the attributes once the context is created. To be sure that the
     * requested attributes are accepted by the implementation, compare the attributes of the created context.
     *
     * @author Sri Harsha Chilakapati
     */
    public static class Attributes extends JavaScriptObject
    {
        protected Attributes()
        {
        }

        /**
         * <p> Creates an Attributes object with the default values as specified in the WebGL 1.0 Specification. The
         * default values for the properties are as follows. </p>
         *
         * <pre>
         *     alpha: true
         *     depth: true
         *     stencil: false
         *     antiAlias: true
         *     preMultipliedAlpha: true
         *     preserveDrawingBuffer: false
         *     failIfMajorPerformanceCaveat: false
         * </pre>
         *
         * @return An attributes object that contain the default values.
         */
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

        /**
         * Returns whether the draw buffer has an alpha channel. An alpha channel is required for OpenGL to performing
         * the destination alpha operations and composition with the page. The default value for this is {@code true}.
         *
         * @return Whether the draw buffer has an Alpha-channel.
         */
        public final native boolean getAlpha() /*-{
            return this.alpha;
        }-*/;

        /**
         * Sets the existence of the alpha channel on the drawing buffer. If the value is true, the drawing buffer has
         * an alpha channel for the purposes of performing OpenGL destination alpha operations and compositing with the
         * page. If the value is false, no alpha buffer is available. The default value for this is {@code true}.
         *
         * @param alpha The value of the alpha channel.
         */
        public final native void setAlpha(boolean alpha) /*-{
            this.alpha = alpha;
        }-*/;

        /**
         * Returns whether anti aliasing is enabled. This is dependent on the implementation. So there is no guarantee
         * that the implementation respects this property. The default value for this is {@code true}.
         *
         * @return Whether anti aliasing is enabled.
         */
        public final native boolean getAntialias() /*-{
            return this.antialias;
        }-*/;

        /**
         * Sets the antialias property of the to be created context. If the value is true and the implementation
         * supports antialiasing the drawing buffer will perform antialiasing using its choice of technique
         * (multisample/supersample) and quality. If the value is false or the implementation does not support
         * antialiasing, no antialiasing is performed. The default value for this property is {@code true}.
         *
         * @param antialias The new value of the antialiasing property.
         */
        public final native void setAntialias(boolean antialias) /*-{
            this.antialias = antialias;
        }-*/;

        /**
         * Returns the depth property of the WebGLContext. If the value is true, then the drawing buffer has a depth
         * buffer of at least 8 bits. If the value is false, then no depth buffer is available for that context.
         *
         * @return The depth property of WebGLContext.
         */
        public final native boolean getDepth() /*-{
            return this.depth;
        }-*/;

        /**
         * Sets the depth property of the WebGLContext. If the new value is true, then the drawing buffer will have a
         * depth buffer that is at least 8 bits. If the value is false, then no depth buffer is available for the
         * context. However, this is just a request, you have to check the property after the context is created.
         *
         * @param depth The depth property of WebGLContext.
         */
        public final native void setDepth(boolean depth) /*-{
            this.depth = depth;
        }-*/;

        /**
         * <p> If the value is true, context creation will fail if the implementation determines that the performance of
         * the created WebGL context would be dramatically lower than that of a native application making equivalent
         * OpenGL calls. This could happen for a number of reasons, including: </p>
         *
         * <ul> <li> An implementation might switch to a software rasterizer if the user's GPU driver is known to be
         * unstable.</li> <li> An implementation might require reading back the framebuffer from GPU memory to system
         * memory before compositing it with the rest of the page, significantly reducing performance.</li> </ul>
         *
         * <p> Applications that don't require high performance should leave this parameter at its default value of
         * false. Applications that require high performance may set this parameter to true, and if context creation
         * fails then the application may prefer to use a fallback rendering path. </p>
         *
         * @return Whether the context fails if there is a major performance caveat.
         */
        public final native boolean getFailIfMajorPerformanceCaveat() /*-{
            return this.failIfMajorPerformanceCaveat;
        }-*/;

        /**
         * <p> If the value is true, context creation will fail if the implementation determines that the performance of
         * the created WebGL context would be dramatically lower than that of a native application making equivalent
         * OpenGL calls. This could happen for a number of reasons, including: </p>
         *
         * <ul> <li> An implementation might switch to a software rasterizer if the user's GPU driver is known to be
         * unstable.</li> <li> An implementation might require reading back the framebuffer from GPU memory to system
         * memory before compositing it with the rest of the page, significantly reducing performance.</li> </ul>
         *
         * <p> Applications that don't require high performance should leave this parameter at its default value of
         * false. Applications that require high performance may set this parameter to true, and if context creation
         * fails then the application may prefer to use a fallback rendering path. </p>
         *
         * @param fail Whether the context should fail if there is a major performance caveat.
         */
        public final native void setFailIfMajorPerformanceCaveat(boolean fail) /*-{
            this.failIfMajorPerformanceCaveat = fail;
        }-*/;

        /**
         * If the value is true the page compositor will assume the drawing buffer contains colors with premultiplied
         * alpha. If the value is false the page compositor will assume that colors in the drawing buffer are not
         * premultiplied. This flag is ignored if the alpha flag is false. See <a href="https://www.khronos.org/registry/webgl/specs/1.0/#PREMULTIPLIED_ALPHA">Premultiplied
         * Alpha</a> for more information on the effects of the <code>premultipliedAlpha</code> flag.
         *
         * @return Whether the drawing buffer contains colors with premultiplied alpha.
         */
        public final native boolean getPremultipliedAlpha() /*-{
            return this.premultipliedAlpha;
        }-*/;

        /**
         * If the value is true the page compositor will assume the drawing buffer contains colors with premultiplied
         * alpha. If the value is false the page compositor will assume that colors in the drawing buffer are not
         * premultiplied. This flag is ignored if the alpha flag is false. See <a href="https://www.khronos.org/registry/webgl/specs/1.0/#PREMULTIPLIED_ALPHA">Premultiplied
         * Alpha</a> for more information on the effects of the <code>premultipliedAlpha</code> flag.
         *
         * @param premultipliedAlpha Whether the drawing buffer should accept colors with premultiplied alpha.
         */
        public final native void setPremultipliedAlpha(boolean premultipliedAlpha) /*-{
            this.premultipliedAlpha = premultipliedAlpha;
        }-*/;

        /**
         * <p> If false, once the drawing buffer is presented as described in the <a
         * href="https://www.khronos.org/registry/webgl/specs/1.0/#THE_DRAWING_BUFFER">Drawing Buffer</a> section, the
         * contents of the drawing buffer are cleared to their default values. All elements of the drawing buffer
         * (color, depth and stencil) are cleared. If the value is true the buffers will not be cleared and will
         * preserve their values until cleared or overwritten by the author. </p>
         *
         * <p><i>On some hardware setting the preserveDrawingBuffer flag to true can have significant performance
         * implications.</i></p>
         *
         * @return Whether the drawing buffer is preserved after presenting.
         */
        public final native boolean getPreserveDrawingBuffer() /*-{
            return this.preserveDrawingBuffer;
        }-*/;

        /**
         * <p> If false, once the drawing buffer is presented as described in the <a
         * href="https://www.khronos.org/registry/webgl/specs/1.0/#THE_DRAWING_BUFFER">Drawing Buffer</a> section, the
         * contents of the drawing buffer are cleared to their default values. All elements of the drawing buffer
         * (color, depth and stencil) are cleared. If the value is true the buffers will not be cleared and will
         * preserve their values until cleared or overwritten by the author. </p>
         *
         * <p><i>On some hardware setting the preserveDrawingBuffer flag to true can have significant performance
         * implications.</i></p>
         *
         * @param preserveDrawingBuffer Whether the drawing buffer should be preserved after presenting.
         */
        public final native void setPreserveDrawingBuffer(boolean preserveDrawingBuffer) /*-{
            this.preserveDrawingBuffer = preserveDrawingBuffer;
        }-*/;

        /**
         * Returns whether there is a stencil buffer associated with the context. If the value is true, the drawing
         * buffer has a stencil buffer of at least 8 bits. If the value is false, no stencil buffer is available.
         *
         * @return Whether there is a stencil buffer of at least 8 bits.
         */
        public final native boolean getStencil() /*-{
            return this.stencil;
        }-*/;

        /**
         * Sets whether there is a stencil buffer associated with the context. If the value is true, the drawing buffer
         * has a stencil buffer of at least 8 bits. If the value is false, no stencil buffer is available.
         *
         * @param stencil Whether a stencil buffer of at least 8 bits should be used.
         */
        public final native void setStencil(boolean stencil) /*-{
            this.stencil = stencil;
        }-*/;
    }

    /**
     * Handles Context Loss is an attribute that specifies that a method defined by WebGL API handles the context loss
     * automatically. This does nothing but notifies the user by sitting in the documentation.
     */
    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface HandlesContextLoss
    {
    }
}
