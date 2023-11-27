pipeline{
    agent any
    stages{
        stage('Build MAVEN') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Create Image Docker') {
            steps{
                script{
                    bat 'docker build -t tst-jenkins .'
                }
            }
            
        }
        stage('Push Image to Hub') {
            steps{
                
            }
        }
    }
}