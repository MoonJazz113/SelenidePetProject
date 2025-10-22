FROM jenkins/jenkins:2.479.1-jdk21

USER root

# Устанавливаем зависимости
RUN apt-get update && apt-get install -y \
    curl wget gnupg2 unzip xvfb fonts-liberation \
    libasound2 libnss3 libxss1 libatk-bridge2.0-0 libgtk-3-0 xdg-utils lsb-release \
    apt-transport-https ca-certificates software-properties-common

# Устанавливаем Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-linux-keyring.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux-keyring.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Устанавливаем Maven
RUN apt-get update && apt-get install -y maven

RUN java -version && mvn -version && google-chrome --version

WORKDIR /app
USER jenkins