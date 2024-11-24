package beans;

import dao.EditorialDAO;
import model.Editorial;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
@Named
public class EditorialBean {
    private Editorial nuevaEditorial = new Editorial();
    private List<Editorial> listaEditoriales;

    private EditorialDAO editorialDAO = new EditorialDAO();

    @PostConstruct
    public void init() {
        cargarEditoriales();
    }

    public void cargarEditoriales() {
        listaEditoriales = editorialDAO.getAllEditoriales();
    }

    public void guardarEditorial() {
        editorialDAO.insertEditorial(nuevaEditorial);
        nuevaEditorial = new Editorial(); // Limpiar el formulario
        cargarEditoriales(); // Actualizar la lista
    }

    public void eliminarEditorial(int edCodigo) {
        editorialDAO.deleteEditorial(edCodigo);
        cargarEditoriales(); // Actualizar la lista
    }

    // Getters y Setters
    public Editorial getNuevaEditorial() {
        return nuevaEditorial;
    }

    public void setNuevaEditorial(Editorial nuevaEditorial) {
        this.nuevaEditorial = nuevaEditorial;
    }

    public List<Editorial> getListaEditoriales() {
        return listaEditoriales;
    }

    public void setListaEditoriales(List<Editorial> listaEditoriales) {
        this.listaEditoriales = listaEditoriales;
    }
}

