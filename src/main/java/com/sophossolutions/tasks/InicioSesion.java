package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sophossolutions.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InicioSesion implements Task {

    private String username;
    private String password;

    public InicioSesion(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        actor.attemptsTo(
                Enter.theValue(username).into(USERNAME_LOGIN),
                Enter.theValue(password).into(PASSWORD_LOGIN),
                Click.on(BTN_LOGIN)
        );

// Esperar y manejar la alerta
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String registroFault = alert.getText();  // Obtener el texto de la alerta
            alert.accept();  // Aceptar la alerta

            // Almacenar el mensaje en la memoria del actor
            actor.remember("alertMessage", registroFault);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static InicioSesion IniSesion(String username, String password) {
        return instrumented(InicioSesion.class, username, password);
    }

}



















/*package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sophossolutions.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InicioSesion implements Task {

    private String username;
    private String password;
    public InicioSesion(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(USERNAME_LOGIN),
                Enter.theValue(password).into(PASSWORD_LOGIN),
                Click.on(BTN_LOGIN)

        );

    }



    public static InicioSesion IniSesion(String username, String password) {
        return instrumented(InicioSesion.class, username, password);
    }


}*/
