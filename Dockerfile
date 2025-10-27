FROM jenkins/jenkins:2.528.1-jdk21

USER root

# Устанавливаем Chrome
RUN curl -fsSL https://dl.google.com/linux/linux_signing_key.pub -o /tmp/google.pub && \
    gpg --batch --yes --no-tty --dearmor -o /usr/share/keyrings/google-linux-keyring.gpg /tmp/google.pub && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux-keyring.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/* /tmp/google.pub

ENV ALLURE_VERSION=2.30.0
RUN wget https://maven.aliyun.com/repository/public/io/qameta/allure/allure-commandline/${ALLURE_VERSION}/allure-commandline-${ALLURE_VERSION}.zip -O /tmp/allure.zip && \
    unzip -o -q /tmp/allure.zip -d /opt/allure && \
    ln -sf /opt/allure/allure-${ALLURE_VERSION}/bin/allure /usr/bin/allure && \
    rm /tmp/allure.zip

RUN apt-get update && apt-get install -y maven

RUN java -version && mvn -version && google-chrome --version

WORKDIR /var/jenkins_home/workspace/Test

USER jenkins