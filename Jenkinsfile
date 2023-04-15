pipeline {
    agent any
    stages {
        stage("Clone code") {
             steps {
                git branch: 'master',
                url: 'git@github.com:dzmitrydan/shopizer-perf-test.git'
             }
        }
        stage("Build Maven") {
            steps {
                sh 'mvn -B clean package'
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
