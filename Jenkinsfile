pipeline{
    agent any  
    stages{
        stage('Build MAVEN') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Build Image') {
            steps {
                script {
                    bat 'docker build -t lucasycosta/tst-jenkins .'
                }
            }
        }
        stage('Run Container') {
            steps {
                script {
                    bat 'docker run -p 8080:8080 lucasycosta/tst-jenkins'
                }
            }
        }
    }
}