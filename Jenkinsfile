pipeline {
    agent any
    environment {
        PATH = '/Users/Dmitry_Danilov/apache-maven-3.9.0/bin/mvn:$PATH'
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
