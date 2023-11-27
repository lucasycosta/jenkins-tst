pipeline{
    agent any
    stages{
        stage('Build Backend'){
            steps{
                bat'mvn clean package -DskipTests=true'
            }
        }
        stage(){
            steps{
                script{
                    dockerapp = docker.build("tst-jenkins", '-f ./Dockerfile ./')
                }
            }
        }
    }
}