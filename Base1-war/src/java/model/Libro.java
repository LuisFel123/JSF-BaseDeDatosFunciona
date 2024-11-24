package model;

public class Libro {
    private int reIsbn;
    private String reTitulo;
    private String reResumen;
    private int reNumPag;
    private String reTipo;
    private int edCodigo;

    public Libro(int reIsbn, String reTitulo, String reResumen, int reNumPag, String reTipo, int edCodigo) {
        this.reIsbn = reIsbn;
        this.reTitulo = reTitulo;
        this.reResumen = reResumen;
        this.reNumPag = reNumPag;
        this.reTipo = reTipo;
        this.edCodigo = edCodigo;
    }

    public Libro() {}

    // Getters y Setters
    public int getReIsbn() {
        return reIsbn;
    }

    public void setReIsbn(int reIsbn) {
        this.reIsbn = reIsbn;
    }

    public String getReTitulo() {
        return reTitulo;
    }

    public void setReTitulo(String reTitulo) {
        this.reTitulo = reTitulo;
    }

    public String getReResumen() {
        return reResumen;
    }

    public void setReResumen(String reResumen) {
        this.reResumen = reResumen;
    }

    public int getReNumPag() {
        return reNumPag;
    }

    public void setReNumPag(int reNumPag) {
        this.reNumPag = reNumPag;
    }

    public String getReTipo() {
        return reTipo;
    }

    public void setReTipo(String reTipo) {
        this.reTipo = reTipo;
    }

    public int getEdCodigo() {
        return edCodigo;
    }

    public void setEdCodigo(int edCodigo) {
        this.edCodigo = edCodigo;
    }
}
