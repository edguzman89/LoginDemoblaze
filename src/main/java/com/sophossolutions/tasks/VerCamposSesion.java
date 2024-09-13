package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sophossolutions.userinterfaces.HomePage.LOG_IN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VerCamposSesion implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOG_IN)
        );

    }

    public static VerCamposSesion VerCamposSesion(){
        return instrumented(VerCamposSesion.class);
    }
}
