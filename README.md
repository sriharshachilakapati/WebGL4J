# WebGL4J

Simple JSNI based WebGL wrapper for GWT projects

## Design

WebGL4J aims to provide static methods to all the WebGL functions, and also the extensions present in the Khronos WebGL Registry. This provides a similar interface to people who are coming from legacy OpenGL environments to use WebGL easily, yet having the same interface to the users coming from JavaScript.
 
| Class     | Description                                                                     |
|-----------|---------------------------------------------------------------------------------|
| WebGL10   | Contains all the constants and functions defined in the WebGL 1.0 specification |
| WebGL20   | Contains all the constants and functions defined in the WebGL 2.0 specification |
| {ExtName} | Contains all the constants and functions defined in the extension {ExtName}     |

As you have seen above, that is how the functions are structured in the wrapper, allowing to use WebGL functions from any where in the app once the context is created. All the functions have the OpenGL prefixes and suffixes, to help the users coming from the native desktop OpenGL.

## Installation

Right now, the best way to setup WebGL4J is to either copy the sources into your project (recommended) or copy the entire project and start modifying the `TriangleTest` class. This is because GWT requires the sources to be able to compile the your WebGL application. I'm still looking for ways to do this using the `gwt-gradle` plugin.

If you want to go with the class path JAR approach, you have to compile the library and add the resulting JAR file to your classpath. First start with building the project.

```bash
./gradlew clean build
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
WebGL10.ContextAttributes ctxAttributes = WebGL10.ContextAttributes.create();
ctxAttributes.setStencil(true);

// Create the context now
WebGL10.createContext(canvas, ctxAttributes);
```

## Licence

This project is covered by MIT licence. You can read the terms [here](http://opensource.org/licenses/MIT).