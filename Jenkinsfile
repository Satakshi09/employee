pipeline {
    agent any
    tools {
        maven "jenkins-maven-3.9.5"
    }
    stages {
        stage('Build') {
            steps {
                git branch: 'master', url: 'https://github.com/Satakshi09/employee'
                sh "mvn clean install -DskipTests"
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
