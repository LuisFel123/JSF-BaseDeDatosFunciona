package beans;

import dao.LibroDAO;
import model.Libro;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
@Named
public class LibrosBean {

    private Libro nuevoLibro = new Libro();
    private List<Libro> listaLibros;
    private LibroDAO libroDAO = new LibroDAO();

    @PostConstruct
    public void init() {
        cargarLibros();
    }

    public void cargarLibros() {
        listaLibros = libroDAO.getAllLibros();
    }

    public void guardarLibro() {
        libroDAO.insertLibro(nuevoLibro);
        nuevoLibro = new Libro(); // Limpiar el formulario
        cargarLibros(); // Actualizar la lista
    }

    // Getters y Setters
    public Libro getNuevoLibro() {
        return nuevoLibro;
    }

    public void setNuevoLibro(Libro nuevoLibro) {
        this.nuevoLibro = nuevoLibro;
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
}
