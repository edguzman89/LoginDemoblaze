package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class PagBienvenida extends PageObject {

    public static Target PAG_WELCOME(String welcome) {
        return Target.the("validacion de creacion registro exitoso").locatedBy("//*[contains(text(),'Welcome') and contains(text(),'{0}')]").of(welcome);
    }


    }
