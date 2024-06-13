package org.unrn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
public class AspectLog {
    BufferedWriter emisor;

    private static String formatearMensaje(JoinPoint joinPoint) {

        return String.format("\"%s\", \"%s\", \"%s\"\n",
                joinPoint.getSignature().getName(),
                formatearArgumentos(joinPoint.getArgs()),
                formatearFecha());
    }

    private static String formatearFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(new Date());
    }

    private static String formatearArgumentos(Object[] args) {
        String texto = "sin parametros";
        if (args.length > 0) {
            texto = Arrays.toString(args);
            texto = texto.substring(1, texto.length() - 1);
            texto = texto.replace(", ", "|");
        }
        return texto;
    }

    @Before("execution(@Log * *(..))")
    public void registrarAntes(JoinPoint joinPoint) {
        String mensaje = formatearMensaje(joinPoint);

        try {
            emisor = new BufferedWriter(new FileWriter("./src/main/resources/log.txt", true));
            emisor.write(mensaje);
            emisor.close();
        } catch (IOException e) {
            throw new RuntimeException("Problema al escribir en archivo", e);
        }
        System.out.println("Log: " + mensaje);
    }
}
