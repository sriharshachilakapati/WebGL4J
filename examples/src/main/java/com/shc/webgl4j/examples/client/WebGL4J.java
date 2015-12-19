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

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shc.webgl4j.client.*;

import java.util.ArrayList;

import static com.shc.webgl4j.client.WEBGL_debug_renderer_info.*;
import static com.shc.webgl4j.client.WebGL10.*;

/**
 * @author Sri Harsha Chilakapati
 */
public class WebGL4J implements EntryPoint
{
    private static String isSupportedHTML(String name, boolean value)
    {
        return "<b>" + name + ": </b>" + (value ? "Supported" : "Not Supported") + "</br>";
    }

    @Override
    public void onModuleLoad()
    {
        RootLayoutPanel.get().add(new HTML(
                "<img style='float: left; padding: 10px;'" +
                " src='http://goharsha.com/WebGL4J/logos/128/logo-green-dark.png'></img>" +
                "<h1 style='padding-left: 20px; font-size: 65px;'>" +
                "&nbsp;Examples</h1>"));

        final ArrayList<Example> examples = new ArrayList<>();

        final TabLayoutPanel tabs = new TabLayoutPanel(190, Style.Unit.PX);
        tabs.add(new ScrollPanel(createInformationTab()), "Information");

        Example triangleExample = new TriangleExample(createCanvas());
        examples.add(triangleExample);
        tabs.add(triangleExample.canvas, "Triangle");

        Example rectangleExample = new RectangleExample(createCanvas());
        examples.add(rectangleExample);
        tabs.add(rectangleExample.canvas, "Rectangle");

        Example textureExample = new TextureExample(createCanvas());
        examples.add(textureExample);
        tabs.add(textureExample.canvas, "Texture");

        Example cubeExample = new CubeExample(createCanvas());
        examples.add(cubeExample);
        tabs.add(cubeExample.canvas, "Cube");

        Example texturedCubeExample = new TexturedCubeExample(createCanvas());
        examples.add(texturedCubeExample);
        tabs.add(texturedCubeExample.canvas, "Textured Cube");

        RootLayoutPanel.get().add(tabs);

        // Init all examples
        for (Example example : examples)
        {
            example.context.makeCurrent();
            example.init();
        }

        AnimationScheduler.get().requestAnimationFrame(new AnimationScheduler.AnimationCallback()
        {
            @Override
            public void execute(double timestamp)
            {
                for (Example example : examples)
                {
                    if (tabs.getWidget(tabs.getSelectedIndex()) == example.canvas)
                    {
                        example.context.makeCurrent();
                        example.render();
                        break;
                    }
                }

                AnimationScheduler.get().requestAnimationFrame(this);
            }
        });
    }

    private Widget createInformationTab()
    {
        WebGLContext infoContext = (WebGL20.isSupported()) ? WebGL20.createContext(Canvas.createIfSupported())
                                                           : WebGL10.createContext(Canvas.createIfSupported());
        infoContext.makeCurrent();

        String webglInfo = "<h2>Browser</h2>";
        webglInfo += "<p style='padding-left: 40px;'>";
        {
            webglInfo += "<b>User Agent: </b>" + Window.Navigator.getUserAgent() + "</br>";
            webglInfo += "<b>Platform: </b>" + Window.Navigator.getPlatform() + "</br>";
        }
        webglInfo += "</p>";

        webglInfo += "<h2>WebGL context</h2>";
        webglInfo += "<p style='padding-left: 40px;'>";
        {
            webglInfo += isSupportedHTML("WebGL 1.0", WebGL10.isSupported());
            webglInfo += isSupportedHTML("WebGL 2.0", WebGL20.isSupported());

            webglInfo += "<b>WebGL version: </b>" + glGetParameter(GL_VERSION) + "</br>";
            webglInfo += "<b>GLSL version: </b>" + glGetParameter(GL_SHADING_LANGUAGE_VERSION) + "</br>";
            webglInfo += "<b>WebGL renderer: </b>" + glGetParameter(GL_RENDERER) + "</br>";
            webglInfo += "<b>WebGL vendor: </b>" + glGetParameter(GL_VENDOR) + "</br>";

            if (WEBGL_debug_renderer_info.isSupported())
            {
                WEBGL_debug_renderer_info.enableExtension();

                webglInfo += "<b>Unmasked renderer: </b>" + glGetParameter(GL_UNMASKED_RENDERER_WEBGL) + "</br>";
                webglInfo += "<b>Unmasked vendor: </b>" + glGetParameter(GL_UNMASKED_VENDOR_WEBGL) + "</br>";
            }
        }
        webglInfo += "</p>";

        webglInfo += "<h2>WebGL Extensions</h2>";
        webglInfo += "<p style='padding-left: 40px;'>";
        {
            webglInfo += isSupportedHTML("ANGLE_instanced_arrays", ANGLE_instanced_arrays.isSupported());

            webglInfo += isSupportedHTML("EXT_blend_minmax", EXT_blend_minmax.isSupported());
            webglInfo += isSupportedHTML("EXT_frag_depth", EXT_frag_depth.isSupported());
            webglInfo += isSupportedHTML("EXT_shader_texture_lod", EXT_shader_texture_lod.isSupported());
            webglInfo += isSupportedHTML("EXT_texture_filter_anisotropic", EXT_texture_filter_anisotropic.isSupported());

            webglInfo += isSupportedHTML("OES_element_index_uint", OES_element_index_uint.isSupported());
            webglInfo += isSupportedHTML("OES_standard_derivatives", OES_standard_derivatives.isSupported());
            webglInfo += isSupportedHTML("OES_texture_float", OES_texture_float.isSupported());
            webglInfo += isSupportedHTML("OES_texture_float_linear", OES_texture_float_linear.isSupported());
            webglInfo += isSupportedHTML("OES_texture_half_float", OES_texture_half_float.isSupported());
            webglInfo += isSupportedHTML("OES_texture_half_float_linear", OES_texture_half_float_linear.isSupported());
            webglInfo += isSupportedHTML("OES_vertex_array_object", OES_vertex_array_object.isSupported());

            webglInfo += isSupportedHTML("WEBGL_compressed_texture_s3tc", WEBGL_compressed_texture_s3tc.isSupported());
            webglInfo += isSupportedHTML("WEBGL_debug_renderer_info", WEBGL_debug_renderer_info.isSupported());
            webglInfo += isSupportedHTML("WEBGL_debug_shaders", WEBGL_debug_shaders.isSupported());
            webglInfo += isSupportedHTML("WEBGL_depth_texture", WEBGL_depth_texture.isSupported());
            webglInfo += isSupportedHTML("WEBGL_draw_buffers", WEBGL_draw_buffers.isSupported());
            webglInfo += isSupportedHTML("WEBGL_lose_context", WEBGL_lose_context.isSupported());
        }
        webglInfo += "</p>";

        WebGLContext.Attributes attributes = WebGLContext.getCurrent().getAttributes();

        webglInfo += "<h2>Context Attributes</h2>";
        webglInfo += "<p style='padding-left: 40px;'>";
        {
            webglInfo += "<b>Alpha: </b>" + attributes.getAlpha() + "</br>";
            webglInfo += "<b>Antialias: </b>" + attributes.getAntialias() + "</br>";
            webglInfo += "<b>Depth: </b>" + attributes.getDepth() + "</br>";
            webglInfo += "<b>FailIfMajorPerformanceCaveat: </b>" + attributes.getFailIfMajorPerformanceCaveat() + "</br>";
            webglInfo += "<b>PremultipliedAlpha: </b>" + attributes.getPremultipliedAlpha() + "</br>";
            webglInfo += "<b>PreserveDrawingBuffer: </b>" + attributes.getPreserveDrawingBuffer() + "</br>";
            webglInfo += "<b>Stencil: </b>" + attributes.getStencil() + "</br>";
        }
        webglInfo += "</p>";

        return new HTML(webglInfo);
    }

    private Canvas createCanvas()
    {
        Canvas canvas = Canvas.createIfSupported();
        canvas.setCoordinateSpaceWidth(640);
        canvas.setCoordinateSpaceHeight(480);
        return canvas;
    }
}
