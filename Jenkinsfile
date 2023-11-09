pipeline {
    agent any
    environment {
        APP_NAME = "spring-boot-app"
        DOCKER_IMAGE_NAME = "rest"
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
                checkout scm
                script {
                    sh "mvn clean install -DskipTests"
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_IMAGE_NAME} ."
                }
            }
        }
        stage('Push Docker Image to Dockerhub') {
            steps {
                script {
                    sh 'docker login -u satakshi09 -p "S@ttu123"'
                    sh "docker push ${DOCKER_IMAGE_NAME}"
                }
            }
        }
       stage('Deploy to Docker') {
           steps {
               script {
                   sh "docker stop ${CONTAINER_NAME} && docker rm ${CONTAINER_NAME} || true"
                   sh "docker pull ${DOCKER_IMAGE_NAME}"
                   sh "docker run --name ${CONTAINER_NAME} -p ${HOST_PORT}:${CONTAINER_PORT} -d ${DOCKER_IMAGE_NAME}"
               }
           }
       }

    }
}
