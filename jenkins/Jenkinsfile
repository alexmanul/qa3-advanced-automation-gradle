pipeline {
    tools {
        gradle 'Gradle'
    }
    agent any
    stages {
        stage('Get stuff') {
            steps {
                echo 'Git Steps can be added'
            }
        }
        stage('Installing stuff') {
            steps {
                echo 'Execute Tests'
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                echo "Jenkins Workspace ${env.WORKSPACE}"
            }
        }
        stage('reports') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: 'allure-results']]
                    ])
                }
            }
        }
    }
}