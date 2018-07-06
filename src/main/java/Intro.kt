import java.sql.Date

object Intro {

    @JvmStatic
    fun main(args: Array<String>) {
        //查询
        var dao = GoddessDAO()
//        var list = dao.query()
//        list.forEach { println("${it.user_name}-${it.age}") }
//        //增加
//        var goddess = Goddess()
//        goddess.user_name="很多事"
//        goddess.age=22
//        goddess.sex=2
//        goddess.birthday=Date(System.currentTimeMillis())
////        goddess.email="850570138@qq.com"
////        goddess.mobile="13812356234"
////        goddess.create_user="admin"
////        goddess.create_date= Date(System.currentTimeMillis()-24*60*60*1000*2)
////        goddess.update_user="admin1"
////        goddess.update_date= Date(System.currentTimeMillis()-24*60*60*1000)
////        goddess.isdel = 1
//        dao.add(goddess)

//        var goddess = dao.get(4)
//        print(goddess.toString())

//        dao.delete(1)
//        dao.delete(2)

//        var goddess = Goddess()
//        goddess.id = 3
//        goddess.user_name = "JimGreen"
//        dao.update(goddess)

       // dao.query("JimGreen").forEach { println(it.toString()) }
        var list = ArrayList<HashMap<String,Any>>()
        var map1 = HashMap<String,Any>()
        map1["name"] = "user_name"
        map1["rela"] = "like"
        map1["value"] = "'%很%'"//注意要加单引号，否则会报语法错误
        list.add(map1)
        dao.query(list).forEach { println("******"+it.toString()) }

    }

}