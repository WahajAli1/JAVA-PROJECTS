import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileCreatorAndRunner 
{

    public static void writeHelloJavaFile() 
    {
        String code = """
            public class Hello 
            {
                public static void main(String[] args) 
                {
                    System.out.println("Hello, World!");
                }
            }
        """;

        try (FileWriter writer = new FileWriter("Hello.java")) 
        {
            writer.write(code);
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }

    public static void runHelloJavaFile() 
    {
        try 
        {
            // Compile the Hello.java file
            Process compileProcess = Runtime.getRuntime().exec("javac Hello.java");
            compileProcess.waitFor();

            // Run the Hello class
            Process runProcess = Runtime.getRuntime().exec("java Hello");

            // Read and print the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line);
            }
            runProcess.waitFor();
        } 
        catch (IOException | InterruptedException e) 
        {
            System.out.println("An error occurred while running the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
        writeHelloJavaFile();
        runHelloJavaFile();
    }
}
