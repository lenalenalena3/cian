package step;

import cucumber.api.DataTable;
import cucumber.api.java.ru.*;

import java.util.Map;

import static step.StepInitial.driver;
import static step.StepInitial.resultSearchPage;
import static step.StepInitial.searchPage;

public class StepCase {

    @Когда("^пользователь заполняет поле выбора действия значением \"([^\"]*)\"$")
    public void userWrite_fieldAction(String v_fieldAction) {
        searchPage.setfieldAction(driver, v_fieldAction);
    }

    @И("^пользователь заполняет поле выбора недвижимости значением \"([^\"]*)\"$")
    public void userWrite_fieldRealty(String v_fieldRealty) {
        searchPage.setfieldRealty(driver, v_fieldRealty);
    }

    @Также("^пользователь заполняет поле выбора категории значением \"([^\"]*)\"$")
    public void userWrite_fieldCategory(String v_fieldCategory) {
        searchPage.setfieldCategory(driver, v_fieldCategory);
    }

    @И("^пользователь заполняет поле количество комнат$")
    public void userWrite_fieldNumberRooms(Map<String, Boolean> v_fieldNumberRooms){
        searchPage.setfieldNumberRooms(driver, v_fieldNumberRooms);
    }

    @Также("^пользователь заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void userWrite_fieldPrice(String v_namePrice, Double v_fieldPrice) {
        searchPage.setfieldPrice(driver,v_namePrice,v_fieldPrice);
    }

    @И("^пользователь заполняет поле адреса значением \"([^\"]*)\"$")
    public void userWrite_fieldCity(String v_fieldCity) {
        searchPage.setfieldCity(driver, v_fieldCity);
    }

    @Тогда("^пользователь нажимает кнопку Найти$")
    public void userWrite_buttonFind() {
        searchPage.buttonFindlClick(driver);
    }

    @Тогда("^пользователь нажимает кнопку Сохранить файл в Excel$")
    public void userWrite_buttonExcel() {
        resultSearchPage.buttonExcelClick(driver);
    }
}
