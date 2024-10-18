package starter.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.helpers.actionsPage;
import starter.models.Datos;
import starter.models.DatosCompra;
import starter.models.DatosUserLogin;
import starter.navigation.NavigateTo;

import java.io.File;
import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CarritoStepDefinitions {

    private DatosUserLogin datosLogin;
    private DatosCompra datosCompra;
    private String mensajeEsperado;

    @Before
    public void setTheStage() {
        Datos datos;
        OnStage.setTheStage(new OnlineCast());
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File("src/test/resources/features/datos.json");
        try {
             datos = mapper.readValue(jsonFile, Datos.class);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo JSON", e);
        }
        datosLogin = datos.getDatosUserLogin();
        datosCompra = datos.getDatosCompra();
        mensajeEsperado = datos.getMensajeEsperado();
    }

    @Given("^(.*) ingresa a la pagina")
    public void ingresopagina(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.carritoHomePage());
    }

    @When("ingresa los datos del login")
    public void login() {
        Performable action = actionsPage.datosLogin(datosLogin.getUsuario(), datosLogin.getContrasena());
        theActorInTheSpotlight().attemptsTo(action);
    }

    @And("agregar al carrito")
    public void agregarAlCarrito() {
        Performable action = actionsPage.AgregarAlCarrito();
        theActorInTheSpotlight().attemptsTo(action);
    }

    @And("ver carrito")
    public void verCarrito() {
        Performable action = actionsPage.VerCarrito();
        theActorInTheSpotlight().attemptsTo(action);
    }

    @And("ingresar al checkout")
    public void ingresarAlCheckout() {
        Performable action = actionsPage.IngresarAlCheckout();
        theActorInTheSpotlight().attemptsTo(action);
    }

    @And("llenar informacion de la orden desde datos.json")
    public void llenarInformacionDeLaOrden() {
        Performable action = actionsPage.llenarOrden(datosCompra.getNombre(), datosCompra.getApellido(), datosCompra.getCodigoPostal());
        theActorInTheSpotlight().attemptsTo(action);
    }

    @Then("recibo el mensaje")
    public void reciboElMensaje() {
        Performable action = actionsPage.ValidarCompra(mensajeEsperado);
        theActorInTheSpotlight().attemptsTo(action);
    }
}
