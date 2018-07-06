import java.sql.Date

/*
id int primary key auto_increment,
user_name varchar(30) not null,
sex int,
age int,
birthday date,
email varchar(30),
mobile varchar(11),
create_user varchar(30),
create_date date,
update_user varchar(30),
update_date date,
isdel int
 */
class Goddess{

    var id:Int = 0
    var user_name:String = ""
    var sex:Int = 0
    var age:Int = 0
    var birthday:Date = Date(0)
    var email:String = ""
    var mobile:String = ""
    var create_user:String = ""
    var create_date:Date = Date(0)
    var update_user:String = ""
    var update_date:Date = Date(0)
    var isdel:Int = 0

    override fun toString(): String {
        return "Goddess(id=$id, user_name='$user_name', sex=$sex, age=$age, birthday=$birthday, email='$email', mobile='$mobile', create_user='$create_user', create_date=$create_date, update_user='$update_user', update_date=$update_date, isdel=$isdel)"
    }


}