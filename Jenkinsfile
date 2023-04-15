pipeline {
    agent any
    tools {
        maven 'maven-3.9.0'
    }
    stages {
        stage("Build Maven") {
            steps {
                sh 'mvn clean'
            }
        }
        stage("Run Gatling") {
            steps {
                sh 'mvn gatling:test'
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
