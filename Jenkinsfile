pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build and Test') {
            steps { sh 'mvn clean verify' }
            post { always { junit '**/target/surefire-reports/*.xml' } }
        }
        stage('SonarQube Code Inspection') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token-2024SL70018', variable: 'SONAR_TOKEN')]) {
                    sh "mvn sonar:sonar -Dsonar.projectKey=leave-service-2024SL70018 -Dsonar.host.url=http://localhost:9000 -Dsonar.login=${SONAR_TOKEN} || true"
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t leave-service-2024sl70018:${BUILD_NUMBER} .'
            }
        }
        stage('Deploy to Staging') {
            steps {
                sh '''
                    docker stop leave-service-staging || true
                    docker rm leave-service-staging || true
                    docker run -d --name leave-service-staging -e APP_ENV=staging -p 8085:8080 leave-service-2024sl70018:${BUILD_NUMBER}
                    sleep 3
                    docker logs leave-service-staging
                '''
            }
        }
    }
}
