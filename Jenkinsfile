pipeline{
   agent any
   environment{
     APP_NAME="employee"
     DOCKER_IMAGE_NAME="satakshi09/rest"
     CONTAINER_NAME="${APP_NAME}-container"
     HOST_PORT="8080"
     CONTAINER_PORT="8080"
   }
   tools{
   maven "jenkins-maven-3.9.5"
   }
   stages{
      stage('Build'){
         steps{
         checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Satakshi09/employee']])
         sh "mvn clean install -DskipTests"
         }
      }
      stage('Test'){
         steps{
           script{
           sh 'docker login -u satakshi09 -p "S@ttu12345678"'
           sh "docker push satakshi09/rest"
           }
         }
      }
      stage('Deploy to Docker'){
      steps{
      script{
      sh "docker stop ${CONTAINER_NAME} && docker rm ${CONTAINER_NAME} ||true"
      sh "docker pull ${DOCKER_IMAGE_NAME}"
      sh "docker run --name ${CONTAINER_NAME} -p ${HOST_PORT}:${CONTAINER_PORT} -d ${DOCKER_IMAGE_NAME}"

      }
      }
      }
   }
}