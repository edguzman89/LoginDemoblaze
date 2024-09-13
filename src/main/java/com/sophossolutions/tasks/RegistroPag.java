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

public class RegistroPag implements Task {

    private String username;
    private String password;

    public RegistroPag(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ingresar el username y password
        actor.attemptsTo(
                Enter.theValue(username).into(USERNAME),
                Enter.theValue(password).into(PASSWORD),
                Click.on(BTN_SIGN_UP)
        );

        // Esperar y manejar la alerta
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String registroOk = alert.getText();  // Obtener el texto de la alerta
            alert.accept();  // Aceptar la alerta

            // Almacenar el mensaje en la memoria del actor
            actor.remember("alertMessage", registroOk);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método estático para instanciar la clase con los parámetros username y password
    public static RegistroPag Agregardatos(String username, String password) {
        return instrumented(RegistroPag.class, username, password);
    }
}
