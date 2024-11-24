package dao;

import model.Libro;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    // Obtener todos los libros
    public List<Libro> getAllLibros() {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libros";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                libros.add(new Libro(
                        rs.getInt("re_isbn"),
                        rs.getString("re_titulo"),
                        rs.getString("re_resumen"),
                        rs.getInt("re_numpag"),
                        rs.getString("re_tipo"),
                        rs.getInt("ed_codigo")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }

    // Insertar un nuevo libro
    public void insertLibro(Libro libro) {
        String query = "INSERT INTO libros (re_titulo, re_resumen, re_numpag, re_tipo, ed_codigo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, libro.getReTitulo());
            ps.setString(2, libro.getReResumen());
            ps.setInt(3, libro.getReNumPag());
            ps.setString(4, libro.getReTipo());
            ps.setInt(5, libro.getEdCodigo());
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: No existe una editorial con el ed_codigo proporcionado.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
