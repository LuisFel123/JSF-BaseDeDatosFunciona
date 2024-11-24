package model;

public class Editorial {
    private int edCodigo;
    private String edNombre;

    public Editorial(int edCodigo, String edNombre) {
        this.edCodigo = edCodigo;
        this.edNombre = edNombre;
    }

    public Editorial() {}

    // Getters y Setters
    public int getEdCodigo() {
        return edCodigo;
    }

    public void setEdCodigo(int edCodigo) {
        this.edCodigo = edCodigo;
    }

    public String getEdNombre() {
        return edNombre;
    }

    public void setEdNombre(String edNombre) {
        this.edNombre = edNombre;
    }
}

