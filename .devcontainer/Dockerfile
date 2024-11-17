# Use a imagem base do Ubuntu
FROM mcr.microsoft.com/devcontainers/java:17

# Instale ferramentas adicionais (opcional)
RUN apt-get update && apt-get install -y \
    maven \
    git \
    curl \
    && apt-get clean

# Configure o Maven cache para o usuário
ENV MAVEN_CONFIG=/home/vscode/.m2