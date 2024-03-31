package e2e.enums;

import lombok.Getter;

@Getter
public enum Header_menu {
    Home("Home"),
    About("About"),
    Contact("Contact");


    private final String headerMenu;

    Header_menu(String listOfHeader) {
        this.headerMenu = "//*[@class='header__nav header__menu']//a[text()='"+listOfHeader+"']";
    }
    public String getListOfHeader(){
        return headerMenu;
    }
}
