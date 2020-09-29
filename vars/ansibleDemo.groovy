def call(){


node{
 
 
  


 stage("Git Checkout")
 {
 
   git 'https://github.com/Somyagaur06/jenkinsDemo.git'
 
 
 }



stage("Maven Build"){

 dir("/var/lib/jenkins/workspace/ansibleDemo/jenkinsDemo"){

docker.image('maven:3.3.3-jdk-8').inside{
 sh "sudo chmod 666 /var/run/docker.sock"
 sh "mvn clean package"

}}}
 

 
 
    stage("Tomcat Deployment by Ansible"){
  
  
  ansiblePlaybook credentialsId: 'ubuntu', disableHostKeyChecking: true, installation: 'ansible', inventory: 'inventory.inv', playbook: 'tomcatDeploy.yaml'
 
 }

























}}






































