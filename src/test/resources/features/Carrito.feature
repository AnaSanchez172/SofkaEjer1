Feature: Flujo de compras
  Scenario: Compra de productos
    Given Ana ingresa a la pagina
    When ingresa los datos del login
    And agregar productos al carrito
    And ver carrito
    And ingresar al checkout
    And llenar informacion de la orden desde datos.json
    Then verifico el mensaje recibido