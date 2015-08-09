package com.shc.webgl4j.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Sri Harsha Chilakapati
 */
public final class WebGLContext extends JavaScriptObject
{
    protected WebGLContext()
    {
    }

    public native JavaScriptObject getGL() /*-{
        return this['gl'];
    }-*/;

    public native float getVersion() /*-{
        return this['glv'];
    }-*/;

    public native Attributes getAttributes() /*-{
        return this['attribs'];
    }-*/;

    public native void makeCurrent() /*-{
        $wnd.gl = this.gl;
        $wnd.attribs = this.attribs;
        $wnd.glv = this.glv;
        $wnd.context = this;
    }-*/;

    public static void makeContextCurrent(WebGLContext context)
    {
        context.makeCurrent();
    }

    public static native WebGLContext getCurrentContext() /*-{
        return $wnd['context'];
    }-*/;

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
