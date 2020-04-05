/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2020, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tech.uom.demo.java10.jshell;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

import java.util.List;
import java.util.Scanner;

public class JShellDemo {
    public static void main(String[] args) {
        final JShell myShell = JShell.create();

        System.out.println("Welcome to JShell Unit API Demo");
        System.out.println("Please Enter a Snippet. Enter EXIT to exit:");
        try(Scanner reader = new Scanner(System.in)){
            while(true){
                String snippet = reader.nextLine();
                if ( "EXIT".equalsIgnoreCase(snippet)){
                    break;
                }
                List<SnippetEvent> events = myShell.eval(snippet);
                events.stream().forEach(se -> {
                    System.out.print("Evaluation status: " + se.status());
                    System.out.println(" Evaluation result: " + se.value());
                });
            }
        }
        System.out.println("Snippets processed: ");
        myShell.snippets().forEach(s -> {
            String msg = String.format("%s -> %s", s.kind(), s.source());
            System.out.println(msg);
        });

        System.out.println("Methods: ");
        myShell.methods().forEach(m -> System.out.println(m.name() + " " + m.signature()));

        System.out.println("Variables: ");
        myShell.variables().forEach(v -> System.out.println(v.typeName() + " " + v.name()));
        myShell.close();
    }
}
