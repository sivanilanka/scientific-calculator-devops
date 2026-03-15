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

        emailext(
            subject: "Build SUCCESS: ${env.JOB_NAME}",
            body: "Build completed successfully.\nBuild Number: ${env.BUILD_NUMBER}",
            to: "sivanireddylanka@gmail.com"
        )
    }

    failure {
        echo 'Pipeline failed! Check logs.'

        emailext(
            subject: "Build FAILED: ${env.JOB_NAME}",
            body: "Build failed. Check Jenkins logs.\nBuild Number: ${env.BUILD_NUMBER}",
            to: "sivanireddylanka@gmail.com"
        )
    }
}

}
