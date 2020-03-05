package step_definitions;

import utilities.DBUtility;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDBUtility {

    public static void main(String[] args) throws SQLException {
        DBUtility.createConnection();
        List<Map<Object, Object>> mydata = DBUtility.executeQuery("select*from teacher where id=");
        DBUtility.close();
      //  System.out.println(mydata);
        for(Map<Object, Object> teacher:mydata){
            System.out.println(teacher);
        }

    }
}
