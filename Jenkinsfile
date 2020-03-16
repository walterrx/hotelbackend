pipeline {
  environment {
    registry = "walterrx/hotelmsa"
    registryCredential = 'docker-hub-credentials'
    dockerImage = ''
  }
  agent any
  tools {
      maven 'maven-3.6.3'
      jdk 'jdk8'
   }
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/walterrx/hotelbackend.git'
      }
    }
    stage('Execute Docker Mongo') {
      steps {
        sh 'free -m'
      }
    }
    
   stage('Build Maven') {
           steps {
              sh 'mvn -T 10 clean package'
           }
       } 
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
  }
}
