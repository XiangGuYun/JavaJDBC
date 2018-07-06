import DBUtils.conn
import java.sql.Date

class GoddessDAO{

    fun add(goddess: Goddess){
        var sql = "insert into imooc_goddess" +
                "(user_name,sex,age,birthday,email,mobile," +
                "create_user,create_date,update_user,update_date,isdel)" +
                "values(" +
                "?,?,?,?,?,?,?,?,?,?,?)"
        var preSM = conn.prepareStatement(sql)
        preSM.setString(1,goddess.user_name)
        preSM.setInt(2,goddess.sex)
        preSM.setInt(3,goddess.age)
        preSM.setDate(4,goddess.birthday)
        preSM.setString(5,goddess.email)
        preSM.setString(6,goddess.mobile)
        preSM.setString(7,goddess.create_user)
        preSM.setDate(8,goddess.create_date)
        preSM.setString(9,goddess.update_user)
        preSM.setDate(10,goddess.update_date)
        preSM.setInt(11,goddess.isdel)
        preSM.execute()
    }

    fun update(goddess: Goddess){
        var sql = " UPDATE imooc_goddess " +
                " SET user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?," +
                " create_user=?,create_date=?,update_user=?,update_date=?,isdel=?" +
                " WHERE id=?"
        var preSM = conn.prepareStatement(sql)
        preSM.setString(1,goddess.user_name)
        preSM.setInt(2,goddess.sex)
        preSM.setInt(3,goddess.age)
        preSM.setDate(4,goddess.birthday)
        preSM.setString(5,goddess.email)
        preSM.setString(6,goddess.mobile)
        preSM.setString(7,goddess.create_user)
        preSM.setDate(8,goddess.create_date)
        preSM.setString(9,goddess.update_user)
        preSM.setDate(10,goddess.update_date)
        preSM.setInt(11,goddess.isdel)
        preSM.setInt(12,goddess.id)
        preSM.execute()
    }

    fun query(): ArrayList<Goddess> {
        var statement = conn.createStatement()
        var resultSet = statement.executeQuery("SELECT user_name, age FROM imooc_goddess")
        var goddessList = ArrayList<Goddess>()
        var goddess:Goddess
        while (resultSet.next()){
            goddess = Goddess()
            goddess.user_name = resultSet.getString("user_name")
            goddess.age = resultSet.getInt("age")
            goddessList.add(goddess)
        }
        return goddessList
    }

    fun query(name:String,mobile:String, email:String):ArrayList<Goddess>{
        var builder = StringBuilder()
        builder.append("SELECT * FROM imooc_goddess")
        builder.append(" where user_name = ? and mobile like ? and email like ?")
        var preSM = conn.prepareStatement(builder.toString())
        //左边的数字代表where语句的索引值，从1开始
        preSM.setString(1, name)
        preSM.setString(1, "%$mobile%")
        preSM.setString(1, "%$email%")
        var set = preSM.executeQuery()
        var goddessList = ArrayList<Goddess>()
        var goddess:Goddess
        while (set.next()){
            goddess = Goddess()
            goddess.id = set.getInt("id")
            goddess.user_name= set.getString("user_name")
            goddess.sex = set.getInt("sex")
            goddess.age = set.getInt("age")
            goddess.birthday= set.getDate("birthday")
            goddess.email= set.getString("email")
            goddess.mobile= set.getString("mobile")
            goddess.create_user= set.getString("create_user")
            goddess.create_date= set.getDate("create_date")
            goddess.update_user= set.getString("update_user")
            goddess.update_date= set.getDate("update_date")
            goddess.isdel= set.getInt("isdel")
            goddessList.add(goddess)

        }
        return goddessList
    }

    fun query(list:ArrayList<HashMap<String,Any>>):ArrayList<Goddess>{
        var builder = StringBuilder()
        builder.append("SELECT * FROM imooc_goddess")

        var preSM = conn.prepareStatement(builder.toString())
        //" where user_name = ? and mobile like ? and email like ?"
        for ((i,map) in list.withIndex()){
            if(i==0) {
                builder.append(" where ${map["name"]} ${map["rela"]} ${map["value"]}")
            }
            else{
                builder.append(" and ${map["name"]} ${map["rela"]} ${map["value"]}")
            }
        }
        println(builder.toString())
        var resultSet = conn.createStatement().executeQuery(builder.toString())
        var goddessList = ArrayList<Goddess>()
        var goddess:Goddess
        while (resultSet.next()){
            goddess = Goddess()
            goddess.user_name = resultSet.getString("user_name")
            goddess.age = resultSet.getInt("age")
            goddessList.add(goddess)
        }
        return goddessList
    }

    fun delete(id:Int){
        var sql = " DELETE FROM imooc_goddess " +
                " WHERE id=?"
        var preSM = conn.prepareStatement(sql)
        preSM.setInt(1,id)
        preSM.execute()
    }

    fun get(id:Int): Goddess {
        var goddess = Goddess()
        var sql = "SELECT * FROM imooc_goddess " +
                " WHERE id=?"
        var preSM = conn.prepareStatement(sql)
        preSM.setInt(1,id)
        var set = preSM.executeQuery()
        while (set.next()){
            goddess.id = set.getInt("id")
            goddess.user_name= set.getString("user_name")
            goddess.sex = set.getInt("sex")
            goddess.age = set.getInt("age")
            goddess.birthday= set.getDate("birthday")
            goddess.email= set.getString("email")
            goddess.mobile= set.getString("mobile")
            goddess.create_user= set.getString("create_user")
            goddess.create_date= set.getDate("create_date")
            goddess.update_user= set.getString("update_user")
            goddess.update_date= set.getDate("update_date")
            goddess.isdel= set.getInt("isdel")
        }
        return goddess
    }

}