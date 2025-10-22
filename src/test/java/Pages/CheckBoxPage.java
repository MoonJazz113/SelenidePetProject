package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class CheckBoxPage {
    private ElementsCollection elementList = $$x("//li//span[@class='rct-text']");
    private Map<String, SelenideElement> collapseMap = new HashMap<>();
    private Map<String, SelenideElement> checkBoxMap = new HashMap<>();
    private ElementsCollection selectedObjects = $$x("//div[@id='result']//span[@class='text-success']");


    public CheckBoxPage(){
        updateCheckBoxMap(elementList);
        updateCollapseMap(elementList);
    }

    public void updateCollapseMap(ElementsCollection elementList){
        collapseMap.clear();
        elementList.forEach(elem -> collapseMap.put(elem.$x("label").$("span.rct-title").getText(), elem.$x("button")));
    }

    public void updateCheckBoxMap(ElementsCollection elementList){
        checkBoxMap.clear();
        elementList.forEach(elem -> checkBoxMap.put(elem.$x("label").$("span.rct-title").getText(), elem.$x("label")));
    }

    public void pushCheckBox(String name){
        checkBoxMap.get(name).click();
        updateCheckBoxMap(elementList);
    }

    public void pushCollapseButton(String name){
        collapseMap.get(name).click();
        updateCollapseMap(elementList);
        updateCheckBoxMap(elementList);
    }

    public ArrayList<String> getSelectedObjects(){
        ArrayList<String> listObjects = new ArrayList<>();
        selectedObjects.forEach(object -> listObjects.addLast(object.getText()));
        return listObjects;
    }
}
