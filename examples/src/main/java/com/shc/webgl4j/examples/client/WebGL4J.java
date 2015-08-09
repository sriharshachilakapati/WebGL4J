package com.shc.webgl4j.examples.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

/**
 * @author Sri Harsha Chilakapati
 */
public class WebGL4J implements EntryPoint
{
    @Override
    public void onModuleLoad()
    {
        TabLayoutPanel tabs = new TabLayoutPanel(40, Style.Unit.PX);

        Example triangleExample = new TriangleExample(createCanvas()).start();
        tabs.add(triangleExample.canvas, "Triangle");

        Example rectangleExample = new RectangleExample(createCanvas()).start();
        tabs.add(rectangleExample.canvas, "Rectangle");

        Example textureExample = new TextureExample(createCanvas()).start();
        tabs.add(textureExample.canvas, "Texture");

        RootLayoutPanel.get().add(tabs);
    }

    private Canvas createCanvas()
    {
        Canvas canvas = Canvas.createIfSupported();
        canvas.setCoordinateSpaceWidth(640);
        canvas.setCoordinateSpaceHeight(480);
        return canvas;
    }
}
