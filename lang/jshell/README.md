# JShell Demo

## Folders
In this repo, you'll find several folders:

- imports
- libs
- startups
- utils

### Imports

This directory contains pre-defined, commonly used imports. 

You'll find as you use JShell more and more that it becomes quite painful to have to re-type a bunch of import statements when you want to use or experiment with a particular external library. 

Instead, you can save all the necessary import statements into a file and then utilize the `/open` command to bring them in.

### Libs

This directory is pretty self-explanatory and contains any and all external libraries that you might use with JShell. You can choose to organize your libraries in whatever fashion makes the most sense, whether it's all in one directory or on a per-project basis. Whatever it is, _having all your external libraries organized in an easily loadable way_ will save you time in the end, as we saw in the Classpath Tips section.

### Startups

You can utilize this directory to store any startup or initialization code. This is a feature that's directly supported by JShell with the `--startup` parameter.

These files are similar, in nature, to the type of files located in the imports directory but they go beyond just imports. These files are meant to contain any necessary commands, imports, snippets, methods, classes, etc needed to initailize your JShell environment.

### Utils

We all know how verbose Java can be. This directory, as it's aptly named, is meant to contain any utility or "shortcut code", that will make your time spent with JShell more enjoyable. The type of files you would store here are very similiar to the special PRINTING file that comes with JShell, which defines a number of shortcut methods for printing text.

## Running
Use
`jshell -class-path libs\unit-api-2.1.jar;libs\indriya-2.2.3.jar;libs\uom-lib-common-2.2.jar --startup startups\uom-startup`
on Windows or
`jshell -class-path libs/unit-api-2.1.jar:libs/indriya-2.2.3.jar:libs/uom-lib-common-2.2.jar --startup startups/uom-startup`
on Linux/Unix

## Thank You
Inspired by the [JShell Utilities Example](https://github.com/dustinschultz/jshell).
