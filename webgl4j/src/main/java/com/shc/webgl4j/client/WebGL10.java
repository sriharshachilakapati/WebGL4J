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

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.ImageData;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.typedarrays.shared.ArrayBufferView;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.typedarrays.shared.Int32Array;
import com.google.gwt.typedarrays.shared.TypedArrays;
import com.google.gwt.user.client.ui.Image;

/**
 * @author Sri Harsha Chilakapati
 */
public final class WebGL10
{
    public static final int GL_ACTIVE_ATTRIBUTES                            = 0x8B89;
    public static final int GL_ACTIVE_TEXTURE                               = 0x84E0;
    public static final int GL_ACTIVE_UNIFORMS                              = 0x8B86;
    public static final int GL_ALIASED_LINE_WIDTH_RANGE                     = 0x846E;
    public static final int GL_ALIASED_POINT_SIZE_RANGE                     = 0x846D;
    public static final int GL_ALPHA                                        = 0x1906;
    public static final int GL_ALPHA_BITS                                   = 0x0D55;
    public static final int GL_ALWAYS                                       = 0x0207;
    public static final int GL_ARRAY_BUFFER                                 = 0x8892;
    public static final int GL_ARRAY_BUFFER_BINDING                         = 0x8894;
    public static final int GL_ATTACHED_SHADERS                             = 0x8B85;
    public static final int GL_BACK                                         = 0x0405;
    public static final int GL_BLEND                                        = 0x0BE2;
    public static final int GL_BLEND_COLOR                                  = 0x8005;
    public static final int GL_BLEND_DST_ALPHA                              = 0x80CA;
    public static final int GL_BLEND_DST_RGB                                = 0x80C8;
    public static final int GL_BLEND_EQUATION                               = 0x8009;
    public static final int GL_BLEND_EQUATION_ALPHA                         = 0x883D;
    public static final int GL_BLEND_EQUATION_RGB                           = 0x8009;
    public static final int GL_BLEND_SRC_ALPHA                              = 0x80CB;
    public static final int GL_BLEND_SRC_RGB                                = 0x80C9;
    public static final int GL_BLUE_BITS                                    = 0x0D54;
    public static final int GL_BOOL                                         = 0x8B56;
    public static final int GL_BOOL_VEC2                                    = 0x8B57;
    public static final int GL_BOOL_VEC3                                    = 0x8B58;
    public static final int GL_BOOL_VEC4                                    = 0x8B59;
    public static final int GL_BROWSER_DEFAULT_WEBGL                        = 0x9244;
    public static final int GL_BUFFER_SIZE                                  = 0x8764;
    public static final int GL_BUFFER_USAGE                                 = 0x8765;
    public static final int GL_BYTE                                         = 0x1400;
    public static final int GL_CCW                                          = 0x0901;
    public static final int GL_CLAMP_TO_EDGE                                = 0x812F;
    public static final int GL_COLOR_ATTACHMENT0                            = 0x8CE0;
    public static final int GL_COLOR_BUFFER_BIT                             = 0x4000;
    public static final int GL_COLOR_CLEAR_VALUE                            = 0x0C22;
    public static final int GL_COLOR_WRITEMASK                              = 0x0C23;
    public static final int GL_COMPILE_STATUS                               = 0x8B81;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS                   = 0x86A3;
    public static final int GL_CONSTANT_ALPHA                               = 0x8003;
    public static final int GL_CONSTANT_COLOR                               = 0x8001;
    public static final int GL_CONTEXT_LOST_WEBGL                           = 0x9242;
    public static final int GL_CULL_FACE                                    = 0x0B44;
    public static final int GL_CULL_FACE_MODE                               = 0x0B45;
    public static final int GL_CURRENT_PROGRAM                              = 0x8B8D;
    public static final int GL_CURRENT_VERTEX_ATTRIB                        = 0x8626;
    public static final int GL_CW                                           = 0x0900;
    public static final int GL_DECR                                         = 0x1E03;
    public static final int GL_DECR_WRAP                                    = 0x8508;
    public static final int GL_DELETE_STATUS                                = 0x8B80;
    public static final int GL_DEPTH_ATTACHMENT                             = 0x8D00;
    public static final int GL_DEPTH_BITS                                   = 0x0D56;
    public static final int GL_DEPTH_BUFFER_BIT                             = 0x0100;
    public static final int GL_DEPTH_CLEAR_VALUE                            = 0x0B73;
    public static final int GL_DEPTH_COMPONENT                              = 0x1902;
    public static final int GL_DEPTH_COMPONENT16                            = 0x81A5;
    public static final int GL_DEPTH_FUNC                                   = 0x0B74;
    public static final int GL_DEPTH_RANGE                                  = 0x0B70;
    public static final int GL_DEPTH_STENCIL                                = 0x84F9;
    public static final int GL_DEPTH_STENCIL_ATTACHMENT                     = 0x821A;
    public static final int GL_DEPTH_TEST                                   = 0x0B71;
    public static final int GL_DEPTH_WRITEMASK                              = 0x0B72;
    public static final int GL_DITHER                                       = 0x0BD0;
    public static final int GL_DONT_CARE                                    = 0x1100;
    public static final int GL_DST_ALPHA                                    = 0x0304;
    public static final int GL_DST_COLOR                                    = 0x0306;
    public static final int GL_DYNAMIC_DRAW                                 = 0x88E8;
    public static final int GL_ELEMENT_ARRAY_BUFFER                         = 0x8893;
    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING                 = 0x8895;
    public static final int GL_EQUAL                                        = 0x0202;
    public static final int GL_FASTEST                                      = 0x1101;
    public static final int GL_FLOAT                                        = 0x1406;
    public static final int GL_FLOAT_MAT2                                   = 0x8B5A;
    public static final int GL_FLOAT_MAT3                                   = 0x8B5B;
    public static final int GL_FLOAT_MAT4                                   = 0x8B5C;
    public static final int GL_FLOAT_VEC2                                   = 0x8B50;
    public static final int GL_FLOAT_VEC3                                   = 0x8B51;
    public static final int GL_FLOAT_VEC4                                   = 0x8B52;
    public static final int GL_FRAGMENT_SHADER                              = 0x8B30;
    public static final int GL_FRAMEBUFFER                                  = 0x8D40;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME           = 0x8CD1;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE           = 0x8CD0;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL         = 0x8CD2;
    public static final int GL_FRAMEBUFFER_BINDING                          = 0x8CA6;
    public static final int GL_FRAMEBUFFER_COMPLETE                         = 0x8CD5;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT            = 0x8CD6;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS            = 0x8CD9;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT    = 0x8CD7;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED                      = 0x8CDD;
    public static final int GL_FRONT                                        = 0x0404;
    public static final int GL_FRONT_AND_BACK                               = 0x0408;
    public static final int GL_FRONT_FACE                                   = 0x0B46;
    public static final int GL_FUNC_ADD                                     = 0x8006;
    public static final int GL_FUNC_REVERSE_SUBTRACT                        = 0x800B;
    public static final int GL_FUNC_SUBTRACT                                = 0x800A;
    public static final int GL_GENERATE_MIPMAP_HINT                         = 0x8192;
    public static final int GL_GEQUAL                                       = 0x0206;
    public static final int GL_GREATER                                      = 0x0204;
    public static final int GL_GREEN_BITS                                   = 0x0D53;
    public static final int GL_HIGH_FLOAT                                   = 0x8DF2;
    public static final int GL_HIGH_INT                                     = 0x8DF5;
    public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT             = 0x8B9B;
    public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE               = 0x8B9A;
    public static final int GL_INCR                                         = 0x1E02;
    public static final int GL_INCR_WRAP                                    = 0x8507;
    public static final int GL_INT                                          = 0x1404;
    public static final int GL_INT_VEC2                                     = 0x8B53;
    public static final int GL_INT_VEC3                                     = 0x8B54;
    public static final int GL_INT_VEC4                                     = 0x8B55;
    public static final int GL_INVALID_ENUM                                 = 0x0500;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION                = 0x0506;
    public static final int GL_INVALID_OPERATION                            = 0x0502;
    public static final int GL_INVALID_VALUE                                = 0x0501;
    public static final int GL_INVERT                                       = 0x150A;
    public static final int GL_KEEP                                         = 0x1E00;
    public static final int GL_LEQUAL                                       = 0x0203;
    public static final int GL_LESS                                         = 0x0201;
    public static final int GL_LINEAR                                       = 0x2601;
    public static final int GL_LINEAR_MIPMAP_LINEAR                         = 0x2703;
    public static final int GL_LINEAR_MIPMAP_NEAREST                        = 0x2701;
    public static final int GL_LINES                                        = 0x0001;
    public static final int GL_LINE_LOOP                                    = 0x0002;
    public static final int GL_LINE_STRIP                                   = 0x0003;
    public static final int GL_LINE_WIDTH                                   = 0x0B21;
    public static final int GL_LINK_STATUS                                  = 0x8B82;
    public static final int GL_LOW_FLOAT                                    = 0x8DF0;
    public static final int GL_LOW_INT                                      = 0x8DF3;
    public static final int GL_LUMINANCE                                    = 0x1909;
    public static final int GL_LUMINANCE_ALPHA                              = 0x190A;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS             = 0x8B4D;
    public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE                    = 0x851C;
    public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS                 = 0x8DFD;
    public static final int GL_MAX_RENDERBUFFER_SIZE                        = 0x84E8;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS                      = 0x8872;
    public static final int GL_MAX_TEXTURE_SIZE                             = 0x8872;
    public static final int GL_MAX_VARYING_VECTORS                          = 0x8DFC;
    public static final int GL_MAX_VERTEX_ATTRIBS                           = 0x8869;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS               = 0x8B4C;
    public static final int GL_MAX_VERTEX_UNIFORM_VECTORS                   = 0x8DFB;
    public static final int GL_MAX_VIEWPORT_DIMS                            = 0x0D3A;
    public static final int GL_MEDIUM_FLOAT                                 = 0x8DF1;
    public static final int GL_MEDIUM_INT                                   = 0x8DF4;
    public static final int GL_MIRRORED_REPEAT                              = 0x8370;
    public static final int GL_NEAREST                                      = 0x2600;
    public static final int GL_NEAREST_MIPMAP_LINEAR                        = 0x2702;
    public static final int GL_NEAREST_MIPMAP_NEAREST                       = 0x2700;
    public static final int GL_NEVER                                        = 0x0200;
    public static final int GL_NICEST                                       = 0x1102;
    public static final int GL_NONE                                         = 0x0000;
    public static final int GL_NOTEQUAL                                     = 0x0205;
    public static final int GL_NOERROR                                      = 0x0000;
    public static final int GL_ONE                                          = 0x0001;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA                     = 0x8004;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR                     = 0x8002;
    public static final int GL_ONE_MINUS_DST_ALPHA                          = 0x0305;
    public static final int GL_ONE_MINUS_DST_COLOR                          = 0x0307;
    public static final int GL_ONE_MINUS_SRC_ALPHA                          = 0x0303;
    public static final int GL_ONE_MINUS_SRC_COLOR                          = 0x0301;
    public static final int GL_OUT_OF_MEMORY                                = 0x0505;
    public static final int GL_PACK_ALIGNMENT                               = 0x0D05;
    public static final int GL_POINTS                                       = 0x0000;
    public static final int GL_POLYGON_OFFSET_FACTOR                        = 0x8038;
    public static final int GL_POLYGON_OFFSET_FILL                          = 0x8037;
    public static final int GL_POLYGON_OFFSET_UNITS                         = 0x2A00;
    public static final int GL_RED_BITS                                     = 0x0D52;
    public static final int GL_RENDERBUFFER                                 = 0x8D41;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE                      = 0x8D53;
    public static final int GL_RENDERBUFFER_BINDING                         = 0x8CA7;
    public static final int GL_RENDERBUFFER_BLUE_SIZE                       = 0x8D52;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE                      = 0x8D54;
    public static final int GL_RENDERBUFFER_GREEN_SIZE                      = 0x8D51;
    public static final int GL_RENDERBUFFER_HEIGHT                          = 0x8D43;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT                 = 0x8D44;
    public static final int GL_RENDERBUFFER_RED_SIZE                        = 0x8D50;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE                    = 0x8D55;
    public static final int GL_RENDERBUFFER_WIDTH                           = 0x8D42;
    public static final int GL_RENDERER                                     = 0x1F01;
    public static final int GL_REPEAT                                       = 0x2901;
    public static final int GL_REPLACE                                      = 0x1E01;
    public static final int GL_RGB                                          = 0x1907;
    public static final int GL_RGB565                                       = 0x8D62;
    public static final int GL_RGB5_A1                                      = 0x8057;
    public static final int GL_RGBA                                         = 0x1908;
    public static final int GL_RGBA4                                        = 0x8056;
    public static final int GL_SAMPLER_2D                                   = 0x8B5E;
    public static final int GL_SAMPLER_CUBE                                 = 0x8B60;
    public static final int GL_SAMPLES                                      = 0x80A9;
    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE                     = 0x809E;
    public static final int GL_SAMPLE_BUFFERS                               = 0x80A8;
    public static final int GL_SAMPLE_COVERAGE                              = 0x80A0;
    public static final int GL_SAMPLE_COVERAGE_INVERT                       = 0x80AB;
    public static final int GL_SAMPLE_COVERAGE_VALUE                        = 0x80AA;
    public static final int GL_SCISSOR_BOX                                  = 0x0C10;
    public static final int GL_SCISSOR_TEST                                 = 0x0C11;
    public static final int GL_SHADER_TYPE                                  = 0x8B4F;
    public static final int GL_SHADING_LANGUAGE_VERSION                     = 0x8B8C;
    public static final int GL_SHORT                                        = 0x1402;
    public static final int GL_SRC_ALPHA                                    = 0x0302;
    public static final int GL_SRC_ALPHA_SATURATE                           = 0x0308;
    public static final int GL_SRC_COLOR                                    = 0x0300;
    public static final int GL_STATIC_DRAW                                  = 0x88E4;
    public static final int GL_STENCIL_ATTACHMENT                           = 0x8D20;
    public static final int GL_STENCIL_BACK_FAIL                            = 0x8801;
    public static final int GL_STENCIL_BACK_FUNC                            = 0x8800;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL                 = 0x8802;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS                 = 0x8803;
    public static final int GL_STENCIL_BACK_REF                             = 0x8CA3;
    public static final int GL_STENCIL_BACK_VALUE_MASK                      = 0x8CA4;
    public static final int GL_STENCIL_BACK_WRITEMASK                       = 0x8CA5;
    public static final int GL_STENCIL_BITS                                 = 0x0D57;
    public static final int GL_STENCIL_BUFFER_BIT                           = 0x0400;
    public static final int GL_STENCIL_CLEAR_VALUE                          = 0x0B91;
    public static final int GL_STENCIL_FAIL                                 = 0x0B94;
    public static final int GL_STENCIL_FUNC                                 = 0x0B92;
    public static final int GL_STENCIL_INDEX                                = 0x1901;
    public static final int GL_STENCIL_INDEX8                               = 0x8D48;
    public static final int GL_STENCIL_PASS_DEPTH_FAIL                      = 0x0B95;
    public static final int GL_STENCIL_PASS_DEPTH_PASS                      = 0x0B96;
    public static final int GL_STENCIL_REF                                  = 0x0B97;
    public static final int GL_STENCIL_TEST                                 = 0x0B90;
    public static final int GL_STENCIL_VALUE_MASK                           = 0x0B93;
    public static final int GL_STENCIL_WRITEMASK                            = 0x0B98;
    public static final int GL_STREAM_DRAW                                  = 0x88E0;
    public static final int GL_SUBPIXEL_BITS                                = 0x0D50;
    public static final int GL_TEXTURE                                      = 0x1702;
    public static final int GL_TEXTURE0                                     = 0x84C0;
    public static final int GL_TEXTURE1                                     = 0x84C1;
    public static final int GL_TEXTURE2                                     = 0x84C2;
    public static final int GL_TEXTURE3                                     = 0x84C3;
    public static final int GL_TEXTURE4                                     = 0x84C4;
    public static final int GL_TEXTURE5                                     = 0x84C5;
    public static final int GL_TEXTURE6                                     = 0x84C6;
    public static final int GL_TEXTURE7                                     = 0x84C7;
    public static final int GL_TEXTURE8                                     = 0x84C8;
    public static final int GL_TEXTURE9                                     = 0x84C9;
    public static final int GL_TEXTURE10                                    = 0x84CA;
    public static final int GL_TEXTURE11                                    = 0x84CB;
    public static final int GL_TEXTURE12                                    = 0x84CC;
    public static final int GL_TEXTURE13                                    = 0x84CD;
    public static final int GL_TEXTURE14                                    = 0x84CE;
    public static final int GL_TEXTURE15                                    = 0x84CF;
    public static final int GL_TEXTURE16                                    = 0x84D0;
    public static final int GL_TEXTURE17                                    = 0x84D1;
    public static final int GL_TEXTURE18                                    = 0x84D2;
    public static final int GL_TEXTURE19                                    = 0x84D3;
    public static final int GL_TEXTURE20                                    = 0x84D4;
    public static final int GL_TEXTURE21                                    = 0x84D5;
    public static final int GL_TEXTURE22                                    = 0x84D6;
    public static final int GL_TEXTURE23                                    = 0x84D7;
    public static final int GL_TEXTURE24                                    = 0x84D8;
    public static final int GL_TEXTURE25                                    = 0x84D9;
    public static final int GL_TEXTURE26                                    = 0x84DA;
    public static final int GL_TEXTURE27                                    = 0x84DB;
    public static final int GL_TEXTURE28                                    = 0x84DC;
    public static final int GL_TEXTURE29                                    = 0x84DD;
    public static final int GL_TEXTURE30                                    = 0x84DE;
    public static final int GL_TEXTURE31                                    = 0x84DF;
    public static final int GL_TEXTURE_2D                                   = 0x0DE1;
    public static final int GL_TEXTURE_BINDING_2D                           = 0x8069;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP                     = 0x8514;
    public static final int GL_TEXTURE_CUBE_MAP                             = 0x8513;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X                  = 0x8516;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y                  = 0x8518;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z                  = 0x851A;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X                  = 0x8515;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y                  = 0x8517;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z                  = 0x8519;
    public static final int GL_TEXTURE_MAG_FILTER                           = 0x2800;
    public static final int GL_TEXTURE_MIN_FILTER                           = 0x2801;
    public static final int GL_TEXTURE_WRAP_S                               = 0x2802;
    public static final int GL_TEXTURE_WRAP_T                               = 0x2803;
    public static final int GL_TRIANGLES                                    = 0x0004;
    public static final int GL_TRIANGLE_FAN                                 = 0x0006;
    public static final int GL_TRIANGLE_STRIP                               = 0x0005;
    public static final int GL_UNPACK_ALIGNMENT                             = 0x0CF5;
    public static final int GL_UNPACK_COLORSPACE_CONVERSION_WEBGL           = 0x9243;
    public static final int GL_UNPACK_FLIP_Y_WEBGL                          = 0x9240;
    public static final int GL_UNPACK_PREMULTIPLY_ALPHA_WEBGL               = 0x9241;
    public static final int GL_UNSIGNED_BYTE                                = 0x1401;
    public static final int GL_UNSIGNED_INT                                 = 0x1405;
    public static final int GL_UNSIGNED_SHORT                               = 0x1403;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4                       = 0x8033;
    public static final int GL_UNSIGNED_SHORT_5_5_5_1                       = 0x8034;
    public static final int GL_UNSIGNED_SHORT_5_6_5                         = 0x8363;
    public static final int GL_VALIDATE_STATUS                              = 0x8B83;
    public static final int GL_VENDOR                                       = 0x1F00;
    public static final int GL_VERSION                                      = 0x1F02;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING           = 0x889F;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED                  = 0x8622;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED               = 0x886A;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER                  = 0x8645;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE                     = 0x8623;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE                   = 0x8624;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE                     = 0x8625;
    public static final int GL_VERTEX_SHADER                                = 0x8B31;
    public static final int GL_VIEWPORT                                     = 0x0BA2;
    public static final int GL_ZERO                                         = 0x0000;

    /* Prevent instantiation */
    private WebGL10()
    {
    }

    public static WebGLContext createContext(Canvas canvas)
    {
        return createContext(canvas.getCanvasElement());
    }

    public static WebGLContext createContext(Canvas canvas, WebGLContext.Attributes attributes)
    {
        return createContext(canvas.getCanvasElement(), attributes);
    }

    public static WebGLContext createContext(CanvasElement canvas)
    {
        return createContext(canvas, null);
    }

    public static native WebGLContext createContext(CanvasElement canvas, WebGLContext.Attributes attributes) /*-{
        try
        {
            if (attributes)
                $wnd.gl = canvas.getContext("webgl", attributes) || canvas.getContext("experimental-webgl", attributes);
            else
                $wnd.gl = canvas.getContext("webgl") || canvas.getContext("experimental-webgl");

            $wnd.attribs = $wnd.gl.getContextAttributes();
            $wnd.glv = 1.0;
        }
        catch (e)
        {
            alert(e);

            $wnd.alert("Your browser doesn't appear to support WebGL. Try upgrading your browser.");
            $wnd.location.href = 'http://get.webgl.org/';
        }

        return $wnd.context = {
            gl: $wnd.gl,
            attribs: $wnd.attribs,
            glv: $wnd.glv
        };
    }-*/;

    public static native boolean isSupported() /*-{
        try
        {
            var canvas = $doc.createElement('canvas');
            return !!( $wnd.WebGLRenderingContext && (canvas.getContext('webgl') ||
            canvas.getContext('experimental-webgl')));
        }
        catch (e)
        {
            $wnd.console.log(e);
            return false;
        }
    }-*/;

    public static boolean isContextCompatible()
    {
        return WebGLContext.getCurrent() != null && WebGLContext.getCurrent().getVersion() >= 1.0;
    }

    private static void checkContextCompatibility()
    {
        if (!isContextCompatible())
            throw new IllegalStateException("The context should be created before invoking the GL functions");
    }

    public static void glActiveTexture(int texture)
    {
        checkContextCompatibility();
        nglActiveTexture(texture);
    }

    public static void glAttachShader(int programID, int shaderID)
    {
        checkContextCompatibility();

        JavaScriptObject program = WebGLObjectMap.get().toProgram(programID);
        JavaScriptObject shader = WebGLObjectMap.get().toShader(shaderID);

        nglAttachShader(program, shader);
    }

    public static void glBindAttribLocation(int programID, int index, String name)
    {
        checkContextCompatibility();
        nglBindAttribLocation(WebGLObjectMap.get().toProgram(programID), index, name);
    }

    public static void glBindBuffer(int target, int buffer)
    {
        checkContextCompatibility();
        nglBindBuffer(target, WebGLObjectMap.get().toBuffer(buffer));
    }

    public static void glBindFramebuffer(int target, int frameBuffer)
    {
        checkContextCompatibility();
        nglBindFramebuffer(target, WebGLObjectMap.get().toFramebuffer(frameBuffer));
    }

    public static void glBindRenderbuffer(int target, int renderBuffer)
    {
        checkContextCompatibility();
        nglBindRenderbuffer(target, WebGLObjectMap.get().toRenderBuffer(renderBuffer));
    }

    public static void glBindTexture(int target, int textureID)
    {
        checkContextCompatibility();
        nglBindTexture(target, WebGLObjectMap.get().toTexture(textureID));
    }

    public static void glBlendColor(float r, float g, float b, float a)
    {
        checkContextCompatibility();
        nglBlendColor(r, g, b, a);
    }

    public static void glBlendEquation(int mode)
    {
        checkContextCompatibility();
        nglBlendEquation(mode);
    }

    public static void glBlendEquationSeparate(int modeRGB, int modeAlpha)
    {
        checkContextCompatibility();
        nglBlendEquationSeparate(modeRGB, modeAlpha);
    }

    public static void glBlendFunc(int srcFactor, int dstFactor)
    {
        checkContextCompatibility();
        nglBlendFunc(srcFactor, dstFactor);
    }

    public static void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha)
    {
        checkContextCompatibility();
        nglBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
    }

    public static void glBufferData(int target, float[] data, int usage)
    {
        checkContextCompatibility();
        nglBufferData(target, data, usage);
    }

    public static void glBufferData(int target, int[] data, int usage)
    {
        checkContextCompatibility();
        nglBufferData(target, data, usage);
    }

    public static void glBufferData(int target, short[] data, int usage)
    {
        checkContextCompatibility();
        nglBufferData(target, data, usage);
    }

    public static void glBufferData(int target, ArrayBufferView data, int usage)
    {
        checkContextCompatibility();
        nglBufferData(target, data, usage);
    }

    public static void glBufferSubData(int target, int offset, long size, float[] data)
    {
        checkContextCompatibility();
        nglBufferSubData(target, offset, size, data);
    }

    public static void glBufferSubData(int target, int offset, long size, int[] data)
    {
        checkContextCompatibility();
        nglBufferSubData(target, offset, size, data);
    }

    public static void glBufferSubData(int target, int offset, long size, short[] data)
    {
        checkContextCompatibility();
        nglBufferSubData(target, offset, size, data);
    }

    public static void glBufferSubData(int target, int offset, long size, ArrayBufferView data)
    {
        checkContextCompatibility();
        nglBufferSubData(target, offset, size, data);
    }

    public static int glCheckFramebufferStatus(int target)
    {
        checkContextCompatibility();
        return nglCheckFramebufferStatus(target);
    }

    public static void glClear(int masks)
    {
        checkContextCompatibility();
        nglClear(masks);
    }

    public static void glClearColor(float r, float g, float b, float a)
    {
        checkContextCompatibility();
        nglClearColor(r, g, b, a);
    }

    public static void glClearDepth(float depth)
    {
        checkContextCompatibility();
        nglClearDepth(depth);
    }

    public static void glClearStencil(int stencil)
    {
        checkContextCompatibility();
        nglClearStencil(stencil);
    }

    public static void glColorMask(boolean red, boolean green, boolean blue, boolean alpha)
    {
        checkContextCompatibility();
        nglColorMask(red, green, blue, alpha);
    }

    public static void glCompileShader(int shaderID)
    {
        checkContextCompatibility();
        nglCompileShader(WebGLObjectMap.get().toShader(shaderID));
    }

    public static void glCompressedTexImage2D(int target, int level, int internalFormat,
                                              int border, long imageSize, Image image)
    {
        glCompressedTexImage2D(target, level, internalFormat, border, imageSize, image.getElement());
    }

    public static void glCompressedTexImage2D(int target, int level, int internalFormat, long width, long height,
                                              int border, long imageSize, ArrayBufferView pixels)
    {
        checkContextCompatibility();
        nglCompressedTexImage2D(target, level, internalFormat, width, height, border, imageSize, pixels);
    }

    public static void glCompressedTexImage2D(int target, int level, int internalFormat,
                                              int border, long imageSize, JavaScriptObject JavaScriptObject)
    {
        checkContextCompatibility();
        nglCompressedTexImage2D(target, level, internalFormat,border, imageSize, JavaScriptObject);
    }

    public static void glCompressedTexSubImage2D(int target, int level, int xOffset, int yOffset,
                                                 int format, long imageSize, Image image)
    {
        glCompressedTexSubImage2D(target, level, xOffset, yOffset, format, imageSize, image.getElement());
    }

    public static void glCompressedTexSubImage2D(int target, int level, int xOffset, int yOffset,
                                                 int format, long imageSize, JavaScriptObject data)
    {
        checkContextCompatibility();
        nglCompressedTexSubImage2D(target, level, xOffset, yOffset, format, imageSize, data);
    }

    public static void glCompressedTexSubImage2D(int target, int level, int xOffset, int yOffset, long width, long height,
                                                 int format, long imageSize, ArrayBufferView data)
    {
        checkContextCompatibility();
        nglCompressedTexSubImage2D(target, level, xOffset, yOffset, width, height, format, imageSize, data);
    }

    public static void glCopyTexImage2D(int target, int level, int internalFormat, int x, int y, long width, long height,
                                        int border)
    {
        checkContextCompatibility();
        nglCopyTexImage2D(target, level, internalFormat, x, y, width, height, border);
    }

    public static void glCopyTexSubImage2D(int target, int level, int xOffset, int yOffset, int x, int y, long width, long height)
    {
        checkContextCompatibility();
        nglCopyTexSubImage2D(target, level, xOffset, yOffset, x, y, width, height);
    }

    public static int glCreateBuffer()
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createBuffer(nglCreateBuffer());
    }

    public static int glCreateFramebuffer()
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createFramebuffer(nglCreateFramebuffer());
    }

    public static int glCreateProgram()
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createProgram(nglCreateProgram());
    }

    public static int glCreateRenderbuffer()
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createRenderBuffer(nglCreateRenderbuffer());
    }

    public static int glCreateShader(int type)
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createShader(nglCreateShader(type));
    }

    public static int glCreateTexture()
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createTexture(nglCreateTexture());
    }

    public static void glCullFace(int mode)
    {
        checkContextCompatibility();
        nglCullFace(mode);
    }

    public static void glDeleteBuffer(int bufferID)
    {
        checkContextCompatibility();
        nglDeleteBuffer(WebGLObjectMap.get().toBuffer(bufferID));
        WebGLObjectMap.get().deleteBuffer(bufferID);
    }

    public static void glDeleteFramebuffer(int frameBufferID)
    {
        checkContextCompatibility();
        nglDeleteFramebuffer(WebGLObjectMap.get().toFramebuffer(frameBufferID));
        WebGLObjectMap.get().deleteFramebuffer(frameBufferID);
    }

    public static void glDeleteProgram(int programID)
    {
        checkContextCompatibility();
        nglDeleteProgram(WebGLObjectMap.get().toProgram(programID));
        WebGLObjectMap.get().deleteProgram(programID);
    }

    public static void glDeleteRenderbuffer(int renderBufferID)
    {
        checkContextCompatibility();
        nglDeleteRenderbuffer(WebGLObjectMap.get().toRenderBuffer(renderBufferID));
        WebGLObjectMap.get().deleteRenderBuffer(renderBufferID);
    }

    public static void glDeleteShader(int shaderID)
    {
        checkContextCompatibility();
        nglDeleteShader(WebGLObjectMap.get().toShader(shaderID));
        WebGLObjectMap.get().deleteShader(shaderID);
    }

    public static void glDeleteTexture(int textureID)
    {
        checkContextCompatibility();
        nglDeleteTexture(WebGLObjectMap.get().toTexture(textureID));
        WebGLObjectMap.get().deleteTexture(textureID);
    }

    public static void glDepthFunc(int func)
    {
        checkContextCompatibility();
        nglDepthFunc(func);
    }

    public static void glDepthMask(boolean flag)
    {
        checkContextCompatibility();
        nglDepthMask(flag);
    }

    public static void glDepthRange(double nearVal, double farVal)
    {
        checkContextCompatibility();
        nglDepthRange(nearVal, farVal);
    }

    public static void glDetachShader(int programID, int shaderID)
    {
        checkContextCompatibility();
        nglDetachShader(WebGLObjectMap.get().toProgram(programID), WebGLObjectMap.get().toShader(shaderID));
    }

    public static void glDisable(int disableCap)
    {
        checkContextCompatibility();
        nglDisable(disableCap);
    }

    public static void glDisableVertexAttribArray(int index)
    {
        checkContextCompatibility();
        nglDisableVertexAttribArray(index);
    }

    public static void glDrawArrays(int mode, int first, int count)
    {
        checkContextCompatibility();
        nglDrawArrays(mode, first, count);
    }

    public static void glDrawElements(int mode, int count, int type, int offset)
    {
        checkContextCompatibility();
        nglDrawElements(mode, count, type, offset);
    }

    public static void glEnable(int enableCap)
    {
        checkContextCompatibility();
        nglEnable(enableCap);
    }

    public static void glEnableVertexAttribArray(int index)
    {
        checkContextCompatibility();
        nglEnableVertexAttribArray(index);
    }

    public static void glFinish()
    {
        checkContextCompatibility();
        nglFinish();
    }

    public static void glFlush()
    {
        checkContextCompatibility();
        nglFlush();
    }

    public static void glFramebufferRenderbuffer(int target, int attachment, int renderbufferTarget, int renderBuffer)
    {
        checkContextCompatibility();
        nglFramebufferRenderbuffer(target, attachment, renderbufferTarget, WebGLObjectMap.get().toRenderBuffer(renderBuffer));
    }

    public static void glFramebufferTexture2D(int target, int attachment, int textureTarget, int texture, int level)
    {
        checkContextCompatibility();
        nglFramebufferTexture2D(target, attachment, textureTarget, WebGLObjectMap.get().toTexture(texture), level);
    }

    public static void glFrontFace(int mode)
    {
        checkContextCompatibility();
        nglFrontFace(mode);
    }

    public static void glGenerateMipmap(int target)
    {
        checkContextCompatibility();
        nglGenerateMipmap(target);
    }

    public static ActiveInfo glGetActiveAttrib(int programID, int index)
    {
        checkContextCompatibility();
        return nglGetActiveAttrib(WebGLObjectMap.get().toProgram(programID), index);
    }

    public static ActiveInfo glGetActiveUniform(int programID, int index)
    {
        checkContextCompatibility();
        return nglGetActiveUniform(WebGLObjectMap.get().toProgram(programID), index);
    }

    public static int[] glGetAttachedShaders(int programID)
    {
        checkContextCompatibility();
        JavaScriptObject[] nativeArray = nglGetAttachedShaders(WebGLObjectMap.get().toProgram(programID));
        int[] transformedArray = new int[nativeArray.length];

        for (int i = 0; i < nativeArray.length; i++)
            transformedArray[i] = WebGLObjectMap.get().createShader(nativeArray[i]);

        return transformedArray;
    }

    public static int glGetAttribLocation(int programID, String name)
    {
        checkContextCompatibility();
        return nglGetAttribLocation(WebGLObjectMap.get().toProgram(programID), name);
    }

    public static Element glGetCanvas()
    {
        checkContextCompatibility();
        return nglGetCanvas();
    }

    public static WebGLContext.Attributes glGetContextAttributes()
    {
        checkContextCompatibility();
        return nglGetContextAttributes();
    }

    public static int glGetDrawingBufferHeight()
    {
        checkContextCompatibility();
        return nglGetDrawingBufferHeight();
    }

    public static int glGetDrawingBufferWidth()
    {
        checkContextCompatibility();
        return nglGetDrawingBufferWidth();
    }

    public static int glGetError()
    {
        checkContextCompatibility();
        return nglGetError();
    }

    public static JavaScriptObject glGetExtension(String name)
    {
        checkContextCompatibility();
        return nglGetExtension(name);
    }

    public static int glGetFramebufferAttachmentParameter(int target, int attachment, int pname)
    {
        checkContextCompatibility();
        return nglGetFramebufferAttachmentParameter(target, attachment, pname);
    }

    public static <T extends JavaScriptObject> T glGetParameter(int pname)
    {
        checkContextCompatibility();
        return nglGetParameter(pname);
    }

    public static int glGetParameteri(int pname)
    {
        checkContextCompatibility();
        return nglGetParameteri(pname);
    }

    public static boolean glGetParameterb(int pname)
    {
        checkContextCompatibility();
        return nglGetParameterb(pname);
    }

    public static int[] glGetParameterii(int pname)
    {
        checkContextCompatibility();
        return nglGetParameterii(pname);
    }

    public static float[] glGetParameterff(int pname)
    {
        checkContextCompatibility();
        return nglGetParameterff(pname);
    }

    public static boolean[] glGetParameterbb(int pname)
    {
        checkContextCompatibility();
        return nglGetParameterbb(pname);
    }

    public static String glGetParameters(int pname)
    {
        checkContextCompatibility();
        return nglGetParameters(pname);
    }

    public static String glGetProgramInfoLog(int programID)
    {
        checkContextCompatibility();
        return nglGetProgramInfoLog(WebGLObjectMap.get().toProgram(programID));
    }

    public static int glGetProgramParameteri(int programID, int pname)
    {
        checkContextCompatibility();
        return nglGetProgramParameteri(WebGLObjectMap.get().toProgram(programID), pname);
    }

    public static boolean glGetProgramParameterb(int programID, int pname)
    {
        checkContextCompatibility();
        return nglGetProgramParameterb(WebGLObjectMap.get().toProgram(programID), pname);
    }

    public static int glGetRenderbufferParameter(int target, int pname)
    {
        checkContextCompatibility();
        return nglGetRenderbufferParameter(target, pname);
    }

    public static String glGetShaderInfoLog(int shaderID)
    {
        checkContextCompatibility();
        return nglGetShaderInfoLog(WebGLObjectMap.get().toShader(shaderID));
    }

    public static int glGetShaderParameteri(int shaderID, int pname)
    {
        checkContextCompatibility();
        return nglGetShaderParameteri(WebGLObjectMap.get().toShader(shaderID), pname);
    }

    public static boolean glGetShaderParameterb(int shaderID, int pname)
    {
        checkContextCompatibility();
        return nglGetShaderParameterb(WebGLObjectMap.get().toShader(shaderID), pname);
    }

    public static ShaderPrecisionFormat glGetShaderPrecisionFormat(int shaderType, int precisionType)
    {
        checkContextCompatibility();
        return nglGetShaderPrecisionFormat(shaderType, precisionType);
    }

    public static String glGetShaderSource(int shaderID)
    {
        checkContextCompatibility();
        return nglGetShaderSource(WebGLObjectMap.get().toShader(shaderID));
    }

    public static String[] glGetSupportedExtensions()
    {
        checkContextCompatibility();
        return nglGetSupportedExtensions();
    }

    public static int glGetTexParameter(int textureID, int pname)
    {
        checkContextCompatibility();
        return nglGetTexParameter(WebGLObjectMap.get().toTexture(textureID), pname);
    }

    public static boolean glGetUniformb(int programID, int location)
    {
        return glGetUniformbv(programID, location)[0];
    }

    public static boolean[] glGetUniformbv(int programID, int location)
    {
        checkContextCompatibility();
        return nglGetUniformbv(WebGLObjectMap.get().toProgram(programID), WebGLObjectMap.get().toUniform(programID, location));
    }

    public static float glGetUniformf(int programID, int location)
    {
        return glGetUniformfv(programID, location)[0];
    }

    public static float[] glGetUniformfv(int programID, int location)
    {
        checkContextCompatibility();
        return nglGetUniformfv(WebGLObjectMap.get().toProgram(programID), WebGLObjectMap.get().toUniform(programID, location));
    }

    public static int glGetUniformi(int programID, int location)
    {
        return glGetUniformiv(programID, location)[0];
    }

    public static int[] glGetUniformiv(int programID, int location)
    {
        checkContextCompatibility();
        return nglGetUniformiv(WebGLObjectMap.get().toProgram(programID), WebGLObjectMap.get().toUniform(programID, location));
    }

    public static int glGetUniformLocation(int programID, String name)
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createUniform(nglGetUniformLocation(WebGLObjectMap.get().toProgram(programID), name));
    }

    public static boolean glGetVertexAttribb(int index, int pname)
    {
        checkContextCompatibility();
        return nglGetVertexAttribb(index, pname);
    }

    public static float glGetVertexAttribf(int index, int pname)
    {
        return glGetVertexAttribfv(index, pname)[0];
    }

    public static float[] glGetVertexAttribfv(int index, int pname)
    {
        checkContextCompatibility();
        return nglGetVertexAttribfv(index, pname);
    }

    public static int glGetVertexAttribi(int index, int pname)
    {
        checkContextCompatibility();
        return nglGetVertexAttribi(index, pname);
    }

    public static int glGetVertexAttribOffset(int index, int pname)
    {
        checkContextCompatibility();
        return nglGetVertexAttribOffset(index, pname);
    }

    public static void glHint(int target, int mode)
    {
        checkContextCompatibility();
        nglHint(target, mode);
    }

    public static boolean glIsBuffer(int bufferID)
    {
        checkContextCompatibility();
        return nglIsBuffer(WebGLObjectMap.get().toBuffer(bufferID));
    }

    public static boolean glIsContextLost()
    {
        checkContextCompatibility();
        return nglIsContextLost();
    }

    public static boolean glIsEnabled(int enableCap)
    {
        checkContextCompatibility();
        return nglIsEnabled(enableCap);
    }

    public static boolean glIsFramebuffer(int framebufferID)
    {
        checkContextCompatibility();
        return nglIsFramebuffer(WebGLObjectMap.get().toFramebuffer(framebufferID));
    }

    public static boolean glIsProgram(int programID)
    {
        checkContextCompatibility();
        return nglIsProgram(WebGLObjectMap.get().toProgram(programID));
    }

    public static boolean glIsRenderbuffer(int renderbufferID)
    {
        checkContextCompatibility();
        return nglIsRenderbuffer(WebGLObjectMap.get().toRenderBuffer(renderbufferID));
    }

    public static boolean glIsShader(int shaderID)
    {
        checkContextCompatibility();
        return nglIsShader(WebGLObjectMap.get().toShader(shaderID));
    }

    public static boolean glIsTexture(int textureID)
    {
        checkContextCompatibility();
        return nglIsTexture(WebGLObjectMap.get().toTexture(textureID));
    }

    public static void glLineWidth(int width)
    {
        checkContextCompatibility();
        nglLineWidth(width);
    }

    public static void glLinkProgram(int programID)
    {
        checkContextCompatibility();
        nglLinkProgram(WebGLObjectMap.get().toProgram(programID));
    }

    public static void glPixelStorei(int pname, int param)
    {
        checkContextCompatibility();
        nglPixelStorei(pname, param);
    }

    public static void glPolygonOffset(double factor, double units)
    {
        checkContextCompatibility();
        nglPolygonOffset(factor, units);
    }

    public static void glReadPixels(int x, int y, int w, int h, int format, int type, ArrayBufferView pixels)
    {
        checkContextCompatibility();
        nglReadPixels(x, y, w, h, format, type, pixels);
    }

    public static void glRenderbufferStorage(int target, int internalFormat, int width, int height)
    {
        checkContextCompatibility();
        nglRenderbufferStorage(target, internalFormat, width, height);
    }

    public static void glSampleCoverage(float value, boolean invert)
    {
        checkContextCompatibility();
        nglSampleCoverage(value, invert);
    }

    public static void glScissor(int x, int y, int w, int h)
    {
        checkContextCompatibility();
        nglScissor(x, y, w, h);
    }

    public static void glShaderSource(int shaderID, String source)
    {
        checkContextCompatibility();
        nglShaderSource(WebGLObjectMap.get().toShader(shaderID), source);
    }

    public static void glStencilFunc(int func, int ref, int mask)
    {
        checkContextCompatibility();
        nglStencilFunc(func, ref, mask);
    }

    public static void glStencilFuncSeparate(int face, int func, int ref, int mask)
    {
        checkContextCompatibility();
        nglStencilFuncSeparate(face, func, ref, mask);
    }

    public static void glStencilMask(int mask)
    {
        checkContextCompatibility();
        nglStencilMask(mask);
    }

    public static void glStencilMaskSeparate(int face, int mask)
    {
        checkContextCompatibility();
        nglStencilMaskSeparate(face, mask);
    }

    public static void glStencilOp(int sFail, int dpFail, int dpPass)
    {
        checkContextCompatibility();
        nglStencilOp(sFail, dpFail, dpPass);
    }

    public static void glStencilOpSeparate(int face, int fail, int zFail, int zPass)
    {
        checkContextCompatibility();
        nglStencilOpSeparate(face, fail, zFail, zPass);
    }
    public static void glTexImage2D(int target, int level, int internalFormat, int format, int type, Image pixels)
    {
        checkContextCompatibility();
        nglTexImage2D(target, level, internalFormat, format, type, pixels.getElement());
    }

    public static void glTexImage2D(int target, int level, int internalFormat, int format, int type, ImageData pixels)
    {
        checkContextCompatibility();
        nglTexImage2D(target, level, internalFormat, format, type, pixels);
    }

    public static void glTexImage2D(int target, int level, int internalFormat, int width, int height, int border, int format,
                                    int type, ArrayBufferView pixels)
    {
        checkContextCompatibility();
        nglTexImage2D(target, level, internalFormat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(int target, int level, int internalFormat, int format,
                                    int type, JavaScriptObject pixels)
    {
        checkContextCompatibility();
        nglTexImage2D(target, level, internalFormat, format, type, pixels);
    }

    public static void glTexParameterf(int target, int pname, float value)
    {
        checkContextCompatibility();
        nglTexParameterf(target, pname, value);
    }

    public static void glTexParameteri(int target, int pname, int value)
    {
        checkContextCompatibility();
        nglTexParameteri(target, pname, value);
    }

    public static void glTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format,
                                       int type, ArrayBufferView pixels)
    {
        checkContextCompatibility();
        nglTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format,
                                       int type, JavaScriptObject pixels)
    {
        checkContextCompatibility();
        nglTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format,
                                       int type, Image pixels)
    {
        glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels.getElement());
    }

    public static void glTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format,
                                       int type, ImageData pixels)
    {
        glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, (JavaScriptObject) pixels);
    }

    public static void glTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format,
                                       int type, Canvas pixels)
    {
        glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels.getElement());
    }

    public static void glUniform1f(int location, float x)
    {
        checkContextCompatibility();
        nglUniform1f(WebGLObjectMap.get().toUniform(location), x);
    }

    public static void glUniform1fv(int location, Float32Array x)
    {
        checkContextCompatibility();
        nglUniform1fv(WebGLObjectMap.get().toUniform(location), x);
    }

    public static void glUniform1i(int location, int x)
    {
        checkContextCompatibility();
        nglUniform1i(WebGLObjectMap.get().toUniform(location), x);
    }

    public static void glUniform1iv(int location, Int32Array x)
    {
        checkContextCompatibility();
        nglUniform1iv(WebGLObjectMap.get().toUniform(location), x);
    }

    public static void glUniform2f(int location, float x, float y)
    {
        checkContextCompatibility();
        nglUniform2f(WebGLObjectMap.get().toUniform(location), x, y);
    }

    public static void glUniform2fv(int location, Float32Array xy)
    {
        checkContextCompatibility();
        nglUniform2fv(WebGLObjectMap.get().toUniform(location), xy);
    }

    public static void glUniform2i(int location, int x, int y)
    {
        checkContextCompatibility();
        nglUniform2i(WebGLObjectMap.get().toUniform(location), x, y);
    }

    public static void glUniform2iv(int location, Int32Array xy)
    {
        checkContextCompatibility();
        nglUniform2iv(WebGLObjectMap.get().toUniform(location), xy);
    }

    public static void glUniform3f(int location, float x, float y, float z)
    {
        checkContextCompatibility();
        nglUniform3f(WebGLObjectMap.get().toUniform(location), x, y, z);
    }

    public static void glUniform3fv(int location, Float32Array xy)
    {
        checkContextCompatibility();
        nglUniform3fv(WebGLObjectMap.get().toUniform(location), xy);
    }

    public static void glUniform3i(int location, int x, int y, int z)
    {
        checkContextCompatibility();
        nglUniform3i(WebGLObjectMap.get().toUniform(location), x, y, z);
    }

    public static void glUniform3iv(int location, Int32Array xy)
    {
        checkContextCompatibility();
        nglUniform3iv(WebGLObjectMap.get().toUniform(location), xy);
    }

    public static void glUniform4f(int location, float x, float y, float z, float w)
    {
        checkContextCompatibility();
        nglUniform4f(WebGLObjectMap.get().toUniform(location), x, y, z, w);
    }

    public static void glUniform4fv(int location, Float32Array xy)
    {
        checkContextCompatibility();
        nglUniform4fv(WebGLObjectMap.get().toUniform(location), xy);
    }

    public static void glUniform4i(int location, int x, int y, int z, int w)
    {
        checkContextCompatibility();
        nglUniform4i(WebGLObjectMap.get().toUniform(location), x, y, z, w);
    }

    public static void glUniform4iv(int location, Int32Array xy)
    {
        checkContextCompatibility();
        nglUniform4iv(WebGLObjectMap.get().toUniform(location), xy);
    }

    public static void glUniformMatrix2fv(int location, boolean transpose, float[] value)
    {
        Float32Array array = TypedArrays.createFloat32Array(value.length);
        array.set(value);
        glUniformMatrix2fv(location, transpose, array);
    }

    public static void glUniformMatrix2fv(int location, boolean transpose, Float32Array value)
    {
        checkContextCompatibility();
        nglUniformMatrix2fv(WebGLObjectMap.get().toUniform(location), transpose, value);
    }

    public static void glUniformMatrix3fv(int location, boolean transpose, float[] value)
    {
        Float32Array array = TypedArrays.createFloat32Array(value.length);
        array.set(value);
        glUniformMatrix3fv(location, transpose, array);
    }

    public static void glUniformMatrix3fv(int location, boolean transpose, Float32Array value)
    {
        checkContextCompatibility();
        nglUniformMatrix3fv(WebGLObjectMap.get().toUniform(location), transpose, value);
    }

    public static void glUniformMatrix4fv(int location, boolean transpose, float[] value)
    {
        Float32Array array = TypedArrays.createFloat32Array(value.length);
        array.set(value);
        glUniformMatrix4fv(location, transpose, array);
    }

    public static void glUniformMatrix4fv(int location, boolean transpose, Float32Array value)
    {
        checkContextCompatibility();
        nglUniformMatrix4fv(WebGLObjectMap.get().toUniform(location), transpose, value);
    }

    public static void glUseProgram(int programID)
    {
        checkContextCompatibility();
        WebGLObjectMap.get().currentProgram = programID;
        nglUseProgram(WebGLObjectMap.get().toProgram(programID));
    }

    public static void glValidateProgram(int programID)
    {
        checkContextCompatibility();
        nglValidateProgram(WebGLObjectMap.get().toProgram(programID));
    }

    public static void glVertexAttribPointer(int index, int size, int type, boolean normalized, long stride, long offset)
    {
        checkContextCompatibility();
        nglVertexAttribPointer(index, size, type, normalized, stride, offset);
    }

    public static void glVertexAttrib1f(int index, float x)
    {
        checkContextCompatibility();
        nglVertexAttrib1f(index, x);
    }

    public static void glVertexAttrib1fv(int index, ArrayBufferView values)
    {
        checkContextCompatibility();
        nglVertexAttrib1fv(index, values);
    }

    public static void glVertexAttrib1fv(int index, JavaScriptObject values)
    {
        checkContextCompatibility();
        nglVertexAttrib1fv(index, values);
    }

    public static void glVertexAttrib1fv(int index, float[] values)
    {
        Float32Array float32Array = TypedArrays.createFloat32Array(values.length);
        float32Array.set(values);
        glVertexAttrib1fv(index, float32Array);
    }

    public static void glVertexAttrib2f(int index, float x, float y)
    {
        checkContextCompatibility();
        nglVertexAttrib2f(index, x, y);
    }

    public static void glVertexAttrib2fv(int index, ArrayBufferView values)
    {
        checkContextCompatibility();
        nglVertexAttrib2fv(index, values);
    }

    public static void glVertexAttrib2fv(int index, JavaScriptObject values)
    {
        checkContextCompatibility();
        nglVertexAttrib2fv(index, values);
    }

    public static void glVertexAttrib2fv(int index, float[] values)
    {
        Float32Array float32Array = TypedArrays.createFloat32Array(values.length);
        float32Array.set(values);
        glVertexAttrib2fv(index, float32Array);
    }

    public static void glVertexAttrib3f(int index, float x, float y, float z)
    {
        checkContextCompatibility();
        nglVertexAttrib3f(index, x, y, z);
    }

    public static void glVertexAttrib3fv(int index, ArrayBufferView values)
    {
        checkContextCompatibility();
        nglVertexAttrib3fv(index, values);
    }

    public static void glVertexAttrib3fv(int index, JavaScriptObject values)
    {
        checkContextCompatibility();
        nglVertexAttrib3fv(index, values);
    }

    public static void glVertexAttrib3fv(int index, float[] values)
    {
        Float32Array float32Array = TypedArrays.createFloat32Array(values.length);
        float32Array.set(values);
        glVertexAttrib3fv(index, float32Array);
    }

    public static void glVertexAttrib4f(int index, float x, float y, float z, float w)
    {
        checkContextCompatibility();
        nglVertexAttrib4f(index, x, y, z, w);
    }

    public static void glVertexAttrib4fv(int index, ArrayBufferView values)
    {
        checkContextCompatibility();
        nglVertexAttrib4fv(index, values);
    }

    public static void glVertexAttrib4fv(int index, JavaScriptObject values)
    {
        checkContextCompatibility();
        nglVertexAttrib4fv(index, values);
    }

    public static void glVertexAttrib4fv(int index, float[] values)
    {
        Float32Array float32Array = TypedArrays.createFloat32Array(values.length);
        float32Array.set(values);
        glVertexAttrib4fv(index, float32Array);
    }

    public static void glViewport(int x, int y, int w, int h)
    {
        checkContextCompatibility();
        nglViewport(x, y, w, h);
    }

    private static native void nglActiveTexture(int texture) /*-{
        $wnd.gl.activeTexture(texture);
    }-*/;

    private static native int nglAttachShader(JavaScriptObject programID, JavaScriptObject shaderID) /*-{
        $wnd.gl.attachShader(programID, shaderID);
    }-*/;

    private static native void nglBindAttribLocation(JavaScriptObject programID, int index, String name) /*-{
        $wnd.gl.bindAttribLocation(programID, index, name);
    }-*/;

    private static native void nglBindBuffer(int target, JavaScriptObject buffer) /*-{
        if (buffer == 0)
            buffer = null;

        $wnd.gl.bindBuffer(target, buffer);
    }-*/;

    private static native void nglBindFramebuffer(int target, JavaScriptObject frameBuffer) /*-{
        if (frameBuffer == 0)
            frameBuffer = null;

        $wnd.gl.bindFramebuffer(target, frameBuffer);
    }-*/;

    private static native void nglBindRenderbuffer(int target, JavaScriptObject renderBuffer) /*-{
        if (renderBuffer == 0)
            renderBuffer = null;

        $wnd.gl.bindRenderbuffer(target, renderBuffer);
    }-*/;

    private static native void nglBindTexture(int target, JavaScriptObject textureID) /*-{
        if (textureID == 0)
            textureID = null;

        $wnd.gl.bindTexture(target, textureID);
    }-*/;

    private static native void nglBlendColor(float r, float g, float b, float a) /*-{
        $wnd.gl.blendColor(r, g, b, a);
    }-*/;

    private static native void nglBlendEquation(int mode) /*-{
        $wnd.gl.blendEquation(mode);
    }-*/;

    private static native void nglBlendEquationSeparate(int modeRGB, int modeAlpha) /*-{
        $wnd.gl.blendEquationSeparate(modeRGB, modeAlpha);
    }-*/;

    private static native void nglBlendFunc(int srcFactor, int dstFactor) /*-{
        $wnd.gl.blendFunc(srcFactor, dstFactor);
    }-*/;

    private static native void nglBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) /*-{
        $wnd.gl.blendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
    }-*/;

    private static native void nglBufferData(int target, float[] data, int usage) /*-{
        $wnd.gl.bufferData(target, new Float32Array(data), usage);
    }-*/;

    private static native void nglBufferData(int target, int[] data, int usage) /*-{
        $wnd.gl.bufferData(target, new Int32Array(data), usage);
    }-*/;

    private static native void nglBufferData(int target, short[] data, int usage) /*-{
        $wnd.gl.bufferData(target, new Int16Array(data), usage);
    }-*/;

    private static native void nglBufferData(int target, ArrayBufferView data, int usage) /*-{
        $wnd.gl.bufferData(target, data, usage);
    }-*/;

    private static native void nglBufferSubData(int target, int offset, double size, float[] data) /*-{
        $wnd.gl.bufferSubData(target, offset, size, new Float32Array(data));
    }-*/;

    private static native void nglBufferSubData(int target, int offset, double size, int[] data) /*-{
        $wnd.gl.bufferSubData(target, offset, size, new Int32Array(data));
    }-*/;

    private static native void nglBufferSubData(int target, int offset, double size, short[] data) /*-{
        $wnd.gl.bufferSubData(target, offset, size, new Int16Array(data));
    }-*/;

    private static native void nglBufferSubData(int target, int offset, double size, ArrayBufferView data) /*-{
        $wnd.gl.bufferSubData(target, offset, size, data);
    }-*/;

    private static native int nglCheckFramebufferStatus(int target) /*-{
        return $wnd.gl.checkFramebufferStatus(target);
    }-*/;

    private static native void nglClear(int masks) /*-{
        $wnd.gl.clear(masks);
    }-*/;

    private static native void nglClearColor(float r, float g, float b, float a) /*-{
        $wnd.gl.clearColor(r, g, b, a);
    }-*/;

    private static native void nglClearDepth(float depth) /*-{
        $wnd.gl.clearDepth(depth);
    }-*/;

    private static native void nglClearStencil(int stencil) /*-{
        $wnd.gl.clearStencil(stencil);
    }-*/;

    private static native void nglColorMask(boolean red, boolean green, boolean blue, boolean alpha) /*-{
        $wnd.gl.colorMask(red, green, blue, alpha);
    }-*/;

    private static native void nglCompileShader(JavaScriptObject shaderID) /*-{
        $wnd.gl.compileShader(shaderID);
    }-*/;

    private static native void nglCompressedTexImage2D(int target, int level, int internalFormat,
                                                       int border, double imageSize, JavaScriptObject JavaScriptObject) /*-{
        $wnd.gl.compressedTexImage2D(target, level, internalFormat, border, imageSize, JavaScriptObject);
    }-*/;

    private static native void nglCompressedTexImage2D(int target, int level, int internalFormat, double width, double height,
                                                       int border, double imageSize, ArrayBufferView pixels) /*-{
        $wnd.gl.compressedTexImage2D(target, level, internalFormat, width, height, border, imageSize, pixels);
    }-*/;

    private static native void nglCompressedTexSubImage2D(int target, int level, int xOffset, int yOffset, int format, double imageSize, JavaScriptObject data) /*-{
        $wnd.gl.compressedTexSubImage2D(target, level, xOffset, yOffset, format, imageSize, data);
    }-*/;

    private static native void nglCompressedTexSubImage2D(int target, int level, int xOffset, int yOffset, double width,
                                                          double height, int format, double imageSize, ArrayBufferView data) /*-{
        $wnd.gl.compressedTexSubImage2D(target, level, xOffset, yOffset, width, height, format, imageSize, data);
    }-*/;

    private static native void nglCopyTexImage2D(int target, int level, int internalFormat, int x, int y, double width,
                                                 double height, int border) /*-{
        $wnd.gl.copyTexImage2D(target, level, internalFormat, x, y, width, height, border);
    }-*/;

    private static native void nglCopyTexSubImage2D(int target, int level, int xOffset, int yOffset,
                                                    int x, int y, double width, double height) /*-{
        $wnd.gl.copyTexSubImage2D(target, level, xOffset, yOffset, x, y, width, height);
    }-*/;

    private static native JavaScriptObject nglCreateBuffer() /*-{
        return $wnd.gl.createBuffer();
    }-*/;

    private static native JavaScriptObject nglCreateFramebuffer() /*-{
        return $wnd.gl.createFramebuffer();
    }-*/;

    private static native JavaScriptObject nglCreateProgram() /*-{
        return $wnd.gl.createProgram();
    }-*/;

    private static native JavaScriptObject nglCreateRenderbuffer() /*-{
        return $wnd.gl.createRenderbuffer();
    }-*/;

    private static native JavaScriptObject nglCreateShader(int type) /*-{
        return $wnd.gl.createShader(type);
    }-*/;

    private static native JavaScriptObject nglCreateTexture() /*-{
        return $wnd.gl.createTexture();
    }-*/;

    private static native void nglCullFace(int mode) /*-{
        $wnd.gl.cullFace(mode);
    }-*/;

    private static native void nglDeleteBuffer(JavaScriptObject bufferID) /*-{
        $wnd.gl.deleteBuffer(bufferID);
    }-*/;

    private static native void nglDeleteFramebuffer(JavaScriptObject frameBufferID) /*-{
        $wnd.gl.deleteFramebuffer(frameBufferID);
    }-*/;

    private static native void nglDeleteProgram(JavaScriptObject programID) /*-{
        $wnd.gl.deleteProgram(programID);
    }-*/;

    private static native void nglDeleteRenderbuffer(JavaScriptObject renderBufferID) /*-{
        $wnd.gl.deleteRenderbuffer(renderBufferID);
    }-*/;

    private static native void nglDeleteShader(JavaScriptObject shaderID) /*-{
        $wnd.gl.deleteShader(shaderID);
    }-*/;

    private static native void nglDeleteTexture(JavaScriptObject textureID) /*-{
        $wnd.gl.deleteTexture(textureID);
    }-*/;

    private static native void nglDepthFunc(int func) /*-{
        $wnd.gl.depthFunc(func);
    }-*/;

    private static native void nglDepthMask(boolean flag) /*-{
        $wnd.gl.depthMask(flag);
    }-*/;

    private static native void nglDepthRange(double nearVal, double farVal) /*-{
        $wnd.gl.depthRange(nearVal, farVal);
    }-*/;

    private static native void nglDetachShader(JavaScriptObject programID, JavaScriptObject shaderID) /*-{
        $wnd.gl.detachShader(programID, shaderID);
    }-*/;

    private static native void nglDisable(int disableCap) /*-{
        $wnd.gl.disable(disableCap);
    }-*/;

    private static native void nglDisableVertexAttribArray(int index) /*-{
        $wnd.gl.disableVertexAttribArray(index);
    }-*/;

    private static native void nglDrawArrays(int mode, int first, int count) /*-{
        $wnd.gl.drawArrays(mode, first, count);
    }-*/;

    private static native void nglDrawElements(int mode, int count, int type, int offset) /*-{
        $wnd.gl.drawElements(mode, count, type, offset);
    }-*/;

    private static native void nglEnable(int enableCap) /*-{
        $wnd.gl.enable(enableCap);
    }-*/;

    private static native void nglEnableVertexAttribArray(int index) /*-{
        $wnd.gl.enableVertexAttribArray(index);
    }-*/;

    private static native void nglFinish() /*-{
        $wnd.gl.finish();
    }-*/;

    private static native void nglFlush() /*-{
        $wnd.gl.flush();
    }-*/;

    private static native void nglFramebufferRenderbuffer(int target, int attachment, int renderbufferTarget, JavaScriptObject renderBuffer) /*-{
        $wnd.gl.framebufferRenderbuffer(target, attachment, renderbufferTarget, renderBuffer);
    }-*/;

    private static native void nglFramebufferTexture2D(int target, int attachment, int textureTarget, JavaScriptObject texture, int level) /*-{
        $wnd.gl.framebufferTexture2D(target, attachment, textureTarget, texture, level);
    }-*/;

    private static native void nglFrontFace(int mode) /*-{
        $wnd.gl.frontFace(mode);
    }-*/;

    private static native void nglGenerateMipmap(int target) /*-{
        $wnd.gl.generateMipmap(target);
    }-*/;

    private static native ActiveInfo nglGetActiveAttrib(JavaScriptObject programID, int index) /*-{
        return $wnd.gl.getActiveAttrib(programID, index);
    }-*/;

    private static native ActiveInfo nglGetActiveUniform(JavaScriptObject programID, int index) /*-{
        return $wnd.gl.getActiveUniform(programID, index);
    }-*/;

    private static native JavaScriptObject[] nglGetAttachedShaders(JavaScriptObject programID) /*-{
        return $wnd.gl.getAttachedShaders(programID);
    }-*/;

    private static native int nglGetAttribLocation(JavaScriptObject programID, String name) /*-{
        return $wnd.gl.getAttribLocation(programID, name);
    }-*/;

    private static native int nglGetBufferParameter(int target, int pname) /*-{
        return $wnd.gl.getBufferParameter(target, pname);
    }-*/;

    private static native Element nglGetCanvas() /*-{
        return $wnd.gl.canvas;
    }-*/;

    private static native WebGLContext.Attributes nglGetContextAttributes() /*-{
        return $wnd.gl.getContextAttributes();
    }-*/;

    private static native int nglGetDrawingBufferHeight() /*-{
        return $wnd.gl.drawingBufferHeight;
    }-*/;

    private static native int nglGetDrawingBufferWidth() /*-{
        return $wnd.gl.drawingBufferWidth;
    }-*/;

    private static native int nglGetError() /*-{
        return $wnd.gl.getError();
    }-*/;

    private static native JavaScriptObject nglGetExtension(String name) /*-{
        return $wnd.gl.getExtension(name);
    }-*/;

    private static native int nglGetFramebufferAttachmentParameter(int target, int attachment, int pname) /*-{
        return $wnd.gl.getFramebufferAttachmentParameter(target, attachment, pname);
    }-*/;

    private static native <T extends JavaScriptObject> T nglGetParameter(int pname) /*-{
        return $wnd.gl.getParameter(pname);
    }-*/;

    private static native int nglGetParameteri(int pname) /*-{
        return $wnd.gl.getParameter(pname);
    }-*/;

    private static native boolean nglGetParameterb(int pname) /*-{
        return $wnd.gl.getParameter(pname);
    }-*/;

    private static native int[] nglGetParameterii(int pname) /*-{
        return $wnd.gl.getParameter(pname);
    }-*/;

    private static native float[] nglGetParameterff(int pname) /*-{
        return $wnd.gl.getParameter(pname);
    }-*/;

    private static native boolean[] nglGetParameterbb(int pname) /*-{
        return $wnd.gl.getParameter(pname);
    }-*/;

    private static native String nglGetParameters(int pname) /*-{
        return $wnd.gl.getParameter(pname);
    }-*/;

    private static native String nglGetProgramInfoLog(JavaScriptObject programID) /*-{
        return $wnd.gl.getProgramInfoLog(programID);
    }-*/;

    private static native int nglGetProgramParameteri(JavaScriptObject programID, int pname) /*-{
        return $wnd.gl.getProgramParameter(programID, pname);
    }-*/;

    private static native boolean nglGetProgramParameterb(JavaScriptObject programID, int pname) /*-{
        return $wnd.gl.getProgramParameter(programID, pname);
    }-*/;

    private static native int nglGetRenderbufferParameter(int target, int pname) /*-{
        return $wnd.gl.getRenderbufferParameter(target, pname);
    }-*/;

    private static native String nglGetShaderInfoLog(JavaScriptObject shaderID) /*-{
        return $wnd.gl.getShaderInfoLog(shaderID);
    }-*/;

    private static native int nglGetShaderParameteri(JavaScriptObject shaderID, int pname) /*-{
        return $wnd.gl.getShaderParameter(shaderID, pname);
    }-*/;

    private static native boolean nglGetShaderParameterb(JavaScriptObject shaderID, int pname) /*-{
        return $wnd.gl.getShaderParameter(shaderID, pname);
    }-*/;

    private static native ShaderPrecisionFormat nglGetShaderPrecisionFormat(int shaderType, int precisionType) /*-{
        return $wnd.gl.getShaderPrecisionFormat(shaderType, precisionType);
    }-*/;

    private static native String nglGetShaderSource(JavaScriptObject shaderID) /*-{
        return $wnd.gl.getShaderSource(shaderID);
    }-*/;

    private static native String[] nglGetSupportedExtensions() /*-{
        return $wnd.gl.getSupportedExtensions();
    }-*/;

    private static native int nglGetTexParameter(JavaScriptObject textureID, int pname) /*-{
        return $wnd.gl.getTexParameter(textureID, pname);
    }-*/;

    private static native boolean[] nglGetUniformbv(JavaScriptObject programID, JavaScriptObject location) /*-{
        return $wnd.gl.getUniform(programID, location);
    }-*/;

    private static native float[] nglGetUniformfv(JavaScriptObject programID, JavaScriptObject location) /*-{
        return $wnd.gl.getUniform(programID, location);
    }-*/;

    private static native int[] nglGetUniformiv(JavaScriptObject programID, JavaScriptObject location) /*-{
        return $wnd.gl.getUniform(programID, location);
    }-*/;

    private static native JavaScriptObject nglGetUniformLocation(JavaScriptObject programID, String name) /*-{
        return $wnd.gl.getUniformLocation(programID, name);
    }-*/;

    private static native boolean nglGetVertexAttribb(int index, int pname) /*-{
        return $wnd.gl.getVertexAttrib(index, pname);
    }-*/;

    private static native float[] nglGetVertexAttribfv(int index, int pname) /*-{
        return $wnd.gl.getVertexAttrib(index, pname);
    }-*/;

    private static native int nglGetVertexAttribi(int index, int pname) /*-{
        return $wnd.gl.getVertexAttrib(index, pname);
    }-*/;

    private static native int nglGetVertexAttribOffset(int index, int pname) /*-{
        return $wnd.gl.getVertexAttribOffset(index, pname);
    }-*/;

    private static native void nglHint(int target, int mode) /*-{
        return $wnd.gl.hint(target, mode);
    }-*/;

    private static native boolean nglIsBuffer(JavaScriptObject bufferID) /*-{
        return $wnd.gl.isBuffer(bufferID);
    }-*/;

    private static native boolean nglIsContextLost() /*-{
        return $wnd.gl.isContextLost();
    }-*/;

    private static native boolean nglIsEnabled(int capability) /*-{
        return $wnd.gl.isEnabled(capability);
    }-*/;

    private static native boolean nglIsFramebuffer(JavaScriptObject framebufferID) /*-{
        return $wnd.gl.isFramebuffer(framebufferID);
    }-*/;

    private static native boolean nglIsProgram(JavaScriptObject programID) /*-{
        return $wnd.gl.isProgram(programID);
    }-*/;

    private static native boolean nglIsRenderbuffer(JavaScriptObject renderbufferID) /*-{
        return $wnd.gl.isRenderbuffer(renderbufferID);
    }-*/;

    private static native boolean nglIsShader(JavaScriptObject shaderID) /*-{
        return $wnd.gl.isShader(shaderID);
    }-*/;

    private static native boolean nglIsTexture(JavaScriptObject textureID) /*-{
        return $wnd.gl.isTexture(textureID);
    }-*/;

    private static native void nglLineWidth(int width) /*-{
        $wnd.gl.lineWidth(width);
    }-*/;

    private static native void nglLinkProgram(JavaScriptObject programID) /*-{
        $wnd.gl.linkProgram(programID);
    }-*/;

    private static native void nglPixelStorei(int pname, int param) /*-{
        $wnd.gl.pixelStorei(pname, param);
    }-*/;

    private static native void nglPolygonOffset(double factor, double units) /*-{
        $wnd.gl.polygonOffset(factor, units);
    }-*/;

    private static native void nglReadPixels(int x, int y, int w, int h, int format, int type, ArrayBufferView pixels) /*-{
        $wnd.gl.readPixels(x, y, w, h, format, type, pixels);
    }-*/;

    private static native void nglRenderbufferStorage(int target, int internalFormat, int width, int height) /*-{
        $wnd.gl.renderbufferStorage(target, internalFormat, width, height);
    }-*/;

    private static native void nglSampleCoverage(float value, boolean invert) /*-{
        $wnd.gl.sampleCoverage(value, invert);
    }-*/;

    private static native void nglScissor(int x, int y, int w, int h) /*-{
        $wnd.gl.scissor(x, y, w, h);
    }-*/;

    private static native void nglShaderSource(JavaScriptObject shaderID, String source) /*-{
        return $wnd.gl.shaderSource(shaderID, source);
    }-*/;

    private static native void nglStencilFunc(int func, int ref, int mask) /*-{
        $wnd.gl.stencilFunc(func, ref, mask);
    }-*/;

    private static native void nglStencilFuncSeparate(int face, int func, int ref, int mask) /*-{
        $wnd.gl.stencilFuncSeparate(face, func, ref, mask);
    }-*/;

    private static native void nglStencilMask(int mask) /*-{
        $wnd.gl.stencilMask(mask);
    }-*/;

    private static native void nglStencilMaskSeparate(int face, int mask) /*-{
        $wnd.gl.stencilMaskSeparate(face, mask);
    }-*/;

    private static native void nglStencilOp(int sFail, int dpFail, int dpPass) /*-{
        $wnd.gl.stencilOp(sFail, dpFail, dpPass);
    }-*/;

    private static native void nglStencilOpSeparate(int face, int fail, int zFail, int zPass) /*-{
        $wnd.gl.stencilOpSeparate(face, fail, zFail, zPass);
    }-*/;

    private static native void nglTexImage2D(int target, int level, int internalFormat, int width, int height, int border,
                                             int format, int type, ArrayBufferView pixels) /*-{
        $wnd.gl.texImage2D(target, level, internalFormat, width, height, border, format, type, pixels);
    }-*/;

    private static native void nglTexImage2D(int target, int level, int internalFormat, int format, int type, JavaScriptObject pixels) /*-{
        $wnd.gl.texImage2D(target, level, internalFormat, format, type, pixels);
    }-*/;

    private static native void nglTexParameterf(int target, int pname, float value) /*-{
        $wnd.gl.texParameterf(target, pname, value);
    }-*/;

    private static native void nglTexParameteri(int target, int pname, int value) /*-{
        $wnd.gl.texParameteri(target, pname, value);
    }-*/;

    private static native void nglTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height,
                                                int format, int type, ArrayBufferView pixels) /*-{
        $wnd.gl.texSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
    }-*/;

    private static native void nglTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height,
                                                int format, int type, JavaScriptObject pixels) /*-{
        $wnd.gl.texSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
    }-*/;

    private static native void nglUniform1f(JavaScriptObject location, float x) /*-{
        $wnd.gl.uniform1f(location, x);
    }-*/;

    private static native void nglUniform1fv(JavaScriptObject location, Float32Array x) /*-{
        $wnd.gl.uniform1fv(location, x);
    }-*/;

    private static native void nglUniform1i(JavaScriptObject location, int x) /*-{
        $wnd.gl.uniform1i(location, x);
    }-*/;

    private static native void nglUniform1iv(JavaScriptObject location, Int32Array x) /*-{
        $wnd.gl.uniform1iv(location, x);
    }-*/;

    private static native void nglUniform2f(JavaScriptObject location, float x, float y) /*-{
        $wnd.gl.uniform2f(location, x, y);
    }-*/;

    private static native void nglUniform2fv(JavaScriptObject location, Float32Array xy) /*-{
        $wnd.gl.uniform2fv(location, xy);
    }-*/;

    private static native void nglUniform2i(JavaScriptObject location, int x, int y) /*-{
        $wnd.gl.uniform2i(location, x, y);
    }-*/;

    private static native void nglUniform2iv(JavaScriptObject location, Int32Array xy) /*-{
        $wnd.gl.uniform2iv(location, xy);
    }-*/;

    private static native void nglUniform3f(JavaScriptObject location, float x, float y, float z) /*-{
        $wnd.gl.uniform3f(location, x, y, z);
    }-*/;

    private static native void nglUniform3fv(JavaScriptObject location, Float32Array xy) /*-{
        $wnd.gl.uniform3fv(location, xy);
    }-*/;

    private static native void nglUniform3i(JavaScriptObject location, int x, int y, int z) /*-{
        $wnd.gl.uniform3i(location, x, y, z);
    }-*/;

    private static native void nglUniform3iv(JavaScriptObject location, Int32Array xy) /*-{
        $wnd.gl.uniform3iv(location, xy);
    }-*/;

    private static native void nglUniform4f(JavaScriptObject location, float x, float y, float z, float w) /*-{
        $wnd.gl.uniform4f(location, x, y, z, w);
    }-*/;

    private static native void nglUniform4fv(JavaScriptObject location, Float32Array xy) /*-{
        $wnd.gl.uniform4fv(location, xy);
    }-*/;

    private static native void nglUniform4i(JavaScriptObject location, int x, int y, int z, int w) /*-{
        $wnd.gl.uniform4i(location, x, y, z, w);
    }-*/;

    private static native void nglUniform4iv(JavaScriptObject location, Int32Array xy) /*-{
        $wnd.gl.uniform4iv(location, xy);
    }-*/;

    private static native void nglUniformMatrix2fv(JavaScriptObject location, boolean transpose, Float32Array value)/*-{
        $wnd.gl.uniformMatrix2fv(location, transpose, value);
    }-*/;

    private static native void nglUniformMatrix3fv(JavaScriptObject location, boolean transpose, Float32Array value)/*-{
        $wnd.gl.uniformMatrix3fv(location, transpose, value);
    }-*/;

    private static native void nglUniformMatrix4fv(JavaScriptObject location, boolean transpose, Float32Array value)/*-{
        $wnd.gl.uniformMatrix4fv(location, transpose, value);
    }-*/;

    private static native void nglUseProgram(JavaScriptObject programID) /*-{
        $wnd.gl.useProgram(programID);
    }-*/;

    private static native void nglValidateProgram(JavaScriptObject programID) /*-{
        $wnd.gl.validateProgram(programID);
    }-*/;

    private static native void nglVertexAttribPointer(int index, int size, int type, boolean normalized, double stride, double offset) /*-{
        $wnd.gl.vertexAttribPointer(index, size, type, normalized, stride, offset);
    }-*/;

    private static native void nglVertexAttrib1f(int index, float x) /*-{
        $wnd.gl.vertexAttrib1f(x);
    }-*/;

    private static native void nglVertexAttrib1fv(int index, ArrayBufferView values) /*-{
        $wnd.gl.vertexAttrib1fv(index, values);
    }-*/;

    private static native void nglVertexAttrib1fv(int index, JavaScriptObject values) /*-{
        $wnd.gl.vertexAttrib1fv(index, values);
    }-*/;

    private static native void nglVertexAttrib2f(int index, float x, float y) /*-{
        $wnd.gl.vertexAttrib2f(x, y);
    }-*/;

    private static native void nglVertexAttrib2fv(int index, ArrayBufferView values) /*-{
        $wnd.gl.vertexAttrib2fv(index, values);
    }-*/;

    private static native void nglVertexAttrib2fv(int index, JavaScriptObject values) /*-{
        $wnd.gl.vertexAttrib2fv(index, values);
    }-*/;

    private static native void nglVertexAttrib3f(int index, float x, float y, float z) /*-{
        $wnd.gl.vertexAttrib3f(x, y, z);
    }-*/;

    private static native void nglVertexAttrib3fv(int index, ArrayBufferView values) /*-{
        $wnd.gl.vertexAttrib3fv(index, values);
    }-*/;

    private static native void nglVertexAttrib3fv(int index, JavaScriptObject values) /*-{
        $wnd.gl.vertexAttrib3fv(index, values);
    }-*/;

    private static native void nglVertexAttrib4f(int index, float x, float y, float z, float w) /*-{
        $wnd.gl.vertexAttrib4f(x, y, z, w);
    }-*/;

    private static native void nglVertexAttrib4fv(int index, ArrayBufferView values) /*-{
        $wnd.gl.vertexAttrib4fv(index, values);
    }-*/;

    private static native void nglVertexAttrib4fv(int index, JavaScriptObject values) /*-{
        $wnd.gl.vertexAttrib4fv(index, values);
    }-*/;

    private static native void nglViewport(int x, int y, int w, int h) /*-{
        $wnd.gl.viewport(x, y, w, h);
    }-*/;

    public static class ActiveInfo extends JavaScriptObject
    {
        protected ActiveInfo()
        {
        }

        public final native int getName() /*-{
            return this.name;
        }-*/;

        public final native int getSize() /*-{
            return this.size;
        }-*/;

        public final native int getType() /*-{
            return this.type;
        }-*/;
    }

    public static class ShaderPrecisionFormat extends JavaScriptObject
    {
        protected ShaderPrecisionFormat()
        {
        }

        public final native int getPrecision() /*-{
            return this.precision;
        }-*/;

        public final native int getRangeMax() /*-{
            return this.rangeMax;
        }-*/;

        public final native int getRangeMin() /*-{
            return this.rangeMin;
        }-*/;
    }
}
