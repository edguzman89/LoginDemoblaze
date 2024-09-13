package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {

    public static Target REGISTRO_OK(String message) {return Target.the("validacion de creacion registro exitoso").locatedBy("//*[text()='{0}']").of(message);

    }

    public static final Target SIGN_UP = Target.the("iniciar un nuevo registo").locatedBy("/html/body/nav/div[1]/ul/li[8]/a");
   public static final Target USERNAME = Target.the("Ingresar usuario").locatedBy("/html/body/div[2]/div/div/div[2]/form/div[1]/input");
    public static final Target PASSWORD = Target.the("ingresar password").locatedBy("/html/body/div[2]/div/div/div[2]/form/div[2]/input");
    public static final Target BTN_SIGN_UP = Target.the("boton registro").locatedBy("/html/body/div[2]/div/div/div[3]/button[2]");

    public static final Target USERNAME_LOGIN = Target.the("Login de usuario nombre").located(By.id("loginusername"));
    public static final Target PASSWORD_LOGIN = Target.the("Login de usuario password").located(By.id("loginpassword"));
    public static final Target BTN_LOGIN = Target.the("boton login").locatedBy("/html/body/div[3]/div/div/div[3]/button[2]");

    public static final Target LOG_IN = Target.the("iniciar Sesion").locatedBy("/html/body/nav/div[1]/ul/li[5]/a");

}
