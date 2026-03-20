public class TestMBApp{
    public static void main(String[] args){
        MessageBoard mb = new MessageBoard("Coding Support");

        

       mb.addPost("Alex Adam", "Help with Java", "Hi, could anyone help me I need to learn how to code in java!");
       mb.addPost("Belinda Bennet", "Help with Java", "Hi Alex. Yes I can send some tutorials I found useful.");
       mb.addPost("Cindy Carter", "Coding on a Chromebook", "Hi, could anyone help me I need to learn how to code in java!");
       mb.addPost("Dennis Dobson", "Windows problems", "My windows laptop is stuck on a reboot loop. Does anyone know what to do!");

       int[] posts = mb.getPostIDs();

       for(int postID : posts){
        System.out.println(mb.getFormattedPost(postID));
       }

       int[] specificSubjectList = mb.searchPostsBySubject("Java");
       for(int i : specificSubjectList){
        mb.deletePost(i);
       }

       posts = mb.getPostIDs();
       for(int postID : posts){
        System.out.println(mb.getFormattedPost(postID));
       }


    mb.addPost("Ellie", "Java IDE", "Can someone recommend a Java IDE?", 20148);
    mb.addPost("Fred Fansha", "Java IDE", "I just use VS Code", 20149);

    int[] postsByDate = mb.searchPostsByDate(20147, 20149);

    for(int ID : postsByDate){
        System.out.println(mb.getFormattedPost(ID));
    }
    }
}