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

    }
}
