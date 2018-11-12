package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Flowcontrol {
	private Database DB;
	private Connection connect;
	private Statement statement;
	private Servicehelper helper;
	private int id;
	
	  public Flowcontrol() {
		  try{
			DB = new Database();
			connect = DB.getConnection();
			helper = new Servicehelper();
			statement = connect.createStatement();
			findId();
			connect.close();
		}catch(Exception e){}
	}
	
	  @RequestMapping(value="/addData",method = RequestMethod.POST)
	@ResponseBody
	public void addDatatoDb(@RequestParam String str) throws SQLException{
		String arr[] = str.split("_");
		connect = DB.getConnection();
		statement = connect.createStatement();
		findId();
		String car_brand = arr[0];
		String car_detail = arr[1];
		String car_model = arr[2];
		String city = arr[3];
		String image = "2131427328";
		String id_car = ""+id;
		String sql = "insert into car " + "(id_car,image,car_brand,car_model,car_detail,city) "+
		"values ('"+id_car+"','"+image+"','"+car_brand+"','"+car_model+"','"+car_detail+"','"+city+"')";
		statement.execute(sql);
		id++;
		connect.close();
	}
	
	@RequestMapping(value="/deleteData",method = RequestMethod.POST)
	@ResponseBody
	public void deleteDataDb(@RequestParam String select) throws SQLException{
		String id = select;
		connect = DB.getConnection();
		statement = connect.createStatement();
		String sql = "delete from car "+"where id_car = '"+id+"'";
		statement.execute(sql);
		reBuild(Integer.parseInt(id));
		this.id--;
		connect.close();
	}

	@RequestMapping(value="/checkOrder")
	@ResponseBody
	public String checkOrder()throws SQLException{
		LinkedList<String> listOrder = new LinkedList<String>();
		int count = 0;
		connect = DB.getConnection();
		statement = connect.createStatement();
		ResultSet result = statement.executeQuery("select * from oder");
		while(result.next()){
			String str = "";
			str += "orderID: "+result.getString("order_id")+"_";
			str += "carID: " + result.getString("car_id")+"_";
			str += "name: " + result.getString("name")+"_";
			str += "idPassport: " + result.getString("id_passport")+"_";
			str += "id_Driving: " + result.getString("id_driving")+"_";
			str += "Tel: " + result.getString("tel")+"_";
			str += "Email: " + result.getString("Email")+"_";
			str += "firstDate: " + result.getString("first_date")+"_";
			str += "endDate: " + result.getString("end_date")+"_";
			str += "City: " +  result.getString("city")+"_";
			str += "Time: " + result.getString("time")+"_";
			str += "Place: " + result.getString("place")+"_";
			listOrder.add(str);
		}
		connect.close();
		return ""+listOrder;
		
	}
	@RequestMapping(value="/deleteColumn")
	@ResponseBody
	public void deleteColumn(@RequestParam String table, @RequestParam String column)throws SQLException{
		connect = DB.getConnection();
		statement = connect.createStatement();
		String sql = "ALTER TABLE "+table+" DROP COLUMN "+column;
		statement.execute(sql);
		connect.close();
	}
	
	@RequestMapping(value="/showData")
	@ResponseBody
	public String showData()throws SQLException{
		connect = DB.getConnection();
		statement = connect.createStatement();
		ResultSet result = statement.executeQuery("select * from car");
		LinkedList<String> link = new LinkedList<String>();
		while(result.next()){
			String str = "";
			str += result.getString("id_car")+"_";
			str += "Carbrand: "+result.getString("car_brand")+"_";
			str += "Carmodel: "+result.getString("car_model")+"_";
			str += "Cardetail: "+result.getString("car_detail")+"_";
			str += "city: "+result.getString("city");
			link.add(str);
		}
		connect.close();
		return ""+link;
	}
	
	private void  findId() throws SQLException{
		int i = 0;
		ResultSet result = statement.executeQuery("select * from car");
		while(result.next()){
			i++;
		}
		this.id = i+1;
	}
	private void reBuild(int id){
		
		
		try{
			for(int i = id; i < this.id; i++){
				String sql = "update car set id_car = '"+i+"' where id_car = '"+(i+1)+"'";
				statement.execute(sql);
				
			}
		}catch(Exception e){}
	}
}
