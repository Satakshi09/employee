pipeline {
    agent any
    tools {
        maven "jenkins-maven-3.9.5"
    }
    stages {
        stage('Build') {
            steps {
                git branch: 'master', url: 'https://github.com/Satakshi09/employee'
                script {
                    if (isUnix()) {
                        sh "mvn clean install -DskipTests"
                    } else {
                        bat "mvn clean install -DskipTests"
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn test'
                    } else {
                        bat 'mvn test'
                    }
                }
            }
        }
    }
}
