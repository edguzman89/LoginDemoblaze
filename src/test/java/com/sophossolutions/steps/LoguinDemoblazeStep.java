package com.sophossolutions.steps;

import com.sophossolutions.exceptions.Diferencias;
import com.sophossolutions.questions.ValidacionMessage;
import com.sophossolutions.questions.ValidacionTexto;
import com.sophossolutions.tasks.InicioSesion;
import com.sophossolutions.tasks.RegistroPag;
import com.sophossolutions.tasks.VerCamposLoguin;
import com.sophossolutions.tasks.VerCamposSesion;
import com.sophossolutions.userinterfaces.HomePage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static com.sophossolutions.userinterfaces.PagBienvenida.PAG_WELCOME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoguinDemoblazeStep {

    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor actor = Actor.named("Usuario");
    private HomePage homePage = new HomePage();



    @Given("que el usuario está en la página de inicio")
    public void queElUsuarioEstáEnLaPáginaDeInicio() {
        actor.can(BrowseTheWeb.with(navegador));
        navegador.manage().window().maximize();
        actor.wasAbleTo(Open.browserOn(homePage));
    }


    @When("el usuario da clic en la opcion Sign up donde se desplega un pop up")
    public void elUsuarioDaClicEnLaOpcionSignUpDondeSeDesplegaUnPopUp() {
        actor.wasAbleTo(VerCamposLoguin.Vercampos());
    }
    @When("^el usuario ingresa (.+) en el campo Username y (.+) en el campo Password dar clic en el botón Sign up$")
    public void elUsuarioIngresaUsuarioautomaticoEnElCampoUsernameYEnElCampoPassworddarClicEnElBotónSignUp(String username, String password) {
        actor.wasAbleTo(RegistroPag.Agregardatos(username, password));
    }
    @Then("^el usuario vera un mensaje que indica (.+)$")
    public void elUsuarioVeraUnMensajeQueIndica(String message) {
         // Comparar el mensaje real con el esperado utilizando ValidacionMessage
        actor.should(seeThat(ValidacionMessage.field(), equalTo(message)).orComplainWith(
                Diferencias.class,"El valor esperado: \"" + message + "\", no se encontró dentro del contenido"));
    }

    @When("el usuario dara clic en la opcion Log in donde se desplega un pop up")
    public void elUsuarioDaraClicEnLaOpcionLogInDondeSeDesplegaUnPopUp() {
        actor.wasAbleTo(VerCamposSesion.VerCamposSesion());
    }
    @When("^aqui el usuario ingresa (.+) en campo Username y (.+) en campo Password dar clic en el botón Sign up$")
    public void aquiElUsuarioIngresaEnCampoUsernameYEnCampoPasswordDarClicEnElBotonSignUp(String username, String password) {
        actor.wasAbleTo(InicioSesion.IniSesion(username, password));
    }
    @Then("^el usuario ingresa a su pagina y vera un mensaje que indica (.+)$")
    public void elUsuarioIngresaASuPaginaYVeraUnMensajeQueIndica(String welcome) {
        actor.should(seeThat(ValidacionTexto.field(PAG_WELCOME(welcome)), equalTo(welcome)));
    }

}

