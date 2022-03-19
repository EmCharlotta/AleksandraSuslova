package com.epam.tc.hw5.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractPage {

    @FindBy(id = "ivan")
    private WebElement checkboxIvan;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public void clickVip(String name) {
        if (name.equals("Sergey Ivan")) {
            checkboxIvan.click();
        }
    }

    @FindBy(id = "user-table")
    private WebElement table;

    public List<WebElement> getTableRows(WebElement table) {
        return table.findElements(By.tagName("tr"));
    }

    public WebElement getTable() {
        return table;
    }

    public List<WebElement> getRowsCells(WebElement row) {
        return row.findElements(By.tagName("td"));
    }

    public List<WebElement> getAllInColumn(String column) {
        List<WebElement> columnData = new ArrayList<>();
        WebElement table = getTable();
        List<WebElement> rows = getTableRows(table);

        if (column.equals(("Number Type Dropdowns"))) {
            columnData.add(rows.get(0).findElements(By.tagName("th")).get(0));
            for (int i = 1; i < rows.size(); i++) {
                columnData.add(rows.get(i).findElements(By.tagName("td")).get(0));
            }
        }
        if (column.equals("Usernames")) {
            columnData.add(rows.get(0).findElements(By.tagName("th")).get(2));
            for (int i = 1; i < rows.size(); i++) {
                columnData.add(rows.get(i).findElements(By.tagName("td")).get(2));
            }
        }
        if (column.equals("Description texts under images")) {
            columnData.add(rows.get(0).findElements(By.tagName("th")).get(3));
            for (int i = 1; i < rows.size(); i++) {
                columnData.add(rows.get(i).findElements(By.tagName("td")).get(3));
            }
        }
        if (column.equals("Type")) {
            for (int i = 1; i < rows.size(); i++) {
                columnData.add(rows.get(i).findElements(By.tagName("td")).get(1));
            }
        }
        if (column.equals("checkboxes")) {
            List<WebElement> checkbox = new ArrayList<>();
            checkbox.add(rows.get(0).findElements(By.tagName("th")).get(3));
            for (int i = 1; i < rows.size(); i++) {
                columnData.add(rows.get(i).findElements(By.tagName("td")).get(3));
            }
            for (int i = 0; i < columnData.size(); i++) {
                checkbox.add(columnData.get(i).findElement(By.tagName("input")));
            }
            return checkbox;
        }

        return columnData;
    }

    public WebElement getDroplist(String column, String user) {
        List<WebElement> allInColumn = getAllInColumn(column);
        WebElement dropdown = null;
        if (user.equals("Roman")) {
            dropdown = allInColumn.get(1);
        }
        return dropdown;
    }
}


