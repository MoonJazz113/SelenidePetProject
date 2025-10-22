pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test -Dselenide.headless=true'
            }
        }

        stage('Archive Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}