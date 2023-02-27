package tests;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost(){
//        Object[][] data = new Object[2][3];
//        data[0][0] = "A";
//        data[0][1] = "E";
//        data[0][2] = 2;
//
//        data[1][0] = "T";
//        data[1][1] = "E";
//        data[1][2] = 1;
//        return data;

        return new Object[][]{
                {"G","B",3},
                {"H","F",1}
        };
    }
}
