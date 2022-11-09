package ru.ac.uniyar.databasescourse;

public class DatabaseExample {

    public static void main(String[] args) {
        System.out.println("The work has started");

//        try (Connection conn = createConnection()) {
//            try (Statement smt = conn.createStatement()) {
//                DatabaseMethods.create(smt);
//                DatabaseMethods.use(smt);
//                TableMethods.create(smt);
//
//                List<Student> studentsList = SomeCsvDataLoader.load("./solutions.csv");
//                studentsList.forEach(read -> {
//                    try {
//                        TableMethods.insert(read, conn);
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//            } catch (SQLException ex) {
//                System.out.printf("Can't create statement: %s\n", ex);
//            } catch (IOException ex) {
//                System.out.println("File not found.");
//            }
//        } catch (SQLException ex) {
//            System.out.printf("Can't create connection: %s\n", ex);
//        }
    }
}

