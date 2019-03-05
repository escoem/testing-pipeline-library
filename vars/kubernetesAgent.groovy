// vars/kubernetesAgent.groovy
def call(Closure body) {
  def versions = libraryResource 'versions.properties'
  def props = readProperties text:versions
  def dockerImage = props['maven']
  echo "using $dockerImage maven docker image"
  def label = "mypod-${UUID.randomUUID().toString()}"
  podTemplate(label: label, containers: [
    containerTemplate(name: 'maven', image: dockerImage, ttyEnabled: true, command: 'cat')
    ]) {
    node (label){
      body()
    }
  }
}
