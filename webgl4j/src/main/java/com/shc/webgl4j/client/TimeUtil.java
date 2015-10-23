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
 * <p>Provides access to a high performance timer. This class creates a polyfill function on first access that uses the
 * following APIs in the priority of given order.</p>
 *
 * <p>
 *     {@code window.performance.now()} &#8594; {@code window.performance.webkitNow()} &#8594; {@code Date.now()}
 * </p>
 *
 * <p>The first two are high performance timers, which provide timestamps with microsecond precision. The last one is a
 * low performance timer and is used as a fallback when the first two are not available. At first we check if the
 * {@code window.performance.now()} is supported or not. If not then a check is performed for {@code window.performance
 * .webkitNow()} and finally if everything fails we use {@code Date.now()} as the last option.</p>
 *
 * @author Sri Harsha Chilakapati
 */
public final class TimeUtil
{
    private static Implementation implementation = Implementation.HIGH_PERFORMANCE;

    /**
     * Prevent instantiation
     */
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
            @com.shc.webgl4j.client.TimeUtil::implementation
                = @com.shc.webgl4j.client.TimeUtil.Implementation::HIGH_PERFORMANCE;

            currentMillis = function (){ return $wnd.performance.now(); }
        }
        else if ($wnd.performance.webkitNow)
        {
            @com.shc.webgl4j.client.TimeUtil::implementation
                = @com.shc.webgl4j.client.TimeUtil.Implementation::HIGH_PERFORMANCE_WEBKIT;

            currentMillis = function (){ return $wnd.performance.webkitNow(); }
        }
        else
        {
            @com.shc.webgl4j.client.TimeUtil::implementation
                = @com.shc.webgl4j.client.TimeUtil.Implementation::LOW_PERFORMANCE;

            currentMillis = function (){ return Date.now(); }
        }

        $wnd.currentMillis = currentMillis;
    }-*/;

    private static native double nGetTimeStamp() /*-{
        return $wnd.currentMillis();
    }-*/;

    /**
     * Returns the current time stamp in the unit of seconds. This method does multiply the current milli seconds by
     * {@literal 0.001} to convert them into seconds.
     *
     * @return The current time stamp in the unit of seconds.
     */
    public static double currentSeconds()
    {
        return currentMillis() * 0.001;
    }

    /**
     * Returns the current time stamp in the unit of milli seconds. This method simply returns the value returned by the
     * underlying high performance timer which by default returns milli seconds.
     *
     * @return The current time stamp in the unit of milli seconds.
     */
    public static double currentMillis()
    {
        if (!isInitialized())
            initialize();

        return nGetTimeStamp();
    }

    /**
     * Returns the current time stamp in the unit of micro seconds. This method does multiply the current milli seconds
     * by {@literal 1000} to convert them into micro seconds.
     *
     * @return The current time stamp in the unit of micro seconds.
     */
    public static double currentMicros()
    {
        return currentMillis() * 1000;
    }

    /**
     * Returns the current time stamp in the unit of nano seconds. This method does multiply the current milli seconds
     * by {@literal 1000000} to convert them into nano seconds. This however will not be so accurate as the browsers as
     * of now only provide timers to the microsecond resolution.
     *
     * @return The current time stamp in the unit of nano seconds.
     */
    public static double currentNanos()
    {
        return currentMicros() * 1000;
    }

    /**
     * Returns the implementation that this polyfill uses. It might be {@code window.performance.now()} in the best case
     * or {@code window.performance.webkitNow()} in the average case. In the worst case if both those timers are not
     * available, that is we are using {@code Date.now()} it returns {@link Implementation#LOW_PERFORMANCE}.
     *
     * @return Returns an enum describing which implementation that this timer polyfill is using.
     */
    public static Implementation getImplementation()
    {
        if (!isInitialized())
            initialize();

        return implementation;
    }

    /**
     * An enumeration used to describe the method this polyfill is using to report time stamps.
     */
    public enum Implementation
    {
        /**
         * Corresponds to {@code window.performance.now()}
         */
        HIGH_PERFORMANCE,

        /**
         * Corresponds to {@code window.performance.webkitNow()}
         */
        HIGH_PERFORMANCE_WEBKIT,

        /**
         * Corresponds to {@code Date.now()}
         */
        LOW_PERFORMANCE
    }
}
