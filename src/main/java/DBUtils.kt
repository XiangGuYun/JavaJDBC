import java.sql.Connection
import java.sql.Driver
import java.sql.DriverManager

object DBUtils{

    val URL = "jdbc:mysql://127.0.0.1:3306/imooc?serverTimezone=GMT&userSSL=false"
    val USER = "root"
    val PASSWORD = "yida9456388"

    var conn: Connection

    init {
        //step1 加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver")
        //step2 获得数据库的连接
        conn = DriverManager.getConnection(URL, USER, PASSWORD)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        //step3 操作数据库，实现增删改查
        var statement = conn.createStatement()
        var resultSet = statement.executeQuery("SELECT user_name, age FROM imooc_goddess")
        while (resultSet.next()){
            println("${resultSet.getString("user_name")} ${resultSet.getInt("age")}")
        }
    }
}