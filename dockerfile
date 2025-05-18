# Etapa 1: Build com Gradle e JDK 17
FROM gradle:8.5-jdk17 AS builder

WORKDIR /app

# Copia arquivos principais do Gradle
COPY build.gradle* settings.gradle* gradle.properties* ./
COPY gradle ./gradle

# Baixa dependências (melhora cache de builds)
RUN gradle dependencies || true

# Copia o restante do código-fonte
COPY src ./src

# Gera o .jar (sem testes para velocidade)
RUN gradle bootJar -x test

# Etapa 2: Imagem final apenas com JRE 17
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copia o .jar da etapa de build
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
