package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo  {

    public static Performable carritoHomePage() {
        return Task.where("{0} abrir carrito",
                Open.browserOn().the(CarritoHomePage.class)
        );
    }

}