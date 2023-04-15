pipeline {
    agent any
    environment {
            PATH = "/Users/Dmitry_Danilov/apache-maven-3.9.0/bin:$PATH"
    }
    stages {
        stage("build maven") {
            steps {
                sh "mvn -B clean package"
            }
        }
        stage("run gatling") {
            steps {
                sh "mvn gatling:test"
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
