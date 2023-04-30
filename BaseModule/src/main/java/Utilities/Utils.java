package Utilities;

import Base.TestBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Utils extends TestBase
{

    ObjectMapper objectMapper1 = null;
    public String readDataFromJsonFile(String filePath, String key) {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = jsonParser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = (JSONObject) obj;
        String value = (String) jsonObject.get(key);
        return value;
    }

    @Step("Function for windows handling")
    public void windowHandle(String CHILD_or_PARENT) {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();

        String parentWindow = itr.next();
        String childWindow = itr.next();

        //Switch to the child window
        if (CHILD_or_PARENT.equalsIgnoreCase("child")) {
            driver.switchTo().window(childWindow);
        }

        //Come back to parent window
        if (CHILD_or_PARENT.equalsIgnoreCase("parent")) {
            driver.switchTo().window(parentWindow);
        }
    }


    @Step("Handle iFrame")
    public void handleIframe(String iFrame_id_or_name)
    {
        driver.switchTo().frame(iFrame_id_or_name);
    }









}
