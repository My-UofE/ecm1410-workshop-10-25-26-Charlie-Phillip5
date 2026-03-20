
public class TestPostApp{
    public static void main(String[] args){
        Post testPost = new Post("Alex Adam", "Help with Java", "Hi, could anyone help me I need to learn how to code in java!");
        System.out.println(testPost.toString());

        try{
            testPost.saveFormattedTextToFile("FormatText");
        }
        catch(Exception e){
            System.out.println("File not saved.");
            e.printStackTrace();
        }
    }
}