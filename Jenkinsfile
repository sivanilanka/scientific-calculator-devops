pipeline {
    agent any

    tools {
        maven 'Maven-3'
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/sivanilanka/scientific-calculator-devops.git'
            }
        }

        stage('Build Project') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t scientific-calculator .'
            }
        }
       stage('Push Docker Image') {
           steps {
               sh 'docker tag scientific-calculator sivanilanka/scientific-calculator:latest'
               sh 'docker push sivanilanka/scientific-calculator:latest'
          }
      }
      stage('Deploy Container') {
    steps {
        sh 'docker stop scientific-calculator || true'
        sh 'docker rm scientific-calculator || true'
        sh 'docker run -d --name scientific-calculator -p 8081:8080 sivanilanka/scientific-calculator:latest'
    }
}

    }
}
