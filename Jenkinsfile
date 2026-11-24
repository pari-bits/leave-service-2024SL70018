pipeline {
    agent any
    environment {
        SONAR_TOKEN = credentials('sonar-token-2024SL70018')
    }
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build and Test') {
            steps { sh 'mvn clean verify' }
            post { always { junit 'target/surefire-reports/*.xml' } }
        }
        stage('SonarQube Code Inspection') {
            steps {
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184:sonar -Dsonar.projectKey=leave-service-2024SL70018 -Dsonar.host.url=http://localhost:9000 -Dsonar.login=$SONAR_TOKEN'
            }
        }
    }
}
