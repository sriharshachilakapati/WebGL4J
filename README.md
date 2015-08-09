# WebGL4J

Simple JSNI based WebGL wrapper for GWT projects

## Design

WebGL4J aims to provide static methods to all the WebGL functions, and also the extensions present in the Khronos WebGL Registry. This provides a similar interface to people who are coming from legacy OpenGL environments (by legacy, I mean desktop) to use WebGL easily, yet having the same interface to the users coming from JavaScript.

| Class     | Description                                                                     |
|-----------|---------------------------------------------------------------------------------|
| WebGL10   | Contains all the constants and functions defined in the WebGL 1.0 specification |
| WebGL20   | Contains all the constants and functions defined in the WebGL 2.0 specification |
| {ExtName} | Contains all the constants and functions defined in the extension {ExtName}     |

As you have seen above, that is how the functions are structured in the wrapper, allowing to use WebGL functions from any where in the app once the context is created. All the functions have the OpenGL prefixes and suffixes, to help the users coming from the native desktop OpenGL.

## Installation

For now you have to compile the library and add the resulting JAR file to your classpath in your webapp. First start with building the project.

```bash
./gradlew clean build javadoc
```

Then copy the `WebGL4J.jar` from the `build/libs` directory and add it in the classpath of your GWT application. Now inherit the `WebGL4J` in your modules that use this library by adding the following line to your GWT module XML file.

```xml
<inherits name="com.shc.webgl4j.client" />
```

That should let you use WebGL4J in your project. You can now start writing WebGL applications using GWT.

## Creating the context

To create a WebGL context, you first need a `<canvas>` element in your HTML template.

```html
<!DOCTYPE html>
<html>
    <head>
        <!-- Trimmed off -->
    </head>
    <body>
        <!-- A Canvas element is needed to render the WebGL graphics -->
        <canvas id="webgl" width="640" height="480"></canvas>
    </body>
</html>
```

With that template, you can get the canvas element and create the context on module load in your entrypoint. This is how it looks.

```java
// Get the CanvasElement
CanvasElement canvas = (CanvasElement) Document.get().getElementById("webgl");

// Create the context
WebGL10.createContext(canvas);
```

Creating a context with a set of context attributes is also supported. Here is an example for creating a context with a stencil buffer.

```java
WebGL10.ContextAttributes ctxAttributes = WebGLContext.Attributes.create();
ctxAttributes.setStencil(true);

// Create the context now
WebGL10.createContext(canvas, ctxAttributes);
```

## Using multiple contexts

WebGL4J has support for rendering using multiple contexts. All the overloads to the method `createContext` returns a `WebGLContext` object which you can store. Then depending on your usage, you make a context 'current'.

```java
// Create the contexts and store their handles
WebGLContext ctx1 = WebGL10.createContext(canvas1);
WebGLContext ctx2 = WebGL10.createContext(canvas2);

// Make context 1 current
ctx1.makeCurrent();

// [... Draw using context 1       ...]
// [... Drawing happens on canvas1 ...]

// Make context 2 current
ctx2.makeCurrent();

// [... Draw using context 2       ...]
// [... Drawing happens on canvas2 ...]
```

You don't need to make the context current if you are only using one context. If you are using multiple contexts, the context that is just created will be the current, so in the above example, `ctx2` will be current since it is the latest created context.

## Licence

This project is covered by MIT licence. You can read the terms [here](http://opensource.org/licenses/MIT).