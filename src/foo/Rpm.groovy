package foo

public class Rpm implements Serializable {
    private def steps

    public Rpm(Map m = [:]) {
        this.steps = m.steps
    }

    public sayHello(String name = 'human') {
      steps.echo(name)
    }
}
