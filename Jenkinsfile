def CONTAINER_NAME = "springboot-msa-hotel"
def COINTAINER_TAG = "latest"

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
   stage('Build Maven') {
           steps {
              sh 'mvn package -DskipTests'
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
          docker.withRegistry( '', registryCredential ) 
          {
            dockerImage.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"    
      }
    }
     stage('Run App') {
         steps {
            sh 'docker pull $registry:$BUILD_NUMBER'
            sh "docker run -d --rm -p 8090:8090 --name $registry:$BUILD_NUMBER"
         }
     } 
  }
}
