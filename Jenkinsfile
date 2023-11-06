pipeline {
    agent any
    tools {
        maven "apache-maven-3.8.6"
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
