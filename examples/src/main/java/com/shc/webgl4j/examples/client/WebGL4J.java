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
