package peaksoft.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static final SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            try{
                return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Throwable ex) {
                System.out.println("Session not created " + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        public static SessionFactory getSessionFactory(){
            return sessionFactory;
        }
        public static void shutDown() {
            sessionFactory.close();
        }
    }


//    private static final String username = "postgres";
//    private static final String password = "1234";
//    private static final String url = "jdbc:postgresql://localhost:5432/postgresql";
//
//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Подключение успешно установлена");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return connection;
//    }
