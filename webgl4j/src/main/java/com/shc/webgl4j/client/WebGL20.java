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
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.typedarrays.client.Uint32ArrayNative;
import com.google.gwt.typedarrays.shared.ArrayBufferView;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.typedarrays.shared.Int32Array;
import com.google.gwt.typedarrays.shared.Uint32Array;
import com.google.gwt.user.client.ui.Image;

import java.util.List;

import static com.shc.webgl4j.client.WebGL10.*;

/**
 * @author Sri Harsha Chilakapati
 */
public final class WebGL20
{
    public static final int GL_ACTIVE_UNIFORM_BLOCKS                         = 0x8A36;
    public static final int GL_ALREADY_SIGNALED                              = 0x911A;
    public static final int GL_ANY_SAMPLES_PASSED                            = 0x8C2F;
    public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE               = 0x8D6A;
    public static final int GL_COLOR                                         = 0x1800;
    public static final int GL_COLOR_ATTACHMENT1                             = 0x8CE1;
    public static final int GL_COLOR_ATTACHMENT10                            = 0x8CEA;
    public static final int GL_COLOR_ATTACHMENT11                            = 0x8CEB;
    public static final int GL_COLOR_ATTACHMENT12                            = 0x8CEC;
    public static final int GL_COLOR_ATTACHMENT13                            = 0x8CED;
    public static final int GL_COLOR_ATTACHMENT14                            = 0x8CEE;
    public static final int GL_COLOR_ATTACHMENT15                            = 0x8CEF;
    public static final int GL_COLOR_ATTACHMENT2                             = 0x8CE2;
    public static final int GL_COLOR_ATTACHMENT3                             = 0x8CE3;
    public static final int GL_COLOR_ATTACHMENT4                             = 0x8CE4;
    public static final int GL_COLOR_ATTACHMENT5                             = 0x8CE5;
    public static final int GL_COLOR_ATTACHMENT6                             = 0x8CE6;
    public static final int GL_COLOR_ATTACHMENT7                             = 0x8CE7;
    public static final int GL_COLOR_ATTACHMENT8                             = 0x8CE8;
    public static final int GL_COLOR_ATTACHMENT9                             = 0x8CE9;
    public static final int GL_COMPARE_REF_TO_TEXTURE                        = 0x884E;
    public static final int GL_COMPRESSED_R11_EAC                            = 0x9270;
    public static final int GL_COMPRESSED_RG11_EAC                           = 0x9272;
    public static final int GL_COMPRESSED_RGB8_ETC2                          = 0x9274;
    public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2      = 0x9276;
    public static final int GL_COMPRESSED_RGBA8_ETC2_EAC                     = 0x9278;
    public static final int GL_COMPRESSED_SIGNED_R11_EAC                     = 0x9271;
    public static final int GL_COMPRESSED_SIGNED_RG11_EAC                    = 0x9273;
    public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC              = 0x9279;
    public static final int GL_COMPRESSED_SRGB8_ETC2                         = 0x9275;
    public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2     = 0x9277;
    public static final int GL_CONDITION_SATISFIED                           = 0x911C;
    public static final int GL_COPY_READ_BUFFER                              = 0x8F36;
    public static final int GL_COPY_READ_BUFFER_BINDING                      = 0x8F36;
    public static final int GL_COPY_WRITE_BUFFER                             = 0x8F37;
    public static final int GL_COPY_WRITE_BUFFER_BINDING                     = 0x8F37;
    public static final int GL_CURRENT_QUERY                                 = 0x8865;
    public static final int GL_DEPTH                                         = 0x1801;
    public static final int GL_DEPTH24_STENCIL8                              = 0x88F0;
    public static final int GL_DEPTH32F_STENCIL8                             = 0x8CAD;
    public static final int GL_DEPTH_COMPONENT24                             = 0x81A6;
    public static final int GL_DEPTH_COMPONENT32F                            = 0x8CAC;
    public static final int GL_DEPTH_STENCIL                                 = 0x84F9;
    public static final int GL_DEPTH_STENCIL_ATTACHMENT                      = 0x821A;
    public static final int GL_DRAW_BUFFER0                                  = 0x8825;
    public static final int GL_DRAW_BUFFER1                                  = 0x8826;
    public static final int GL_DRAW_BUFFER10                                 = 0x882F;
    public static final int GL_DRAW_BUFFER11                                 = 0x8830;
    public static final int GL_DRAW_BUFFER12                                 = 0x8831;
    public static final int GL_DRAW_BUFFER13                                 = 0x8832;
    public static final int GL_DRAW_BUFFER14                                 = 0x8833;
    public static final int GL_DRAW_BUFFER15                                 = 0x8834;
    public static final int GL_DRAW_BUFFER2                                  = 0x8827;
    public static final int GL_DRAW_BUFFER3                                  = 0x8828;
    public static final int GL_DRAW_BUFFER4                                  = 0x8829;
    public static final int GL_DRAW_BUFFER5                                  = 0x882A;
    public static final int GL_DRAW_BUFFER6                                  = 0x882B;
    public static final int GL_DRAW_BUFFER7                                  = 0x882C;
    public static final int GL_DRAW_BUFFER8                                  = 0x882D;
    public static final int GL_DRAW_BUFFER9                                  = 0x882E;
    public static final int GL_DRAW_FRAMEBUFFER                              = 0x8CA9;
    public static final int GL_DRAW_FRAMEBUFFER_BINDING                      = 0x8CA6;
    public static final int GL_DYNAMIC_COPY                                  = 0x88EA;
    public static final int GL_DYNAMIC_READ                                  = 0x88E9;
    public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV                = 0x8DAD;
    public static final int GL_FLOAT_MAT2x3                                  = 0x8B65;
    public static final int GL_FLOAT_MAT2x4                                  = 0x8B66;
    public static final int GL_FLOAT_MAT3x2                                  = 0x8B67;
    public static final int GL_FLOAT_MAT3x4                                  = 0x8B68;
    public static final int GL_FLOAT_MAT4x2                                  = 0x8B69;
    public static final int GL_FLOAT_MAT4x3                                  = 0x8B6A;
    public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT               = 0x8B8B;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE             = 0x8215;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE              = 0x8214;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING         = 0x8210;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE         = 0x8211;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE             = 0x8216;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE             = 0x8213;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE               = 0x8212;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE           = 0x8217;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER          = 0x8CD4;
    public static final int GL_FRAMEBUFFER_DEFAULT                           = 0x8218;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE            = 0x8D56;
    public static final int GL_HALF_FLOAT                                    = 0x140B;
    public static final int GL_INTERLEAVED_ATTRIBS                           = 0x8C8C;
    public static final int GL_INT_2_10_10_10_REV                            = 0x8D9F;
    public static final int GL_INT_SAMPLER_2D                                = 0x8DCA;
    public static final int GL_INT_SAMPLER_2D_ARRAY                          = 0x8DCF;
    public static final int GL_INT_SAMPLER_3D                                = 0x8DCB;
    public static final int GL_INT_SAMPLER_CUBE                              = 0x8DCC;
    public static final int GL_INVALID_INDEX                                 = 0xFFFFFFFF;
    public static final int GL_MAX                                           = 0x8008;
    public static final int GL_MAX_3D_TEXTURE_SIZE                           = 0x8073;
    public static final int GL_MAX_ARRAY_TEXTURE_LAYERS                      = 0x88FF;
    public static final int GL_MAX_CLIENT_WAIT_TIMEOUT_WEBGL                 = 0x9247;
    public static final int GL_MAX_COLOR_ATTACHMENTS                         = 0x8CDF;
    public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS      = 0x8A33;
    public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS                   = 0x8A2E;
    public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS        = 0x8A31;
    public static final int GL_MAX_DRAW_BUFFERS                              = 0x8824;
    public static final int GL_MAX_ELEMENTS_INDICES                          = 0x80E9;
    public static final int GL_MAX_ELEMENTS_VERTICES                         = 0x80E8;
    public static final int GL_MAX_ELEMENT_INDEX                             = 0x8D6B;
    public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS                 = 0x9125;
    public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS                   = 0x8A2D;
    public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS               = 0x8B49;
    public static final int GL_MAX_PROGRAM_TEXEL_OFFSET                      = 0x8905;
    public static final int GL_MAX_SAMPLES                                   = 0x8D57;
    public static final int GL_MAX_SERVER_WAIT_TIMEOUT                       = 0x9111;
    public static final int GL_MAX_TEXTURE_LOD_BIAS                          = 0x84FD;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 0x8C8A;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS       = 0x8C8B;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS    = 0x8C80;
    public static final int GL_MAX_UNIFORM_BLOCK_SIZE                        = 0x8A30;
    public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS                   = 0x8A2F;
    public static final int GL_MAX_VARYING_COMPONENTS                        = 0x8B4B;
    public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS                  = 0x9122;
    public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS                     = 0x8A2B;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS                 = 0x8B4A;
    public static final int GL_MIN                                           = 0x8007;
    public static final int GL_MIN_PROGRAM_TEXEL_OFFSET                      = 0x8904;
    public static final int GL_OBJECT_TYPE                                   = 0x9112;
    public static final int GL_PACK_ROW_LENGTH                               = 0x0D02;
    public static final int GL_PACK_SKIP_PIXELS                              = 0x0D04;
    public static final int GL_PACK_SKIP_ROWS                                = 0x0D03;
    public static final int GL_PIXEL_PACK_BUFFER                             = 0x88EB;
    public static final int GL_PIXEL_PACK_BUFFER_BINDING                     = 0x88ED;
    public static final int GL_PIXEL_UNPACK_BUFFER                           = 0x88EC;
    public static final int GL_PIXEL_UNPACK_BUFFER_BINDING                   = 0x88EF;
    public static final int GL_QUERY_RESULT                                  = 0x8866;
    public static final int GL_QUERY_RESULT_AVAILABLE                        = 0x8867;
    public static final int GL_R11F_G11F_B10F                                = 0x8C3A;
    public static final int GL_R16F                                          = 0x822D;
    public static final int GL_R16I                                          = 0x8233;
    public static final int GL_R16UI                                         = 0x8234;
    public static final int GL_R32F                                          = 0x822E;
    public static final int GL_R32I                                          = 0x8235;
    public static final int GL_R32UI                                         = 0x8236;
    public static final int GL_R8                                            = 0x8229;
    public static final int GL_R8I                                           = 0x8231;
    public static final int GL_R8UI                                          = 0x8232;
    public static final int GL_R8_SNORM                                      = 0x8F94;
    public static final int GL_RASTERIZER_DISCARD                            = 0x8C89;
    public static final int GL_READ_BUFFER                                   = 0x0C02;
    public static final int GL_READ_FRAMEBUFFER                              = 0x8CA8;
    public static final int GL_READ_FRAMEBUFFER_BINDING                      = 0x8CAA;
    public static final int GL_RED                                           = 0x1903;
    public static final int GL_RED_INTEGER                                   = 0x8D94;
    public static final int GL_RENDERBUFFER_SAMPLES                          = 0x8CAB;
    public static final int GL_RG                                            = 0x8227;
    public static final int GL_RG16F                                         = 0x822F;
    public static final int GL_RG16I                                         = 0x8239;
    public static final int GL_RG16UI                                        = 0x823A;
    public static final int GL_RG32F                                         = 0x8230;
    public static final int GL_RG32I                                         = 0x823B;
    public static final int GL_RG32UI                                        = 0x823C;
    public static final int GL_RG8                                           = 0x822B;
    public static final int GL_RG8I                                          = 0x8237;
    public static final int GL_RG8UI                                         = 0x8238;
    public static final int GL_RG8_SNORM                                     = 0x8F95;
    public static final int GL_RGB10_A2                                      = 0x8059;
    public static final int GL_RGB10_A2UI                                    = 0x906F;
    public static final int GL_RGB16F                                        = 0x881B;
    public static final int GL_RGB16I                                        = 0x8D89;
    public static final int GL_RGB16UI                                       = 0x8D77;
    public static final int GL_RGB32F                                        = 0x8815;
    public static final int GL_RGB32I                                        = 0x8D83;
    public static final int GL_RGB32UI                                       = 0x8D71;
    public static final int GL_RGB8                                          = 0x8051;
    public static final int GL_RGB8I                                         = 0x8D8F;
    public static final int GL_RGB8UI                                        = 0x8D7D;
    public static final int GL_RGB8_SNORM                                    = 0x8F96;
    public static final int GL_RGB9_E5                                       = 0x8C3D;
    public static final int GL_RGBA16F                                       = 0x881A;
    public static final int GL_RGBA16I                                       = 0x8D88;
    public static final int GL_RGBA16UI                                      = 0x8D76;
    public static final int GL_RGBA32F                                       = 0x8814;
    public static final int GL_RGBA32I                                       = 0x8D82;
    public static final int GL_RGBA32UI                                      = 0x8D70;
    public static final int GL_RGBA8                                         = 0x8058;
    public static final int GL_RGBA8I                                        = 0x8D8E;
    public static final int GL_RGBA8UI                                       = 0x8D7C;
    public static final int GL_RGBA8_SNORM                                   = 0x8F97;
    public static final int GL_RGBA_INTEGER                                  = 0x8D99;
    public static final int GL_RGB_INTEGER                                   = 0x8D98;
    public static final int GL_RG_INTEGER                                    = 0x8228;
    public static final int GL_SAMPLER_2D_ARRAY                              = 0x8DC1;
    public static final int GL_SAMPLER_2D_ARRAY_SHADOW                       = 0x8DC4;
    public static final int GL_SAMPLER_2D_SHADOW                             = 0x8B62;
    public static final int GL_SAMPLER_3D                                    = 0x8B5F;
    public static final int GL_SAMPLER_BINDING                               = 0x8919;
    public static final int GL_SAMPLER_CUBE_SHADOW                           = 0x8DC5;
    public static final int GL_SEPARATE_ATTRIBS                              = 0x8C8D;
    public static final int GL_SIGNALED                                      = 0x9119;
    public static final int GL_SIGNED_NORMALIZED                             = 0x8F9C;
    public static final int GL_SRGB                                          = 0x8C40;
    public static final int GL_SRGB8                                         = 0x8C41;
    public static final int GL_SRGB8_ALPHA8                                  = 0x8C43;
    public static final int GL_STATIC_COPY                                   = 0x88E6;
    public static final int GL_STATIC_READ                                   = 0x88E5;
    public static final int GL_STENCIL                                       = 0x1802;
    public static final int GL_STREAM_COPY                                   = 0x88E2;
    public static final int GL_STREAM_READ                                   = 0x88E1;
    public static final int GL_SYNC_CONDITION                                = 0x9113;
    public static final int GL_SYNC_FENCE                                    = 0x9116;
    public static final int GL_SYNC_FLAGS                                    = 0x9115;
    public static final int GL_SYNC_FLUSH_COMMANDS_BIT                       = 0x0001;
    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE                    = 0x9117;
    public static final int GL_SYNC_STATUS                                   = 0x9114;
    public static final int GL_TEXTURE_2D_ARRAY                              = 0x8C1A;
    public static final int GL_TEXTURE_3D                                    = 0x806F;
    public static final int GL_TEXTURE_BASE_LEVEL                            = 0x813C;
    public static final int GL_TEXTURE_BINDING_2D_ARRAY                      = 0x8C1D;
    public static final int GL_TEXTURE_BINDING_3D                            = 0x806A;
    public static final int GL_TEXTURE_COMPARE_FUNC                          = 0x884D;
    public static final int GL_TEXTURE_COMPARE_MODE                          = 0x884C;
    public static final int GL_TEXTURE_IMMUTABLE_FORMAT                      = 0x912F;
    public static final int GL_TEXTURE_IMMUTABLE_LEVELS                      = 0x82DF;
    public static final int GL_TEXTURE_MAX_LEVEL                             = 0x813D;
    public static final int GL_TEXTURE_MAX_LOD                               = 0x813B;
    public static final int GL_TEXTURE_MIN_LOD                               = 0x813A;
    public static final int GL_TEXTURE_WRAP_R                                = 0x8072;
    public static final int GL_TIMEOUT_EXPIRED                               = 0x911B;
    public static final int GL_TIMEOUT_IGNORED                               = -1;
    public static final int GL_TRANSFORM_FEEDBACK                            = 0x8E22;
    public static final int GL_TRANSFORM_FEEDBACK_ACTIVE                     = 0x8E24;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING                    = 0x8E25;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER                     = 0x8C8E;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING             = 0x8C8F;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE                = 0x8C7F;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE                = 0x8C85;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START               = 0x8C84;
    public static final int GL_TRANSFORM_FEEDBACK_PAUSED                     = 0x8E23;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN         = 0x8C88;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS                   = 0x8C83;
    public static final int GL_UNIFORM_ARRAY_STRIDE                          = 0x8A3C;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS                 = 0x8A42;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES          = 0x8A43;
    public static final int GL_UNIFORM_BLOCK_BINDING                         = 0x8A3F;
    public static final int GL_UNIFORM_BLOCK_DATA_SIZE                       = 0x8A40;
    public static final int GL_UNIFORM_BLOCK_INDEX                           = 0x8A3A;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER   = 0x8A46;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER     = 0x8A44;
    public static final int GL_UNIFORM_BUFFER                                = 0x8A11;
    public static final int GL_UNIFORM_BUFFER_BINDING                        = 0x8A28;
    public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT               = 0x8A34;
    public static final int GL_UNIFORM_BUFFER_SIZE                           = 0x8A2A;
    public static final int GL_UNIFORM_BUFFER_START                          = 0x8A29;
    public static final int GL_UNIFORM_IS_ROW_MAJOR                          = 0x8A3E;
    public static final int GL_UNIFORM_MATRIX_STRIDE                         = 0x8A3D;
    public static final int GL_UNIFORM_OFFSET                                = 0x8A3B;
    public static final int GL_UNIFORM_SIZE                                  = 0x8A38;
    public static final int GL_UNIFORM_TYPE                                  = 0x8A37;
    public static final int GL_UNPACK_IMAGE_HEIGHT                           = 0x806E;
    public static final int GL_UNPACK_ROW_LENGTH                             = 0x0CF2;
    public static final int GL_UNPACK_SKIP_IMAGES                            = 0x806D;
    public static final int GL_UNPACK_SKIP_PIXELS                            = 0x0CF4;
    public static final int GL_UNPACK_SKIP_ROWS                              = 0x0CF3;
    public static final int GL_UNSIGNALED                                    = 0x9118;
    public static final int GL_UNSIGNED_INT_10F_11F_11F_REV                  = 0x8C3B;
    public static final int GL_UNSIGNED_INT_24_8                             = 0x84FA;
    public static final int GL_UNSIGNED_INT_2_10_10_10_REV                   = 0x8368;
    public static final int GL_UNSIGNED_INT_5_9_9_9_REV                      = 0x8C3E;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D                       = 0x8DD2;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY                 = 0x8DD7;
    public static final int GL_UNSIGNED_INT_SAMPLER_3D                       = 0x8DD3;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE                     = 0x8DD4;
    public static final int GL_UNSIGNED_INT_VEC2                             = 0x8DC6;
    public static final int GL_UNSIGNED_INT_VEC3                             = 0x8DC7;
    public static final int GL_UNSIGNED_INT_VEC4                             = 0x8DC8;
    public static final int GL_UNSIGNED_NORMALIZED                           = 0x8C17;
    public static final int GL_VERTEX_ARRAY_BINDING                          = 0x85B5;
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR                   = 0x88FE;
    public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER                   = 0x88FD;
    public static final int GL_WAIT_FAILED                                   = 0x911D;

    /* Prevent instantiation */
    private WebGL20()
    {
    }

    private static void checkContextCompatibility()
    {
        if (!isContextCompatible())
            throw new IllegalStateException("The context should be created before invoking the GL functions");
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
                $wnd.gl = canvas.getContext("webgl2", attributes) || canvas.getContext("experimental-webgl2", attributes);
            else
                $wnd.gl = canvas.getContext("webgl2") || canvas.getContext("experimental-webgl2");

            $wnd.attribs = $wnd.gl.getContextAttributes();
            $wnd.glv = 2.0;
        }
        catch (e)
        {
            alert(e);

            $wnd.alert("Your browser doesn't appear to support WebGL 2. Try upgrading your browser.");
            $wnd.location.href = 'http://get.webgl.org/';
        }

        return $wnd.context = {
            gl: $wnd.gl,
            attribs: $wnd.attribs,
            glv: $wnd.glv
        };
    }-*/;

    public static void glBeginQuery(int target, int query)
    {
        checkContextCompatibility();
        nglBeginQuery(target, WebGLObjectMap.get().toQuery(query));
    }

    public static void glBeginTransformFeedback(int primitiveMode)
    {
        checkContextCompatibility();
        nglBeginTransformFeedback(primitiveMode);
    }

    public static void glBindBufferBase(int target, int index, int buffer)
    {
        checkContextCompatibility();
        nglBindBufferBase(target, index, WebGLObjectMap.get().toBuffer(buffer));
    }

    public static void glBindBufferRange(int target, int index, int buffer, int offset, int size)
    {
        checkContextCompatibility();
        nglBindBufferRange(target, index, WebGLObjectMap.get().toBuffer(buffer), offset, size);
    }

    public static void glBindSampler(int unit, int sampler)
    {
        checkContextCompatibility();
        nglBindSampler(unit, WebGLObjectMap.get().toSampler(sampler));
    }

    public static void glBindTransformFeedback(int target, int transformFeedback)
    {
        checkContextCompatibility();
        nglBindTransformFeedback(target, WebGLObjectMap.get().toTransformFeedback(transformFeedback));
    }

    public static void glBindVertexArray(int vertexArray)
    {
        checkContextCompatibility();
        nglBindVertexArray(WebGLObjectMap.get().toVertexArrayObject(vertexArray));
    }

    public static void glBlitFramebuffer(int srcX0, int srcY0,
                                         int srcX1, int srcY1,
                                         int dstX0, int dstY0,
                                         int dstX1, int dstY1, int mask, int filter)
    {
        checkContextCompatibility();
        nglBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
    }

    public static void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil)
    {
        checkContextCompatibility();
        nglClearBufferfi(buffer, drawbuffer, depth, stencil);
    }

    public static void glClearBufferfv(int buffer, int drawbuffer, Float32Array source)
    {
        checkContextCompatibility();
        nglClearBufferfv(buffer, drawbuffer, source);
    }

    public static void glClearBufferiv(int buffer, int drawbuffer, Int32Array source)
    {
        checkContextCompatibility();
        nglClearBufferiv(buffer, drawbuffer, source);
    }

    public static void glClearBufferuiv(int buffer, int drawbuffer, Uint32Array source)
    {
        checkContextCompatibility();
        nglClearBufferuiv(buffer, drawbuffer, source);
    }

    public static int glClientWaitSync(int sync, int flags, int timeout)
    {
        checkContextCompatibility();
        return nglClientWaitSync(WebGLObjectMap.get().toSync(sync), flags, timeout);
    }

    public static void glCompressedTexImage3D(int target, int level, int internalFormat,
                                              int width, int height, int depth,
                                              int border, ArrayBufferView data)
    {
        checkContextCompatibility();
        nglCompressedTexImage3D(target, level, internalFormat, width, height, depth, border, data);
    }

    public static void glCompressedTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                                 int width, int height, int depth,
                                                 int format, ArrayBufferView data)
    {
        checkContextCompatibility();
        nglCompressedTexSubImage3D(target, level, xOffset, yOffset, zOffset, width, height, depth, format, data);
    }

    public static void glCopyBufferSubData(int readTarget, int writeTarget, int readOffset, int writeOffset, int size)
    {
        checkContextCompatibility();
        nglCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
    }

    public static void glCopyTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                           int x, int y, int width, int height)
    {
        checkContextCompatibility();
        nglCopyTexSubImage3D(target, level, xOffset, yOffset, zOffset, x, y, width, height);
    }

    public static int glCreateQuery()
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createQuery(nglCreateQuery());
    }

    public static int glCreateSampler()
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createSampler(nglCreateSampler());
    }

    public static int glCreateTransformFeedback()
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createTransformFeedback(nglCreateTransformFeedback());
    }

    public static int glCreateVertexArray()
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createVertexArrayObject(nglCreateVertexArray());
    }

    public static void glDeleteQuery(int query)
    {
        checkContextCompatibility();

        nglDeleteQuery(WebGLObjectMap.get().toQuery(query));
        WebGLObjectMap.get().deleteQuery(query);
    }

    public static void glDeleteSampler(int sampler)
    {
        checkContextCompatibility();
        nglDeleteSampler(WebGLObjectMap.get().toSampler(sampler));
        WebGLObjectMap.get().deleteSampler(sampler);
    }

    public static void glDeleteSync(int sync)
    {
        checkContextCompatibility();
        nglDeleteSync(WebGLObjectMap.get().toSync(sync));
        WebGLObjectMap.get().deleteSync(sync);
    }

    public static void glDeleteTransformFeedback(int transformFeedback)
    {
        checkContextCompatibility();
        nglDeleteTransformFeedback(WebGLObjectMap.get().toTransformFeedback(transformFeedback));
        WebGLObjectMap.get().deleteTransformFeedback(transformFeedback);
    }

    public static void glDeleteVertexArray(int vertexArray)
    {
        checkContextCompatibility();
        nglDeleteVertexArray(WebGLObjectMap.get().toVertexArrayObject(vertexArray));
        WebGLObjectMap.get().deleteVertexArrayObject(vertexArray);
    }

    public static void glDrawArraysInstanced(int mode, int first, int count, int instanceCount)
    {
        checkContextCompatibility();
        nglDrawArraysInstanced(mode, first, count, instanceCount);
    }

    public static void glDrawBuffers(Uint32Array buffers)
    {
        checkContextCompatibility();
        nglDrawBuffers(buffers);
    }

    public static void glDrawElementsInstanced(int mode, int count, int type, int offset, int instanceCount)
    {
        checkContextCompatibility();
        nglDrawElementsInstanced(mode, count, type, offset, instanceCount);
    }

    public static void glDrawRangeElements(int mode, int start, int end, int count, int type, int offset)
    {
        checkContextCompatibility();
        nglDrawRangeElements(mode, start, end, count, type, offset);
    }

    public static void glEndQuery(int target)
    {
        checkContextCompatibility();
        nglEndQuery(target);
    }

    public static void glEndTransformFeedback()
    {
        checkContextCompatibility();
        nglEndTransformFeedback();
    }

    public static int glFenceSync(int condition, int flags)
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createSync(nglFenceSync(condition, flags));
    }

    public static void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer)
    {
        checkContextCompatibility();
        JavaScriptObject textureObj = WebGLObjectMap.get().toTexture(texture);
        nglFramebufferTextureLayer(target, attachment, textureObj, level, layer);
    }

    public static String glGetActiveUniformBlockName(int program, int uniformBlockIndex)
    {
        checkContextCompatibility();
        return nglGetActiveUniformBlockName(WebGLObjectMap.get().toProgram(program), uniformBlockIndex);
    }

    public static <T> T glGetActiveUniformBlockParameter(int program, int uniformBlockIndex, int pname)
    {
        checkContextCompatibility();
        return nglGetActiveUniformBlockParameter(WebGLObjectMap.get().toProgram(program), uniformBlockIndex, pname);
    }

    public static Int32Array glGetActiveUniforms(int program, Uint32Array uniformIndices, int pname)
    {
        checkContextCompatibility();
        return nglGetActiveUniforms(WebGLObjectMap.get().toProgram(program), uniformIndices, pname);
    }

    public static Int32Array glGetActiveUniforms(int program, List<Integer> uniformIndices, int pname)
    {
        Uint32Array indices = Uint32ArrayNative.create(uniformIndices.size());

        for (int i = 0; i < uniformIndices.size(); i++)
            indices.set(i, uniformIndices.get(i));

        return glGetActiveUniforms(program, indices, pname);
    }

    public static Int32Array glGetActiveUniforms(int program, int[] uniformIndices, int pname)
    {
        Uint32Array indices = Uint32ArrayNative.create(uniformIndices.length);

        for (int i = 0; i < uniformIndices.length; i++)
            indices.set(i, uniformIndices[i]);

        return glGetActiveUniforms(program, indices, pname);
    }

    public static void glGetBufferSubData(int target, int offset, ArrayBufferView returnedData)
    {
        checkContextCompatibility();
        nglGetBufferSubData(target, offset, returnedData);
    }

    public static int glGetFragDataLocation(int program, String name)
    {
        checkContextCompatibility();
        return nglGetFragDataLocation(WebGLObjectMap.get().toProgram(program), name);
    }

    @SuppressWarnings("unchecked")
    public static <T> T glGetIndexedParameter(int target, int index)
    {
        checkContextCompatibility();

        if (target == GL_TRANSFORM_FEEDBACK_BUFFER_BINDING || target == GL_UNIFORM_BUFFER_BINDING)
            return (T) (Integer) WebGLObjectMap.get().createBuffer((JavaScriptObject) nglGetIndexedParameter(target, index));
        else
            return nglGetIndexedParameter(target, index);
    }

    public static Int32Array glGetInternalformatParameter(int target, int internalFormat, int pName)
    {
        checkContextCompatibility();
        return nglGetInternalformatParameter(target, internalFormat, pName);
    }

    public static int glGetQuery(int target, int pname)
    {
        checkContextCompatibility();
        return WebGLObjectMap.get().createQuery(nglGetQuery(target, pname));
    }

    public static <T> T glGetQueryParameter(int query, int pname)
    {
        checkContextCompatibility();
        return nglGetQueryParameter(WebGLObjectMap.get().toQuery(query), pname);
    }

    public static <T> T glGetSamplerParameter(int sampler, int pname)
    {
        checkContextCompatibility();
        return nglGetSamplerParameter(WebGLObjectMap.get().toSampler(sampler), pname);
    }

    public static int glGetSyncParameter(int sync, int pname)
    {
        checkContextCompatibility();
        return nglGetSyncParameter(WebGLObjectMap.get().toSync(sync), pname);
    }

    public static WebGL10.ActiveInfo glGetTransformFeedbackVarying(int program, int index)
    {
        checkContextCompatibility();
        return nglGetTransformFeedbackVarying(WebGLObjectMap.get().toProgram(program), index);
    }

    public static int glGetUniformBlockIndex(int program, String uniformBlockName)
    {
        checkContextCompatibility();
        return nglGetUniformBlockIndex(WebGLObjectMap.get().toProgram(program), uniformBlockName);
    }

    public static Uint32Array glGetUniformIndices(int program, JsArrayString uniformNames)
    {
        checkContextCompatibility();
        return nglGetUniformIndices(WebGLObjectMap.get().toBuffer(program), uniformNames);
    }

    public static Uint32Array glGetUniformIndices(int program, List<String> uniformNames)
    {
        JsArrayString arrayString = JsArrayString.createArray(uniformNames.size()).cast();

        for (String uniformName : uniformNames)
            arrayString.push(uniformName);

        return glGetUniformIndices(program, arrayString);
    }

    public static Uint32Array glGetUniformIndices(int program, String... uniformNames)
    {
        JsArrayString arrayString = JsArrayString.createArray(uniformNames.length).cast();

        for (String uniformName : uniformNames)
            arrayString.push(uniformName);

        return glGetUniformIndices(program, arrayString);
    }

    @SuppressWarnings("unchecked")
    public static <T> T glGetVertexAttrib(int index, int pname)
    {
        checkContextCompatibility();

        Object value = nglGetVertexAttrib(index, pname);

        if (pname == GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING)
            return (T) (Integer) WebGLObjectMap.get().createBuffer((JavaScriptObject) value);

        return nglGetVertexAttrib(index, pname);
    }

    public static void glInvalidateFramebuffer(int target, ArrayBufferView attachments)
    {
        checkContextCompatibility();
        nglInvalidateFramebuffer(target, attachments);
    }

    public static void glInvalidateSubFramebuffer(int target, ArrayBufferView attachments, int x, int y, int w, int h)
    {
        checkContextCompatibility();
        nglInvalidateSubFramebuffer(target, attachments, x, y, w, h);
    }

    @WebGLContext.HandlesContextLoss
    public static boolean glIsQuery(int query)
    {
        checkContextCompatibility();
        return nglIsQuery(WebGLObjectMap.get().toQuery(query));
    }

    @WebGLContext.HandlesContextLoss
    public static boolean glIsSampler(int sampler)
    {
        checkContextCompatibility();
        return nglIsSampler(WebGLObjectMap.get().toSampler(sampler));
    }

    @WebGLContext.HandlesContextLoss
    public static boolean glIsSync(int sync)
    {
        checkContextCompatibility();
        return nglIsSync(WebGLObjectMap.get().toSync(sync));
    }

    @WebGLContext.HandlesContextLoss
    public static boolean glIsTransformFeedback(int transformFeedback)
    {
        checkContextCompatibility();
        return nglIsTransformFeedback(WebGLObjectMap.get().toTransformFeedback(transformFeedback));
    }

    @WebGLContext.HandlesContextLoss
    public static boolean glIsVertexArray(int vertexArray)
    {
        checkContextCompatibility();
        return nglIsVertexArray(WebGLObjectMap.get().toVertexArrayObject(vertexArray));
    }

    public static void glPauseTransformFeedback()
    {
        checkContextCompatibility();
        nglPauseTransformFeedback();
    }

    public static void glReadBuffer(int src)
    {
        checkContextCompatibility();
        nglReadBuffer(src);
    }

    public static void glRenderbufferStorageMultisample(int target, int samples, int internalFormat, int width, int height)
    {
        checkContextCompatibility();
        nglRenderbufferStorageMultisample(target, samples, internalFormat, width, height);
    }

    public static void glResumeTransformFeedback()
    {
        checkContextCompatibility();
        nglResumeTransformFeedback();
    }

    public static void glSamplerParameterf(int sampler, int pname, float param)
    {
        checkContextCompatibility();
        nglSamplerParameterf(WebGLObjectMap.get().toSampler(sampler), pname, param);
    }

    public static void glSamplerParameteri(int sampler, int pname, int param)
    {
        checkContextCompatibility();
        nglSamplerParameteri(WebGLObjectMap.get().toSampler(sampler), pname, param);
    }

    public static void glTexImage3D(int target, int level, int internalFormat, int width, int height, int depth,
                                    int border, int format, int type, ArrayBufferView pixels)
    {
        checkContextCompatibility();
        nglTexImage3D(target, level, internalFormat, width, height, depth, border, format, type, pixels);
    }

    public static void glTexStorage2D(int target, int levels, int internalFormat, int width, int height)
    {
        checkContextCompatibility();
        nglTexStorage2D(target, levels, internalFormat, width, height);
    }

    public static void glTexStorage3D(int target, int levels, int internalFormat, int width, int height, int depth)
    {
        checkContextCompatibility();
        nglTexStorage3D(target, levels, internalFormat, width, height, depth);
    }

    public static void glTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                       int width, int height, int depth, int format, int type,
                                       ArrayBufferView pixels)
    {
        checkContextCompatibility();
        nglTexSubImage3D(target, level, xOffset, yOffset, zOffset, width, height, depth, format, type, pixels);
    }

    public static void glTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                       int format, int type, JavaScriptObject pixels)
    {
        checkContextCompatibility();
        nglTexSubImage3D(target, level, xOffset, yOffset, zOffset, format, type, pixels);
    }

    public static void glTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                       int format, int type, ImageData pixels)
    {
        checkContextCompatibility();
        nglTexSubImage3D(target, level, xOffset, yOffset, zOffset, format, type, pixels);
    }

    public static void glTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                       int format, int type, Image pixels)
    {
        checkContextCompatibility();
        nglTexSubImage3D(target, level, xOffset, yOffset, zOffset, format, type, pixels.getElement());
    }

    public static void glTransformFeedbackVaryings(int program, JsArrayString varyings, int bufferMode)
    {
        checkContextCompatibility();
        nglTransformFeedbackVaryings(WebGLObjectMap.get().toProgram(program), varyings, bufferMode);
    }

    public static void glTransformFeedbackVaryings(int program, String[] varyings, int bufferMode)
    {
        JsArrayString varyingsArray = JsArrayString.createArray(varyings.length).cast();

        for (String varying : varyings)
            varyingsArray.push(varying);

        glTransformFeedbackVaryings(program, varyingsArray, bufferMode);
    }

    public static void glTransformFeedbackVaryings(int program, List<String> varyings, int bufferMode)
    {
        JsArrayString varyingsArray = JsArrayString.createArray(varyings.size()).cast();

        for (String varying : varyings)
            varyingsArray.push(varying);

        glTransformFeedbackVaryings(program, varyingsArray, bufferMode);
    }

    public static void glUniform1ui(int location, int v0)
    {
        checkContextCompatibility();
        nglUniform1ui(WebGLObjectMap.get().toUniform(location), v0);
    }

    public static void glUniform1uiv(int location, Uint32Array value)
    {
        checkContextCompatibility();
        nglUniform1uiv(WebGLObjectMap.get().toUniform(location), value);
    }

    public static void glUniform2ui(int location, int v0, int v1)
    {
        checkContextCompatibility();
        nglUniform2ui(WebGLObjectMap.get().toUniform(location), v0, v1);
    }

    public static void glUniform2uiv(int location, Uint32Array value)
    {
        checkContextCompatibility();
        nglUniform2uiv(WebGLObjectMap.get().toUniform(location), value);
    }

    public static void glUniform3ui(int location, int v0, int v1, int v2)
    {
        checkContextCompatibility();
        nglUniform3ui(WebGLObjectMap.get().toUniform(location), v0, v1, v2);
    }

    public static void glUniform3uiv(int location, Uint32Array value)
    {
        checkContextCompatibility();
        nglUniform3uiv(WebGLObjectMap.get().toUniform(location), value);
    }

    public static void glUniform4ui(int location, int v0, int v1, int v2, int v3)
    {
        checkContextCompatibility();
        nglUniform4ui(WebGLObjectMap.get().toUniform(location), v0, v1, v2, v3);
    }

    public static void glUniform4uiv(int location, Uint32Array value)
    {
        checkContextCompatibility();
        nglUniform4uiv(WebGLObjectMap.get().toUniform(location), value);
    }

    public static void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding)
    {
        checkContextCompatibility();
        nglUniformBlockBinding(WebGLObjectMap.get().toProgram(program), uniformBlockIndex, uniformBlockBinding);
    }

    public static void glUniformMatrix2x3fv(int location, boolean transpose, Float32Array value)
    {
        checkContextCompatibility();
        nglUniformMatrix2x3fv(WebGLObjectMap.get().toUniform(location), transpose, value);
    }

    public static void glUniformMatrix2x4fv(int location, boolean transpose, Float32Array value)
    {
        checkContextCompatibility();
        nglUniformMatrix2x4fv(WebGLObjectMap.get().toUniform(location), transpose, value);
    }

    public static void glUniformMatrix3x2fv(int location, boolean transpose, Float32Array value)
    {
        checkContextCompatibility();
        nglUniformMatrix3x2fv(WebGLObjectMap.get().toUniform(location), transpose, value);
    }

    public static void glUniformMatrix3x4fv(int location, boolean transpose, Float32Array value)
    {
        checkContextCompatibility();
        nglUniformMatrix3x4fv(WebGLObjectMap.get().toUniform(location), transpose, value);
    }

    public static void glUniformMatrix4x2fv(int location, boolean transpose, Float32Array value)
    {
        checkContextCompatibility();
        nglUniformMatrix4x2fv(WebGLObjectMap.get().toUniform(location), transpose, value);
    }

    public static void glUniformMatrix4x3fv(int location, boolean transpose, Float32Array value)
    {
        checkContextCompatibility();
        nglUniformMatrix4x3fv(WebGLObjectMap.get().toUniform(location), transpose, value);
    }

    public static void glVertexAttribDivisor(int index, int divisor)
    {
        checkContextCompatibility();
        nglVertexAttribDivisor(index, divisor);
    }

    public static void glVertexAttribI4i(int index, int x, int y, int z, int w)
    {
        checkContextCompatibility();
        nglVertexAttribI4i(index, x, y, z, w);
    }

    public static void glVertexAttribI4iv(int index, Int32Array value)
    {
        checkContextCompatibility();
        nglVertexAttribI4iv(index, value);
    }

    public static void glVertexAttribI4ui(int index, int x, int y, int z, int w)
    {
        checkContextCompatibility();
        nglVertexAttribI4ui(index, x, y, z, w);
    }

    public static void glVertexAttribI4uiv(int index, Int32Array value)
    {
        checkContextCompatibility();
        nglVertexAttribI4uiv(index, value);
    }

    public static void glVertexAttribIPointer(int index, int size, int type, int stride, int offset)
    {
        checkContextCompatibility();
        nglVertexAttribIPointer(index, size, type, stride, offset);
    }

    public static void glWaitSync(int sync, int flags, int timeout)
    {
        checkContextCompatibility();
        nglWaitSync(WebGLObjectMap.get().toSync(sync), flags, timeout);
    }

    public static boolean isContextCompatible()
    {
        return WebGLContext.getCurrent() != null && WebGLContext.getCurrent().getVersion() >= 2.0;
    }

    public static boolean isSupported()
    {
        return isContextCompatible() || nIsSupported();
    }

    private static native boolean nIsSupported() /*-{
        try
        {
            var canvas = $doc.createElement('canvas');
            return !!( $wnd.WebGLRenderingContext && (canvas.getContext('webgl2') ||
            canvas.getContext('experimental-webgl2')));
        }
        catch (e)
        {
            $wnd.console.log(e);
            return false;
        }
    }-*/;

    private static native void nglBeginQuery(int target, JavaScriptObject query) /*-{
        $wnd.gl.beginQuery(target, query);
    }-*/;

    private static native void nglBeginTransformFeedback(int primitiveMode) /*-{
        $wnd.gl.beginTransformFeedback(primitiveMode);
    }-*/;

    private static native void nglBindBufferBase(int target, int index, JavaScriptObject buffer) /*-{
        $wnd.gl.bindBufferBase(target, index, buffer);
    }-*/;

    private static native void nglBindBufferRange(int target, int index, JavaScriptObject buffer, int offset, int size) /*-{
        $wnd.gl.bindBufferRange(target, index, buffer, offset, size);
    }-*/;

    private static native void nglBindSampler(int unit, JavaScriptObject sampler) /*-{
        $wnd.gl.bindSampler(unit, sampler);
    }-*/;

    private static native void nglBindTransformFeedback(int target, JavaScriptObject transformFeedback) /*-{
        $wnd.gl.bindTransformFeedback(target, transformFeedback);
    }-*/;

    private static native void nglBindVertexArray(JavaScriptObject vertexArray) /*-{
        $wnd.gl.bindVertexArray(vertexArray);
    }-*/;

    private static native void nglBlitFramebuffer(int srcX0, int srcY0,
                                                  int srcX1, int srcY1,
                                                  int dstX0, int dstY0,
                                                  int dstX1, int dstY1, int mask, int filter) /*-{
        $wnd.gl.blitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
    }-*/;

    private static native void nglClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) /*-{
        $wnd.gl.clearBufferfi(buffer, drawbuffer, depth, stencil);
    }-*/;

    private static native void nglClearBufferfv(int buffer, int drawbuffer, Float32Array source) /*-{
        $wnd.gl.clearBufferfv(buffer, drawbuffer, source);
    }-*/;

    private static native void nglClearBufferiv(int buffer, int drawbuffer, Int32Array source) /*-{
        $wnd.gl.clearBufferiv(buffer, drawbuffer, source);
    }-*/;

    private static native void nglClearBufferuiv(int buffer, int drawbuffer, Uint32Array source) /*-{
        $wnd.gl.clearBufferuiv(buffer, drawbuffer, source);
    }-*/;

    private static native int nglClientWaitSync(JavaScriptObject sync, int flags, int timeout) /*-{
        return $wnd.gl.clientWaitSync(sync, flags, timeout);
    }-*/;

    private static native void nglCompressedTexImage3D(int target, int level, int internalFormat,
                                                       int width, int height, int depth,
                                                       int border, ArrayBufferView data) /*-{
        $wnd.gl.compressedTexImage3D(target, level, internalFormat, width, height, depth, border, data);
    }-*/;

    private static native void nglCompressedTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                                          int width, int height, int depth,
                                                          int format, ArrayBufferView data) /*-{
        $wnd.gl.compressedTexSubImage3D(target, level, xOffset, yOffset, zOffset, width, height, data, format, data);
    }-*/;

    private static native void nglCopyBufferSubData(int readTarget, int writeTarget, int readOffset, int writeOffset, int size) /*-{
        $wnd.gl.copyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
    }-*/;

    private static native void nglCopyTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                                    int x, int y, int width, int height) /*-{
        $wnd.gl.copyTexSubImage3D(target, level, xOffset, yOffset, zOffset, x, y, width, height);
    }-*/;

    private static native JavaScriptObject nglCreateQuery() /*-{
        return $wnd.gl.createQuery();
    }-*/;

    private static native JavaScriptObject nglCreateSampler() /*-{
        return $wnd.gl.createSampler();
    }-*/;

    private static native JavaScriptObject nglCreateTransformFeedback() /*-{
        return $wnd.gl.createTransformFeedback();
    }-*/;

    private static native JavaScriptObject nglCreateVertexArray() /*-{
        return $wnd.gl.createVertexArray();
    }-*/;

    private static native void nglDeleteQuery(JavaScriptObject query) /*-{
        $wnd.gl.deleteQuery(query);
    }-*/;

    private static native void nglDeleteSampler(JavaScriptObject sampler) /*-{
        $wnd.gl.deleteSampler(sampler);
    }-*/;

    private static native void nglDeleteSync(JavaScriptObject sync) /*-{
        $wnd.gl.deleteSync(sync);
    }-*/;

    public static native void nglDeleteTransformFeedback(JavaScriptObject transformFeedback) /*-{
        $wnd.gl.deleteTransformFeedback(transformFeedback);
    }-*/;

    private static native void nglDeleteVertexArray(JavaScriptObject vertexArray) /*-{
        $wnd.gl.deleteVertexArray(vertexArray);
    }-*/;

    private static native void nglDrawArraysInstanced(int mode, int first, int count, int instanceCount) /*-{
        $wnd.gl.drawArraysInstanced(mode, first, count, instanceCount);
    }-*/;

    private static native void nglDrawBuffers(Uint32Array buffers) /*-{
        $wnd.gl.drawBuffers(buffers);
    }-*/;

    private static native void nglDrawElementsInstanced(int mode, int count, int type, int offset, int instanceCount) /*-{
        $wnd.gl.drawElementsInstanced(mode, count, type, offset, instanceCount);
    }-*/;

    private static native void nglDrawRangeElements(int mode, int start, int end, int count, int type, int offset) /*-{
        $wnd.gl.drawRangeElements(mode, start, end, count, type, offset);
    }-*/;

    private static native void nglEndQuery(int target) /*-{
        $wnd.gl.endQuery(target);
    }-*/;

    private static native void nglEndTransformFeedback() /*-{
        $wnd.gl.endTransformFeedback();
    }-*/;

    private static native JavaScriptObject nglFenceSync(int condition, int flags) /*-{
        return $wnd.gl.fenceSync(condition, flags);
    }-*/;

    private static native void nglFramebufferTextureLayer(int target, int attachment, JavaScriptObject texture, int level, int layer) /*-{
        $wnd.gl.framebufferTextureLayer(target, attachment, texture, level, layer);
    }-*/;

    private static native String nglGetActiveUniformBlockName(JavaScriptObject program, int uniformBlockIndex) /*-{
        return $wnd.gl.getActiveUniformBlockName(program, uniformBlockIndex);
    }-*/;

    private static native <T> T nglGetActiveUniformBlockParameter(JavaScriptObject program, int uniformBlockIndex, int pname) /*-{
        var value = $wnd.gl.getActiveUniformBlockParameter(program, uniformBlockIndex, pname);

        switch (pname)
        {
            case @com.shc.webgl4j.client.WebGL20::GL_UNIFORM_BLOCK_BINDING:
            case @com.shc.webgl4j.client.WebGL20::GL_UNIFORM_BLOCK_DATA_SIZE:
            case @com.shc.webgl4j.client.WebGL20::GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS:
                return @java.lang.Integer::valueOf(I)(value);

            case @com.shc.webgl4j.client.WebGL20::GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER:
            case @com.shc.webgl4j.client.WebGL20::GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER:
                return @java.lang.Boolean::valueOf(Z)(value);
        }

        return value;
    }-*/;

    private static native Int32Array nglGetActiveUniforms(JavaScriptObject program, Uint32Array uniformIndices, int pname) /*-{
        return $wnd.gl.getActiveUniforms(program, uniformIndices, pname);
    }-*/;

    private static native void nglGetBufferSubData(int target, int offset, ArrayBufferView returnedData) /*-{
        $wnd.gl.getBufferSubData(target, offset, returnedData);
    }-*/;

    private static native int nglGetFragDataLocation(JavaScriptObject program, String name) /*-{
        return $wnd.gl.getFragDataLocation(program, name);
    }-*/;

    private static native <T> T nglGetIndexedParameter(int target, int index) /*-{
        var value = $wnd.gl.getIndexedParameter(target, index);

        switch (value)
        {
            case @com.shc.webgl4j.client.WebGL20::GL_UNIFORM_BUFFER_SIZE:
            case @com.shc.webgl4j.client.WebGL20::GL_UNIFORM_BUFFER_START:
            case @com.shc.webgl4j.client.WebGL20::GL_TRANSFORM_FEEDBACK_BUFFER_SIZE:
            case @com.shc.webgl4j.client.WebGL20::GL_TRANSFORM_FEEDBACK_BUFFER_START:
                return @java.lang.Integer::valueOf(I)(value);
        }

        return value;
    }-*/;

    private static native Int32Array nglGetInternalformatParameter(int target, int internalFormat, int pName) /*-{
        return $wnd.gl.getInternalformatParameter(target, internalFormat, pName);
    }-*/;

    private static native JavaScriptObject nglGetQuery(int target, int pname) /*-{
        return $wnd.gl.getQuery(target, pname);
    }-*/;

    private static native <T> T nglGetQueryParameter(JavaScriptObject query, int pname) /*-{
        var value = $wnd.gl.getQueryParameter(query, pname);

        if (value != null)
        {
            switch (pname)
            {
                case @com.shc.webgl4j.client.WebGL20::GL_QUERY_RESULT:
                    return @java.lang.Integer::valueOf(I)(value);

                case @com.shc.webgl4j.client.WebGL20::GL_QUERY_RESULT_AVAILABLE:
                    return @java.lang.Boolean::valueOf(Z)(value);
            }
        }

        return value;
    }-*/;

    private static native <T> T nglGetSamplerParameter(JavaScriptObject sampler, int pname) /*-{
        var value = $wnd.gl.getSamplerParameter(sampler, pname);

        switch (value)
        {
            case @com.shc.webgl4j.client.WebGL20::GL_TEXTURE_COMPARE_FUNC:
            case @com.shc.webgl4j.client.WebGL20::GL_TEXTURE_COMPARE_MODE:
            case @com.shc.webgl4j.client.WebGL10::GL_TEXTURE_MAG_FILTER:
            case @com.shc.webgl4j.client.WebGL10::GL_TEXTURE_MIN_FILTER:
            case @com.shc.webgl4j.client.WebGL20::GL_TEXTURE_WRAP_R:
            case @com.shc.webgl4j.client.WebGL10::GL_TEXTURE_WRAP_S:
            case @com.shc.webgl4j.client.WebGL10::GL_TEXTURE_WRAP_T:
                return @java.lang.Integer::valueOf(I)(value);

            case @com.shc.webgl4j.client.WebGL20::GL_TEXTURE_MAX_LOD:
            case @com.shc.webgl4j.client.WebGL20::GL_TEXTURE_MIN_LOD:
                return @java.lang.Float::valueOf(F)(value);
        }

        return value;
    }-*/;

    private static native int nglGetSyncParameter(JavaScriptObject sync, int pname) /*-{
        return $wnd.gl.getSyncParameter(sync, pname);
    }-*/;

    private static native WebGL10.ActiveInfo nglGetTransformFeedbackVarying(JavaScriptObject program, int index) /*-{
        return $wnd.gl.getTransformFeedbackVarying(program, index);
    }-*/;

    private static native int nglGetUniformBlockIndex(JavaScriptObject program, String uniformBlockName) /*-{
        return $wnd.gl.getUniformBlockIndex(program, uniformBlockName);
    }-*/;

    private static native Uint32Array nglGetUniformIndices(JavaScriptObject program, JsArrayString uniformNames) /*-{
        return $wnd.gl.getUniformIndices(program, uniformNames);
    }-*/;

    private static native <T> T nglGetVertexAttrib(int index, int pname) /*-{
        var value = $wnd.gl.getVertexAttrib(index, pname);

        switch (value)
        {
            case @com.shc.webgl4j.client.WebGL10::GL_VERTEX_ATTRIB_ARRAY_SIZE:
            case @com.shc.webgl4j.client.WebGL10::GL_VERTEX_ATTRIB_ARRAY_TYPE:
            case @com.shc.webgl4j.client.WebGL10::GL_VERTEX_ATTRIB_ARRAY_STRIDE:
            case @com.shc.webgl4j.client.WebGL20::GL_VERTEX_ATTRIB_ARRAY_DIVISOR:
                return @java.lang.Integer::valueOf(I)(value);

            case @com.shc.webgl4j.client.WebGL10::GL_VERTEX_ATTRIB_ARRAY_ENABLED:
            case @com.shc.webgl4j.client.WebGL10::GL_VERTEX_ATTRIB_ARRAY_NORMALIZED:
            case @com.shc.webgl4j.client.WebGL20::GL_VERTEX_ATTRIB_ARRAY_INTEGER:
                return @java.lang.Boolean::valueOf(Z)(value);
        }

        return value;
    }-*/;

    private static native void nglInvalidateFramebuffer(int target, ArrayBufferView attachments) /*-{
        $wnd.gl.invalidateFramebuffer(target, attachments);
    }-*/;

    private static native void nglInvalidateSubFramebuffer(int target, ArrayBufferView attachments, int x, int y, int w, int h) /*-{
        $wnd.gl.invalidateSubFramebuffer(target, attachments, x, y, w, h);
    }-*/;

    private static native boolean nglIsQuery(JavaScriptObject query) /*-{
        return $wnd.gl.isQuery(query);
    }-*/;

    private static native boolean nglIsSampler(JavaScriptObject sampler) /*-{
        return $wnd.gl.isSampler(sampler);
    }-*/;

    private static native boolean nglIsSync(JavaScriptObject sync) /*-{
        return $wnd.gl.isSync(sync);
    }-*/;

    private static native boolean nglIsTransformFeedback(JavaScriptObject transformFeedback) /*-{
        return $wnd.gl.isTransformFeedback(transformFeedback);
    }-*/;

    private static native boolean nglIsVertexArray(JavaScriptObject vertexArray) /*-{
        return $wnd.gl.isVertexArray(vertexArray);
    }-*/;

    private static native void nglPauseTransformFeedback() /*-{
        $wnd.gl.pauseTransformFeedback();
    }-*/;

    private static native void nglReadBuffer(int src) /*-{
        $wnd.gl.readBuffer(src);
    }-*/;

    private static native void nglRenderbufferStorageMultisample(int target, int samples, int internalFormat, int width, int height) /*-{
        $wnd.gl.renderbufferStorageMultisample(target, samples, internalFormat, width, height);
    }-*/;

    private static native void nglResumeTransformFeedback() /*-{
        $wnd.gl.resumeTransformFeedback();
    }-*/;

    private static native void nglSamplerParameterf(JavaScriptObject sampler, int pname, float param) /*-{
        $wnd.gl.samplerParameterf(sampler, pname, param);
    }-*/;

    private static native void nglSamplerParameteri(JavaScriptObject sampler, int pname, int param) /*-{
        $wnd.gl.samplerParameteri(sampler, pname, param);
    }-*/;

    private static native void nglTexImage3D(int target, int level, int internalFormat, int width, int height, int depth,
                                             int border, int format, int type, ArrayBufferView pixels) /*-{
        $wnd.gl.texImage3D(target, level, internalFormat, width, height, depth, border, format, type, pixels);
    }-*/;

    private static native void nglTexStorage2D(int target, int levels, int internalFormat, int width, int height) /*-{
        $wnd.gl.texStorage2D(target, levels, internalFormat, width, height);
    }-*/;

    private static native void nglTexStorage3D(int target, int levels, int internalFormat, int width, int height, int depth) /*-{
        $wnd.gl.texStorage3D(target, levels, internalFormat, width, height, depth);
    }-*/;

    private static native void nglTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                                int format, int type, JavaScriptObject pixels) /*-{
        $wnd.gl.texSubImage3D(target, level, xOffset, yOffset, zOffset, format, type, pixels);
    }-*/;

    private static native void nglTexSubImage3D(int target, int level, int xOffset, int yOffset, int zOffset,
                                                int width, int height, int depth, int format, int type,
                                                ArrayBufferView pixels) /*-{
        $wnd.gl.texSubImage3D(target, level, xOffset, yOffset, zOffset, width, height, depth, format, type, pixels);
    }-*/;

    private static native void nglTransformFeedbackVaryings(JavaScriptObject program, JsArrayString varyings, int bufferMode) /*-{
        $wnd.gl.transformFeedbackVaryings(program, varyings, bufferMode);
    }-*/;

    private static native void nglUniform1ui(JavaScriptObject location, int v0) /*-{
        $wnd.gl.uniform1ui(location, v0);
    }-*/;

    private static native void nglUniform1uiv(JavaScriptObject location, Uint32Array value) /*-{
        $wnd.gl.uniform1uiv(location, value);
    }-*/;

    private static native void nglUniform2ui(JavaScriptObject location, int v0, int v1) /*-{
        $wnd.gl.uniform2ui(location, v0, v1);
    }-*/;

    private static native void nglUniform2uiv(JavaScriptObject location, Uint32Array value) /*-{
        $wnd.gl.uniform2uiv(location, value);
    }-*/;

    private static native void nglUniform3ui(JavaScriptObject location, int v0, int v1, int v2) /*-{
        $wnd.gl.uniform3ui(location, v0, v1, v2);
    }-*/;

    private static native void nglUniform3uiv(JavaScriptObject location, Uint32Array value) /*-{
        $wnd.gl.uniform3uiv(location, value);
    }-*/;

    private static native void nglUniform4ui(JavaScriptObject location, int v0, int v1, int v2, int v3) /*-{
        $wnd.gl.uniform4ui(location, v0, v1, v2, v3);
    }-*/;

    private static native void nglUniform4uiv(JavaScriptObject location, Uint32Array value) /*-{
        $wnd.gl.uniform4uiv(location, value);
    }-*/;

    private static native void nglUniformBlockBinding(JavaScriptObject program, int uniformBlockIndex, int uniformBlockBinding) /*-{
        $wnd.gl.uniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
    }-*/;

    private static native void nglUniformMatrix2x3fv(JavaScriptObject location, boolean transpose, Float32Array value) /*-{
        $wnd.gl.uniformMatrix2x3fv(location, transpose, value);
    }-*/;

    private static native void nglUniformMatrix2x4fv(JavaScriptObject location, boolean transpose, Float32Array value) /*-{
        $wnd.gl.uniformMatrix2x4fv(location, transpose, value);
    }-*/;

    private static native void nglUniformMatrix3x2fv(JavaScriptObject location, boolean transpose, Float32Array value) /*-{
        $wnd.gl.uniformMatrix3x2fv(location, transpose, value);
    }-*/;

    private static native void nglUniformMatrix3x4fv(JavaScriptObject location, boolean transpose, Float32Array value) /*-{
        $wnd.gl.uniformMatrix3x4fv(location, transpose, value);
    }-*/;

    private static native void nglUniformMatrix4x2fv(JavaScriptObject location, boolean transpose, Float32Array value) /*-{
        $wnd.gl.uniformMatrix4x2fv(location, transpose, value);
    }-*/;

    private static native void nglUniformMatrix4x3fv(JavaScriptObject location, boolean transpose, Float32Array value) /*-{
        $wnd.gl.uniformMatrix4x3fv(location, transpose, value);
    }-*/;

    private static native void nglVertexAttribDivisor(int index, int divisor) /*-{
        $wnd.gl.vertexAttribDivisor(index, divisor);
    }-*/;

    private static native void nglVertexAttribI4i(int index, int x, int y, int z, int w) /*-{
        $wnd.gl.vertexAttribI4i(index, x, y, z, w);
    }-*/;

    private static native void nglVertexAttribI4iv(int index, Int32Array value) /*-{
        $wnd.gl.vertexAttribI4iv(index, value);
    }-*/;

    private static native void nglVertexAttribI4ui(int index, int x, int y, int z, int w) /*-{
        $wnd.gl.vertexAttribI4ui(index, x, y, z, w);
    }-*/;

    private static native void nglVertexAttribI4uiv(int index, Int32Array value) /*-{
        $wnd.gl.vertexAttribI4uiv(index, value);
    }-*/;

    private static native void nglVertexAttribIPointer(int index, int size, int type, int stride, int offset) /*-{
        $wnd.gl.vertexAttribIPointer(index, size, type, stride, offset);
    }-*/;

    private static native void nglWaitSync(JavaScriptObject sync, int flags, int timeout) /*-{
        $wnd.gl.waitSync(sync, flags, timeout);
    }-*/;
}
