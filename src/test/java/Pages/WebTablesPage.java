package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.*;

public class WebTablesPage {
    private final SelenideElement addButton = $("#addNewRecordButton");
    private ElementsCollection tableList = $$x("//div[@class='rt-tbody']//div[.//div//div//div[contains(text(), *)]]");

    public WebTablesRegistrationForm pushAddButton(){
        addButton.click();
        return new WebTablesRegistrationForm();
    }
    public void pushDeleteButton(int num){
        tableList.get(num).$x(".//div//div//div//span[contains(@id, 'delete-record-')]").click();
    }

    public WebTablesRegistrationForm pushEditButton(int num){
        tableList.get(num).$x(".//div//div//div//span[contains(@id, 'edit-record-')]").click();
        return new WebTablesRegistrationForm();
    }

    public Optional<SelenideElement> findByFirstName(String name){
        return tableList.stream().filter(row -> {
            SelenideElement firstCell = row.$x(".//div[@class='rt-td'][1]");
            return firstCell.getText().equalsIgnoreCase(name);})
                .findFirst();
    }
}
