pipeline{

    agent any

    stages {

        stage ('Compile Stage') {

            steps {
                    bat 'mvn clean install'
            }
        }
    stage ('Test Stage') {

            steps {
                   bat 'mvn test'
            }
        }

    stage('Deploy to Staging'){
        steps {
                echo "Ok"
            }
    }

    stage ('Senerity Reports') {

        steps {
            publishHTML(target: [
            reportName : 'Serenity',
            reportDir:   'target/site/serenity',
            reportFiles: 'index.html',
            keepAll:     true,
            alwaysLinkToLastBuild: true,
            allowMissing: false
        ])

        }

    }

    }

}
