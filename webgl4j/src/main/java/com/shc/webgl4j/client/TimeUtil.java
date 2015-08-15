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
public final class TimeUtil
{
    private static ImplementationUsed implementationUsed = ImplementationUsed.HIGH_PERFORMANCE;

    private TimeUtil()
    {
    }

    private static native boolean isInitialized() /*-{
        return !!$wnd['currentMillis'];
    }-*/;

    private static native void initialize() /*-{
        var currentMillis;
        if ($wnd.performance.now)
        {
            @com.shc.webgl4j.client.TimeUtil::implementationUsed
                = @com.shc.webgl4j.client.TimeUtil.ImplementationUsed::HIGH_PERFORMANCE;

            currentMillis = function (){ return $wnd.performance.now(); }
        }
        else if ($wnd.performance.webkitNow)
        {
            @com.shc.webgl4j.client.TimeUtil::implementationUsed
                = @com.shc.webgl4j.client.TimeUtil.ImplementationUsed::HIGH_PERFORMANCE_WEBKIT;

            currentMillis = function (){ return $wnd.performance.webkitNow(); }
        }
        else
        {
            @com.shc.webgl4j.client.TimeUtil::implementationUsed
                = @com.shc.webgl4j.client.TimeUtil.ImplementationUsed::LOW_PERFORMANCE;

            currentMillis = function (){ return Date.now(); }
        }

        $wnd.currentMillis = currentMillis;
    }-*/;

    private static native double nGetTimeStamp() /*-{
        return $wnd.currentMillis();
    }-*/;

    public static double currentSeconds()
    {
        return currentMillis() * 0.001;
    }

    public static double currentMillis()
    {
        if (!isInitialized())
            initialize();

        return nGetTimeStamp();
    }

    public static double currentMicros()
    {
        return currentMillis() * 1000;
    }

    public static double currentNanos()
    {
        return currentMicros() * 1000;
    }

    public static ImplementationUsed getImplementationUsed()
    {
        if (!isInitialized())
            initialize();

        return implementationUsed;
    }

    public enum ImplementationUsed
    {
        HIGH_PERFORMANCE,
        HIGH_PERFORMANCE_WEBKIT,
        LOW_PERFORMANCE
    }
}
