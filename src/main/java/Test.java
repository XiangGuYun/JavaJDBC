public class Test {

    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
