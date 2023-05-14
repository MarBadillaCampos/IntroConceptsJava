
package cr.caricature.domain;

/**
 *
 * @author MarBadilla
 */
public class Caricature {
    private String name;
    private String description;

    public Caricature() {
    }

    public Caricature(String name, String descripcion) {
        this.name = name;
        this.description = descripcion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripcion) {
        this.description = descripcion;
    }

    @Override
    public String toString() {
        return "Caricature{" + "name=" + name + ", descripcion=" + description + '}';
    }  
}
