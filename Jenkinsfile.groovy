node {
    stage("Say Hello"){
        properties([parameters([string(defaultValue: 'Fahriddin', description: 'adds a name', name: 'NAME', trim: false)]), pipelineTriggers([cron('* * * * *')])])
        git 'https://github.com/fahriddin23/jenkins.git'
    }
}