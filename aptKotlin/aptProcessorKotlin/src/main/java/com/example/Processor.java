package com.example;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Processor extends AbstractProcessor {

    private Filer filer;
    private Messager messager;

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Example.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        List<Element> annotatedElements = new LinkedList<Element>();

        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(Example.class)) {
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                error(annotatedElement, "Only classes can be annotated with @%s", Example.class.getSimpleName());
                continue;
            }
            annotatedElements.add(annotatedElement);
        }

        if (annotatedElements.size() > 0) {

            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("sayHello")
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class);

            for (Element e : annotatedElements) {
                String msg = e.getAnnotation(Example.class).text();
                methodBuilder = methodBuilder.addStatement("$T.out.println($S)", System.class, msg);
            }

            MethodSpec method = methodBuilder.build();

            TypeSpec clazz = TypeSpec.classBuilder("GeneratedClass")
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addMethod(method)
                    .build();

            JavaFile file = JavaFile.builder("com.example", clazz).build();

            try {
                file.writeTo(filer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return true;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    private void error(Element element, String msg, Object... args) {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), element);
    }
}
