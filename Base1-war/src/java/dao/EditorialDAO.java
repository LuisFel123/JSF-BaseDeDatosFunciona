package dao;

import model.Editorial;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EditorialDAO {

    // Obtener todas las editoriales
    public List<Editorial> getAllEditoriales() {
        List<Editorial> editoriales = new ArrayList<>();
        String query = "SELECT * FROM editorial";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                editoriales.add(new Editorial(
                        rs.getInt("ed_codigo"),
                        rs.getString("ed_nombre")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return editoriales;
    }

    // Insertar una nueva editorial
    public void insertEditorial(Editorial editorial) {
        String query = "INSERT INTO editorial (ed_nombre) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, editorial.getEdNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Eliminar una editorial
    public void deleteEditorial(int edCodigo) {
        String query = "DELETE FROM editorial WHERE ed_codigo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, edCodigo);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
