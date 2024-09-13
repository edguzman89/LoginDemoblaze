package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sophossolutions.userinterfaces.HomePage.SIGN_UP;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VerCamposLoguin implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SIGN_UP)
        );

    }

    public static VerCamposLoguin Vercampos(){
        return instrumented(VerCamposLoguin.class);
    }
}
