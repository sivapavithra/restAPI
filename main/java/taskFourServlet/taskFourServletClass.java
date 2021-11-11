package taskFourServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import testrest.Employee;
import testrest.resultset;

@Path("reportingtree")
public class taskFourServletClass {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{employeeName}")
	public ArrayList<NameDetails> threejson(@PathParam("employeeName") String employeeName) {

		String q="SELECT p.\"Name\" FROM employee AS n,employee AS p WHERE n.\"lft\" BETWEEN p.\"lft\" AND p.\"rgt\" AND n.\"Name\" = '"+employeeName+"'"
				+ " ORDER BY p.\"lft\";";
		ResultSet rs=resultset.registerEmployee(q);
		ArrayList<NameDetails> ar1=new ArrayList<NameDetails>();

		try {
			while(rs.next()){

				String Name=rs.getString("Name");				
				NameDetails ed1=new NameDetails();				
				ed1.setName(Name);							
				ar1.add(ed1);
			}

		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return ar1;

	}
}
