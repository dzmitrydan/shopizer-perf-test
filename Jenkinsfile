pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                sh 'mvn -B clean package'
            }
        }
        stage("Run Gatling") {
            steps {
                sh 'mvn gatling:test -DUsers=1'
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
