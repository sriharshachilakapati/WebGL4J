package com.shc.webgl4j.client;

/**
 * @author Sri Harsha Chilakapati
 */
public final class TimeUtil
{
    private TimeUtil()
    {
    }

    private static ImplementationUsed implementationUsed = ImplementationUsed.HIGH_PERFORMANCE;

    private static native boolean isInitialized() /*-{
        return !!$wnd['getTimeStamp'];
    }-*/;

    private static native void initialize() /*-{
        var getTimeStamp;
        if ($wnd.performance.now)
        {
            @com.shc.webgl4j.client.TimeUtil::implementationUsed = @com.shc.webgl4j.client.TimeUtil.ImplementationUsed::HIGH_PERFORMANCE;
            getTimeStamp = function()
            {
                return $wnd.performance.now();
            }
        }
        else
        {
            if ($wnd.performance.webkitNow)
            {
                @com.shc.webgl4j.client.TimeUtil::implementationUsed = @com.shc.webgl4j.client.TimeUtil.ImplementationUsed::HIGH_PERFORMANCE_WEBKIT;
                getTimeStamp = function()
                {
                    return $wnd.performance.webkitNow();
                }
            }
            else
            {
                @com.shc.webgl4j.client.TimeUtil::implementationUsed = @com.shc.webgl4j.client.TimeUtil.ImplementationUsed::LOW_PERFORMANCE;
                getTimeStamp = function()
                {
                    return Date.now();
                }
            }
        }

        $wnd.getTimeStamp = getTimeStamp;
    }-*/;

    private static native double nGetTimeStamp() /*-{
        return $wnd.getTimeStamp();
    }-*/;

    public static double getTimeStamp()
    {
        if (!isInitialized())
            initialize();

        return nGetTimeStamp();
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
