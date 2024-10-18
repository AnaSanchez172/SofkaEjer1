package starter.helpers;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

public class actionsPage {

    public static Performable datosLogin(String usuario, String contrasena) {
        return Task.where("{0} llena el formulario con los datos proporcionados",
                actor -> actor.attemptsTo(
                        Enter.theValue(usuario).into(objetosPage.usuario),
                        Enter.theValue(contrasena).into(objetosPage.contrasena),
                        Click.on(objetosPage.btnLogin)
                )
        );
    }


    public static Performable AgregarAlCarrito() {
        return Task.where("{0} agregar al carrito",
                Click.on(objetosPage.producto1),
                Click.on(objetosPage.producto2)
        );
    }

    public static Performable VerCarrito() {
        return Task.where("{0} ver carrito",
                Click.on(objetosPage.btnVerCarrito)
        );
    }

    public static Performable IngresarAlCheckout() {
        return Task.where("{0} ver orden",
                Click.on(objetosPage.btnCheckout)
        );
    }

    public static Performable llenarOrden(String nombre, String apellido, String codigoPostal) {
        return Task.where("{0} llena el formulario con los datos proporcionados",
                actor -> {
                    actor.attemptsTo(
                            Enter.theValue(nombre).into(objetosPage.firstName),
                            Enter.theValue(apellido).into(objetosPage.lastName),
                            Enter.theValue(codigoPostal).into(objetosPage.postalCode),
                            Click.on(objetosPage.btnContinuar),
                            Click.on(objetosPage.btnFinalizar)
                    );
                }
        );
    }

    public static Performable ValidarCompra(String mensaje) {
        return Task.where("{0} valida que el mensaje de compra sea igual a " + mensaje,
                actor -> {
                    if(!Text.of(objetosPage.MENSAJE_COMPRA).viewedBy(actor).asString().equals(mensaje)){
                        throw new AssertionError("El mensaje de compra no coincide con el esperado. Mensaje esperado: " + mensaje + ", Mensaje recibido: "
                                + Text.of(objetosPage.MENSAJE_COMPRA).viewedBy(actor).asString());
                    }
                }
        );
    }






}
