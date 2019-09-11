import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Processor extends UnicastRemoteObject implements IProcess {
    protected Processor() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<IStudent> fromTxtFile(File file) throws RemoteException {
        String extension = file.getName().substring(file.getName().lastIndexOf('.'));
        ArrayList<IStudent> processedStudents;

        if (!extension.equals(".txt") && !extension.equals(".csv"))
            throw new RemoteException("File extension not supported");

        if (extension.equals(".txt"))
            processedStudents = readFile(file, "\t");
        else
            processedStudents = readFile(file, ";");

        return processedStudents;
    }

    @Override
    public ArrayList<IStudent> fromDatabase() throws RemoteException {
        ArrayList<IStudent> processedStudents = new ArrayList<>();
        try
        {
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection("jdbc:h2:./Database/school","root","123456");
            System.out.println("Database connected");
            PreparedStatement ps = con.prepareStatement("select * from Student");
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                processedStudents.add(student);
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return processedStudents;
    }

    private ArrayList<IStudent> readFile(File file, String separator) {
        ArrayList<IStudent> processedStudents = new ArrayList<>();
        FileReader reader = null;

        try {
            reader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                //process the line
                String[] strStudent = line.split(separator);
                Student student = new Student(strStudent[0], strStudent[1], strStudent[2], strStudent[3]);
                processedStudents.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return processedStudents;
    }
}
