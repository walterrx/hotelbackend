
pipeline {
    agent { dockerfile true }

    stages {
        stage('Build') {
            steps {
               sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'node --version'
                sh 'svn --version'
           }
        }
}
