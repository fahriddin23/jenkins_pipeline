node {
    stage("Say Hello"){
        properties([parameters([string(defaultValue: 'Dev', description: '''Dev: 18.219.171.79 QA: 18.219.242.93 Prod: 3.17.206.126''', name: 'Remote_instances', trim: false)])])
        git 'https://github.com/fahriddin23/jenkins.git'
    }
}