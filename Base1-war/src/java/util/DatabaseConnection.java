package util;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {

    private static DataSource dataSource;

    static {
        try {
            // Buscar el recurso JNDI configurado en Payara
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/aplicacionPool");
        } catch (NamingException e) {
            e.printStackTrace();
            System.out.println("No se pudo hacer a conexion con el pool");
        }
    }

    public static Connection getConnection() throws Exception {
        if (dataSource == null) {
            throw new Exception("El pool de conexión jdbc/aplicacionPool no está configurado.");
        }
        return dataSource.getConnection();
    }
}
