               pipeline {
                   agent any
                   environment {
                       APP_NAME = "employee"
                       DOCKER_IMAGE_NAME = "satakshi09/rest"
                       CONTAINER_NAME = "${APP_NAME}-container"
                       HOST_PORT = "8080"
                       CONTAINER_PORT = "8080"
                   }
                   tools {
                       maven "jenkins-maven-3.9.5"
                   }
                   stages {
                       stage('Build') {
                           steps {
                           checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Satakshi09/employee']])
                               sh "mvn clean install"
                           }
                       }
                       stage('Test') {
                           steps {
                               sh "mvn test"
                           }
                       }
                       stage('Build Docker image') {
                           steps {
                               script {
                                   sh "docker build -t satakshi09/rest ."
                               }
                           }
                       }
                       stage('Push Docker Image to Dockerhub') {
                           steps {
                               script {
                                   sh 'docker login -u satakshi09 -p "S@ttu12345678"'
                                   sh "docker push satakshi09/rest"
                               }
                           }
                       }
                       // Add more stages as needed
                   }
               }
