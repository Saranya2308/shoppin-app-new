def call(Map config = [:]) {
    pipeline {
        agent any
        environment {
            IMAGE_NAME = config.imageName ?: 'default/image'
            DOCKERHUB_CREDENTIALS = config.dockerCreds ?: 'dockerhub-id'
        }
        stages {
            stage('Checkout') {
                steps {
                    git url: config.repo
                }
            }
            stage('Build') {
                steps {
                    sh './mvnw clean package -DskipTests'
                }
            }
            stage('Docker Build') {
                steps {
                    script {
                        dockerImage = docker.build("${IMAGE_NAME}:${env.BUILD_NUMBER}")
                    }
                }
            }
            stage('Docker Push') {
                steps {
                    script {
                        docker.withRegistry('', DOCKERHUB_CREDENTIALS) {
                            dockerImage.push()
                            dockerImage.push('latest')
                        }
                    }
                }
            }
        }
        post {
            always {
                echo 'Pipeline Completed!'
            }
        }
    }
}
