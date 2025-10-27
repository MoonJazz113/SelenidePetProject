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
               sh 'mvn clean test'
            }
        }
    }
}