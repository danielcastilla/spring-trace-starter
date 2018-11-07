### Spring trace starter

Prueba de concepto sobre como crear un started con Spring-Boot

- Incluimos el fichero *spring.factories* en el modulo trace-spring-starter-autoconfigure dentro de la carpeta /resources/META-INF/ con los siguientes valores:

```properties
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    com.dancas.trace.autoconfigure.TraceAutoConfiguration
```


