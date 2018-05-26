package com.ala;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ALa\\Desktop\\selenium\\chromedriver.exe");

        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade("A",3));
        grades.add(new Grade("A-",3));
        grades.add(new Grade("B",3));
        grades.add(new Grade("B",2));


        List<Grade> grades2 = Arrays.asList(
                new Grade("F",3),
                new Grade("A",4)
                );


        if(TestCase.Test(grades,3.455))
            System.out.println("Test success");
        else
            System.out.println("Test Failed");

        if(TestCase.Test(grades2,3.1))
            System.out.println("Test success");
        else
            System.out.println("Test Failed");

    }

    static class TestCase{
        static boolean Test(List<Grade> grades, double resultExpected){
            WebDriver driver= new ChromeDriver();
            driver.get("https://www.un-web.com/tools/aauj/?action=FirstYear");
                for (int i=0;i<grades.size();i++){

                    WebElement gradeElement = driver.findElement(By.name("c" +(i+1)));
                    Select select = new Select(gradeElement);
                    select.selectByVisibleText(grades.get(i).getGrade());

                    WebElement elementHours = driver.findElement(By.name("h" + (i+1)));
                    elementHours.sendKeys(grades.get(i).getHours() + "");
            }

            driver.findElement(By.name("B1")).submit();

            String resultString = driver.findElement(By.cssSelector("span.result"))
                    .getText().trim()
                    .split(" ")[0];
            driver.quit();
            double resultDouble = Double.parseDouble(resultString);
            System.out.println("result from website="+resultDouble);

            return resultDouble == resultExpected;
        }
    }
}
