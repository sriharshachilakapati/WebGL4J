<p align="center"><img src="http://goharsha.com/WebGL4J/logos/256/logo-blue-light.png"></img></p>

WebGL4J is a WebGL wrapper library for the Java programming language which allows to use Java to write HTML5 applications using GWT (Google Web Toolkit) which uses WebGL to draw 2D / 3D hardware accelerated graphics using a HTML5 Canvas.

## Design

WebGL4J aims to provide static methods to all the WebGL functions, and also the extensions present in the Khronos WebGL Registry. This provides a similar interface to people who are coming from legacy OpenGL environments (by legacy, I mean desktop) to use WebGL easily, yet having the same interface to the users coming from JavaScript.

| Class     | Description                                                                     |
|-----------|---------------------------------------------------------------------------------|
| WebGL10   | Contains all the constants and functions defined in the WebGL 1.0 specification |
| WebGL20   | Contains all the constants and functions defined in the WebGL 2.0 specification |
| {ExtName} | Contains all the constants and functions defined in the extension {ExtName}     |

As you have seen above, that is how the functions are structured in the wrapper, allowing to use WebGL functions from any where in the app once the context is created. All the functions have the OpenGL prefixes and suffixes, to help the users coming from the native desktop OpenGL.

## Installation

You can get WebGL4J in three ways, either from the central maven repository, or downloading from the GitHub releases, and finally building yourself.

```xml
<dependency>
    <groupId>com.goharsha</groupId>
    <artifactId>webgl4j</artifactId>
    <version>0.2.8</version>
    <scope>compile</scope>
</dependency>
```

That is for maven. The repository is maven central repository. For gradle users, you can add it to your dependencies like the following.

```gradle
compile group: 'com.goharsha', name: 'webgl4j', version: '0.2.8'

// or shorthand notation
compile 'com.goharsha:webgl4j:0.2.8'
```

Add that and you'll be getting your dependencies downloaded to you. The second way is to download the JAR from the GitHub releases and add it to the classpath in your webapp. You can build your own version of the library in the following way.

```bash
./gradlew clean build javadoc
```

Then copy the `webgl4j.jar` from the `webgl4j/build/libs` directory and add it in the classpath of your GWT application. Now inherit the `WebGL4J` in your modules that use this library by adding the following line to your GWT module XML file.

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

Creating the context and canvas at runtime without declaring it at runtime is also supported. You can simply create a canvas and call `WebGL10.createContext()` on it.

```java
// Create the Canvas
Canvas canvas = Canvas.createIfSupported();
canvas.setCoordinateSpaceWidth(640);
canvas.setCoordinateSpaceHeight(480);

// Create the context
WebGL10.createContext(canvas);
```

Creating a context with a set of context attributes is also supported. Here is an example for creating a context with a stencil buffer.

```java
WebGLContext.Attributes ctxAttributes = WebGLContext.Attributes.create();
ctxAttributes.setStencil(true);

// Create the context now
WebGL10.createContext(canvas, ctxAttributes);
```

To create WebGL2 contexts, you can use the `createContext` method in the `WebGL20` class. Just like the `createContext` method in the `WebGL10` class, the context attributes are not necessary and are optional.

```java
WebGL20.createContext(canvas, ctxAttributes);
```

You can call `WebGL10` methods when you have a `WebGL20` context, but you cannot call WebGL 2.0 functions when you have a WebGL 1.0 context.

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

## Using extensions

Extensions in WebGL are a bit different when compared to the standard desktop OpenGL extensions. One notable difference is that here the extension needs to be enabled first, unlike the traditional desktop OpenGL where all the extensions are enabled by default.

```java
// Check if the extension is supported
if (OES_vertex_array_object.isSupported())
    OES_vertex_array_object.enableExtension();
```

The above example demonstrates the `OES_vertex_array_object` extension, and how to enable it. Once it's enabled, you can call any of it's static functions just like you call the WebGL functions. If you try to use an exception without enabling it, an `IllegalStateException` will be thrown at you.

## Fullscreen mode

You can use the built in polyfill to request the fullscreen mode on a context. This works in most browsers (Chrome, Safari, Opera, Firefox, IE 11 and the new Edge), with the ones that are tested being Chrome, Firefox, IE 11 and Edge. This is how you request fullscreen mode.

```java
boolean success = WebGLContext.getCurrent().requestFullscreen();
```

This method returns a success value, to notify you whether the request is accepted. However, there are some restrictions on this, you can't simply request fullscreen, the request will only be accepted if the user has pressed a key or clicked a button which initiated the request.

## Running the examples

You can see the examples in action by navigating your browser to [http://goharsha.com/WebGL4J/](http://goharsha.com/WebGL4J/). Instead if you want to compile them yourself, enter the following command into the console.

```bash
./gradlew clean build superDev
```

Once the terminal says that the server is ready at **http://localhost:9876**, fire up your browser to go to **http://localhost:8080/examples/** and you will see the examples in live.

## Licence

This project is covered by MIT licence. You can read the terms [here](http://opensource.org/licenses/MIT).

The logos were designed by [NegativeZero](https://github.com/NegativeXero/) (Twitter: [@NegativeZeroDEV](https://twitter.com/NegativeZeroDEV/)) and is licenced under Creative Commons.

## Contact

If you want to contact me about this project, or ask any questions, you can e-mail me at [hello@goharsha.com](mailto://hello@goharsha.com). Alternatively, if you are not comfortable with e-mail, you can join the IRC at [#WebGL4J@Freenode](https://kiwiirc.com/client/irc.freenode.net/#WebGL4J)
