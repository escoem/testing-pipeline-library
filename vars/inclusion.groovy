// vars/inclusion.groovy
def call(String name = 'human') {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    echo "Hello, ${name}."
    echo "I'm asking for a new library..."
    library identifier: 'testing-pipeline-library-dynamic@crash', 
            retriever: modernSCM([$class: 'GitSCMSource', remote: 'https://github.com/escoem/testing-pipeline-library.git'])
    sayHello ("libray")
}
