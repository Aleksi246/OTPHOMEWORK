pipeline {
    agent any

    tools {
        maven 'Apache Maven 3.8.7'
    }

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'dockerhub-creds'
        DOCKERHUB_REPO = 'aleksi246/temp_converter'
        DOCKER_IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
                // Print branch name for debugging
                script {
                    echo "Current branch: ${env.BRANCH_NAME}"
                }
            }
        }

        stage('Build, Test & Coverage') {
            steps {
                sh 'mvn -B clean verify'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco execPattern: 'target/jacoco.exec',
                       classPattern: 'target/classes',
                       sourcePattern: 'src/main/java',
                       exclusionPattern: ''
                archiveArtifacts artifacts: 'target/site/jacoco/**', fingerprint: true
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Use a variable to reference the image for reuse
                    env.DOCKER_IMAGE = "${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
                    def appImage = docker.build(env.DOCKER_IMAGE)
                    // Also tag as latest
                    appImage.tag('latest')
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        def appImage = docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                        appImage.push()
                        appImage.push('latest')
                    }
                }
            }
        }

    }
}