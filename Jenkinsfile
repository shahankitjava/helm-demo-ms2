pipeline {
    libraries { lib 'SharedLibrary@helm-support' }
    
    agent none

    options {
        timestamps()
        timeout(time: 1, unit: 'HOURS')
        buildDiscarder(logRotator(numToKeepStr: '10'))
        //disableConcurrentBuilds()
        //preserveStashes()
    }

    stages {
        stage("Helm") {
            agent {
                            docker {
                                image 'artifacts.aa.com/docker-prod/edots-base:1.0.0'
                                label 'Builder'
                            }
                        }
            steps {
                echo "*****Calling Helm Function*****"
                script {
                    HelmInstall(
                        name: "Hello World!",
                        KUBE_CONTEXT_NAME:"C4E-Pipeline-Templates/3cdf9bdadce442ac9f9abea7a72da7a9",
                        KUBE_CLUSTER_NAME:"C4E-Pipeline-Templates/3cdf9bdadce442ac9f9abea7a72da7a9",
                        KUBE_NAMESPACE:"helm-test"
                    )
                }
            }
        }
    }
}
