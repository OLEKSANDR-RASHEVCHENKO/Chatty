package enums;
import lombok.Getter;

@Getter
public enum DropDownMenu {
    Your_Profile("Your Profile"),
    My_Drafts("My Drafts"),
    Logout("Logout"),
    AdminPanel("Admin Panel");



    private final String dropDownMenu;

    DropDownMenu(String listOfDropDown) {
        this.dropDownMenu = "//*[@class='dropdown-menu']//a[contains(text(),'"+listOfDropDown+"')]";
    }
    public String getListOfDropDownMenu(){
        return dropDownMenu;
    }
}

