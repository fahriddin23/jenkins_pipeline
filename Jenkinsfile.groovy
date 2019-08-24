node {
    stage("Pull git"){
        properties([parameters([string(defaultValue: 'Dev', description: '''Dev: 18.219.171.79 QA: 18.219.242.93 Prod: 3.17.206.126''', name: 'Remote_instances', trim: false)])])
        git 'https://github.com/fahriddin23/jenkins.git'
    }
    stage ("Install Apache"){
        sh "ssh ec2-user@ ${Remote_instances} sudo yum install httpd -y"
    }
    stage ("Create Index.html"){
        sh "scp index.html ec2-user@${Remote_instaces}:tmp"
    }
    stage ("Move files"){
        sh "ssh ec2-user@${Remote_instaces} sudo mv /tmp/index.html /var/www/html/index.html"
    }
    stage ("restart httpd"){
        sh "ssh ec2-user@${Remote_instace} sudo systemctl restart httpd"
    }
}