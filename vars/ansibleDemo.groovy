def call(){


node{
 var myImage
 
  


 stage("Git Checkout")
 {
 
   git 'https://github.com/Somyagaur06/jenkinsDemo.git'
 
 
 }



stage("Maven Build"){

 dir("/var/lib/jenkins/workspace/ansibleDemo/jenkinsDemo"){

myImage=docker.image('maven:3.3.3-jdk-8')
  myImage.inside{
 
 sh "mvn clean package"

}}}
 

 
 
          

























}}






































