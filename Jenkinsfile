pipeline {
    agent any

    tools {
        maven 'Maven-3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/sivanilanka/scientific-calculator-devops.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Containerize Application') {
            steps {
                sh 'docker build -t scientific-calculator .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                sh 'docker tag scientific-calculator sivanilanka/scientific-calculator:latest'
                sh 'docker push sivanilanka/scientific-calculator:latest'
            }
        }

        stage('Run Ansible Deployment') {
            steps {
                sh 'ansible-playbook -i hosts.ini deploy.yml'
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully! The Scientific Calculator is deployed.'
        }
        failure {
            echo 'Pipeline failed! Check logs.'
        }
    }
}
