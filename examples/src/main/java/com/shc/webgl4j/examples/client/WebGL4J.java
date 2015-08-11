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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import java.util.ArrayList;

/**
 * @author Sri Harsha Chilakapati
 */
public class WebGL4J implements EntryPoint
{
    @Override
    public void onModuleLoad()
    {
        RootLayoutPanel.get().add(new HTML("<h1 style='padding-left: 20px;'>WebGL4J Examples</h1>"));

        final ArrayList<Example> examples = new ArrayList<>();

        final TabLayoutPanel tabs = new TabLayoutPanel(100, Style.Unit.PX);

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

    private Canvas createCanvas()
    {
        Canvas canvas = Canvas.createIfSupported();
        canvas.setCoordinateSpaceWidth(640);
        canvas.setCoordinateSpaceHeight(480);
        return canvas;
    }
}
