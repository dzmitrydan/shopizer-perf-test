pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                sh 'mvn -B clean package'
            }
        }
        stage('Pull Latest Code') {
                    git branch: 'master',
                        url: 'git@github.com:dzmitrydan/shopizer-perf-test.git'
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
