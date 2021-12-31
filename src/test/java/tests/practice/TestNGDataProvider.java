package tests.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestNGDataProvider  {



    @Test (dataProvider =  "getData")
    void UserNameTest (String username, String password ) {
        System.out.println("username : " + username + " "  + "password :" + password);
    }
    @DataProvider
    public Object [][] getData(){
        Object [][] data = {
                {"Muhammet", "123"},
                {"Murat", "asd"},
                {"Kubilay", "1q2w"}
        };
        return data;
    }
    @Test (dataProvider =  "getData2")
    void usernameTest (String username) {
        System.out.println("username = " + username);
    }
    @DataProvider
    public Iterator<Object> getData2 (){
        List<Object> data = new ArrayList<>();
        data.add("Merve");
        data.add("Esra");
        data.add("Hakan");
        return data.iterator();
    }






}
