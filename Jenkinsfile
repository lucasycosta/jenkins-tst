pipeline{
    agent any  

    tools{
        maven 'MAVEN_LOCAL'
    }

    stages{
        stage('Build MAVEN') {
            steps {
                sh 'mvn clean install -DskipTests=true'
            }
        }
        stage('Testes Unitarios') {
            steps{
                sh 'mvn test'
            }
        }
        stage('SonarQube') {
            environment{
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps{
                sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=jenkins-test2 -Dsonar.projectName='jenkins-test2' -Dsonar.host.url=http://localhost:9000 -Dsonar.java.binaries=target -Dsonar.token=sqp_db30b9878e1f2cbcf02ed05040ee38507bf37d9d"
            }
        }
        stage('Build Image') {
            steps {
                script {
                    sh 'docker build -t lucasycosta/tst-jenkins .'
                }
            }
        }
        stage('Run Container') {
            steps {
                script {
                    sh 'docker run --rm --name jenkins-teste -p 8080:8080 lucasycosta/tst-jenkins'
                    sh 'docker stop jenkins-teste'
                }
            }
        }
    }
}