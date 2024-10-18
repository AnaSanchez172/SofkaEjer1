package starter.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class objetosPage
{
    static By usuario = By.cssSelector("[data-test='username']");
    static By contrasena = By.cssSelector("[data-test='password']");
    static By btnLogin = By.cssSelector("[data-test='login-button']");
    static By producto1 = By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']");
    static By producto2 = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    static By btnVerCarrito = By.cssSelector("[data-test='shopping-cart-link']");
    static By btnCheckout = By.cssSelector("[data-test='checkout']");
    static By firstName = By.cssSelector("[data-test='firstName']");
    static By lastName = By.cssSelector("[data-test='lastName']");
    static By postalCode = By.cssSelector("[data-test='postalCode']");
    static By btnContinuar = By.cssSelector("[data-test='continue']");
    static By btnFinalizar = By.cssSelector("[data-test='finish']");
    static By MENSAJE_COMPRA = By.cssSelector("[data-test='complete-header']");
}
