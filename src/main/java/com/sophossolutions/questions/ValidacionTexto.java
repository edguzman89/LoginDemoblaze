package com.sophossolutions.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValidacionTexto implements Question<String> {

    private Target field;

    public ValidacionTexto(Target field) {
        this.field = field;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(field).answeredBy(actor);
    }
    public static ValidacionTexto field(Target field){
        return new ValidacionTexto(field);
    }

}
