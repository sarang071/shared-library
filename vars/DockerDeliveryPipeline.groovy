pipeline {
    agent any
    environment {
        dev_account_id = "1245789"
        qa_account_id  = "5478951"
    }
    parameters {
        choice(name: 'ACCOUNT', choices: ['dev','qa'], description: 'Pick Enviornment')
    }
    stages {
        stage('dev account'){
                when{
                    expression{
                        params.ACCOUNT == 'dev'
                    }
                }
                steps{
                    echo "We are using ${env.dev_account_id}"
                }

            }
        stage('QA account'){
                when{
                    expression{
                        params.ACCOUNT == 'qa'
                    }
                }
                steps{
                    echo "We are using ${env.qa_account_id}"
                }

            }
        }

}
