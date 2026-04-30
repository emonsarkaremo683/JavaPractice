package pos.util;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class DbInitListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(DbInitListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("Initializing database...");
        DbUtil dbUtil = new DbUtil();
        
        try (Connection conn = dbUtil.getCon();
             InputStream is = sce.getServletContext().getResourceAsStream("/setup/schema.sql")) {
            
            if (is == null) {
                // Try alternate path if not in web root
                LOGGER.warning("schema.sql not found in /setup/. Database might not be initialized.");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("--")) {
                    continue;
                }
                sb.append(line);
                if (line.trim().endsWith(";")) {
                    try (Statement stmt = conn.createStatement()) {
                        String sql = sb.toString().trim();
                        // Remove semicolon for JDBC execution if needed, but MySQL usually accepts it
                        stmt.execute(sql);
                    }
                    sb.setLength(0);
                }
            }
            LOGGER.info("Database initialization completed successfully.");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to initialize database", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Nothing to do
    }
}
