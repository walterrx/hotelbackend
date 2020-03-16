
pipeline {
    agent any

    tools {
        maven 'maven-3.6.3'
        jdk 'jdk8'
    }

    stages {
        stage('Build') {
            steps {
               sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
