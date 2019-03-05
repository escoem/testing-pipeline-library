// vars/kubernetesAgent.groovy
def call(Closure body) {
  def versions = libraryResource 'versions.properties'
  def dockerImage = versions
    
  def label = "mypod-${UUID.randomUUID().toString()}"
  podTemplate(label: label, containers: [
    containerTemplate(name: 'maven', image: dockerImage, ttyEnabled: true, command: 'cat')
    ]) {
    node {
      body()
    }
  }
}
